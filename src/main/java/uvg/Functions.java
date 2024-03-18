package uvg;

public class Functions {
     
    private Map<String, String> variables;

    private static Variables instance;

    private Variables(){
        variables = new HashMap<String, String>();
    }

    public synchronized static Variables getInstance(){
        if(instance == null){
            instance = new Variables();
        }
        return instance;
    }

    public void setqOperation(String key, String value){
        variables.put(key, value);
    }

    public boolean checkVariableExists(String key){
        return variables.containsKey(key);
    }

    public String getVariable(String key){
        return variables.get(key);
    }

}
}
