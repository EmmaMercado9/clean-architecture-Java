package com.undec.AppClima.usecaseUnitTest.Utils;

import com.undec.AppClima.Utils.CheckEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MailUnitTest {

    @Test
    void CheckMail_MailCorrect_Correct(){

        String []mails ={
                "john.doe@example.com",
                "jane_doe1234@example.co.uk",
                "user1234@email.domain.org",
                "first.last@subdomain.example.net",
                "alice+bob@email-provider.com",
                "sarah_smith1234@email.domain.net",
                "info@company.com",
                "support@website.co.uk",
                "contact_us123@example.net",
                "sales_team@email-provider.com",
                "johndoe1234@example.com",
                "jane.doe@email-provider.co.uk",
                "user.name1234@email-domain.org",
                "first.last@email-provider.net",
                "alice.bob@email-provider.com",
                "test1234@example.com",
                "example@example.co.uk",
                "user1234@email-domain.org",
                "john_doe1234@email-provider.net",
                "info1234@example.com"
        };

        for(String n : mails){
            Assertions.assertTrue(CheckEmail.verifyEmail(n));
        }

    }
    @Test
    void CheckMail_MailIncorrect_Incorrect(){

        String []mails={
                "john.doe.example.com",
                "jane@doe@example.co.uk",
                "user1234@",
                "@example.com",
                "john.doe@example",
                "john.doe@example..com",
                "john.doe@example_com",
                "john.doe@example_com",
                "john.doe@1234",
                "john.doe@ex ample.com",
                "john.doe@-example.com",
                "john.doe@example-.com",
                "john.doe@exa_mple.com",
                "john.doe@example.c",
                "john.doe@example..com",
                "john.doe@example.com.",
                "john.doe@.example.com",
                "john.doe@example.com",
                "john.doe@example",
                ".john.doe@example.com"
        };

        for(String n :mails){
            Assertions.assertFalse(CheckEmail.verifyEmail(n));
        }
    }
}
