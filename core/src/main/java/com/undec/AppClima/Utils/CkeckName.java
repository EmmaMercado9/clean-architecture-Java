package com.undec.AppClima.Utils;

import java.util.regex.Pattern;

public class CkeckName {
    public static boolean verifyUser(String name) {

        if((name.length()<3 || name.length()>20 )){
            return false;
        }
        return name.matches("[a-zA-Z0-9]+");

    }

    public static boolean verifyLoadedUser(String name) {

        return name != null && !name.isBlank();
    }
}
