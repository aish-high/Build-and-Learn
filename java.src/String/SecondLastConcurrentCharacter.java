package String;

public class SecondLastConcurrentCharacter {

    public static void main(String[] args) {
        String str = "gunaakannan";
        char lastChar = '\0';
        char secondLastChar = '\0';
        for(char ch: str.toCharArray()) {
            if (ch == lastChar)
                secondLastChar = lastChar;
            lastChar = ch;
        }
        System.out.println("The second last concurrent character: " + secondLastChar);
    }
}


