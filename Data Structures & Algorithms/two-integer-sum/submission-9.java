class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        Approach 02: Hash Table
        
        Searches for the current value's complement in the map.
        If not found, stores the current value and its index for future lookups.
        
        TC: O(n) | SC: O(n)
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
