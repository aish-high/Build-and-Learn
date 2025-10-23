package String;

import java.util.HashMap;

public class LongestSubStringWithAtMostKDistinctChars {
    public static void main(String[] args) {
        String str = "zcviqwyuydegijtgwxujqdn";
        int k = 6;
        HashMap<Character,Integer> map = new HashMap();
        int left=0, right=0, maxLen=0;
        while(right<str.length()){
            char ch = str.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char ch2 = str.charAt(left);
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2)==0)
                    map.remove(ch2);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        System.out.println(maxLen);
        optimize(str,k);
    }

    public static void optimize(String str, int k){
        int[] map = new int[256];
        int left=0, right=0, maxLen=0,counter=0;
        while(right<str.length()){
            if(map[str.charAt(right)] == 0) counter++; //counter represents the no of distinct characters
            map[str.charAt(right)]++;
            while(counter>k){   //while counter is invalid
                map[str.charAt(left)]--;
                if(map[str.charAt(left)] == 0) counter--; //make counter valid (basically reduce the no of distinct characters)
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        System.out.println(maxLen);
    }
}
