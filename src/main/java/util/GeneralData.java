package util;

import com.github.javafaker.Faker;
import dtos.AutenticationRecord;
import dtos.DataIncompleteRecord;
import dtos.UsuarioRecord;

import java.util.List;

public class GeneralData {
    Faker faker = new Faker();

    public UsuarioRecord  getAdmin(){

        return  new UsuarioRecord("admin","admin", List.of("admin"));
    }
    public UsuarioRecord getUser(){

        return new UsuarioRecord(getUsername(),getPassword(),List.of("user"));
    }


    public UsuarioRecord getUserWithOutUsername(){
        return new UsuarioRecord(null,getPassword(),List.of("user"));
    }

    public DataIncompleteRecord getUsuarioIncompleto(){
        return new DataIncompleteRecord(getUsername());
    }

    public String getUsername(){
        return faker.name().username();
    }

    public String getPassword(){
        return faker.internet().password();
    }

    public AutenticationRecord getAdminCredential(){
        return new AutenticationRecord("admin","admin");
    }

    public AutenticationRecord getCredential(UsuarioRecord usuario) {
        if( usuario != null ) {
            return new AutenticationRecord(usuario.usuario(), usuario.clave());
        }
        return getCredential(getUser());
    }

}
