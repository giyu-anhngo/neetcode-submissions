class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        Time complexity: O(nlogn)
        Space complexity: O(logn)
        */

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        
        return false;
    }
}