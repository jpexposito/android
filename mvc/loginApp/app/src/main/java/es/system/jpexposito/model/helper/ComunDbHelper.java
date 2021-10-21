package es.system.jpexposito.model.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.system.jpexposito.model.User;
import es.system.jpexposito.model.contract.UserContract;

public class ComunDbHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "notas.db";

    public ComunDbHelper(Context context) {
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    public ComunDbHelper(Context context, String table,
                         SQLiteDatabase.CursorFactory factory, int tableVersion) {
        super(context, table, factory, tableVersion);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // No hay operaciones
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }

    public long save(String table, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                table,
                null,
                values);
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @param table
     * @return Todos los elementos de la BBDD
     */


    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @param table Tabla sobre la que se realiza la operacion
     * @param columns Lista de Columnas a consultar
     * @param selection Columnas para la clausula WHERE
     * @param selectionArgs Valores a comparar con las columnas del WHERE
     * @param groupBy Agrupar con GROUP BY
     * @param having Condición HAVING para GROUP BY
     * @param orderBy Clausula ORDER BY
     * @return
     */
    public Cursor getAll(String table, String[] columns, String selection,
                         String[] selectionArgs, String groupBy, String having,
                         String orderBy) {

        return getReadableDatabase()
                .query(
                        table,
                        columns,
                        selection,
                        selectionArgs,
                        groupBy,
                        having,
                        orderBy
                );
    }

    /**
     * Funcion encargada en eliminar un elemento de la BBBDD
     * @param email identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String table, String email) {
        return getWritableDatabase().delete(
                table,
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
    public int update(String table, User user, String email) {
        return getWritableDatabase().update(
                UserContract.UserEntry.TABLE_NAME,
                user.toContentValues(),
                UserContract.UserEntry.EMAIL + " LIKE ?",
                new String[]{email}
        );
    }

}
