class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {

            int low = 0;
            int high = size;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (tails[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            tails[low] = num;

            if (low == size) {
                size++;
            }
        }

        return size;
    }
}