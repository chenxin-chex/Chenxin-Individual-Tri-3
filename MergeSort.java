import java.util.*;
import java.time.*;

public class MergeSort extends BaseSort {

  public MergeSort() {
    this.unsorted = getUnsorted();
    Instant starts = Instant.now();
    sort(unsorted, unsorted.length);
    Instant stop = Instant.now();
    Duration res = Duration.between(starts, stop);
    result = res.getNano();
  }

  public void sort(int[] a, int n) {
    if (n < 2) {
      return;
    }
    
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++ ) {
      l[i] = a[i];
    }
    for (int j = mid; j < n; j++ ) {
      r[j - mid] = a[j];
    }

    sort(l, mid);
    sort(r, n - mid);

    mergeS(a, l, r, mid, n - mid);
    
  }

  public void mergeS(int[] a, int[] l, int[] r, int left, int right) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left && j < right) {
      if (l[i] <= r[j]) {
        a[k++] = l[i++];
      }
      else {
        a[k++] = r[j++];
      }
    }

    while (i < left) {
      a[k++] = l[i++];
    }
    while (j < right) {
      a[k++] = r[j++];
    }
  }

  public static void main(String[] args) {
    MergeSort merge = new MergeSort();
    System.out.println(merge);
    
  }
}