package uvg;

public class DataTriplet {

    private EExtractionType extractionType;
    private EEvaluationType keyword;
    private String command;

    public DataTriplet(EExtractionType extractionType, EEvaluationType keyWord, String command){
        this.extractionType = extractionType;
        this.keyword = keyWord;
        this.command = command;
    }

    public EExtractionType getExtractionType(){
        return this.extractionType;
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

    public boolean equals(DataTriplet other){
        return (this.keyword.equals(other.getKeyword()) && this.command.equals(other.getCommand()));
    }

}
