package es.system.jpexposito.model;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.Objects;

import es.system.jpexposito.model.contract.UserContract;
import es.system.jpexposito.model.inteface.IUser;

public class User implements IUser {

    private  String id, email,password;

    /**
     * Constructor de la clase User
     * @param email del usuario
     * @param password del usuario
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Funcion que verifica si los datos del usuario son validos
     * @return (-1..3)
     *  0. Email Empty
     *  1. Email Match pattern
     *  2. Password Empty
     *  3. Password <= 6
     * -1. Ok
     */
    @Override
    public int isValid() {

        if(TextUtils.isEmpty(getEmail()))
            return  0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return  1;
        else if(TextUtils.isEmpty(getPassword()))
            return 2;
        else if(getPassword().length()<=6)
            return 3;
        else
            return -1;
    }

    /**
     * Funcion encargada en transformar el valor del objeto en un ContentValues
     * @return ContentValues con el valor del objeto
     */
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.EMAIL, email);
        values.put(UserContract.UserEntry.PASSWORD, password);
        return values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Funcion que determina si dos objetos de la clase user, son iguales
     * @param o objeto a evuluar
     * @return true/false con la evaluacion
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }
}
