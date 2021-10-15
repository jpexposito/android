package es.system.jpexposito.model.helper;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.system.jpexposito.model.User;
import es.system.jpexposito.model.contract.UserContract;


public class UsersDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";
    public UsersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserContract.UserEntry.EMAIL + " TEXT NOT NULL,"
                + UserContract.UserEntry.PASSWORD + " TEXT NOT NULL,"
                + "UNIQUE (" + UserContract.UserEntry.EMAIL + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }

    /**
     * Funcion encargada en realizar el almacenamiento de un usuario
     * @param user Usuario de la BBDD
     * @return identificador con el resultado en el proceso de almacenar
     * en la BBDD
     */
    public long save(User user) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                UserContract.UserEntry.TABLE_NAME,
                null,
                user.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Todos los elementos de la BBDD
     */
    public Cursor getAll() {
        return getReadableDatabase()
                .query(
                        UserContract.UserEntry.TABLE_NAME,
                        null,  // Lista de Columnas a consultar
                        null,  // Columnas para la clausula WHERE
                        null,  // Valores a comparar con las columnas del WHERE
                        null,  // Agrupar con GROUP BY
                        null,  // Condición HAVING para GROUP BY
                        null  // Clausula ORDER BY
                );
    }

    /**
     * Cursor con el elmento encontrado en la BBDD
     * @param email identificador de consulta de la BBDD
     * @return cursor con el elemento
     */
    public Cursor getById(String email) {
        Cursor cursor = getReadableDatabase().query(
                UserContract.UserEntry.TABLE_NAME,
                null,
                UserContract.UserEntry.EMAIL + " LIKE ?",
                new String[]{email},
                null,
                null,
                null);
        return cursor;
    }

    /**
     * Funcion encargada en eliminar un elemento de la BBBDD
     * @param email identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String email) {
        return getWritableDatabase().delete(
                UserContract.UserEntry.TABLE_NAME,
                UserContract.UserEntry.EMAIL + " LIKE ?",
                new String[]{email});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param user Usuario con los datos a actualizar
     * @param email para la busqueda del usuario
     * @return valor con el resultado de la operacion
     */
    public int update(User user, String email) {
        return getWritableDatabase().update(
                UserContract.UserEntry.TABLE_NAME,
                user.toContentValues(),
                UserContract.UserEntry.EMAIL + " LIKE ?",
                new String[]{email}
        );
    }

}
