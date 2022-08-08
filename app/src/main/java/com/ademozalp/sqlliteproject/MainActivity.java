package com.ademozalp.sqlliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Data", MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS table8 (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INT)");

            //database.execSQL("INSERT INTO table8 (name, age) VALUES ('Adem', 23)");
            //database.execSQL("INSERT INTO table8 (name, age) VALUES ('Ferhat', 28)");

            //database.execSQL("UPDATE table8 SET age=28 WHERE name='Adem'");
            //database.execSQL("DELETE FROM table8 where name='Ferhat'");
            //Cursor cursor = database.rawQuery("SELECT * FROM table8 where name='Adem'",null);
            Cursor cursor = database.rawQuery("SELECT * FROM table8",null);

            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            while(cursor.moveToNext()){
                System.out.println(cursor.getInt(idIndex));
                System.out.println(cursor.getString(nameIndex));
                System.out.println(cursor.getInt(ageIndex));
            }
            cursor.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}