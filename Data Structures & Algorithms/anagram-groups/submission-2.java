class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        * Approach 01: Brute Force

        * Iterates through each string and compares it with all subsequent strings using a frequency-count helper (isAnagram). 
        * isAnagram - This method iterates through the length of the strings, which takes O(k) time.
        * Groups matches together and marks them in the boolean array to avoid redundant processing.

        * TC: O(n² * k) - Nested loops (n²) multiplied by string comparison (k).
        * SC: O(n * k) - Space required to store the grouped strings and the tracking array.
        */
        
        List<List<String>> results = new ArrayList<>();
        boolean[] isVisited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (isVisited[i]) continue;

            List<String> currentGroup = new ArrayList<>();
            currentGroup.add(strs[i]);
            
            for (int j = i + 1; j < strs.length; j++) {
                if (!isVisited[i] && areAnagrams(strs[i], strs[j])) {
                    currentGroup.add(strs[j]);
                    isVisited[j] = true;
                }
            }
            
            results.add(currentGroup);
            isVisited[i] = true;
        }

        return results;
    }

    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] charCounts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i) - 'a']++;
            charCounts[s2.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) return false;
        }

        return true;
    }
}
