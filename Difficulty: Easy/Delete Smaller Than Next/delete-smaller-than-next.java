class Solution {
	public static ArrayList<Integer> deleteElement(int arr[], int k) {
		// Code here
		ArrayList<Integer> st = new ArrayList<>();
		
		for (int num : arr) {
			while (!st.isEmpty() && k > 0 && st.get(st.size() - 1) < num) {
				st.remove(st.size() - 1);
				k--;
			}
			st.add(num);
		}
		
		return st;
	}
}
