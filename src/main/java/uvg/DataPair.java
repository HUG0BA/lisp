package uvg;

public class DataPair {

    private EEvaluationType keyword;
    private String command;

    public DataPair(EEvaluationType keyWord, String command){
        this.keyword = keyWord;
        this.command = command;
    }

    public EEvaluationType getKeyword(){
        return this.keyword;
    }

    public String getCommand(){
        return this.command;
    }

    public void setCommand(String command){
        this.command = command;
    }

    public boolean equals(DataPair other){
        return (this.keyword.equals(other.getKeyword()) && this.command.equals(other.getCommand()));
    }

}
