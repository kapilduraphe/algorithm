/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * Solution:
 * 1) Establish a hashmap. The key is itself a hashmap, HashMap<Character, Integer>,
 *    which is the character in the string, and the corresponding count. The value
 *    is an ArrayList of all string that share the character:count hashmap key.
 */
import java.util.ArrayList;
import java.util.HashMap;
public class Anagrams {
    public static ArrayList<String> anagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> hashList = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        // iterate through the string array
        for (String s : strs) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            // iterate through each character in the string
            for (int i = 0; i < s.length(); i++) {
                // c is the character in question
                char c = s.charAt(i);
                if (map.get(c) == null) {
                    map.put(c, 1);                    
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            // put the map:arrayList pair into hashList
            ArrayList<String> arrList = new ArrayList<String>();
            if (hashList.get(map) == null) {
                arrList.add(s);
            } else {
                arrList = hashList.get(map);
                arrList.add(s);
            }
            hashList.put(map, arrList);
        }

        ArrayList<String> resultList = new ArrayList<String>();
        for (ArrayList<String> lst : hashList.values()) {
            if (lst.size() > 1) {
                resultList.addAll(lst);
            }
        }
        return resultList;
    }
    
    public static void main() {
        String[] test0 = new String[5];
        test0[0] = ("acb");
        test0[1] = ("cba");
        test0[2] = ("cab");
        test0[3] = ("ed");
        test0[4] = ("de");
        System.out.println(anagrams(test0).toString());
    }
}