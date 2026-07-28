// Takes ArrayList as an argument and
// inserts the elements of the ArrayList into a
// TreeSet and returns the TreeSet.
class Solution {
    public static TreeSet<Integer> insert(int arr[]) {
        // Your code here
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int num : arr){
            set.add(num);
        }
        return set;
    }

    // Takes a TreeSet as an argument and prints
    // the elements of the TreeSet. The newline
    // is provided by the driver code.
    public static void display(TreeSet<Integer> s) {

        
        // Your code here
        for(int num : s){
            System.out.print(num + " ");
        }
    }

    // Takes TreeSet and x as arguments and erases x
    // from the TreeSet. If erased, print "erased x"
    // else then print "not found".The newline
    // is provided by the driver code.

        
    public static void erase(TreeSet<Integer> s, int x) {
        // Your code here
        if(s.remove(x)){
            System.out.print("erased "+x);
        }else{
            System.out.print("not found");
        }
    }
}