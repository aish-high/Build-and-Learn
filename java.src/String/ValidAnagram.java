package String;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().check());
    }

    private boolean check() {
        String s="anagram", t="nagaram";
        //if(s.length() != t.length()) return false;
        int[] arr = new int[128];
        for(char ch: s.toCharArray())
            arr[ch]++;
        for(int i=0; i<t.length(); i++){
            arr[t.charAt(i)]--;
            if(arr[t.charAt(i)] < 0) return false;
        }
        return true;
    }
}
