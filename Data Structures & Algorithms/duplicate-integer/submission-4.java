class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        Time complexity: O(n)
        Space complexity: O(n)
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