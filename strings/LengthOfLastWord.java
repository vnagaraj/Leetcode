package strings;

/**
 * Created by VGN on 1/7/16.
 */
public class LengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
    return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example,
    Given s = "Hello World",
    return 5.
     */
    public int lengthOfLastWord(String s) {
        int wordCount = 0;
        int wordLength= 0;
        for (int i=0; i < s.length(); i++){
            if (Character.isWhitespace(s.charAt(i))){
               if (wordCount != 0)
                wordLength = wordCount;
               wordCount = 0;
            }
            else{
                wordCount +=1;
            }
        }
        if (wordCount == 0){
            return wordLength;
        }
        return wordCount;
    }

    public static void main(String[] args){
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("b   a    "));
    }
}
