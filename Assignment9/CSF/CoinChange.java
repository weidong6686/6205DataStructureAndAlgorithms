import java.util.Arrays;

public class CoinChange extends CoinChangeBase{

	CoinChange() {
	  	//Nothing can be added here
			testBench();
		}
	  
	@Override
	protected void computeChange(int n, int[] arrayOfCoinsAvailable) {
//	  f[i,j] = min{f[i-1, j], f[i, j-a[i]] + 1},
//	  initialize f[0, 1~n] as MAXINT, f[0, 0] as 0
//	  we can also optimize the DP function from 2-d matrix to 1-d array
		int[] a = arrayOfCoinsAvailable;
		int l = a.length;
		int[] f = new int[n + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;
		int[] k = new int[n + 1];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j <= n; j++) {
				if (j >= a[i])
					if (f[j] > (f[j - a[i]] + 1)) {
						f[j] = f[j - a[i]] + 1;
						k[j] = a[i];
					}
			}
		}
		System.out.print("Change           = ");
		for (int j = 0; j <= n; j++)
			System.out.print(j + "\t");
		System.out.print("\r\nNumbers of coins = ");
		for (int j = 0; j <= n; j++)
			System.out.print((f[j] == Integer.MAX_VALUE ? "none" : f[j]) + "\t");
		System.out.print("\r\nUse the coin of  = ");
		for (int j = 0; j <= n; j++)
			System.out.print(k[j] + "\t");
		System.out.println("\r\n");
	}

  public static void main(String[] args) {
	    System.out.println("CoinChange.java starts");
	    CoinChange m = new CoinChange() ;
	    System.out.println("You are amazing. Bring me a bar of Chocolate");
	    System.out.println("CoinChange.java ends");
	  }
}
