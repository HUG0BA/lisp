package uvg;
import java.util.ArrayList;

public class Quote {
    
    /**
     * @param expression
     * @return 
     * @description evaluates a quote expression and adds the proper Quote expression syntax
     */
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
            quote = quote + "(quote ";
            closing = closing + ")";
        }

        return quote + expression + closing;
        
    }
}
