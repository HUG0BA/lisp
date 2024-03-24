package uvg;

public class SimpleExtractionPair {

    private SimpleExtraction keyword;
    private String command;

    /**
     * @param keyWord
     * @param command
     * @description sonstructor with specified keyWord and command
     */
    public SimpleExtractionPair(SimpleExtraction keyWord, String command){
        this.keyword = keyWord;
        this.command = command;
    }

    /**
     * @return
     * @description retrieves the keyword of the pair
     */
    public SimpleExtraction getKeyword(){
        return this.keyword;
    }

    /**
     * @return
     * @description retrives the command with the pair
     */
    public String getCommand(){
        return this.command;
    }

    /**
     * @param command
     * @return
     * @description sets the command associated with the pair
     */
    public void setCommand(String command){
        this.command = command;
    }

    /**
     * @param other 
     * @return
     * @description method checks of the SimpleExtractionPair is equals to another SimpleExtractionPair
     */
    public boolean equals(SimpleExtractionPair other){
        return (this.keyword.equals(other.getKeyword()) && this.command.equals(other.getCommand()));
    }

}
