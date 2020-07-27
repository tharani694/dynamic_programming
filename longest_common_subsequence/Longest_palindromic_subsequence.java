import java.util.*;
import java.lang.*;
import java.io.*;
class Longest_palindromic_subsequence
{
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();

        int result = helper(s1,s1.length());
        System.out.println(result);
    }
    // Method to find length of the longest palindroomic subsequence
    public static int helper(String a, int n){
        String b = "";

        int n = a.length();

        for(int i =n-1; i>=0; i--){
            b = b+a.charAt(i);
        }

        int m = b.length();
        int t[][] = new int[n+1][m+1];

        for(int i = 0; i < n+1; i++){
            t[i][0] = 0;
        }

        for(int j = 0; j < m+1; j++){
            t[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[n][m];
    }
}