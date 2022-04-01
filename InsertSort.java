public class InsertSort extends BaseSort {
  
  public InsertSort() {
    super();
  }

  public void sort() {
    int n = unsorted.length;
    // iterate through each element of the array as the starting comparison
    for (int i = 1; i < n; i++) {
      int value = unsorted[i];
      int j = i - 1;

      // if the current element is smaller than value before it, continue to look back until it is no longer smaller and insert the element there
      //Sort all of the other elements up a position to make space.
      while (j >= 0 && unsorted[j] > value) {
        compare++;
        sort++;
        unsorted[j+1] = unsorted[j];
        j--;
      }
      unsorted[j+1] = value;
      compare++;
    }
  }

  public static void main(String[] args) {
    InsertSort insert = new InsertSort();
    System.out.println(insert);
  }
}