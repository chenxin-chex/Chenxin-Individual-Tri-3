import java.util.*;
import java.time.*;

public class BaseSort {
  int[] unsorted;
  int compare = 0;
  int sort = 0;
  int result;
  
  public BaseSort() {
    this.unsorted = getUnsorted();
    Instant starts = Instant.now();
    sort();
    Instant stop = Instant.now();
    Duration res = Duration.between(starts, stop);
    result = res.getNano();
  }

  public void sort() {
    // customize sort method based on type of sort
  }

  public String toString() {
    String format = "";
    format += "Compare: " + compare;
    format += "\nSwap: " + sort;
    format += "\nTime: " + result;
    format += "\nSorted: ";
    for (int i = 0; i <  unsorted.length; i++) {
      format += unsorted[i] + ", ";
    }
    return format;
  }

  public int[] getUnsorted() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter unsorted integer array (separated by commas): ");
    String str = sc.next();
    String[] strArr = str.split(",");
    int[] array = new int[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      array[i] = Integer.valueOf(strArr[i]);
    }
    return array;
  }
}