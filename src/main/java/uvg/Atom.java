package uvg;

public class Atom{

     public static boolean evaluateAtom(String expression) {
          expression = expression.trim();
          boolean validation = false;
          if (expression.startsWith("(") && expression.endsWith(")")){
               validation = false;
               return validation;
          } else {
               validation = true;
               return validation;
          }
     }

}
