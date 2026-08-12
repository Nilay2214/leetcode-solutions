class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right,
                          int lower, int upper) {

        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        count += mergeSort(prefix, left, mid, lower, upper);
        count += mergeSort(prefix, mid, right, lower, upper);

        int low = mid;
        int high = mid;

        for (int i = left; i < mid; i++) {

            while (low < right &&
                   prefix[low] - prefix[i] < lower) {
                low++;
            }

            while (high < right &&
                   prefix[high] - prefix[i] <= upper) {
                high++;
            }

            count += high - low;
        }

        // Merge two sorted halves
        long[] temp = new long[right - left];

        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j < right) {

            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i < mid) {
            temp[k++] = prefix[i++];
        }

        while (j < right) {
            temp[k++] = prefix[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            prefix[left + x] = temp[x];
        }

        return count;
    }
}