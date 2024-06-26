package uvg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.AbstractMap.*;
import java.util.regex.*;

import java.util.List;
import java.util.Stack;

public class Tokenizer {

     /**
     * @param str 
     * @return
     * @description method tokenizes a given string into a list of tokens
     */
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
     * @description method that stracts a token along with its symbol
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
          return new SimpleEntry<String, float[]>(Symbol, tokenslist);
     }

     /**
      * @param str
      * @return
      * @description tokenize a given string and stracts the numerical tokens
      */
     public static float[] numberTokenizer(String str) {
          String regex = "(\\d*\\.?\\d+)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          int count = 0;

          while (matcher.find()) {
               count++;
          }

          float[] tokenslist = new float[count];
          matcher.reset();
          count = 0;

          while (matcher.find()) {
               float current = Float.parseFloat(matcher.group(1));
               tokenslist[count] = current;
               count++;
          }

          return tokenslist;
     }

     /**
      * @param str
      * @return
      * @description tokenize a given string that contains booleans expressions
      */
     public static boolean[] booleanTokenizer() {
          return null;
     }

     /**
      * @param str
      * @return
      * @description tokenize a given string containing Quote expressions using (quote...) function syntax
      */
     public static String quoteFunctionTokenizer(String str) {
          String regex = "\\(quote (.+)\\)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          String token = "";

          while (matcher.find()) {
               token = matcher.group(1);
          }

          return token;
     }

     /**
      * @param str
      * @return
      * @description tokenize a given string containing quoted expressions using ' (quote) syntax
      */
     public static String quoteSignTokenizer(String str) {
          String regex = "\'(.+)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          String token = "";

          while (matcher.find()) {
               token = matcher.group(1);

          }

          return token;
     }

     /**
      * @param str
      * @return
      * @description tokenize a given string contaninig (setq ...) expressions to extract variables assigments
      */
     public static ArrayList<String> setqTokenizer(String str) {
          String regex = "\\( *([^ ]*) ([^ ]*).*\\)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          ArrayList<String> arrToken = new ArrayList<String>();

          while (matcher.find()) {
               arrToken.add(matcher.group(1));
               arrToken.add(matcher.group(2));
               str = str.replaceFirst(matcher.group(1), " ");
               str = str.replaceFirst(matcher.group(2), " ");
               // The code below is not the most effective solution for the problem, but time
               // was not from our side
               // The problema is that once the regex matches two empty strings in group 1 and
               // 2, which enters an endless loop
               // This happens when the string reaches the following state (setq )
               if (arrToken.contains("")) {
                    arrToken.remove("");
                    return arrToken;
               }
               matcher.reset(str.trim());
          }
          return arrToken;
     }

     /**
      * @param str
      * @return
      * @description tokenize a given string containing (cond ...) expressions to extract conditional statements
      */
     /*public static Map<String, String> condTokenizer(String str) {
          String regex = "\\(cond (.*)\\)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          String conditions = "";

          while (matcher.find()) {
               conditions = matcher.group(1);
          }

          ArrayList<String> conditionsArr = Chunker.getChunks(conditions);

     }*/

     /**
      * @param conditionsArr
      * @return
      * @description tokenize a given ArrayList contaninig conditions extracted from a (cond ...) expression
      */
     /*public static Map<String, String> conditionsTokenizer(ArrayList<String> conditionsArr) {
          for (String str : conditionsArr) {

          }
     }*/

     /**
      * @param str
      * @return
      * @description tokenize a given string contaning mathematical expressions to verify their vality. It return a float array of sixe 2
      */
     public static float[] verifyExpressionTokenizer(String str) {
          String regex = "(\\d+\\.?\\d*) (\\d+\\.?\\d*)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          int count = 1;

          while (matcher.find()) {
               count++;
          }

          float[] tokenslist = new float[count];
          matcher.reset();

          while (matcher.find()) {
               float n1 = Float.parseFloat(matcher.group(1));
               float n2 = Float.parseFloat(matcher.group(2));

               tokenslist[0] = n1;
               tokenslist[1] = n2;
          }

          return tokenslist;
     }

}
