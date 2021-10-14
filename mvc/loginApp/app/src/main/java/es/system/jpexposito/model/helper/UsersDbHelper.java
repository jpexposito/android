package es.system.jpexposito.model.helper;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.system.jpexposito.model.contract.UserContract;


public class UsersDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";
    public UsersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + LawyerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LawyerEntry.ID + " TEXT NOT NULL,"
                + LawyerEntry.NAME + " TEXT NOT NULL,"
                + LawyerEntry.SPECIALTY + " TEXT NOT NULL,"
                + LawyerEntry.PHONE_NUMBER + " TEXT NOT NULL,"
                + LawyerEntry.BIO + " TEXT NOT NULL,"
                + LawyerEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + LawyerEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
