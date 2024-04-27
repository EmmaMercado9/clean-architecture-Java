package com.undec.AppClima.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Setter
@Getter
public class Usuario {

    private String name;
    private String mail;
    private String password;
    private LocalDate birthdate;
    private String country;


    private Usuario(String name, String mail, String password, LocalDate birthdate, String country) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.birthdate = birthdate;
        this.country = country;
    }

    public static Usuario instance(String name, String mail, String password, LocalDate birthdate, String country) {
        return new Usuario(name, mail,password, birthdate, country);
    }
}
