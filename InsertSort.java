public class InsertSort extends BaseSort {
  
  public InsertSort() {
    super();
  }

  public void sort() {
    int n = unsorted.length;
    for (int i = 1; i < n; i++) {
      int value = unsorted[i];
      int j = i - 1;

      while (j >= 0 && unsorted[j] > value) {
        compare++;
        swap++;
        unsorted[j+1] = unsorted[j];
        j = j - 1;
      }

      unsorted[j+1] = value;
    }
  }

  public static void main(String[] args) {
    InsertSort insert = new InsertSort();
    System.out.println(insert);
  }
}