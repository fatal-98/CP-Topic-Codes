// BS + DP
// BS for every element correct index in new dp array in increasing fashion
// storing mini ele (all subsequence of same len)for every length i
// Maximum sum increasing subsequence
class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        int res = 0; 
        for(int i=0;i<n;i++){
            res = Math.max(res,helper(i,arr,dp));
        }
        return res;
    }
    public int helper(int ind,int [] arr,int [] dp){
        if(dp[ind]!=-1) return dp[ind];
        
        int cur_max = arr[ind];
        for(int i=0;i<ind;i++){
            if(arr[i]<arr[ind]){
                cur_max = Math.max(cur_max,arr[ind] + helper(i,arr,dp));
            }
        }
        dp[ind] = cur_max;
        return dp[ind];
    }
}
// longest increasing subsequence
class Solution {
    public int lengthOfLIS(int[] a) {
        // when q is about increasing subsequence
        // solved by using smallest tail of all inc subsequence with len i
        int [] dp = new int[a.length];
        int len = 0;
        for(int e : a){
            int ind = Arrays.binarySearch(dp,0,len,e);
            // alternate lower bound to find e in interview
            if(ind<0) ind = -(ind+1);
            dp[ind] = e;
            if(ind==len) len++;
        }
        return len;
    }
}