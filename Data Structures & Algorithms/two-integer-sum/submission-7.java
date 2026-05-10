class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        Approach 03: Sorting & Two Pointers
        
        Pairs nums with original index in a 2D array, sorts by num.
        Then uses two pointers at opposite ends to converge on the target sum.
        
        TC: O(nlogn) | SC: O(n)
        */

        // 1. Store num and original index
        int[][] numWithIndex = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            numWithIndex[i][0] = nums[i];
            numWithIndex[i][1] = i;
        }

        // 2. Sort by num
        Arrays.sort(numWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Two-pointer search
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = numWithIndex[left][0] + numWithIndex[right][0];

            if (sum == target) {
                int index1 = numWithIndex[left][1];
                int index2 = numWithIndex[right][1];
                
                return new int[] { 
                    Math.min(index1, index2), 
                    Math.max(index1, index2) 
                };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}