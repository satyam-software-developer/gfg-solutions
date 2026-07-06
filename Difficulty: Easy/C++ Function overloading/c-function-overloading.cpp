#include <iostream>
using namespace std;

void volume(int s) {
	cout << s * s * s << endl;
}

void volume(int r, int h) {
	double ans = 3.14159 * r * r * h;
	cout << ans << endl;
}

void volume(int l, int b, int h) {
	cout << l * b * h << endl;
}
