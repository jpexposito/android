package es.system.jpexposito.model;

public interface IUser {
    String getEmail();
    String getPassword();
    int isValid();
}
