class Solution {
    /**
     * Approach 03: Hash Table with customized key by occurrences
     *
     * TC: O(n * k)
     * SC: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] words) {
        if (words == null || words.length == 0) return new ArrayList<>();
        Map<String, List<String>> sortedToAnagrams = new HashMap<>();

        for (String word: words) {
            String key = buildAnagramKey(word);
            sortedToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(sortedToAnagrams.values());
    }

    private String buildAnagramKey(String word) {
        int[] charOccurences = new int[26];
        
        for (int i = 0; i < word.length(); i++) {
            charOccurences[word.charAt(i) - 'a']++; 
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int count : charOccurences) {
            stringBuilder.append('#').append(count);
        }

        return stringBuilder.toString();
    }
}
