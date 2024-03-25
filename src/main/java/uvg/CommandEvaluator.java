package uvg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandEvaluator {
    
    /**
     * @param command 
     * @return
     * @decription this method evaluate a number given in a string format, it stracts the numbers from the string and make ethe aritmetic operation
     * */
    public static String evaluateSum(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.sum(arguments);
    }

    /**
     * @param command 
     * @return
     * @decription this method evaluate a number given in a string format, it stracts the numbers from the string and make ethe aritmetic operation
     * */
    public static String evaluateSubtraction(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.subtraction(arguments);
    }

    /**
     * @param command 
     * @return
     * @decription this method evaluate a number given in a string format, it stracts the numbers from the string and make ethe aritmetic operation
     * */
    public static String evaluateMultiplication(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.multiplication(arguments);
    }

    /**
     * @param command 
     * @return
     * @decription this method evaluate a number given in a string format, it stracts the numbers from the string and make ethe aritmetic operation
     * */
    public static String evaluateDivision(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.division(arguments);
    }

    /**
     * @param command 
     * @return
     * @decription this method evaluate a number given in a string format, it stracts the numbers from the string and make ethe aritmetic operation
     * */
    public static String evaluateModulus(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.numberTokenizer(command);
        return ArithmeticOperations.modolusSign(arguments);
    }
    
    /**
     * @param command 
     * @return
     * @decription this method evaluate a string format, it stracts the tokens in pairs to asing the proper value
     * */
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

    /**
    * @param command
    * @return 
    * @description method search for a provided variable and replace it to a corresponding value
    */
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

    /**
    * @param command
    * @return 
    * @description method process a string to remove single quotes from around words specifically within parenthesis
    */
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

    /**
    * @param command
    * @return 
    * @description method determins if the first number is greater than the second one given in a string 
    */
    public static String evaluateGreaterExpression(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.verifyExpressionTokenizer(command);
        return VerifyExpresion.greaterThan(arguments);
    }
   
    /**
    * @param command
    * @return 
    * @description method determins if the first number is lower than the second one given in a string 
    */
    public static String evaluateLessExpression(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.verifyExpressionTokenizer(command);
        return VerifyExpresion.lessThan(arguments);
    }
   
    /**
    * @param command
    * @return 
    * @description method determins if the first number is equals than the second one given in a string 
    */
    public static String evaluateEqualsToExpression(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        float[] arguments = Tokenizer.verifyExpressionTokenizer(command);
        return VerifyExpresion.equalsTo(arguments);
   }

   /**
    * @param command
    * @return 
    * @description method determins if the first number is greater than the second one given in a string 
    */
    public static String evaluateList(String command){
        command = checkForVariables(command);
        command = checkForQuotes(command);
        //String[] arguments = Tokenizer.verifyExpressionTokenizer(command);
        return List.evaluateList(null);
    }



}
