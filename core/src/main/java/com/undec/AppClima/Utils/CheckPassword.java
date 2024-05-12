package com.undec.AppClima.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassword {
    public static boolean verifyPassword(String password) {

        Pattern pattern=Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher=pattern.matcher(password);

        return matcher.find();

    }

    public static boolean verifyLoadedPass(String password) {

        return password != null && !password.isBlank();
    }
}
