package uvg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandEvaluator {
    
    public static String evaluateAritmethic(DataTriplet dataTriplet){
        float[] arguments = Tokenizer.numberTokenizer(dataTriplet.getCommand());
        switch (dataTriplet.getKeyword()) {
            case ADDITION:
                return ArithmeticOperations.sum(arguments);
            
            case SUBTRACTION:
                return ArithmeticOperations.subtraction(arguments);

            case MULTIPICATION:
                return ArithmeticOperations.multiplication(arguments);

            case DIVISION:
                return ArithmeticOperations.division(arguments);

            case MODULUS:
                return ArithmeticOperations.modolusSign(arguments);
        
            default:
                return "0";
        
        }
    }

    public static String evaluateSetq(String command){
        ArrayList<String> arguments = Tokenizer.setqTokenizer(command);
        String last = "";
        for(int i = 0; i < (arguments.size()/2)-1; i++){
            Variables.getInstance().setqOperation(arguments.get(i), arguments.get(i+1));
            last = arguments.get(i+1);
        }
        return last;
    }

    public void evaluteComparison(String command){

    }
}
