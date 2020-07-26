import java.util.*;
import java.io.*;
public class lcs1{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        String s1 = s.nextLine();
        String s2 = s.nextLine();

        int result = helper(s1,s2,n,m);
        System.out.println(result);

    }

    public static int helper(String x, String y, int n,int m){
        int t[][] = new int[n+1][m+1];
        int res = 0;

        for(int i = 0; i <n+1; i++){
            t[i][0] = 0;
        }

        for(int j = 0; j <m+1; j++){
            t[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j =1; j < m+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                    res = Math.max(t[i][j],res);
                }else{
                    t[i][j]=0;
                    //t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return res;
    }
}
