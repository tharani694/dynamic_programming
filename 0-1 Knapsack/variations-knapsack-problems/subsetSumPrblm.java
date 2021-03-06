import java.util.*;
public class subsetSumPrblm{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }

        int k = s.nextInt();

        boolean result = subSetSum(arr,n,k);

        System.out.println(result);
    }

    public static boolean subSetSum(int[] arr,int n, int k){

        boolean t[][] = new boolean[n+1][k+1];


        //Initialization
        for(int i = 0; i <n+1; i++ ){
            for(int j = 0; j<k+1; j++){
                if(i==0){
                    t[i][j] = false;
                }
                if( j ==0){
                    t[i][j] = true;
                }
            }
        }

        //Dp code - Top Down Approach of KnapSack Problem

        for(int i = 1; i <n+1; i++){
            for(int j = 1; j< k+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][k];
    }
}