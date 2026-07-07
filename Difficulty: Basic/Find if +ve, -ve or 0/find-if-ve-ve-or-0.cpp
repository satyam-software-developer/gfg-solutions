#include <iostream>
using namespace std;

int main() {
	// Take a as input
	int a;
	cin>> a;
	
	// find it is positive, negative or zero
	if (a > 0)
		cout << "Positive";
	else if (a < 0)
		cout << "Negative";
	else
		cout << "Zero";
	
	return 0;
}
