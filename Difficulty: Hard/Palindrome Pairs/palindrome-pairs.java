import java.util.*;

class Solution {
    public boolean palindromePair(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : arr) {
            int n = s.length();
            
            for (int i = 0; i <= n; i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                
                if (isPalindrome(left)) {
                    String rev = new StringBuilder(right).reverse().toString();
                    
                    if (map.containsKey(rev)) {
                        if (!rev.equals(s) || map.get(rev) > 1) {
                            return true;
                        }
                    }
                }
                
                if (i < n && isPalindrome(right)) {
                    String rev = new StringBuilder(left).reverse().toString();
                    
                    if (map.containsKey(rev)) {
                        if (!rev.equals(s) || map.get(rev) > 1) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}