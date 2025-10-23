package Coding.String;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s="ADOBECODEBANC", t="ABC";
        int right=0,left=0,n=s.length(),counter = t.length(),minLen = Integer.MAX_VALUE,head=0;
        int[] map = new int[128];
        for(char c: t.toCharArray())
            map[c]++;
        while(right<n){
            char ch = s.charAt(right++);
            if(map[ch] > 0) counter--; //counter represents the no of characters in t not found in s
            map[ch]--;
            while(counter==0){ //while counter is valid
                if(right-left < minLen) {
                    minLen = right-left;
                    head = left;
                }
                char ch2 = s.charAt(left);
                map[ch2]++;
                if(map[ch2] > 0) counter++; //make counter invalid
                left++;
            }
        }
        System.out.println("Minimum window substring: " + (minLen==Integer.MAX_VALUE ? "": s.substring(head,minLen+head)));
    }
}
