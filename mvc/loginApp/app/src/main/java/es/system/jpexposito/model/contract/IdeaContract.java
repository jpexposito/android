package es.system.jpexposito.model.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class IdeaContract {

    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="idea";
        public static final String IDUSER = "idUser";
        public static final String DESCRIPCION = "descripcion";
    }
}
