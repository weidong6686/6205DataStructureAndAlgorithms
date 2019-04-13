
/**
 * File Name: BigNumber.java 
 * Infinite capacity Unsigned Number
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */
/*
 * To compile you require:  IntUtil.java RandomInt.java CharArray.java Cstring.java BigNumber.java 
 */

class BigNumber {
  private Cstring d; //data
  static IntUtil u = new IntUtil();
  //YOU CANNOT add any data members
  //YOU CAN add any public or private function so that all the tests will pass
  
  
  //WRITE ALL THE ROUTINES required to pass all the tests in BigNumberTester.java
 
  
  public BigNumber(int i) {
	  d = new Cstring(i+"");
}
  public BigNumber(char c) {
	 d = new Cstring(c);  //string d = new Cstring(c);  is wrong
}

  
public BigNumber(String string) {
	d = new Cstring(string);
}

public BigNumber(Cstring s) {
	d = s;
}

public BigNumber clone() {
	Cstring c = d.clone();
	BigNumber  res = new BigNumber("");
	res.d = c;
	return res;
}

public void pLn(String string) {
	d.pLn(string);
}

public boolean isEqual(int i) {
	Cstring c = new Cstring(i+"");
	return this.d.isEqual(c);
}

public boolean isEqual(String string) {
	Cstring s= new Cstring(string);
	return this.d.isEqual(s);
}

public boolean isEqual(BigNumber g) {
	return this.d.isEqual(g.d);
}

public String size() {
	return d.toString().length() +"";
}


public BigNumber add(BigNumber b) {
    StringBuilder sb = new StringBuilder("");
    String num1 =  d.toString(), num2 = b.d.toString();
    int sum = 0, offset = 0;
    int i = num1.length()-1, j = num2.length()-1;
    while (i >= 0 || j >= 0 || offset != 0){ 
        if (i >= 0 && j >= 0)
            sum = (num1.charAt(i--)-'0') + (num2.charAt(j--)-'0') + offset;
        else if(i < 0 && j >= 0)
            sum = 0 + (num2.charAt(j--)-'0') + offset;  // if bit of j > i;
        else if(i >= 0 && j < 0)
            sum = (num1.charAt(i--)-'0') + 0 + offset;  // if bit of i > j;
        else
            sum = offset;   //  if i = j= 0;
        sb.append(sum % 10);
        offset = sum / 10;
        }
    BigNumber res = new BigNumber (sb.reverse().toString());
    return res;
}


public BigNumber sub(BigNumber bb) {
	String num1 =  d.toString(), num2 = bb.d.toString();
	StringBuilder sb = new StringBuilder("");
    int ans = 0, offset = 0;
    int len1 = num1.length(), len2 = num2.length();
	char sign = '+';
	// judge the result is positive or negative
    if (len1 < len2) {
        sign = '-';
    } else if (len1 == len2) {
        int i = 0;
        while (i < len1-1 && num1.charAt(i) == num2.charAt(i)) {
            i++;
        }
        if ( num1.charAt(i) < num2.charAt(i)) {
            sign = '-';
        }
    }
    int i = len1 -1, j = len2 -1;
    while (i >= 0 || j >= 0 ){
    	if (sign == '+') {  //positive: num1-num2 ;
            if (i >= 0 && j >= 0) 
            	ans = (num1.charAt(i--)-'0') - (num2.charAt(j--)-'0') + offset;
            else if(j < 0)
            	ans = (num1.charAt(i--)-'0') - 0 + offset;
    	}
    	else{   //negative : num2- num1;
    		if (i >= 0 && j >= 0) 
    		ans = (num2.charAt(j--)-'0') - (num1.charAt(i--)-'0') + offset;
        else if(i < 0)
        	ans = (num2.charAt(j--)-'0') - 0 + offset;
    	}
        if (ans < 0 ) {
        	ans = ans + 10;
        	offset = -1;
        }
        else offset = 0;
        sb.append(ans);
        }
    //delete initial 0 of number
    int k = sb.length()-1;
    while(sb.charAt(k) == '0' && k >0) { 
    	sb.deleteCharAt(k--);
    }
    String s =  sign == '-' ?  sign+sb.reverse().toString() : sb.reverse().toString() ;
    BigNumber res = new BigNumber (s);
    return res;
    }

	public BigNumber mult(BigNumber zero) {
		String num1 =  d.toString(), num2 = zero.d.toString();
		int len1=num1.length();
		int len2=num2.length();
		int product, offset = 0, i, j;
		int[] num= new int[len1 + len2];
		for(i = len1-1; i >= 0; i--){
			offset=0;
			for(j = len2-1;j >= 0; j--){
				product = offset + (int)(num1.charAt(i)-'0') * (int)(num2.charAt(j)-'0') + num[i+j+1];
				num[i+j+1] = product % 10;
				offset = product / 10;
				}
			num[i+j+1] = offset;
			}
		i = 0;
		while(i < len1+len2 && num[i] == 0){
			i++;
			}
		StringBuilder sb=new StringBuilder();
		while(i < len1+len2){
			sb.append(num[i++]);
			}
		BigNumber res = new BigNumber (sb.toString());
		return res;
		}


	public static BigNumber factorial(int n) {
		int max = 1;
		int[ ] fact = new int[5000];
		fact[ 0 ] = 1;
		for (int i = 2; i <= n; i++) {
			int ans = 0;
			for (int j = 0; j < max; j++) {
				int s = fact[j] * i + ans;
				fact[ j ] = s % 10;
				ans = s / 10;
				}
			while (ans > 0) {
				fact[max++] = ans % 10;
				ans = ans / 10;
				}
			}
		Cstring cs = new Cstring("");
		for (int i = max - 1; i >= 0; i--) {
			cs.append(""+fact[ i ]);
			}
		BigNumber res = new BigNumber("");
		res.d = cs;
		return res;
		} 


	public static void main(String[] args) {
		System.out.println("BigNumber.java");
		System.out.println("Done");
		}
	}
