package uvg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class List {
    

     public String[] evaluateList(String expression){
          String regex = "\\\\\\\\(|\\\\\\\\)|[a-zA-Z0-9+*/<>=!_?-]+";
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(expression);
          ArrayList<String> tokens = new ArrayList<>();

          while(matcher.find()){
               String token = matcher.group().trim();
               if(!token.isEmpty()){
                    tokens.add(token);
               }
          }
          String[] tokenArr = new String[tokens.size()];
          tokenArr = tokens.toArray(tokenArr);

          return tokenArr;
     }
     
}
