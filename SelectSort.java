public class SelectSort extends BaseSort {
  public SelectSort() {
    super();
  }

  public void sort() {
    int n = unsorted.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        compare++;
        if (unsorted[j] < unsorted[min]) {
          min = j;
        }
      }
      int temp = unsorted[min];
      unsorted[min] = unsorted[i];
      unsorted[i] = temp;
      sort++;
    }
  }

  public static void main(String[] args) {
    SelectSort select = new SelectSort();
    System.out.println(select);
    
  }
}