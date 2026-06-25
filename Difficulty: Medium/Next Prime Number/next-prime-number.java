class Solution {
	public static int nextPrime(int n) {
		
		// code here to find next prime number
		// return next prime number
		
		int num = n + 1;
		
		while (true) {
			boolean prime = true;
			
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					prime = false;
					break;
				}
				
			}
			if (prime) {
				return num;
			}
			
			num++;
			
		}
	}
}
