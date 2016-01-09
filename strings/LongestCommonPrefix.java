package strings;

/**
 * Created by VGN on 1/8/16.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0){
            return new String();
        }
        if (strs.length == 1){
            return strs[0];
        }
        StringBuffer prefix = new StringBuffer();
        int charCounter = 0;
        boolean exitLoop = false; //exitLoop if exceeds string length or char of strings dont match
        while (true){
            int i;
            for(i=0; i< strs.length-1; i++){
                if (charCounter >= strs[i].length() || charCounter >= strs[i+1].length()){
                    exitLoop = true;
                    break;
                }
                if (strs[i].charAt(charCounter) != strs[i+1].charAt(charCounter)){
                    exitLoop = true;
                    break;
                }

            }
            if (exitLoop){
                break;
            }
            prefix.append(strs[i].charAt(charCounter));
            charCounter +=1;
        }
        return prefix.toString();
    }

    public static void main(String[] args){
        String[] strings = new String[]{};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(strings));
    }
}
