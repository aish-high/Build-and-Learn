package String;

import java.util.HashSet;

public class LongestSubStrWithoutRepeatChars {
    public static void main(String[] args) {
        String str = "abcdeaabbcc";
        HashSet<Character> seenSet = new HashSet<>();
        int left =0, right =0,maxLen = 0;
        while(right < str.length()){
            if(!seenSet.contains(str.charAt(right))){
                seenSet.add(str.charAt(right));
                maxLen = Math.max(maxLen, right - left +1);
                right++;
            } else {
                seenSet.remove(str.charAt(right));
                left++;
            }
        }
        System.out.println("Length of longest substring: "+maxLen);
        optimize(str);
    }

    public static void optimize(String str){
        int[] map = new int[128];
        int right=0,left=0,maxLen=0,counter=0;

        while (right<str.length()){
            if(map[str.charAt(right)]==1) //if already that character is present, that means this character is duplicate
                counter++; //counter represents the no of times a character is present in the substring
            map[str.charAt(right++)]++;
            while (counter>0){ //while counter is invalid
                map[str.charAt(left)]--;
                if(map[str.charAt(left)]==1) counter--; //make counter valid
                left++;
            }
            maxLen =Math.max(maxLen,right-left);
        }
        System.out.println(maxLen);
    }
}
