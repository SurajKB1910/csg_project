package com.csg.project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**

 * Count words that processes a list of String and applies -
 * - Counts and returns the number of words that start with specific character
 * - Returns all the words longer than given number
 *
 * @author      Suraj K B
 */

public class CountWord {

    private static final String splitPattern = "\\s+";
    private CountWordData countWordData ;

    /**
     * Constructs a new <code>CountWord</code>
     *
     * @param  countWordData An input data
     */
    public CountWord(CountWordData countWordData) {
        this.countWordData = countWordData;
    }

    /**
     * Used to get Buffer reader object to read the file.
     *
     * @param  fileName An input file name - absolute file path
     */
    private BufferedReader getInputFileReader(String fileName) {
        File inputFile = new File(fileName);

        try {
            return new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Used to close Buffer reader object.
     *
     * @param  fileReader An input buffer reader
     */
    private void closeInputFileReader(BufferedReader fileReader) {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to read the data from file and split data based on newline or space character.
     *
     * @param  inputFileReader An input buffer reader
     */
    private List<String> splitStringToWordsList(BufferedReader inputFileReader) {

        String line ;
        List<String> listOfString = null;

        try {
            line = inputFileReader.readLine();
            if (line != null)
                listOfString = Pattern.compile(splitPattern)
                        .splitAsStream(line)
                        .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfString;
    }

    /**
     * Used to parse the data from file and count the number of words starts with specific character
     *
     * @return List of Words which matches with specific character.
     */
    private List<String> getListOfWordsStartsWith() {
        List<String> wordsStartsWith = new ArrayList<String>();
        BufferedReader inputFileReader = getInputFileReader(countWordData.getInputFilePath());
        List<String> listOfString = splitStringToWordsList(inputFileReader);

        while(listOfString!=null && listOfString.size()>0) {
            wordsStartsWith.addAll(listOfString.stream().filter(word -> word.toLowerCase().startsWith(countWordData.getCharToFindStartsWith().toLowerCase())).collect(Collectors.toList()));
            listOfString = splitStringToWordsList(inputFileReader);
        }

        closeInputFileReader(inputFileReader);

        return wordsStartsWith;
    }

    /**
     * Used to parse the data from file and count the number of words starts with specific character
     *
     * @return List of Words which matches with specific character.
     */
    public List<String> getWordsStartsWith() {

        List<String> wordsStartsWith = getListOfWordsStartsWith();

        System.out.println("Number of words that starts with \"" + countWordData.getCharToFindStartsWith().toUpperCase() + "\" or \"" + countWordData.getCharToFindStartsWith().toLowerCase() + "\" is " + wordsStartsWith.size());
        System.out.println("Words starts with \"" + countWordData.getCharToFindStartsWith().toUpperCase() + "\" or \"" + countWordData.getCharToFindStartsWith().toLowerCase() + "\" is " + wordsStartsWith);

        return wordsStartsWith;
    }

    /**
     * Used to parse the data from file and words longer than given number
     *
     * @return List of Words which longer than with given number.
     */
    private List<String> getListOfWordsLongerThan() {
        List<String> wordsLongerThan = new ArrayList<String>();
        BufferedReader inputFileReader = getInputFileReader(countWordData.getInputFilePath());
        List<String> listOfString = splitStringToWordsList(inputFileReader);

        while(listOfString!=null && listOfString.size()>0) {
            wordsLongerThan.addAll(listOfString.stream().filter(word -> word.length() >= countWordData.getNumberToFindLongerString()).collect(Collectors.toList()));
            listOfString = splitStringToWordsList(inputFileReader);
        }

        closeInputFileReader(inputFileReader);

        return wordsLongerThan;
    }

    /**
     * Used to parse the data from file and words longer than given number
     *
     * @return List of Words which longer than with given number.
     */
    public List<String> getWordsLongerThan() {
        List<String> wordsLongerThan = getListOfWordsLongerThan();

        System.out.println("Number of words that longer than \"" + countWordData.getNumberToFindLongerString() + "\" character is " + wordsLongerThan.size());
        System.out.println("Words that longer than \"" + countWordData.getNumberToFindLongerString() + "\" character is " + wordsLongerThan);
        return wordsLongerThan;
    }
}
