public class Merge<T> {
  private Queue<T> queue1 = new Queue<T>();
  private Queue<T> queue2 = new Queue<T>();

  // constructor
  public Merge(T[] firstList, T[] secList) {
    for (T data : firstList) {
      queue1.add(data);
    }
    
    for (T data : secList) {
      queue2.add(data);
    }
  }

  // compares heads of both queues and adds larger to the third queue
  public Queue<T> merged() {
    QueueIterator<T> firstQueue = new QueueIterator<T>(queue1);
    QueueIterator<T> secQueue = new QueueIterator<T>(queue2);
    Queue<T> mergedQueues = new Queue<T>();

    while (firstQueue.hasNext() && secQueue.hasNext()) {
      T first = firstQueue.getData();
      T sec = secQueue.getData();

      if ((int)first <= (int)sec) {
        mergedQueues.add(first);
        firstQueue.next();
      }
      else {
        mergedQueues.add(sec);
        secQueue.next();
      }
    }

    if (queue1.getHead() != null) {
      while (firstQueue.hasNext()) {
        mergedQueues.add(firstQueue.getData());
        firstQueue.next();
      }
    }
    else {
      while (secQueue.hasNext()) {
        mergedQueues.add(secQueue.getData());
        secQueue.next();
      }
    }

    return mergedQueues;
    
  }

  
  // tester main class
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
      System.out.print(answer.next() + " ");
    }
    System.out.println();
    
    
  }
}