// Function to reverse the digits
void reverseDigit(int &a, int &b) {
	// code here
	int revA = 0, revB = 0;
	
	while (a > 0) {
		revA = revA * 10 + a % 10;
		a = a / 10;
	}
	
	while (b > 0) {
		revB = revB * 10 + b % 10;
		b = b / 10;
	}
	
	a = revA;
	b = revB;
	
}

// Function to swap the values
void swap(int &a, int &b) {
	// code here.
	int temp = a;
	a = b;
	b = temp;
}
