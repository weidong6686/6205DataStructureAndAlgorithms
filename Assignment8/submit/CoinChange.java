import java.util.Arrays;

public class CoinChange extends CoinChangeBase {

	public CoinChange() {
		testBench();
	}


	private int n;
	private int[] arr;
	private int[] dp;
	private int[] k;
//	  f[i,j] = min{f[i-1, j], f[i, j-a[i]] + 1},
	@Override
	protected void computeChange(int n, int[] arrayOfCoinsAvailable) {
			int[] arr = arrayOfCoinsAvailable;
			dp = new int[n + 1];
			k = new int[n + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			for (int i = 0; i <  arr.length; i++) {
				for (int j = 0; j <= n; j++) {
					if (j >= arr[i]) {
						if (dp[j] > (dp[j - arr[i]] + 1)) {
							dp[j] = Math.min(dp[j - arr[i]] + 1,dp[j]);
							k[j] = arr[i];
						}
					}
				}
			}
			System.out.print("Give minimum change for "+n+" cents using coins {");
			for (int i : arr) {
				System.out.print(i+" ");
				}
			System.out.println("}");
			System.out.print("i =        ");
			for (int i = 0; i <= n; i++) {
				System.out.print(i + "\t");
			}
			System.out.print("\nm array ");
			for (int i = 0; i <= n; i++) {
				System.out.print((dp[i] == Integer.MAX_VALUE ? "none" : dp[i]) + "\t");
			}
			System.out.print("\nk array  ");
			for (int i = 0; i <= n; i++) {
				System.out.print(k[i] + "\t");
			}
			System.out.println("\n");
			for (int i = 0; i <= n; i++) {
				System.out.println("minimum change for "+i+ " cents can be achieved using "+dp[i]+" coins");
				printSolution(i);
			}	
		}
	private void printSolution(int p) {
		int res = p, sum = 0, i = dp[p];
		int[] a = new int[dp[p]+1];
		// save coin type from big to small;
		while(res > 0) {
			a[i] = k[res];
			res -= k[res];
			i--;
		}
		sum = 0; 
		res = p;
		// printout the coin type from small to type;
		for(int j = 1; j<= dp[p]; j++) {
			sum += a[j];
			System.out.println(j+"::Pick coin "+a[j]+". Current val= "+sum+". Remaining val= "+  (res-a[j]));
			res -= a[j];
		}
	}

	  public static void main(String[] args) {
		  System.out.println("CoinChange.java starts");
		  CoinChange m = new CoinChange() ;
		  System.out.println("You are amazing. Bring me a bar of Chocolate");
		  System.out.println("CoinChange.java ends");
		  }
}
