package strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.List;

/**
 * Created by VGN on 1/7/16.
 */
public class GroupAnagrams {

    /*
    Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

            [
            ["ate", "eat","tea"],
            ["nat","tan"],
            ["bat"]
            ]
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
        //sort the strings
        Arrays.sort(strs);
        for(String str: strs){
            String key = computeKey(str);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                ArrayList<String> values = new ArrayList<String>();
                values.add(str);
                map.put(key,values);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String keys : map.descendingKeySet()){
            List<String> value = map.get(keys);
            result.add(0, value);
        }
        return result;
    }

    private String computeKey(String string){
        char[] chArr = string.toCharArray();
        Arrays.sort(chArr);
        return new String(chArr);
    }

    public static void main(String[] args){
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] stArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        anagrams.groupAnagrams(stArray);
    }
}
