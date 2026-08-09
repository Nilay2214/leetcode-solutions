class Solution {
    public String majorityFrequencyGroup(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // group[f] stores all characters occurring f times
        String[] group = new String[s.length() + 1];

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                int f = freq[i];

                if (group[f] == null) {
                    group[f] = "";
                }

                group[f] += (char) ('a' + i);
            }
        }

        String ans = "";

        // Find the frequency group having maximum size
        for (int f = 1; f <= s.length(); f++) {

            if (group[f] != null) {

                if (group[f].length() > ans.length()) {
                    ans = group[f];
                }

                // If same size, choose higher frequency
                else if (group[f].length() == ans.length()
                         && f > getFrequency(ans, freq)) {
                    ans = group[f];
                }
            }
        }

        return ans;
    }

    private int getFrequency(String s, int[] freq) {
        return freq[s.charAt(0) - 'a'];
    }
}