import java.util.*;
import java.lang.*;
import java.io.*;
class coin_change_2
{
    public static void main (String[] args)
    {

        Scanner s = new Scanner(System.in);
            int sum = s.nextInt();
            int n = s.nextInt();
            int[] coins = new int[n];

            for(int i = 0; i < n; i++){
                coins[i] = s.nextInt();
            }

            int result = helper(coins, sum, n);
            if(result > 0 || result != Integer.MAX_VALUE)
            {
                System.out.println(result);
            }else{
                System.out.println(-1);
            }
    }

    // function to find the minimum number of coins required to produce the given sum
    public static int helper(int[] coins, int sum, int n){
        int t[][] = new int[n+1][sum+1];

        for(int j = 0; j < sum+1; j++){
            t[0][j] = Integer.MAX_VALUE - 1;
        }

        for(int i = 0; i < n+1 ; i++){
            t[i][0] = 0;
        }
        t[0][0] = Integer.MAX_VALUE - 1;

        for(int j = 1; j < sum+1 ;j++){
            if(j%coins[0] == 0){
                t[1][j] = j/coins[0];
            }else{
                t[1][j] = Integer.MAX_VALUE-1;
            }
        }

        for(int i =2; i< n+1; i++){
            for(int j = 1; j<sum+1; j++){
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(t[i-1][j], t[i][j-coins[i-1]] + 1);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        if(t[n][sum] == Integer.MAX_VALUE -1) return -1;

        return t[n][sum];
    }
}