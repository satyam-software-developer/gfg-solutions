template <class T>
class minElement {
	// Complete the class.Make a private variable,constructors and method called
	// check() which takes one parameter and prints the output in new line.
	private:
	T y; // Private variable
	
	public:
	// Constructor
	minElement(T value) {
		y = value;
	}
	
	// Method to print the minimum of x and y
	void check(T x) {
		if (x < y)
			cout << x << endl;
		else
			cout << y << endl;
	}
};
