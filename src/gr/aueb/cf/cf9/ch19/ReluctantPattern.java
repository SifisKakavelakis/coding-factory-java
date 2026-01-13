package gr.aueb.cf.cf9.ch19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reluctant = Non-greedy
 */
public class ReluctantPattern {

    public static void main(String[] args) {
        String str = "login;alice;pass;12345;";

        Pattern pattern = Pattern.compile(".*?;");   // as little as possible -> non-greedy, reluctant
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
