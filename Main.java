import java.util.*;

class Main {
  String title;
  Runnable replit;

  public Main(String title, Runnable replit) {
    this.title = title;
    this.replit = replit;
  }

  public String getTitle() {
    return title;
  }

  public Runnable getReplit() {
    return replit;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Main> menu = new HashMap<>();
    menu.put(1,  new Main("Int By Reference", () -> IntByReference.main(null)));
    menu.put(2,  new Main("Matrix", () -> Matrix.main(null)));
    menu.put(3,  new Main("Queue", () -> QueueTester.main(null)));
    menu.put(4,  new Main("Merge Queue", () -> Merge.main(null)));
    menu.put(5, new Main("Backwards Stack", () -> Stack.main(null)));
    menu.put(6,  new Main("Calculator", () -> Calculator.main(null)));
    menu.put(7,  new Main("Bubble Sort", () -> BubbleSort.main(null)));
    menu.put(8,  new Main("Selection Sort", () -> SelectSort.main(null)));
    menu.put(9,  new Main("Insertion Sort", () -> InsertSort.main(null)));
    menu.put(10,  new Main("Merge Sort", () -> MergeSort.main(null)));
    menu.put(11, new Main("Clock", () -> Clock.main(null)));

    System.out.println("Menu:");
    for (Map.Entry<Integer, Main> pair : menu.entrySet()) {
      System.out.println(String.format("%2d ==> %s", pair.getKey(), pair.getValue().getTitle()));
    }
    
    int input = sc.nextInt();
    try {
      if (input == 0) {
        return;
      }
      Main m = menu.get(input);
      m.getReplit().run();
    }
    catch(Exception e) {
      System.out.println("Please enter a number listed in the menu.");
    }
    main(null);
  }
}
