package uvg;

import java.util.HashMap;
import java.util.Map;

public class CompoundExtractionMap {
    private static CompoundExtractionMap instance;
    private Map<String, CompoundExtraction> map;

    /**
     * @description private constructor that inizializate a Map 
     */
    private CompoundExtractionMap(){
        map = new HashMap<>();
        map.put("cond", CompoundExtraction.COND);
        map.put("if", CompoundExtraction.IF);

    }

    /**
     * @return 
     * @description return a singleton instance of the CompoundExtractionMap
     */
    public synchronized static CompoundExtractionMap getInstance(){
        if(instance == null){
            instance = new CompoundExtractionMap();
        }
        return instance;
    }

    /**
     * @param key 
     * @return 
     * @description extract the type associated with a given kayword
     */
    public CompoundExtraction getKeyword(String key){
        return map.get(key);
    }
}
