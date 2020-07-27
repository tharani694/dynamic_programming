import java.util.*;
import java.lang.*;
import java.io.*;
class min_no_of_inst_del
{
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();

        int result = helper(s1,s2,s1.length(),s2.length());
        System.out.println(result);
    }
    // Method to find minimum number of insertion and deletion required to conert string s1 to string s2
    public static int helper(String a, String b, int n, int m){
        int t[][] = new int[n+1][m+1];

        for(int i = 0; i < n+1; i++){
            t[i][0] = 0;
        }

        for(int j = 0; j < m+1; j++){
            t[0][j] = 0;
        }

        // Longest common subsequence
        for(int i =1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        // Return length of s1 - length of LCS + length of s2 - length of LCS
        return (n-t[n][m]) + (m-t[n][m]);
    }
}