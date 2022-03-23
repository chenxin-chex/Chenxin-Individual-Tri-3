import java.util.*;
import java.lang.Math;

public class Calculator {
  private final String expression;
  private ArrayList<String> tokens;
  private ArrayList<String> reverse_polish;
  private Double result;

  public Calculator(String expression) {
    // original input
    this.expression = expression;

    // parse expression into terms
    this.termTokenizer();

    // place terms into reverse polish notation
    this.tokensToReversePolishNotation();

    // calculate reverse polish notation
    this.rpnToResult();
  }

  private final Map<String, Integer> OPERATORS = new HashMap<>();
  {
    // Map<"token", precedence>
    OPERATORS.put("^", 2);
    OPERATORS.put("*", 3);
    OPERATORS.put("/", 3);
    OPERATORS.put("%", 3);
    OPERATORS.put("+", 4);
    OPERATORS.put("-", 4);
  }

   // Helper definition for supported operators
  private final Map<String, Integer> SEPARATORS = new HashMap<>();
  {
    // Map<"separator", not_used>
    SEPARATORS.put(" ", 0);
    SEPARATORS.put("(", 0);
    SEPARATORS.put(")", 0);
  }

  // Test if token is an operator
  private boolean isOperator(String token) {
    // find the token in the hash map
    return OPERATORS.containsKey(token);
  }

  // Test if token is an separator
  private boolean isSeperator(String token) {
    // find the token in the hash map
    return SEPARATORS.containsKey(token);
  }

  // Compare precedence of operators.
  private Boolean isPrecedent(String token1, String token2) {
    // token 1 is precedent if it is greater than token 2
    return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
  }

   // Term Tokenizer takes original expression and converts it to ArrayList of tokens
  private void termTokenizer() {
    // contains final list of tokens
    this.tokens = new ArrayList<>();

    int start = 0;  // term split starting index
    StringBuilder multiCharTerm = new StringBuilder();    // term holder
    
    for (int i = 0; i < this.expression.length(); i++) {
      Character c = this.expression.charAt(i);
      if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
        // 1st check for working term and add if it exists
        if (multiCharTerm.length() > 0) {
          tokens.add(this.expression.substring(start, i));
        }
      // Add operator or parenthesis term to list
        if (c != ' ') {
          tokens.add(c.toString());
        }
        // Get ready for next term
        start = i + 1;
        multiCharTerm = new StringBuilder();
      } 
        
      else {
        // multi character terms: numbers, functions, perhaps non-supported elements
        // Add next character to working term
        multiCharTerm.append(c);
      }
    }
    // Add last term
    if (multiCharTerm.length() > 0) {
      tokens.add(this.expression.substring(start));
    }
  }

  private void tokensToReversePolishNotation () {
    // contains final list of tokens in RPN
    this.reverse_polish = new ArrayList<>();

    // stack is used to reorder for appropriate grouping and precedence
    Stack tokenStack = new Stack();
      for (String token : tokens) {
        switch (token) {
          // If left bracket push token on to stack
          case "(":
            tokenStack.push(token);
            break;
          case ")":
            while (tokenStack.peek() != null && !tokenStack.peek().equals("(")) {
              reverse_polish.add( (String)tokenStack.pop() );
            }
            tokenStack.pop();
            break;
          case "+":
          case "-":
          case "*":
          case "/":
          case "%":
          case "^":
            // While stack
            // not empty AND stack top element
            // and is an operator
            while (tokenStack.peek() != null && isOperator((String) tokenStack.peek())) {
              if ( isPrecedent(token, (String) tokenStack.peek() )) {
                reverse_polish.add((String)tokenStack.pop());
                continue;
              }
              break;
            }
            // Push the new operator on the stack
            tokenStack.push(token);
            break;
          default:    // Default should be a number, there could be test here
            this.reverse_polish.add(token);
        }
      }
      // Empty remaining tokens
      while (tokenStack.peek() != null) {
        reverse_polish.add((String)tokenStack.pop());
      }
  }

  // Takes RPN and produces a final result
  private void rpnToResult() {
    // Stack used to hold calculation while process RPN
    Stack calculation = new Stack();

    // for loop to process RPN
    for (String tokens : reverse_polish) {
      // If the token is a number
      if (!isOperator(tokens)) {
        // Push number to stack
        Double num = Double.parseDouble(tokens);
        calculation.push(num);
      }
        // else
      else {
        // Pop the two top entries
        Double temp1 = (Double)calculation.pop();
        Double temp2 = (Double)calculation.pop();
        Double answer = 0.0;

        // Based off of Token operator calculate result
        if (tokens.equals("^")) {
          answer = Math.pow(temp2, temp1);
        }
        if (tokens.equals("*")) {
          answer = temp1 * temp2;
        }
        if (tokens.equals("/")) {
          answer = temp2 / temp1;
        }
        if (tokens.equals("%")) {
          answer = temp2 % temp1;
        }
        if (tokens.equals("+")) {
          answer = temp2 + temp1;
        }
        if (tokens.equals("-")) {
          answer = temp2 - temp1;
        }

        calculation.push(answer);
      }
    }
        // Pop final result and set as final result for expression
    result = (Double)calculation.pop();
  }

  public String toString() {
    return ("Original expression: " + this.expression + "\n" +
            "Tokenized expression: " + this.tokens.toString() + "\n" +
            "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
            "Final result: " + String.format("%.2f", this.result));
  }

  public static void main(String[] args) {
    Calculator simpleMath = new Calculator("100 + 200  * 3");
    System.out.println("Simple Math\n" + simpleMath);

    Calculator parenthesisMath = new Calculator("(100 + 200)  * 3");
    System.out.println("Parenthesis Math\n" + parenthesisMath);

    Calculator fractionMath = new Calculator("100.2 - 99.3");
    System.out.println("Fraction Math\n" + fractionMath);

    Calculator allMath = new Calculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
    System.out.println("All Math\n" + allMath);

    Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
    System.out.println("All Math2\n" + allMath2);

    Calculator powerMath = new Calculator("2 ^ 3 * 4");
    System.out.println("Power Math\n" + powerMath);

    Scanner sc = new Scanner(System.in);
    System.out.println("What expression would you like to calculate?: ");
    String original = sc.nextLine();
    Calculator input = new Calculator(original);
    System.out.println("Result: " + input);
    
  }
  
}