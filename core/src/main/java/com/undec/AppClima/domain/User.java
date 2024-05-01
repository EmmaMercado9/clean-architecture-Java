package com.undec.AppClima.domain;




import com.undec.AppClima.Utils.CheckEmail;
import com.undec.AppClima.Utils.CheckPassword;
import com.undec.AppClima.Utils.CkeckName;
import com.undec.AppClima.exeptions.User.ExceptionUser;

import java.time.LocalDate;



public class User {

    private String name;
    private String mail;
    private String password;
    private LocalDate birthdate;
    private String country;


    private User(String name, String mail, String password, LocalDate birthdate, String country) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.birthdate = birthdate;
        this.country = country;
    }

    public static User instance(String name, String mail, String password, LocalDate birthdate, String country) throws ExceptionUser {

        if(!CkeckName.verifyLoadedUser(name)){
            throw new ExceptionUser("El nombre usuario debe ser cargado!!");
        }
        if((!CkeckName.verifyUser(name))){
            throw  new ExceptionUser("Ingrese un formato adecuado!!");
        }
        if(!CheckEmail.verifyLoadedMail(mail)){
            throw new ExceptionUser("El correo electronico debe ser cargado!!");
        }
        else if(!CheckEmail.verifyEmail(mail)){
            throw new ExceptionUser("El correo electronico es invalido!!");
        }
        if(!CheckPassword.verifyLoadedPass(password)){
            throw new ExceptionUser("La contraseña debe ser cargada!!");
        }
        else if(!CheckPassword.verifyPassword(password)){
            throw new ExceptionUser("La contraseña no es valida!!");
        }
        if(country.length()>50){
            throw new ExceptionUser("Longitud Pais no valida");
        }

        return new User(name, mail,password, birthdate, country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
