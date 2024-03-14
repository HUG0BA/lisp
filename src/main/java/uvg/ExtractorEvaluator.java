package uvg;

import java.util.ArrayList;

public class ExtractorEvaluator {
    
    public static String evaluateExtractions(ArrayList<DataTriplet> dataTripletArr){

        DataTriplet current = dataTripletArr.get(0);
        String currentResult = evaluateSingleExtraction(current);

        for(int i = 1; i < dataTripletArr.size();i++){
            current = null;
            current = dataTripletArr.get(i);
            current.setCommand(current.getCommand().replace("REPLACE"+i, currentResult));
            currentResult = evaluateSingleExtraction(current);
        }

        return currentResult;

    }

    private static String evaluateSingleExtraction(DataTriplet dataTriplet){
        switch(dataTriplet.getExtractionType()){
            case ARITHMETIC:
                return CommandEvaluator.evaluateAritmethic(dataTriplet);
            case SETQ: 
                return CommandEvaluator.evaluateSetq(dataTriplet.getCommand());
            default:
                return "";
        }
    }
}
