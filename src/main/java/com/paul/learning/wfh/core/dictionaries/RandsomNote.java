package com.paul.learning.wfh.core.dictionaries;

import java.util.HashMap;
import java.util.Map;

import static com.paul.learning.wfh.constants.GlobalConstants.SEPARATOR_SPACE;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting.
 * He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use only whole words available in the magazine.
 * He cannot use substrings or concatenation to create the words he needs.
 * <p>
 * Given the words in the magazine and the words in the ransom note,
 * print Yes if he can replicate his ransom note exactly using whole words from the magazine;
 * otherwise, print No.
 * <p>
 * For example, the note is "Attack at dawn".
 * The magazine contains only "attack at dawn".
 * The magazine has all the right words, but there's a case mismatch. The answer is No.
 */
public class RandsomNote {


    public static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> randsomNoteWords = new HashMap<>();

        // Build up a count of words from the note required.
        for (String line : note) {
            String[] nWords = line.split(SEPARATOR_SPACE);
            for (String s : nWords) {
                if (!randsomNoteWords.containsKey(s)) {
                    randsomNoteWords.put(s, 1);
                } else {
                    int count = randsomNoteWords.get(s);
                    randsomNoteWords.put(s, count + 1);
                }
            }
        }

        // Iterate through Magazine
        for (String line : magazine) {
            String[] mWords = line.split(SEPARATOR_SPACE);
            for (String s : mWords) {
                if (randsomNoteWords.containsKey(s)) {
                    // Remove or decrease count for word.
                    int value = randsomNoteWords.get(s);
                    if (value == 1) {
                        randsomNoteWords.remove(s);
                    } else {
                        randsomNoteWords.put(s, value - 1);
                    }
                }
            }
        }

        if (randsomNoteWords.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
