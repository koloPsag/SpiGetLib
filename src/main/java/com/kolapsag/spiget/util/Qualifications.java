package com.kolapsag.spiget.util;

// Went with this name, because Google's library has a class named Preconditions and I didn't want to confuse people
public class Qualifications {

    private Qualifications() {} // Disable instantiation

    public static void checkInt(int i, String message) { if (i < 0) throw new IllegalArgumentException(message); }
    public static void checkInt(int i) { checkInt(i, "Number cannot be smaller than 0"); }
    public static void checkInts(String message, int... is) { for (int i : is) { checkInt(i, message); } }

    public static void checkString(String s, String message) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(message);
    }
    public static void checkString(String s) { checkString(s, "String cannot be blank"); }
    public static void checkStrings(String message, String... ss) { for (String s : ss) { checkString(s, message); } }

}