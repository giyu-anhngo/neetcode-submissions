class Solution {
    public int maxArea(int[] heights) {
        // TC: O(n)
        // SC: O(1)
        
        int length = heights.length;
        int left = 0;
        int right = length - 1;
        int maxArea = 0;

        while (left <= right) {
            int currentArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
