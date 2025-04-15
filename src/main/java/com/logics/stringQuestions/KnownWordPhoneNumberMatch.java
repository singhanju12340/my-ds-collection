package com.logics.stringQuestions;

import java.util.*;

/**
 * @author anju
 * @created on 11/04/25 and 1:22 PM
 */
public class KnownWordPhoneNumberMatch {
    /***
     * /**
     * Given the standard mapping from English letters to digits on a phone keypad (
     * 1 → ""      2 -> a,b,c         3 -> d,e,f      4 -> g,h,i     5 -> j,k,l     6 -> m,n,o      7 -> p,q,r,s     8 -> t,u,v     9 -> w,x,y,z),
     *
     * write a program that outputs all words that can be formed from any n-digit phone number from the list of given KNOWN_WORDS considering the mapping mentioned above.
     *
     *
     *
     * KNOWN_WORDS= ['careers', 'cariiers', 'linkedin', 'hiring', 'interview', 'linkedgo']
     *
     * phoneNumber: 2273377
     * Output: ['careers']
     *
     * phoneNumber: 54653346
     * Output: ['linkedin', 'linkedgo']
     * **/

    // Build a mapping from letter → digit

    private static final Map<Character, Character> LETTER_TO_DIGIT = new HashMap<>();
    static {
        putMapping("abc", '2');
        putMapping("def", '3');
        putMapping("ghi", '4');
        putMapping("jkl", '5');
        putMapping("mno", '6');
        putMapping("pqrs", '7');
        putMapping("tuv", '8');
        putMapping("wxyz", '9');
    }

    private static void putMapping(String letters, char digit) {
        for (char c : letters.toCharArray()) {
            LETTER_TO_DIGIT.put(c, digit);
        }
    }

    public static List<String> wordsFromNumber(String phoneNumber, List<String> knownWords){
        List<String> result = new ArrayList<>();
        int n = phoneNumber.length();

        for (String word : knownWords) {
            if (word.length() != n) continue;

            String lower = word.toLowerCase();
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                char wc = lower.charAt(i);
                Character mapped = LETTER_TO_DIGIT.get(wc);
                if (mapped == null || mapped != phoneNumber.charAt(i)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> KNOWN_WORDS = Arrays.asList(
                "careers", "cariiers", "linkedin", "hiring", "interview", "linkedgo"
        );
        String phoneNumber = "2273377";

        List<String> matches = wordsFromNumber(phoneNumber, KNOWN_WORDS);
        System.out.println(matches);
    }

    //If there are W known words each of length up to L, this runs in O(W·L) time,
    // which is perfectly fine for reasonable dictionary sizes.
}
