class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        Time complexity: O(n^2)
        Space complexity: O(1)
        */
        Set<Integer> setNums = new HashSet<>();
        
        for (int num: nums) {
            if (setNums.contains(num)) {
                return true;
            }
            setNums.add(num);
        }

        return false;
    }
}