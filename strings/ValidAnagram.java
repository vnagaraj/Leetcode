package strings;

import java.util.Arrays;

/**
 * Created by VGN on 1/9/16.
 */
public class ValidAnagram {

    /*
    Given two strings s and t, write a function to determine if t is an anagram of s.
    For example,
    s = "anagram", t = "nagaram", return true.
    s = "rat", t = "car", return false.
     */
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
