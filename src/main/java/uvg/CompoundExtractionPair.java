package uvg;

import java.util.ArrayList;
import java.util.Map;

public class CompoundExtractionPair {
    private CompoundExtraction compoundExtraction;
    private Map<String, String[]> simpleExtractionMap;

     /**
     * @param compoundExtraction
     * @param simpleExtractionMap
     * @description Constructor that have a specified compound extraction type and map of single sxtraction type
     */
    public CompoundExtractionPair(CompoundExtraction compoundExtraction, Map<String, String[]> simpleExtractionMap){
        this.compoundExtraction = compoundExtraction;
        this.simpleExtractionMap = simpleExtractionMap;
    }

    /**
     * @return 
     * @description return a compaund extraction type associated with this pairs 
     */
    public CompoundExtraction getExtractionType(){
        return this.compoundExtraction;
    }

    /**
     * @return 
     * @description retrieve a map of simgle extraction pairs associated with this pairs
     */
    public Map<String, String[]> getSimpleExtractionMap(){
        return this.simpleExtractionMap;
    }
}
