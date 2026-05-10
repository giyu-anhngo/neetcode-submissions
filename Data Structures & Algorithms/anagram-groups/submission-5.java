class Solution {
    /**
     * Approach 03: Hash Table with frequency key
     *
     * Data Structure: HashMap (Key: Frequency String, Value: List of Anagrams)
     * Creates a unique "signature" for each word by counting character occurrences ('a'-'z'). 
     * Words with the same character counts generate identical keys (e.g., #1#0#2...), 
     * allowing them to be grouped without sorting.
     *
     * TC: O(n * k) - Traverses each of the n words once, with O(k) time to build the frequency key.
     * SC: O(n * k) - Stores the frequency keys and all strings in the HashMap.
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