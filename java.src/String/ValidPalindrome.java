package String;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = s.toLowerCase().replaceAll("[^0-9a-z]","");
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) {
                System.out.println("Invalid palindrome");
                break;
            }
            left++;
            right--;
        }
        System.out.println("Valid Palindrome");
    }
}
