class Solution {
    public boolean isPalindrome(String s) {
        String cleanedS = cleanUpDataInput(s.toLowerCase());
        int left = 0;
        int right = cleanedS.length() - 1;

        while (left < right) {
            if (cleanedS.charAt(left) != cleanedS.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private String cleanUpDataInput(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (isAlphanumeric(s.charAt(i))) {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9');
    }
}

// "?"
