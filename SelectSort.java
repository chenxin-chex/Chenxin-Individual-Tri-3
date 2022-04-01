public class SelectSort extends BaseSort {
  public SelectSort() {
    super();
  }

  public void sort() {
    int n = unsorted.length;
    // iterate through each element of list as starting index
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      // within this sublist that has starting index of i, find the minimum value
      for (int j = i+1; j < n; j++) {
        compare++;
        if (unsorted[j] < unsorted[min]) {
          min = j;
        }
      }
      // sort minimum value to the start of the list.
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