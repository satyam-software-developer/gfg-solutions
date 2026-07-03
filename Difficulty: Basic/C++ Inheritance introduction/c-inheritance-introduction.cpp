class Cuboid {
	protected:
	int length, width, height;
	
	public:
	void display() {
		cout << length << " " << width << " " << height << endl;
	}
};

class CuboidVol : public Cuboid {
	public:
	void read_input(int l, int w, int h) {
		length = l;
		width = w;
		height = h;
	}
	
	void display() {
		cout << length * width * height << endl;
	}
};
