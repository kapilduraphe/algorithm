/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        return null;
    }
    
    /**
     * return the sorted string
     */
    public static String stringSort(String input) {
        char[] ar = input.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
}