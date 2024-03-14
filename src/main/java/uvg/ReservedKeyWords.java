package uvg;

import java.util.HashMap;
import java.util.Map;

public class ReservedKeyWords {
    private static ReservedKeyWords instance;
    private Map<String, EEvaluationType> map;

    private ReservedKeyWords(){
        map = new HashMap<>();
        map.put("+", EEvaluationType.ADDITION);
        map.put("-", EEvaluationType.SUBTRACTION);
        map.put("*", EEvaluationType.MULTIPICATION);
        map.put("/", EEvaluationType.DIVISION);
        map.put("%", EEvaluationType.MODULUS);

        map.put("setq", EEvaluationType.SETQ);

        map.put("quote", EEvaluationType.QUOTE);
        map.put("\'", EEvaluationType.QUOTE);

        map.put("atom", EEvaluationType.ATOM);
        map.put("list", EEvaluationType.LIST);
        map.put("equal", EEvaluationType.EQUAL);
        map.put("=", EEvaluationType.EQUAL);

        map.put("<", EEvaluationType.LESSTHAN);
        map.put(">", EEvaluationType.GREATERTHAN);
        
        map.put("cond", EEvaluationType.COND);



    }

    public synchronized static ReservedKeyWords getInstance(){
        if(instance == null){
            instance = new ReservedKeyWords();
        }
        return instance;
    }

    public EEvaluationType getKeyword(String key){
        return map.get(key);
    }
}
