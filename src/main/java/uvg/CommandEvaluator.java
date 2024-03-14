package uvg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandEvaluator {
    
    public static String evaluateSum(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.sum(arguments);
    }

    public static String evaluateSubtraction(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.subtraction(arguments);
    }

    public static String evaluateMultiplication(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.multiplication(arguments);
    }

    public static String evaluateDivision(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.division(arguments);
    }

    public static String evaluateModulus(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.modolusSign(arguments);
    }
    

    public static String evaluateSetq(String command){
        //command = checkForVariables(command);
        command = checkForQuotes(command);
        ArrayList<String> arguments = Tokenizer.setqTokenizer(command);
        String last = "";
        for(int i = 0; i < arguments.size()-1; i+=2){
            last = checkForVariables(arguments.get(i+1));
            Variables.getInstance().setqOperation(arguments.get(i), last);
            
        }
        return last;
    }

    public void evaluteComparison(String command){

    }

    public static String checkForVariables(String command){
        String regex = "(?<!\\')(\\d*[a-zA-Z]+[^ \\(\\)\\.\\']*\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        String key = "";
        String value = "";

        while(matcher.find()){
            key = matcher.group(1);
            if(!key.equals("")){
                value = Variables.getInstance().getVariable(key);
                command = command.replace(key, value);
            }
            
        }
        return command;
    }

    public static String checkForQuotes(String command){
        String regex = "\\(.*(\\'([^ ]+)).*\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        while(matcher.find()){
            if(!matcher.group(1).equals("")){
                command = command.replace(matcher.group(1), matcher.group(2));
            }
            
        }

        return command;
    }

}
