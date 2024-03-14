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

     public static boolean[] booleanTokenizer() {
          return null;
     }

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

     public static ArrayList<String> setqTokenizer(String str){
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

     /* 0 */
     public static Map<String, String> condTokenizer(String str) {
          String regex = "\\(cond (.*)\\)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          String conditions = "";

          while (matcher.find()) {
               conditions = matcher.group(1);
          }

          ArrayList<String> conditionsArr = Chunker.getChunks(conditions);

     }

     public static Map<String, String> conditionsTokenizer(ArrayList<String> conditionsArr) {
          for (String str : conditionsArr) {

          }
     }

     public static String veryfyExpressionTokenizer(String str) {
          String regex = "(\\d+\\.?\\d*) (\\d+\\.?\\d*)";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(str);
          StringBuilder numbers = new StringBuilder();

          while (matcher.find()) {
               String number1 = matcher.group(1);
               String number2 = matcher.group(2);
               numbers.append(number1).append(" ").append(number2);

          }
          return numbers.toString().trim();
     }

}
