import java.util.*;

public class Merge<T> {
  private Queue<T> queue1 = new Queue<T>();
  private Queue<T> queue2 = new Queue<T>();

  public Merge(T[] firstList, T[] secList) {
    for (T data : firstList) {
      queue1.add(data);
    }
    
    for (T data : secList) {
      queue2.add(data);
    }
  }

  public Queue<T> merged() {
    QueueIterator<T> firstQueue = new QueueIterator<T>(queue1);
    QueueIterator<T> secQueue = new QueueIterator<T>(queue2);
    Queue<T> mergedQueues = new Queue<T>();

    while (firstQueue.hasNext() && secQueue.hasNext()) {
      T first = firstQueue.next();
      T sec = secQueue.next();

      if ((int)first <= (int)sec) {
        mergedQueues.add(first);
      }
      else {
        mergedQueues.add(sec);
      }
    }

    return mergedQueues;
    
  }

  
  
  public static void main(String args[]) {
    Integer[] firstlist = new Integer[] { 1, 4, 5, 8};
    Integer[] seclist = new Integer[] { 2, 3, 6, 7};

    Merge mergequeues = new Merge(firstlist, seclist);

    for (Integer i : firstlist) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (Integer j : seclist) {
      System.out.print(j + " ");
    }

    QueueIterator answer = new QueueIterator(mergequeues.merged());
    System.out.println();

    while (answer.hasNext()) {
      System.out.println(answer.next() + " ");
    }
    
    
  }
}