public class Stack {
  private LinkedList lifo;  // last in first out Object of stack

    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
  public Stack() {
    lifo = null;
  }

    /**
     *  Returns the current (LIFO) objects value.
     *
     * @return  the current objects value in Stack.
     */
  public Object peek() {
    if (lifo == null) {
      return null;
    }
    else {
      return lifo.getData();
    }
  }

    /**
     *  Inserts a new object at the top of this Stack,
     *
     * @param  value  is the database to be inserted at the top of the Stack.
     */
  public void push(Object value) {
        // note the order that things happen:
        // the new object becomes current and gets a value
        // current lifo is parameter, it is assigned as previous node in lifo
    lifo = new LinkedList(value, lifo);
  }

    /**
     *  Removes the top element in the Stack.  Garbage collection should destroy this element when needed.
     *
     */
  public Object pop() {
    Object value = null;

    if (lifo != null) {
      value = lifo.getData();
      lifo = lifo.getPrevious();
    }

    return value;
  }

    /**
     *  Returns a string representation of this Stack,
     *  polymorphic nature of toString overrides of standard System.out.print behavior
     *
     * @return    string representation of this list
     */
  public String toString() {
    StringBuilder stackToString = new StringBuilder("[");

    LinkedList node = lifo;  				// start from the back
    while (node != null) {
      stackToString.append(node.getData()); 	// append the database to output string
      node = node.getPrevious();    		// go to previous node
      if (node != null) {
        stackToString.append(", ");
      }
    }										// loop 'till you reach the beginning
    stackToString.append("]");
    return stackToString.toString();
  }

  public static void main(String[] args) {
    int[] integers = {1, 2, 3};
    Queue forward = new Queue();
    Stack backward = new Stack();
    System.out.println("Forward queue: ");
    for (int i : integers) {
      System.out.print(i + " ");
      forward.add(i);
    }
    System.out.println();
    for (int i : integers) {
      backward.push(i);
    }

    System.out.println("Backwards stack: ");
    for (int i : integers) {
      System.out.print(backward.pop() + " ");
    }
    System.out.println();
  }


}