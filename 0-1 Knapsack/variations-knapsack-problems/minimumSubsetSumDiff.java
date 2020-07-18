import java.util.*;
public class minimumSubsetSumDiff{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }

        for(int i = 0; i<n;i++){
            sum+=arr[i];
        }

        List<Integer> list = new ArrayList<Integer>();
        int result = subSetSum(arr,n,k,list);

        System.out.println(result);
    }

    public static int subSetSum(int[] arr,int n, int sum, List<Integer> list){

        boolean t[][] = new boolean[n+1][k+1];
        int minimum = Integer.MAX_VALUE;

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

        // To find out the last row of the table that has true values
        for(int j = sum/2; j>=0; j--){
            if(t[i][j] == true){
                list.add(j);
            }
        }

        //To find out the minimum difference between the listed elements in the list
        for(int i : list){
            minimum = Math.min(minimum, (sum - 2*i));
        }
        return minimum;
    }
}