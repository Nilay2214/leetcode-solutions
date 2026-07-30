class Solution {
    public int Sqrt(long n) {
        if(n==0) return 0;
        long low = 1;
        long high = n;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(mid == n/mid) return (int)mid;
            else if(mid > n/mid) high = mid-1;
            else low = mid + 1;
        }
        return (int)high;
    
    }
    public int arrangeCoins(long n) {
        long m = (long)n;
        return (Sqrt(8*m+1)-1)/2;

         
    }
}