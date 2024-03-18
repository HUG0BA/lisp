package uvg;

import java.util.ArrayList;
import java.util.Map;

public class CompoundExtractionPair {
    private CompoundExtraction compoundExtraction;
    private Map<String, String[]> simpleExtractionMap;

    public CompoundExtractionPair(CompoundExtraction compoundExtraction, Map<String, String[]> simpleExtractionMap){
        this.compoundExtraction = compoundExtraction;
        this.simpleExtractionMap = simpleExtractionMap;
    }

    public CompoundExtraction getExtractionType(){
        return this.compoundExtraction;
    }

    public Map<String, String[]> getSimpleExtractionMap(){
        return this.simpleExtractionMap;
    }
}
