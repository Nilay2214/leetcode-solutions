class Solution {
    public boolean rotateString(String s, String goal) {

        // Length must be the same
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is present in s + s
        return (s + s).contains(goal);
    }
}