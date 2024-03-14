package uvg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class List {

     public String evaluateList(String[] expression) {

          StringBuilder result = new StringBuilder();

          for (int i = 0; i < expression.length; i++) {
               result.append(expression[i]);
               if (i < expression.length - 1) {
                    result.append(" ");
               }
          }
          return result.toString();
     }

}