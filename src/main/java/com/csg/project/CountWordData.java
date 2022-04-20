package com.csg.project;

/**

 * Pojo class to store the data information about count word
 *
 * @author      Suraj K B
 */

public class CountWordData {
    private String inputFilePath, charToFindStartsWith;
    private int numberToFindLongerString;

    public CountWordData(String inputFilePath, String charToFindStartsWith, int numberToFindLongerString) {
        this.inputFilePath = inputFilePath;
        this.charToFindStartsWith = charToFindStartsWith;
        this.numberToFindLongerString = numberToFindLongerString;
    }

    public CountWordData(String inputFilePath, String charToFindStartsWith) {
        this.inputFilePath = inputFilePath;
        this.charToFindStartsWith = charToFindStartsWith;
        this.numberToFindLongerString = -1;
    }

    public CountWordData(String inputFilePath, int numberToFindLongerString) {
        this.inputFilePath = inputFilePath;
        this.charToFindStartsWith = null;
        this.numberToFindLongerString = numberToFindLongerString;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getCharToFindStartsWith() {
        return charToFindStartsWith;
    }

    public void setCharToFindStartsWith(String charToFindStartsWith) {
        this.charToFindStartsWith = charToFindStartsWith;
    }

    public int getNumberToFindLongerString() {
        return numberToFindLongerString;
    }

    public void setNumberToFindLongerString(int numberToFindLongerString) {
        this.numberToFindLongerString = numberToFindLongerString;
    }
}
