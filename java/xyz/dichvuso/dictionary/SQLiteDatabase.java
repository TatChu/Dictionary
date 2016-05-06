package xyz.dichvuso.dictionary;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tatchu on 28/04/2016.
 */
public class SQLiteDatabase {
    android.database.sqlite.SQLiteDatabase db;
    Database helper;

    public SQLiteDatabase(Context context) {
        helper = new Database(context);
        helper.createDatabase();
        db = helper.openDatabase();
    }
    public void ThemXoa(String truyvan) {
        db.execSQL(truyvan);
    }

    public List<Word> getListWord(String sql) {
        List<Word> list = new ArrayList<Word>();

        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            list.add(new Word(c.getString(1), c.getString(1), c.getString(2)));
            c.moveToNext();
        }
        return list;
    }

}
