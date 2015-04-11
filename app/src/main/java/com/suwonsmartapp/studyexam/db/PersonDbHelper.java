
package com.suwonsmartapp.studyexam.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by junsuk on 15. 4. 11..
 */
public class PersonDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Person";
    private static final int DATABASE_VERSION = 1;

    private Context mContext;
    private SQLiteDatabase mDb;

    public PersonDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("PersonDbHelper", "onCreate mDb");
        db.execSQL("CREATE TABLE " + DATABASE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void open() {
        mDb = getWritableDatabase();
        Toast.makeText(mContext, "db open", Toast.LENGTH_SHORT).show();
    }

    public void insert(String name, String email) {
        mDb.execSQL("insert into " + DATABASE_NAME + " (name, email) values ('" + name + "', '"
                + email + "')");
        // mDb.rawQuery("insert into " + DATABASE_NAME +
        // " (name, email) values (?, ?)",
        // new String[]{name, email});
        Toast.makeText(mContext, "db insert", Toast.LENGTH_SHORT).show();
    }

    public void insert(Person person) {
        this.insert(person.getName(), person.getEmail());
    }

    public Cursor selectAll() {
        Cursor cursor = mDb.rawQuery("select _id, name, email from " + DATABASE_NAME, null);
        // cursor.moveToFirst();
        //
        // for (int i = 0; i < cursor.getCount(); i++) {
        // Log.d("DB", "name : " + cursor.getString(1) + ", email : " +
        // cursor.getString(2));
        // cursor.moveToNext();
        // }

        // Toast.makeText(
        // mContext,
        // "db selectAll : " + cursor.getString(0) + ", " + cursor.getString(1)
        // + ", "
        // + cursor.getString(2), Toast.LENGTH_SHORT).show();
        return cursor;
    }
}
