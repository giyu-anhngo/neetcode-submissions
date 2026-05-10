class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        Using int array to count occurrences character of String s

        TC: 
        SC: 
        */
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] charOccurences = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            charOccurences[s.charAt(i) - 'a']++; 
            charOccurences[t.charAt(i) - 'a']--; 
        }

        for (int i = 0; i < charOccurences.length; i++) {
            if (charOccurences[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
