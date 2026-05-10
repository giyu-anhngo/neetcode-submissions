class Solution {
    /**
     * Approach 02: Hash Table with Sorted Key
     *
     * Data Structure: HashMap (Key: Sorted String, Value: List of Anagrams)
     * Sorts the characters of each word to create a canonical "key." 
     * Anagrams produce the same key and are grouped into the same list.
     *
     * TC: O(n * klogk) | SC: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] words) {
        if (words == null || words.length == 0) return new ArrayList<>();

        Map<String, List<String>> sortedToAnagrams = new HashMap<>();

        for (String word : words) {
            // Create the key by sorting characters
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // ComputeIfAbsent replaces the 'if(!contains) put' block
            sortedToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(sortedToAnagrams.values());
    }
}
