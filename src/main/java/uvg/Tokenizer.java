package uvg;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.AbstractMap.*;
import java.util.regex.*;

import java.util.List;
import java.util.Stack;

public class Tokenizer {

     public List<String> tokenizer(String str) {
          List<String> tokens = new ArrayList<>();
          String regex = "\\\\(|\\\\)|[a-zA-Z0-9+*/<>=!_?-]+";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);

          while (matcher.find()) {
               tokens.add(matcher.group());
          }
          return tokens;
     }

     /**
      * @param str
      * @return
      */
     public static SimpleEntry<String, float[]> tokenizers(String str) {
          String regex = "\\\\(|\\\\)|[a-zA-Z0-9+*/<>=!_?-]+";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          int count = 0;
          String Symbol = "";

          while (matcher.find()) {
               count++;
          }

          float[] tokenslist = new float[count];
          int index = 0;

          for (int i = 0; i >= str.length(); i++) {
               char e = str.charAt(i);
               if (e == '*' || e == '+' || e == '-' || e == '/') {
                    Symbol = String.valueOf(e);
               } else {
                    StringBuilder numstr = new StringBuilder();
                    while (i < str.length()) {
                         numstr.append(e);
                         i++;
                    }
                    i--;
                    tokenslist[index++] = Float.parseFloat(numstr.toString());
               }
          }
          return new SimpleEntry<String,float[]>(Symbol, tokenslist) ;
     }
}
