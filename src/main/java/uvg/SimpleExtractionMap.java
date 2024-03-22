package uvg;

import java.util.HashMap;
import java.util.Map;

public class SimpleExtractionMap {
    private static SimpleExtractionMap instance;
    private Map<String, SimpleExtraction> map;

    private SimpleExtractionMap(){
        map = new HashMap<>();
        map.put("+", SimpleExtraction.ADDITION);
        map.put("-", SimpleExtraction.SUBTRACTION);
        map.put("*", SimpleExtraction.MULTIPICATION);
        map.put("/", SimpleExtraction.DIVISION);
        map.put("%", SimpleExtraction.MODULUS);

        map.put("setq", SimpleExtraction.SETQ);

        map.put("quote", SimpleExtraction.QUOTE);
        map.put("\'", SimpleExtraction.QUOTE);

        map.put("atom", SimpleExtraction.ATOM);
        map.put("list", SimpleExtraction.LIST);
        map.put("equal", SimpleExtraction.EQUAL);
        map.put("=", SimpleExtraction.EQUAL);

        map.put("<", SimpleExtraction.LESSTHAN);
        map.put(">", SimpleExtraction.GREATERTHAN);
        
        map.put("cond", SimpleExtraction.COND);



    }

    public synchronized static SimpleExtractionMap getInstance(){
        if(instance == null){
            instance = new SimpleExtractionMap();
        }
        return instance;
    }

    public SimpleExtraction getKeyword(String key){
        return map.get(key);
    }
}
