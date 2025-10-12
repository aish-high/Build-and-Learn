package Coding.String;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(}";
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(',1);
        map.put(')',-1);
        map.put('{',2);
        map.put('}',-2);
        map.put('[',3);
        map.put(']',-3);
        boolean flag = true;

        for(int i=0; i<s.length(); i++){
            int ch = map.get(s.charAt(i));
            if(ch >0) {
                stack.push(s.charAt(i));
            } else{
                if(stack.empty()){
                    flag = false;
                    break;
                }
                char ch2 = stack.pop();
                if((-1 * map.getOrDefault(ch2,0)) != ch){
                    flag = false;
                    break;
                }
            }
        }
        System.out.println("Valid parenthesis: " + (flag && stack.empty()));
    }
}
