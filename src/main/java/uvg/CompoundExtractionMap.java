package uvg;

import java.util.HashMap;
import java.util.Map;

public class CompoundExtractionMap {
    private static CompoundExtractionMap instance;
    private Map<String, CompoundExtraction> map;

    private CompoundExtractionMap(){
        map = new HashMap<>();
        map.put("cond", CompoundExtraction.COND);
        map.put("if", CompoundExtraction.IF);

    }

    public synchronized static CompoundExtractionMap getInstance(){
        if(instance == null){
            instance = new CompoundExtractionMap();
        }
        return instance;
    }

    public CompoundExtraction getKeyword(String key){
        return map.get(key);
    }
}
