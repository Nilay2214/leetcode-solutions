class Solution {
    public int maximumCount(int[] arr) {
        int n = arr.length;

        // First index where arr[i] >= 0
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        int negativeCount = low;

        // First index where arr[i] > 0
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        int positiveCount = n - low;

        return Math.max(negativeCount, positiveCount);
    }
}