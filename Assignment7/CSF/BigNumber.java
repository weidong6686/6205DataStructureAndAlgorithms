
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
	this(String.valueOf(i));
}

  public BigNumber(char i) {
	this(String.valueOf(i));
}

	public BigNumber(String string) {
		d = new Cstring(string);
	}
	
	public BigNumber(Cstring s) {
		d = s;
	}
	
	public static void main(String[] args) {
	    System.out.println("BigNumber.java");
	    System.out.println("Done");
	  }
	
	public void pLn(String string) {
		d.pLn(string);
	}
	
	@Override
	public BigNumber clone() {
		Cstring copy = d.clone();
		BigNumber obj = new BigNumber(copy);
		return obj;
	}
	
	private Cstring getCstring() {
		return this.d;
	}
	
	public boolean isEqual(BigNumber g) {
		if (this.d.isEqual(g.getCstring()))
			return true;
		else 
			return false;
	}

	public boolean isEqual(String string) {
		if (d.length() != string.length())
			return false;
		int i = 0;
		while (d.get(i) != '\0') {
			if (d.get(i) != string.charAt(i))
				return false;
			i++;
		}
		return true;
	}
	
	public boolean isEqual(int i) {
		return isEqual(String.valueOf(i));
	}
		
	public String size() {
		return String.valueOf(d.length());
	}
		
//	public BigNumber add(BigNumber b) {
//		Cstring numA = this.d.clone();
//		numA.reverse();
//		Cstring numB = b.d.clone();
//		numB.reverse();
//		Cstring numC = new Cstring("");
//		int i = 0, moveUp = 0, sum = 0;
//		while ((numA.get(i) != 0) && (numB.get(i) != 0)) {
//			sum = (numA.get(i) - '0') + (numB.get(i) - '0') + moveUp;
//			if (sum > 9) {
//				moveUp = 1;
//				sum -= 10;
//			} else {
//				moveUp = 0;
//			}
//			numC.append(String.valueOf(sum));
//			i++;
//		}
//		Cstring temp = null;
//		if (numA.get(i) != 0) {
//			temp = numA;
//		} else {
//			temp = numB;
//		}
//		while (temp.get(i) != 0) {
//			sum = (temp.get(i) - '0') + moveUp;
//			if (sum > 9) {
//				moveUp = 1;
//				sum -= 10;
//			} else {
//				moveUp = 0;
//			}
//			numC.append(String.valueOf(sum));
//			i++;
//		}
//		if (moveUp > 0) {
//			numC.append("1");
//		}		
//		numC.reverse();
//		return new BigNumber(numC);
//	}
	
	final int STEP = 9;
	int powerStep = 1;
	public BigNumber add(BigNumber b) {
		Cstring numA = this.d.clone();
		Cstring numB = b.d.clone();
		Cstring numC = new Cstring("");
		int i = 0, moveUp = 0, sum = 0;
		int lenA = numA.length(), lenB = numB.length();
		if (lenA < lenB) {
			Cstring temp = numA;
			numA = numB;
			numB = temp;
			int temp2 = lenA;
			lenA = lenB;
			lenB = temp2;
		}
		StringBuilder tempStr = new StringBuilder();
		for (i = 1; i <= (lenA - lenB); i++) {
			tempStr.append("0");
		}
		numB = new Cstring(tempStr.toString() + numB.toString());
		lenB = lenA;
		for (i = 1; i <= STEP; i++)
			powerStep *= 10;
		i = lenA;
		while (i >= 0) {
			int partA = 0, partB = 0;
			for (int j = ((i - STEP) >= 0 ? (i - STEP) : 0);
					j < i; j++) {
				partA *= 10;
				partA += numA.get(j) - '0';
				partB *= 10;
				partB += numB.get(j) - '0';
			}
			sum = partA + partB + moveUp;
			if (sum >= powerStep) {
				moveUp = 1;
				sum -= powerStep;
			} else {
				moveUp = 0;
			}
			numC = new Cstring(String.format("%09d", sum) + numC.toString());
			i -= STEP;
		}
		numC.trimLeftZero();
		return new BigNumber(numC);
	}
	
	public BigNumber sub(BigNumber b) {
		Cstring numA = this.d.clone();
		numA.reverse();
		Cstring numB = b.d.clone();
		numB.reverse();
		Cstring numC = new Cstring("");
		int i = 0, moveUp = 0, sum = 0;
		boolean negative = false; 
		while ((numA.get(i) != 0) && (numB.get(i) != 0)) {
			i++;
		}
		if (numA.get(i) == 0) {
			// Otherwise, numB.get(i) must >0, then numA < numB
			boolean flag = true;
			// So we just judge numA and numB has same length
			if (numB.get(i) == 0) {
				int j = i - 1;
				while ((j >= 0) && (numA.get(j) == numB.get(j))) {
					j--;
				}
				if ((j < 0) || (numA.get(j) >= numB.get(j)))
					flag = false;
			}		
			if (flag) {
				Cstring temp = numA;
				numA = numB;
				numB = temp;
				negative = true;
			}			
		}
		i = 0;
		while ((numA.get(i) != 0) && (numB.get(i) != 0)) {
			sum = (numA.get(i) - '0') - (numB.get(i) - '0') - moveUp;
			if (sum < 0) {
				moveUp = 1;
				sum += 10;
			} else {
				moveUp = 0;
			}
			numC.append(String.valueOf(sum));
			i++;
		}
		while (numA.get(i) != 0) {
			sum = (numA.get(i) - '0') - moveUp;
			if (sum < 0) {
				moveUp = 1;
				sum += 10;
			} else {
				moveUp = 0;
			}
			numC.append(String.valueOf(sum));
			i++;
		}
		numC.reverse();
		numC.trimLeftZero();
		if (negative)
			numC = new Cstring ("-" + numC.toString());		
		return new BigNumber(numC);
	}
	
	public BigNumber mult(BigNumber b) {
		Cstring numB = b.d.clone();
		numB.reverse();
		int i = 0;
		int bit = numB.get(i) - '0';
		BigNumber sum = new BigNumber(0);
		while (bit >= 0) {
			BigNumber sumPerBit = new BigNumber(0);
			
//			if (bit >= 8) {
//				sumPerBit = sumPerBit.add(this);
//				sumPerBit = sumPerBit.add(sumPerBit);
//				sumPerBit = sumPerBit.add(sumPerBit);
//				sumPerBit = sumPerBit.add(sumPerBit);
//				if (bit == 9)
//					sumPerBit = sumPerBit.add(this);
//			} else if (bit >= 4) {
//				sumPerBit = sumPerBit.add(this);
//				sumPerBit = sumPerBit.add(sumPerBit);
//				sumPerBit = sumPerBit.add(sumPerBit);
//				for (int j = 1; j <= bit - 4; j++) {
//					sumPerBit = sumPerBit.add(this);
//				}
//			} else {		
				for (int j = 1; j <= bit; j++) {
					sumPerBit = sumPerBit.add(this);
				}
//			}
			for (int j = 1; j <= i; j++) {
				sumPerBit.d.append("0");
			}
			sum = sum.add(sumPerBit);
			bit = numB.get(++i) - '0';
		}
		sum.d.trimLeftZero();
		return sum;
	}
	
	public static BigNumber factorial(int n) {
		BigNumber ans = new BigNumber(0);
		ans.d = new Cstring("");
		int maxn = 1;
		int[] f = new int[5000];
		f[0] = 1;
		for (int i = 2; i <= n; i++) {
			int c = 0;
			for (int j = 0; j < maxn; j++) {
				int s = f[j] * i + c;
				f[j] = s % 10;
				c = s / 10;
			}
			while (c > 0) {
				f[maxn++] = c % 10;
				c /= 10;
			}
		}
		for (int i = maxn - 1; i >= 0; i--) {
			ans.d.append(String.valueOf(f[i]));
		}
		return ans;
	} 
	
	public static BigNumber factorial2(int n) {
		BigNumber ans = new BigNumber(1);
		for (int i = 1; i <= n; i++) {
			if (i % 50 == 0) {
				System.out.println(i);
			}
			ans = ans.mult2(i);
		}
		return ans;
	} 
	
	public BigNumber mult2(int num) {
		BigNumber sumB;
		BigNumber ans = new BigNumber(0);
		int lenA = this.d.length();
		int i = 0, sum = 0;
		for (i = lenA - 1; i >= 0; i--) {
			sum = (d.get(i) - '0') * num;
			sumB = new BigNumber(sum);
			for (int j = i; j < lenA - 1; j++)
				sumB.d.append("0");
			ans = ans.add(sumB);
//			ans = new Cstring(String.format("%09d", sum) + ans.toString());
		}
		return ans;
	} 
}
