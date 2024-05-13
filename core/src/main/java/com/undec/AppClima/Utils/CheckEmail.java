package com.undec.AppClima.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    public static boolean verifyEmail(String mail) {

        Pattern patron = Pattern.compile("^[\\w!#$%&'*+/=?^{|}~-]+(?:\\.[\\w!#$%&'*+/=?^{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");


        Matcher matcher=patron.matcher(mail);
        return matcher.matches();
    }

    public static boolean verifyLoadedMail(String mail) {

        return mail != null && !mail.isBlank();
    }
}
