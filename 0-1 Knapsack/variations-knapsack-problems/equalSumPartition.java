import java.util.*;
public class equalSumPartition{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        for(int i = 0 ; i < n; i++){
            arr[i] = s.nextInt();
        }

        for(int i = 0; i<n;i++){
            sum+=arr[i];
        }

        System.out.println(helper(sum,arr,n));
    }

    public static boolean helper(int sum, int[] arr, int n){
        if(sum%2 !=0){
            return false;
        }else{
            return subSetSum(arr,sum,n);
        }
    }

    public static boolean subSetSum(int arr[], int sum, int n){
        boolean[][] t = new boolean[n+1][sum+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                if(i==0){
                    t[i][j] = false;
                }

                if(j==0){
                    t[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n ;i++){
            for(int j = 0; j < n ;j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];

    }
}