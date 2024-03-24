package uvg;

public class Atom {

     /**
      * @param expression
      * @return
      * @description: this method evaluates a String and check of the String passed starts with "(" and en with ")"
      */
     public static boolean evaluateAtom(String expression) {
          expression = expression.trim();
          boolean validation = false;
          if (expression.startsWith("(") && expression.endsWith(")")) {
               validation = false;
               return validation;
          } else {
               validation = true;
               return validation;
          }
     }

}
