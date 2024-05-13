package com.undec.AppClima.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassword {
    public static boolean verifyPassword(String password) {

        Pattern pattern=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$");
        Matcher matcher=pattern.matcher(password);

        return matcher.matches();

    }

    public static boolean verifyLoadedPass(String password) {

        return password != null && !password.isBlank();
    }
}
