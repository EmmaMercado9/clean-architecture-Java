package com.undec.AppClima.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    public static boolean verifyEmail(String mail) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher=patron.matcher(mail);
        return matcher.find();
    }

    public static boolean verifyLoadedMail(String mail) {

        return mail != null && !mail.isBlank();
    }
}
