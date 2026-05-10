class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        boolean[] anagramsGrouped = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (anagramsGrouped[i]) {
                continue;
            }

            String currentS = strs[i];
            List<String> anagrams = new ArrayList<>();
            anagrams.add(currentS);
            
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    anagramsGrouped[j] = true;
                }
            }

            anagramsGrouped[i] = true;
            results.add(anagrams);
        }

        return results;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] numsToOccurrences = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            numsToOccurrences[s.charAt(i) - 'a']++;
            numsToOccurrences[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < numsToOccurrences.length; i++) {
            if (numsToOccurrences[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
