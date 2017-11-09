/**
 * Created by cilu on 2017/11/4.
 */
public class Dynation {


    public static int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, max = 0;
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i++)
            for(int j = m; j > 0; j--)
                max = Math.max(max, dp[j] = A[i-1] == B[j-1] ? dp[j-1] + 1 : 0);
        return max;
    }

    public static void main(String args[]){
        int a[] = {1,2,3,2,1};
        int b[] = {3,2,1,4,7};
        System.out.println(findLength(a,b));
    }
}
