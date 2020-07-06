import java.util.*;
public class memoizedCode
{
   	public static void main (String[] args)
	 {
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
	   
	   int result = knapsack(wt,val,W,n);
	   System.out.println(result);
	}
	 
	 public static int knapsack(int wt[], int val[], int W, int n)
	 {
      int[][] t = new int[n+1][W+1];
      Arrays.fill(t,0,t.length,-1);
      
	    if(n==0 || W==0)
	    {
	        return 0;
        }

        if(t[n][W]!=-1){
            return t[n][W];
        }

        if (wt[n - 1] <= W) 
	    {    
            return t[n][W] = Math.max(val[n-1] +  knapsack(wt,val, W-wt[n-1], n-1) , knapsack(wt,val, W, n-1)); 
            }
        else{
            return t[n][W] = knapsack(wt,val,W,n-1);
        }
	 }
}