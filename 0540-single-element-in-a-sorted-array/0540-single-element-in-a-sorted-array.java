class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(arr.length == 1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];
            int f = mid, s = mid;
            if(arr[mid-1]==arr[mid]) f = mid - 1;
            else s = mid+1;
            int leftCount = f-low;
            int rightCount = high-s;
            if(leftCount%2 == 0) low = s + 1;
            else high = f-1;

        }
        return 842;

    }
}