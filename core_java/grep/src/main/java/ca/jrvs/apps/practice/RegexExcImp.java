package ca.jrvs.apps.practice;

import java.util.regex.*;


public class RegexExcImp implements  RegexExc{

    @Override
    public boolean matchJpeg(String filename) {
        Pattern regexStatement = Pattern.compile(".+\\.(?i)(jpeg|jpg)$");
        Matcher matcher = regexStatement.matcher(filename);
        return matcher.matches();

    }

    @Override
    public boolean matchIp(String ip) {
        return Pattern.matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$", ip);
    }

    @Override
    public boolean isEmpty(String line) {
        return Pattern.matches("^\\s*$", line);
    }

    public static void main(String[] args) {
        RegexExcImp regex = new RegexExcImp();
        boolean result = regex.matchJpeg("avengerendgame.jpg");
        System.out.print(result);
        result = regex.matchIp("255.255.255.0");
        System.out.print(result);
        result = regex.isEmpty("              ");
        System.out.print(result);
    }
}


