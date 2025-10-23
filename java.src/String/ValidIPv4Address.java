package String;

import java.util.regex.Pattern;

public class ValidIPv4Address {
    public static void main(String[] args) {
        String ip = "172.0.0.000";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$");
        System.out.println("Is input a valid ipv4 address: " + pattern.matcher(ip).matches());
    }
}
