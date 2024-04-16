package org.example;

import java.lang.reflect.Array;

import static java.lang.Math.max;

public class mostWordsFound {

    public static void main(String[] args) {

        System.out.println("mostWordsFound");
        // You would like to find the sentence containing the largest number of words in some given text.
        // The text is specified as a string S consisting of N characters:
        //  letters, spaces, dots, question marks and exclamation marks.
        System.out.println(new mostWordsFound().solution("We test coders, Give us a try?"));
        System.out.println(new mostWordsFound().solution("We test coders, Give us a try?, We test coders Give us a try? "));
        System.out.println(new mostWordsFound().solution("We test coders, Give us a try?. . We test coders Give us a try? "));

        String strName = "John Doe";
        String textBlockName = """
                John Doe""";
        System.out.println(strName);
        System.out.println(textBlockName);
        System.out.println(strName.equals(textBlockName));
        System.out.println(strName == textBlockName);
    }
    public int solution(String S) {
        String[] sentences = S.split("[,.!?]");

        int maxWords = 0;
        for (String sentence : sentences) {
            System.out.println("sentence = " + sentence);
            String[] words = sentence.trim().split("\\s+");
            int wordCount = words.length;
            maxWords = Math.max(maxWords, wordCount);
        }

        return maxWords;
    }

}