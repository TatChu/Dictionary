package xyz.dichvuso.dictionary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

import java.util.ArrayList;

/**
 * Created by The Boss on 12/05/2016.
 */
public class DbHelper {
    Context context;
    android.database.sqlite.SQLiteDatabase db;

    public DbHelper(Context context) {
        this.context = context;
        AssetDatabaseOpenHelper assetDB = new AssetDatabaseOpenHelper(context);
        db = assetDB.StoreDatabase();
    }

    private ArrayList<Word> get_list_Word(String sql, String... selectionArgs) {
        ArrayList<Word> contents = new ArrayList<Word>();

        // đọc từng cột từ database mới copy từ file assets vào như bình thường
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            Word word = new Word(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
            contents.add(word);
        }
        c.close();
        return contents;
    }


    // Lấy từ danh sách từ

    public ArrayList<Word> danhSach(String word) {
        String sql = "Select rowid, word, content, lang from words_0061";
        return get_list_Word(sql);
    }
/*
    public void Insert_Socre(String Name, int Money, String Img)
    {
        db.execSQL("Insert into Score (PlayerName, Money, Anh) values ('" + Name + "', " + Money + ", '" + "Img')");
    }
*/
}
