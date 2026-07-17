class Solution {
    public static Hello helperFunction() {
        // Your code here
        Hello obj = () -> System.out.println("Hello");
        
        return obj;

        // Implement sayHello using lambda expression and return the object.
        // Write this in the lambda expression: System.out.println("Hello")
    }
}