class Complex {
	int x, y;
	
	public:
	Complex() {}
	
	Complex(int real, int imag) {
		x = real;
		y = imag;
	}
	
	Complex operator + (Complex c) {
		// Add your code here.
		return Complex(x + c.x, y + c.y);
	}
	
	void display() { cout << x << " + " << y << "i" << endl; }
};
