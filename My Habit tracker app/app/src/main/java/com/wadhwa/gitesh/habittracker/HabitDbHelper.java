package com.wadhwa.gitesh.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitDbHelper extends SQLiteOpenHelper {
    /*name of the database is habits.db*/
    private static final String DATABASE_NAME = "habits.db";
    /*version of database is 1*/
    private static final int DATABASE_VERSION = 1;
    /*now final code....>>*/
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /*---------------------------------------------------------------------------*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + Contract.HabitEntry.TABLE_NAME + " ("
                + Contract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Contract.HabitEntry.COLUMN_HABIT + " TEXT NOT NULL, "
                + Contract.HabitEntry.COLUMN_DURATION + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }
    /*----------------------------------------------------------------------------*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
    /*-------------------------------------------------------*/
    public void insertHabit(int habit, String duration) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.HabitEntry.COLUMN_HABIT, habit);
        values.put(Contract.HabitEntry.COLUMN_DURATION, duration);
        db.insert(Contract.HabitEntry.TABLE_NAME, null, values);
    }
    /*---------------------------------------------------------*/
    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.HabitEntry._ID,
                Contract.HabitEntry.COLUMN_HABIT,
                Contract.HabitEntry.COLUMN_DURATION
        };
        Cursor cursor = db.query(
                Contract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
