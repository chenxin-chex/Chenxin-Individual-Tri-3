import java.util.*;

class Main {
  String title;
  Runnable replit;

  public Main(String title, Runnable replit) {
    this.title = title;
    this.replit = replit;
  }

  public String getTitle() {
    return title;
  }

  public Runnable getReplit() {
    return replit;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Main> menu = new HashMap<>();
    menu.put(0, new Main("Int By Reference", () -> IntByReference.main(null)));
    menu.put(1, new Main("Matrix", () -> Matrix.main(null)));

    System.out.println("Menu:");
    for (Map.Entry<Integer, Main> pair : menu.entrySet()) {
      System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
    }
    
    int input = sc.nextInt();
    try {
      Main m = menu.get(input);
      m.getReplit().run();
      }
    catch(Exception e) {
      System.out.println("Please enter a number listed in the menu.");
    }
    main(null);
  }
}