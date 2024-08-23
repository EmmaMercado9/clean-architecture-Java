package com.undec.AppClima.domain;
import com.undec.AppClima.Utils.CheckEmail;
import com.undec.AppClima.Utils.CheckPassword;
import com.undec.AppClima.Utils.CkeckName;
import com.undec.AppClima.exeptions.User.ExceptionUserIncomplete;
import com.undec.AppClima.exeptions.User.ExceptionUserIncorrect;
import java.time.LocalDate;
public class User {
    private Long idUser;
    private String name;
    private String mail;
    private String password;
    private LocalDate birthdate;
    private String country;
    private User(Long id,String name, String mail, String password, LocalDate birthdate, String country) {
        this.idUser=id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.birthdate = birthdate;
        this.country = country;
    }
    public static User instance(Long id,String name, String mail, String password, LocalDate birthdate, String country) {
        if(!CkeckName.verifyLoadedUser(name)){
            throw new ExceptionUserIncomplete("El nombre usuario debe ser cargado!!");
        }
        if((!CkeckName.verifyUser(name))){
            throw  new ExceptionUserIncorrect("Ingrese un formato adecuado!!");
        }
        if(!CheckEmail.verifyLoadedMail(mail)){
            throw new ExceptionUserIncomplete("El correo electronico debe ser cargado!!");
        }
        else if(!CheckEmail.verifyEmail(mail)){
            throw new ExceptionUserIncorrect("El correo electronico es invalido!!");
        }
        if(!CheckPassword.verifyLoadedPass(password)){
            throw new ExceptionUserIncomplete("La contraseña debe ser cargada!!");
        }
        else if(!CheckPassword.verifyPassword(password)){
            throw new ExceptionUserIncorrect("La contraseña no es valida!!");
        }
        if(country.length()>50){
            throw new ExceptionUserIncorrect("Longitud Pais no valida");
        }
        return new User(id,name, mail,password, birthdate, country);
    }
    public  void edit(String name, String password, String mail) {
        if(CkeckName.verifyLoadedUser(name)){
            if((!CkeckName.verifyUser(name))){
                throw  new ExceptionUserIncorrect("Ingrese un formato adecuado!!");
            }
            else{
                this.name=name;
            }
        }
        if(CheckEmail.verifyLoadedMail(mail)){
            if(!CheckEmail.verifyEmail(mail)){
                throw new ExceptionUserIncorrect("El correo electronico es invalido!!");
            }
            else{
                this.mail=mail;
            }
        }
        if(CheckPassword.verifyLoadedPass(password)){
            if(!CheckPassword.verifyPassword(password)){
                throw new ExceptionUserIncorrect("La contraseña no es valida!!");
            }
            else {
                this.password=password;
            }
        }
    }
    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }
    public String getPassword() {
        return password;
    }
    public Long getIdUser() {return idUser;}

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getCountry() {
        return country;
    }
}