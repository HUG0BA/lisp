package uvg;
import java.util.ArrayList;

public class Quote {
     
    public String evaluateQoute(String expression){
        int count = 0;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '\'');
            
            count ++;
        }
        expression.replace("\'", "");

        if(count == 0){
            return expression;
        }

        String quote = "";
        String closing = "";
        for(int i = 0; i < count; i++){
            quote = quote + "(QUOTE ";
            closing = closing + ")";
        }

        return quote + expression + closing;
        
    }
}
