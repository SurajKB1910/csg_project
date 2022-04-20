package com.csg.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**

 * Count words test class
 *
 * @author      Suraj K B
 */

public class CountWordTest {

    private CountWordData defaultInitialize () {
        return new CountWordData(
                "src/main/resources/sample.txt",
                "M",
                4
        );
    }

    /**
     * Used to test - word matches starts with T
     *
     */
    @DisplayName("Test - word matches starts with T")
    @Test
    public void wordMatchesWhichStartsWith() {
        //CountWordData countWordData = defaultInitialize();

        CountWordData countWordData = new CountWordData(
                "src/test/resources/test1.txt",
                "T"
        );

        CountWord countWord = new CountWord(countWordData);

        List<String> expectedWordMatchesStartsWith = Arrays.asList("Testing", "team", "the");
        List<String> actualWordMatchesStartsWith = countWord.getWordsStartsWith();

        assertEquals(expectedWordMatchesStartsWith, actualWordMatchesStartsWith);
    }

    /**
     * Used to test - word matches longer than 6 characters.
     *
     */
    @DisplayName("Test - word matches longer than 6 char")
    @Test
    public void wordMatchesWhichLongerThan() {
        //CountWordData countWordData = defaultInitialize();

        CountWordData countWordData = new CountWordData(
                "src/test/resources/test1.txt",
                6
        );

        CountWord countWord = new CountWord(countWordData);

        List<String> expectedWordMatchesLongerWords = Arrays.asList("Testing", "What's", "progress");
        List<String> actualWordMatchesLongerWords = countWord.getWordsLongerThan();

        assertEquals(expectedWordMatchesLongerWords, actualWordMatchesLongerWords);

    }

    /**
     * Used to test - word not matches with starting character - R
     *
     */
    @DisplayName("Test - not starting with")
    @Test
    public void notMatchingAnyWords() {
        //defaultInitialize();

        CountWordData countWordData = new CountWordData(
                "src/test/resources/test1.txt",
                "R",
                40
        );

        CountWord countWord = new CountWord(countWordData);

        List<String> expectedWordMatchesStartsWith = Arrays.asList();
        List<String> actualWordMatchesStartsWith = countWord.getWordsStartsWith();

        assertEquals(expectedWordMatchesStartsWith, actualWordMatchesStartsWith);
    }

    /**
     * Used to test - word not matches with length of character - 40
     *
     */

    @DisplayName("Test - not matching length of char")
    @Test
    public void notMatchinglength() {
        //defaultInitialize();

        CountWordData countWordData = new CountWordData(
                "src/test/resources/test1.txt",
                40
        );

        CountWord countWord = new CountWord(countWordData);

        List<String> expectedWordMatchesLongerWords = Arrays.asList();
        List<String> actualWordMatchesLongerWords = countWord.getWordsLongerThan();

        assertEquals(expectedWordMatchesLongerWords, actualWordMatchesLongerWords);

    }

}
