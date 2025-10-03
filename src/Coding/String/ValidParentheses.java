package Coding.String;

import java.util.regex.Pattern;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(}";
        int left=0, right=s.length()-1;
        Pattern open = Pattern.compile("[({\\[]", Pattern.CASE_INSENSITIVE);
        Pattern closed = Pattern.compile("[)}\\]]", Pattern.CASE_INSENSITIVE);
        while(left<right){
            if(s.charAt(left+1) - s.charAt(left) == 2 || s.charAt(left+1) - s.charAt(left) == 1
            ||  s.charAt(right) - s.charAt(left) == 2 || s.charAt(right) - s.charAt(left) == 1) {
                left += 2;
                right -= 2;
            } else {
                System.out.println("not valid");
                break;
            }
        }
        System.out.println("valid");
    }
}
