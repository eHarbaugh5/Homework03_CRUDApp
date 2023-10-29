package com.example.homework03;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Employees.db";
    private static final String TABLE_NAME = "Employees";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (username TEXT PRIMARY KEY NOT NULL, firstname TEXT, lastname TEXT, email TEXT, password TEXT, age TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean initializeDB()
    {
        if (numberOfRowsInTable() == 0)
        {

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('Zmoore','Zackary','Moore','zmoore@gmail.com','goodpassword','28')");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('S_Thomas','Shannon','Thomas','s_thomas@gmail.com','badpassword','43')");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('BigG','Gabriel','Smith','bigg@gmail.com','mediocrepassword','23')");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('HMoore','Harrison','Moore','hmoore@gmail.com','123highfive','31')");
            db.close();

            return true;
        }
        else
        {
            return false;
        }




    }

    public int numberOfRowsInTable()
    {

        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);

        db.close();

        return numRows;

    }

    @SuppressLint("Range")
    public ArrayList<Employee> getAllRows()
    {

        ArrayList<Employee> listEmployees = new ArrayList<Employee>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String uname;
        String fname;
        String lname;
        String email;
        String password;
        String age;

        if (cursor.moveToFirst())
        {

            do
            {  //  suppress this V
                uname = cursor.getString(cursor.getColumnIndex("username"));
                fname = cursor.getString(cursor.getColumnIndex("firstname"));
                lname = cursor.getString(cursor.getColumnIndex("lastname"));
                email = cursor.getString(cursor.getColumnIndex("email"));
                password = cursor.getString(cursor.getColumnIndex("password"));
                age = cursor.getString(cursor.getColumnIndex("age"));


                listEmployees.add(new Employee(uname, fname, lname, email, password, age));

            }
            while (cursor.moveToNext());

        }

        db.close();

        return listEmployees;

    }


    public void addNewEmployee(Employee e)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('" + e.getuName() + "','" + e.getfName() + "','" + e.getlName() + "','" + e.getEmail() + "','" + e.getPassword() + "','" + e.getAge() + "');");


    }

    public void updateExistingEmployee(Employee e)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateStatement = "UPDATE " + TABLE_NAME + " SET firstname = '" + e.getfName() + "', lastname = '" + e.getlName() + "', email = '" + e.getEmail() + "', password = '" + e.getPassword() + "', age = '" + e.getAge() + "' WHERE username = '" + e.getuName() + "';";
        Log.d("Update","e = " + e.getAge() + "");
        db.execSQL(updateStatement);

        db.close();
    }

    public void deleteEmployee(String u)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE username = '" + u + "';");

        db.close();

    }

    //  bottom
}
