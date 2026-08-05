class Solution {
    public int binaryGap(int n) {

        int last = -1;
        int maxGap = 0;
        int index = 0;

        while (n > 0) {

            if ((n & 1) == 1) {
                if (last != -1) {
                    maxGap = Math.max(maxGap, index - last);
                }
                last = index;
            }

            index++;
            n >>= 1;
        }

        return maxGap;
    }
}