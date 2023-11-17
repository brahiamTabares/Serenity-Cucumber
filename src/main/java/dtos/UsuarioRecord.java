package dtos;



import java.util.Collection;

public record UsuarioRecord(String usuario, String clave, Collection <String> roles) {



}
