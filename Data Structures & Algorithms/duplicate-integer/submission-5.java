class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        Time complexity: O(n)
        Space complexity: O(n)
        */
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}