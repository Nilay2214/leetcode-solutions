class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[n + 1];

        // suffix[i] = maximum number of characters
        // of word2 that can be matched from word1[i...]
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        j = 0;
        int index = 0;
        boolean mismatchUsed = false;

        for (int i = 0; i < n && j < m; i++) {

            // Characters match
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[index++] = i;
                j++;
            }

            // Use the one allowed mismatch
            else if (!mismatchUsed && suffix[i + 1] >= m - j - 1) {
                ans[index++] = i;
                j++;
                mismatchUsed = true;
            }
        }

        if (j == m) {
            return ans;
        }

        return new int[0];
    }
}