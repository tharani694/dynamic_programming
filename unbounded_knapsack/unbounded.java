import java.util.*;
import java.io.*;
public class unbounded{
    public static void main(String args[]){
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        int W = s.nextInt();

        int wt[] = new int[n];
        int val[] = new int[n];

        for(int i = 0; i < n; i++){
            wt[i] = s.nextInt();
        }

        for(int i = 0; i < n; i++){
            val[i] = s.nextInt();
        }

        int result = unboundedKnap(wt,val,W,n);
        System.out.println(result);
    }

    public static int unboundedKnap(int[] wt, int[] val, int W, int n){
        int t[][] = new int[n+1][W+1];

        for(int i = 0; i <=n; i++)
        {
            for(int j = 0; j <=W; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }else if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }}
        return t[n][W];
    }
}
