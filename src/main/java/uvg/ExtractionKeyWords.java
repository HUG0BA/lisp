package uvg;

import java.util.HashMap;
import java.util.Map;

public class ExtractionKeyWords {
    private static ExtractionKeyWords instance;
    private Map<String, EExtractionType> map;

    private ExtractionKeyWords(){
        map = new HashMap<>();
        map.put("+", EExtractionType.ARITHMETIC);
        map.put("-", EExtractionType.ARITHMETIC);
        map.put("*", EExtractionType.ARITHMETIC);
        map.put("/", EExtractionType.ARITHMETIC);
        map.put("%", EExtractionType.ARITHMETIC);

        map.put("setq", EExtractionType.SETQ);

        /*
        map.put("quote", EExtractionType.QUOTE);
        map.put("\'", EExtractionType.QUOTE);

        map.put("atom", EExtractionType.ATOM);
        map.put("list", EExtractionType.LIST);
        map.put("equal", EExtractionType.EQUAL);

        map.put("<", EExtractionType.LESSTHAN);
        map.put(">", EExtractionType.GREATERTHAN);
        
        map.put("cond", EExtractionType.COND);

        */

    }

    public synchronized static ExtractionKeyWords getInstance(){
        if(instance == null){
            instance = new ExtractionKeyWords();
        }
        return instance;
    }

    public EExtractionType getEvaluationType(String key){
        return map.get(key);
    }
}
