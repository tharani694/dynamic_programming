import java.util.*;
import java.lang.*;
import java.io.*;
class min_no_of_del_to_palin
{
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
            String str = s.next();
            int result = helper(str,str.length());
            System.out.println(result);
    }


    // Method to find minimum number of deletion in a string to make it a Palindrome
    public static int helper(String str, int n){
        String b = "";
        //int n = str.length();

        for(int i = n-1; i>=0; i--){
            b = b+str.charAt(i);
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
                if(str.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return n-t[n][m];
    }
}