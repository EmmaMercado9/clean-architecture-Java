package com.undec.AppClima.usecaseUnitTest.Utils;

import com.undec.AppClima.Utils.CkeckName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameUnitTest {


    @Test
    void  nameCheck_CorrectName_Correct() {
        String []name={"Emmanuel1","Carlos","Roman3","Ezequiel4","Florencia2","Nicolas"
                ,"Carlitos"};

        for (String n : name){
            Assertions.assertTrue(CkeckName.verifyUser(n));
        }


    }

    @Test
    void  nameCheck_IncorrectName_InCorrect() {
        String []name={"Em","C","Roman**Eqwwwwwwwwwwwwww3","(///%%%Ezequiel4","dsdsd11  /Florencia2","Nicolas%$"
                ,"Ca"};

        for (String n : name){
            Assertions.assertFalse(CkeckName.verifyUser(n));
        }


    }
}
