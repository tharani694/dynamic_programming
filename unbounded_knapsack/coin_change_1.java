import java.util.*;
import java.lang.*;
import java.io.*;
class coin_change_1
{
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int coins[] = new int[n];
            for(int i = 0; i <n ; i++){
                coins[i] = s.nextInt();
            }

            int Sum = s.nextInt();
            int res = max_no_ways(n,coins,Sum);
            System.out.println(res);
    }

    // problem to find out maximum number of ways to produce the sum
    public static int max_no_ways(int n, int[] coins, int S){
        int[][] t= new int[n+1][S+1];

        for(int i =0; i<n+1; i++){
            for(int j = 0; j < S+1; j++){
                if(j==0){
                    t[i][0] = 1;
                }
                if(i==0){
                    t[0][j] = 0;
                }
            }
        }

        for(int i = 1 ; i < n+1; i++){
            for(int j = 1; j < S+1; j++){
                if(coins[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i][j-coins[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][S];
    }
}