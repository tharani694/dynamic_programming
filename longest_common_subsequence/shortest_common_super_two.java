import java.util.*;
import java.io.*;
import java.lang.*;

class shortest_common_super_two {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();

        String res = shortestCommonSupersequence(s1,s2);
        System.out.println(res);
    }
    public String shortestCommonSupersequence(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int dp[][] = new int[n + 1][m + 1];

        for(int i=1; i<=n;i++){
            for(int j=1; j<=m; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n, j=m;
        while(i>0 && j>0){
            if(X.charAt(i-1) == Y.charAt(j-1)){
                sb.append(X.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(dp[i][j-1] > dp[i-1][j] ) {
                    sb.append(Y.charAt(j - 1));
                    j--;
                }
                else {
                    sb.append(X.charAt(i-1));
                    i--;
                }
            }

        }
        while (i>0){
            sb.append(X.charAt(i-1));
            i--;
        }
        while (j>0){
            sb.append(Y.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}