package es.system.jpexposito.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.jpexposito.vo.User;
import es.system.jpexposito.model.contract.UserContract;


public class UserDbHelper extends ComunDbHelper {

    public UserDbHelper(Context context) {
        super(context);
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
        return super.save(UserContract.UserEntry.TABLE_NAME,
                user.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<User> getAll() {
        List<User> users = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(UserContract.UserEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                users = new ArrayList<>();
                do {
                    @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.PASSWORD));
                    @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.EMAIL));
                    User user = new User(email, password);
                    users.add(user);
                } while (cursor.moveToNext());
                return users;
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar las excepciones
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList(); //Retornamos una lista vacia
    }

    /**
     * Cursor con el elmento encontrado en la BBDD
     * @param email identificador de consulta de la BBDD
     * @return cursor con el elemento
     */
    public User getById(String email) {
        User user = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(UserContract.UserEntry.TABLE_NAME,
                    null,
                    UserContract.UserEntry.EMAIL + " = ?",
                    new String[]{email},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.PASSWORD));
                user = new User(email, password);
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar el trato de las exception
        }finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return user;
    }


    /**
     * Funcion encargada en eliminar un elemento de la BBBDD
     * @param email identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String email) {
        return super.delete(UserContract.UserEntry.TABLE_NAME,
                UserContract.UserEntry.EMAIL + " = ?",
                new String[]{email});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param user usuario de la app
     * @param email email relacionado
     * @return intero con el valor de la operacion
     */
    public int update(User user, String email) {
        return super.update(UserContract.UserEntry.TABLE_NAME,
                user.toContentValues(),
                UserContract.UserEntry.EMAIL + " = ?",
                new String[]{email});
    }

}
