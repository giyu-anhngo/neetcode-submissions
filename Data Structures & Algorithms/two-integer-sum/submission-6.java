class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        Approach 01: Brute Force
        Explaination: Use nested loops to iterates through every possible pair to find the sum matching the target.
        TC: O(n²) | SC: O(1)
        */

        Map<Integer, Integer> complementToIndexs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (complementToIndexs.containsKey(complement)) {
                return new int[] {complementToIndexs.get(complement), i};
            }

            complementToIndexs.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
