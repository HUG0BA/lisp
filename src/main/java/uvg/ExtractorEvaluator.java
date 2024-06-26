package uvg;

import java.util.ArrayList;

public class ExtractorEvaluator {
    
    /**
     * @param dataPairArrx  
     * @return 
     * @description method evaluates a sequance of single extraction represented by a evaluateSingleExtractions object
     */
    public static String evaluateSingleExtractions(ArrayList<SimpleExtractionPair> dataPairtArr){

        SimpleExtractionPair current = dataPairtArr.get(0);
        String currentResult = evaluateSingleExtraction(current);

        for(int i = 1; i < dataPairtArr.size();i++){
            current = null;
            current = dataPairtArr.get(i);
            current.setCommand(current.getCommand().replace("REPLACE"+i, currentResult));
            currentResult = evaluateSingleExtraction(current);
        }

        return currentResult;

    }

    /**
     * @param dataPair
     * @return 
     * @description method evaluates a single extraction represented by a SimpleExtractionPair object
     */
    private static String evaluateSingleExtraction(SimpleExtractionPair dataPair){
        switch(dataPair.getKeyword()){
            case ADDITION:
                return CommandEvaluator.evaluateSum(dataPair.getCommand());

            case SUBTRACTION:
                return CommandEvaluator.evaluateSubtraction(dataPair.getCommand());
                
            case MULTIPICATION:
                return CommandEvaluator.evaluateMultiplication(dataPair.getCommand());

            case DIVISION:
                return CommandEvaluator.evaluateDivision(dataPair.getCommand());

            case MODULUS:
                return CommandEvaluator.evaluateModulus(dataPair.getCommand());

            case SETQ: 
                return CommandEvaluator.evaluateSetq(dataPair.getCommand());

            case LESSTHAN: 
                return CommandEvaluator.evaluateLessExpression(dataPair.getCommand());

            case GREATERTHAN: 
                return CommandEvaluator.evaluateGreaterExpression(dataPair.getCommand());
            
            case EQUAL: 
                return CommandEvaluator.evaluateEqualsToExpression(dataPair.getCommand());

            case ATOM: 
                return CommandEvaluator.evaluateEqualsToExpression(dataPair.getCommand());

            case LIST: 
                return CommandEvaluator.evaluateList(dataPair.getCommand());




            default:
                return "";
        }
    }
}
