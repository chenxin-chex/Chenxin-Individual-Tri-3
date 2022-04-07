import java.util.Scanner;
import java.io.IOException;

public class Clock {
  private int time;

  public Clock() {
    this.time = 0;
  }

  public void increment() {
    time++;
  }

  // Combine strings horizontally
  public String combineStrings(String string1, String string2) {
    String[] lines1 = string1.split("\n");
    String[] lines2 = string2.split("\n");
    
    int len1 = lines1.length;
    int len2 = lines2.length;

    String string = "";
    int len = len1 >= len2 ? len1 : len2;
    for (int i = 0; i < len; i++) {
      String s1 = len1 > i ? lines1[i] : "";
      String s2 = len2 > i ? lines2[i] : "";
      string = string.concat(String.format("%s %s\n", s1, s2));
    }

    return string;
  }

  // Return the segments for a specific digit
  // Work done in `clock_layout`
  public boolean[] getSegments(int digit) {
    boolean[] segments = new boolean[7];

    segments[0] = (digit & 0b0111) == 0b0000 ||
                  (digit & 0b1101) == 0b0100 ||
                  (digit & 0b1111) == 0b1001 ||
                  (digit & 0b1111) == 0b0101;

    segments[1] = (digit & 0b1010) == 0b0010 ||
                  (digit & 0b0111) == 0b0000 ||
                  (digit & 0b1111) == 0b1001 ||
                  (digit & 0b1111) == 0b0101;

    segments[2] = (digit & 0b1100) == 0b0000 ||
                  (digit & 0b1110) == 0b1000 ||
                  (digit & 0b1111) == 0b0100 ||
                  (digit & 0b1111) == 0b0111;

    segments[3] = (digit & 0b0111) == 0b0000 ||
                  (digit & 0b1011) == 0b0010;

    segments[4] = (digit & 0b1110) == 0b0010 ||
                  (digit & 0b1110) == 0b1000 ||
                  (digit & 0b1101) == 0b0100 ||
                  (digit & 0b1111) == 0b0101;

    segments[5] = (digit & 0b1100) == 0b0100 ||
                  (digit & 0b0111) == 0b0000 ||
                  (digit & 0b0111) == 0b0001 ||
                  (digit & 0b1111) == 0b0011;

    segments[6] = (digit & 0b0111) == 0b0000 ||
                  (digit & 0b1011) == 0b0010 ||
                  (digit & 0b1111) == 0b0011 ||
                  (digit & 0b1111) == 0b0101;

    return segments;
  }

  // Get the string representation of the digit as a string
  public String getSegmentsString(int digit) {
    boolean[] segments = getSegments(digit);
    String[] strings = new String[7];

    String bar = "---------";

    strings[0] = segments[0] ? "|" : " ";
    strings[1] = segments[1] ? "---------" : "         ";
    strings[2] = segments[2] ? "|" : " ";
    strings[3] = segments[3] ? "|" : " ";
    strings[4] = segments[4] ? "---------" : "         ";
    strings[5] = segments[5] ? "|" : " ";
    strings[6] = segments[6] ? "---------" : "         ";

    return String.format(" %s \n", strings[1]) +
           String.format("%s         %s\n", strings[0], strings[2]) +
           String.format("%s         %s\n", strings[0], strings[2]) +
           String.format("%s         %s\n", strings[0], strings[2]) +
           String.format(" %s \n", strings[4]) +
           String.format("%s         %s\n", strings[3], strings[5]) +
           String.format("%s         %s\n", strings[3], strings[5]) +
           String.format("%s         %s\n", strings[3], strings[5]) +
           String.format(" %s ", strings[6]);
  }

  // Print a multidigit number as a string
  public String getNumberString(int time, int num_digits) {
    int[] digits = new int[num_digits];
    int tmp = time;

    for (int i = 0; i < num_digits; i++) {
      digits[i] = tmp % 10;
      tmp /= 10;
    }
    
    String s = getSegmentsString(digits[num_digits - 1]);
    for (int i = num_digits - 2; i >= 0; i--) {
      s = combineStrings(s, getSegmentsString(digits[i]));
    }

    return s;
  }

  // String representation of a colon that separates the hours/minutes/seconds
  private static String colon = " \n \n:\n \n \n \n:\n \n ";

  // Print the clock's time in hours/minutes/seconds
  public String toString() {
    int hours = time / 3600;
    int minutes = (time / 60) % 60;
    int seconds = time % 60;

    String s = "";
    s = getNumberString(hours, 2);
    s = combineStrings(s, colon);
    s = combineStrings(s, getNumberString(minutes, 2));
    s = combineStrings(s, colon);
    s = combineStrings(s, getNumberString(seconds, 2));

    return s;
  }

  public static void main(String[] args) {
    Clock clock = new Clock();

    new Thread(() -> {
      for (;;) {
        // Clear the screen
        System.out.println("\033c");

        // Print out the clock
        System.out.println(clock);

        System.out.println("Press 'q' to quit");
        System.out.print("> ");

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.err.println(e);
        }

        clock.increment();
      }
    }).start();

    // If 'q' is entered, quit the clock
    System.out.println("Type 'q' and then enter to quit");
    Scanner stdin = new Scanner(System.in);

    for (;;) {
      while (stdin.nextLine().equals("q")) {
        System.exit(0);
      }
    }
  }
}

