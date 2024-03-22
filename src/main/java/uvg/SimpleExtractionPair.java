package uvg;

public class SimpleExtractionPair {

    private SimpleExtraction keyword;
    private String command;

    public SimpleExtractionPair(SimpleExtraction keyWord, String command){
        this.keyword = keyWord;
        this.command = command;
    }

    public SimpleExtraction getKeyword(){
        return this.keyword;
    }

    public String getCommand(){
        return this.command;
    }

    public void setCommand(String command){
        this.command = command;
    }

    public boolean equals(SimpleExtractionPair other){
        return (this.keyword.equals(other.getKeyword()) && this.command.equals(other.getCommand()));
    }

}
