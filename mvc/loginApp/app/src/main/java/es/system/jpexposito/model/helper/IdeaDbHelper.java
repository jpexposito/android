package es.system.jpexposito.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.jpexposito.model.contract.IdeaContract;
import es.system.jpexposito.model.contract.UserContract;
import es.system.jpexposito.vo.Idea;


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
        sqLiteDatabase.execSQL("CREATE TABLE " + IdeaContract.IdeaEntry.TABLE_NAME + " ("
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
     * @param idea Idea de la BBDD
     * @return identificador con el resultado en el proceso de almacenar
     * en la BBDD
     */
    public long save(Idea idea) {
        return super.save(IdeaContract.IdeaEntry.TABLE_NAME,
                idea.toContentValues());
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Idea> getAll() {
        List<Idea> ideas = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(IdeaContract.IdeaEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                ideas = new ArrayList<>();
                do {
                    @SuppressLint("Range") String user = cursor.getString(cursor.getColumnIndex(IdeaContract.IdeaEntry.IDUSER));
                    @SuppressLint("Range") String descripcion = cursor.getString(cursor.getColumnIndex(IdeaContract.IdeaEntry.DESCRIPCION));
                    Idea idea = new Idea(user, descripcion);
                    ideas.add(idea);
                } while (cursor.moveToNext());
                return ideas;
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
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @param idUser identificador del usuario
     * @return Lista vacia o todos los elementos de la BBDD
     */
    public List<Idea> getAll(String idUser) {
        List<Idea> ideas = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(IdeaContract.IdeaEntry.TABLE_NAME,
                    null,
                    IdeaContract.IdeaEntry.IDUSER + " = ?",
                    new String[]{idUser},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                ideas = new ArrayList<>();
                do {
                    @SuppressLint("Range") String descripcion = cursor.getString(cursor.getColumnIndex(IdeaContract.IdeaEntry.DESCRIPCION));
                    Idea idea = new Idea(idUser, descripcion);
                    ideas.add(idea);
                } while (cursor.moveToNext());
                return ideas;
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
     * Funcion encargada en eliminar un elemento de la BBBDD
     * @param id identificador de consulta de la BBDD
     * @return valor con el resultado de la operacion
     */
    public int delete(String id) {
        return super.delete(UserContract.UserEntry.TABLE_NAME,
                IdeaContract.IdeaEntry._ID + " = ?",
                new String[]{id});
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * de la BBDD
     * @param idea idea a actualizar en la app
     * @param id idea relacionado
     * @return intero con el valor de la operacion
     */
    public int update(Idea idea, String id) {
        return super.update(IdeaContract.IdeaEntry.TABLE_NAME,
                idea.toContentValues(),
                IdeaContract.IdeaEntry._ID + " = ?",
                new String[]{id});
    }

}
