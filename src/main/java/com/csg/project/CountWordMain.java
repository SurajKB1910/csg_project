package com.csg.project;

import java.util.Scanner;

/**

 * Main class to count words that processes a list of String and applies -
 * - Counts and returns the number of words that start with specific character
 * - Returns all the words longer than given number
 *
 * @author      Suraj K B
 */

public class CountWordMain {

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/sample.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character to find number of string which starts with: ");
        String charToFindStartsWith = scanner.nextLine();

        System.out.println("Enter a value to find words which longer than value: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Enter proper number: ");
            scanner.nextLine();
        }

        int numberToFindLongerString = scanner.nextInt();

        CountWordData countWordData = new CountWordData(
                inputFilePath,
                charToFindStartsWith,
                numberToFindLongerString
        );

        CountWord countWord = new CountWord(countWordData);

        countWord.getWordsStartsWith();
        countWord.getWordsLongerThan();

        scanner.close();
    }
}