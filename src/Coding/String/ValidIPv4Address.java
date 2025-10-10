package Coding.String;

import java.util.regex.Pattern;

public class ValidIPv4Address {
    public static void main(String[] args) {
        String ip = "172.0.0.000";
        Pattern pattern = Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
        System.out.println("Is input a valid ipv4 address: " + pattern.matcher(ip).matches());
    }
}
