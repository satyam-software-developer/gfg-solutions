import java.util.Scanner;

class GFG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// code here
		
		int rightShift = a>> b;
		int leftShift = a << b;
		
		System.out.println(rightShift + " " + leftShift);
		
	}
}
