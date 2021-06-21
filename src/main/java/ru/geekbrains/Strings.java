package ru.geekbrains;

import java.util.Locale;

public class Strings {
    public static void main(String[] args) {
        String s6 = "abc";
        System.out.println(s6.length());
        System.out.println("'" + s6 + "'");
        System.out.println("'" + s6.trim() + "'");
        System.out.println(s6.toLowerCase());
        System.out.println(s6.toUpperCase());
        System.out.println(s6.equalsIgnoreCase("ABC"));
        System.out.println(s6.charAt(0));
        System.out.println(s6.toCharArray());
        System.out.println(s6.substring(1, 2));


        System.out.println(reverseString(s6));


    }

    private static String reverseString(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }

}
