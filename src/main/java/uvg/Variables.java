package uvg;

import java.util.HashMap;
import java.util.Map;

public class Variables {
    private Map<String, String> variables;

    private static Variables instance;

    /**
      * @description private constructor that prevents external instantation
      */
    private Variables(){
        variables = new HashMap<String, String>();
    }

    /**
      * @return
      * @description retrieves the singleton instance of varible class
      */
    public synchronized static Variables getInstance(){
        if(instance == null){
            instance = new Variables();
        }
        return instance;
    }

    /**
      * @param key
      * @param value
      * @description sets a variable with specified key and value
      */
    public void setqOperation(String key, String value){
        variables.put(key, value);
    }

    /**
      * @param key
      * @return
      * @description method that checks if a variable with specified key exist
      */
    public boolean checkVariableExists(String key){
        return variables.containsKey(key);
    }

    /**
      * @param key
      * @return
      * @description retrieves the value of a variable associated with a specified key
      */
    public String getVariable(String key){
        return variables.get(key);
    }

}
