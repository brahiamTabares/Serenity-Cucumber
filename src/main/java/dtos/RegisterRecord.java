package dtos;

import java.util.Collection;

public record RegisterRecord(String usuario, String clave, Collection <String> roles) {
}
