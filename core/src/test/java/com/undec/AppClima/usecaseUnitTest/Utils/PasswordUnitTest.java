package com.undec.AppClima.usecaseUnitTest.Utils;
import com.undec.AppClima.Utils.CheckPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class PasswordUnitTest {
    @Test
    void  PasswordCheck_CorrectPassword_Correct() {
        String[] password = {
                "Ezzx2aa*",
                "ssaWaas!3*",
                "$dsd2Aee",
                "hP21a#WW",
                "CS13as23*"
        };
        for (String n :password ){
            Assertions.assertTrue(CheckPassword.verifyPassword(n));
        }
    }
    @Test
    void  PasswordCheck_InCorrectPassword_InCorrect() {
        String [] password={"22","0","EMMANU;","emmanuel","s::::::","sealoque","nose","MESSIcrack"};
        for (String n :password ){
            Assertions.assertFalse(CheckPassword.verifyPassword(n));
        }
    }
}