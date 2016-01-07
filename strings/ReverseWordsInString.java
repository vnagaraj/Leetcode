package strings;

/**
 * Created by VGN on 1/7/16.
 */
public class ReverseWordsInString {

    /*
    Given an input string, reverse the string word by word.
    For example,
    Given s = "the sky is blue",
    return "blue is sky the".
    */
    public String reverseWords(String s) {
        if (s.length() == 0){
            return s;
        }
        int wordStartIndex = 0;
        int wordEndIndex = 0;
        String finalString = "";
        String temp = "";
        boolean isChar = false;
        for (int i=0; i< s.length(); i++){
            if (Character.isWhitespace(s.charAt(i))){
                if (!isChar){
                    wordStartIndex +=1;
                    wordEndIndex = wordStartIndex;
                    continue;
                }
                temp = s.substring(wordStartIndex, wordEndIndex);
                if (temp.equals("")){
                    wordStartIndex = i +1;
                    wordEndIndex = wordStartIndex;
                    continue;
                }
                if (!finalString.equals("")) {
                    finalString = temp + " " + finalString;
                }
                else {
                    finalString = temp;
                }
                wordStartIndex = i +1;
                wordEndIndex = wordStartIndex;
            }
            else{
                wordEndIndex+=1;
                isChar = true;
            }
        }
        if (wordStartIndex <= wordEndIndex) {
            temp = s.substring(wordStartIndex);
            if (!temp.equals(""))
                if (!finalString.equals(""))
                    finalString = temp + " " + finalString;
                else
                    return temp;
        }
        return finalString;
    }
}
