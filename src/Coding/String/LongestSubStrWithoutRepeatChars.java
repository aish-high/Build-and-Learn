package Coding.String;

import java.util.HashSet;

public class LongestSubStrWithoutRepeatChars {
    public static void main(String[] args) {
        String str = "abcdeaabbcc";
        HashSet<Character> seenSet = new HashSet<>();
        int i=0,j=0,maxLen = 0;
        while(j<str.length()){
            if(!seenSet.contains(str.charAt(j))){
                seenSet.add(str.charAt(j));
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            } else {
                seenSet.remove(str.charAt(j));
                i++;
            }
        }
        System.out.println("Length of longest substring: "+maxLen);

    }
}
