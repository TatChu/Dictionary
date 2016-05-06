package xyz.dichvuso.dictionary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLData;

/**
 * Created by tatchu on 27/04/2016.
 */
public class Database extends SQLiteOpenHelper {
    public static final String DATASE_NAME = "Dictionary.sqlite";


    Context context;
    String duongDanDatabase = "";


    public Database(Context context) {
        super(context, DATASE_NAME, null, 1);
        this.context = context;
        duongDanDatabase = context.getFilesDir().getParent() + "/databases/" + DATASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    public SQLiteDatabase openDatabase(){
        return SQLiteDatabase.openDatabase(duongDanDatabase, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public void copyDatabase(){
        try {
            InputStream is =  context.getAssets().open(DATASE_NAME);
            OutputStream os = new FileOutputStream(duongDanDatabase);
            byte[] buffer = new byte[1024];
            int lenght = 0;
            while((lenght = is.read(buffer)) > 0){
                os.write(buffer, 0, lenght);
            }

            os.flush();
            os.close();
            is.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createDatabase(){
        boolean kt = KiemTraDB();
        if(kt){
            Log.d("KetNoi", "This decives was exits database");
        }else{
            Log.d("KetNoi", "This devices was not exits database. Processing copy database!");
            this.getWritableDatabase();
            copyDatabase();
        }
    }


    public boolean KiemTraDB(){
        SQLiteDatabase kiemTraDB = null;
        try{
            kiemTraDB = SQLiteDatabase.openDatabase(duongDanDatabase, null, SQLiteDatabase.OPEN_READONLY);
        }catch(Exception e){
            e.printStackTrace();
        }

        if(kiemTraDB !=null){
            kiemTraDB.close();
        }
        return kiemTraDB !=null ? true : false;
    }
}
