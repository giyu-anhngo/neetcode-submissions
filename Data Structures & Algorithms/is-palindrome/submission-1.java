class Solution {
    public boolean isPalindrome(String s) {
        // TC: O(N)
        // SC: O(1)

        String normalized = normalize(s);
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private String normalize(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (isAlphanumeric(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        return stringBuilder.toString();
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z')
            || (c >= 'A' && c <= 'Z')
            || (c >= '0' && c <= '9');
    }
}
