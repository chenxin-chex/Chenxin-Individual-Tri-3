public class BubbleSort extends BaseSort {

  public BubbleSort() {
    super();
  }
  
  public void sort() {
    int n = unsorted.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        compare++;
        if (unsorted[j] > unsorted[j+1]) {
          sort++;
          int temp = unsorted[j];
          unsorted[j] = unsorted[j+1];
          unsorted[j+1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    BubbleSort bubble = new BubbleSort();
    System.out.println(bubble);
    
  }
}