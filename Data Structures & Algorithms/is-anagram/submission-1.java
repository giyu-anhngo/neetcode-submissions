class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        TC: O(nlogn)
        SC: O(n)
        */

        if (s.length() != t.length()) {
            return false;
        }

        // TC: O(n) | SC: O(n)
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // O(nlogn)
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
