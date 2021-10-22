package es.system.jpexposito.model.helper;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import es.system.jpexposito.model.Idea;
import es.system.jpexposito.model.User;
import es.system.jpexposito.model.contract.IdeaContract;
import es.system.jpexposito.model.contract.UserContract;


public class IdeaDbHelper extends ComunDbHelper {

    public IdeaDbHelper(Context context) {
        super(context);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + IdeaContract.IdeaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + IdeaContract.IdeaEntry.IDUSER + " TEXT NOT NULL,"
                + IdeaContract.IdeaEntry.DESCRIPCION + " TEXT NOT NULL)");
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
    public long save(Idea idea) {
        return super.save(IdeaContract.IdeaEntry.TABLE_NAME,
                idea.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Todos los elementos de la BBDD
     */
    public Cursor getAll() {

        return super.getAll(UserContract.UserEntry.TABLE_NAME,
                null, null, null,
                null, null, null);
    }

    /**
     * Cursor con el elmento encontrado en la BBDD
     * @param user identificador de consulta de la BBDD
     * @return cursor con el elemento
     */
    public Cursor getByIdUser(String user) {
        return super.getAll(IdeaContract.IdeaEntry.TABLE_NAME,
                null,
                IdeaContract.IdeaEntry.IDUSER + " LIKE ?",
                new String[]{user},
                null,
                null,
                null);
    }

    /**
     * Funcion encargada en eliminar un elemento de la BBBDD
     * @param id identificador de eliminacion de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String id) {
        return super.delete(UserContract.UserEntry.TABLE_NAME,
                UserContract.UserEntry._ID + " = ?",
                new String[]{id});
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
                UserContract.UserEntry.EMAIL + " LIKE ?",
                new String[]{email});
    }

}
