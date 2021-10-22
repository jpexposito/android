package es.system.jpexposito.model;

import android.content.ContentValues;

import es.system.jpexposito.model.contract.IdeaContract;
import es.system.jpexposito.model.contract.UserContract;
import es.system.jpexposito.model.inteface.IIdea;

public class Idea implements IIdea {
    String user;
    String descripcion;

    /**
     * Constructor de la clase
     * @param user asociado a la idea
     * @param descripcion descripcion de la idea creada
     */
    public Idea(String user, String descripcion) {
        this.user = user;
        this.descripcion = descripcion;
    }

    @Override
    public int isValid() {
        return 0;
    }

    /**
     * Funcion encargada en transformar el valor del objeto en un ContentValues
     * @return ContentValues con el valor del objeto
     */
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(IdeaContract.IdeaEntry.IDUSER, user);
        values.put(IdeaContract.IdeaEntry.DESCRIPCION, descripcion);
        return values;
    }
}
