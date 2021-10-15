package es.system.jpexposito.model.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class UserContract {

    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="user";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }
}
