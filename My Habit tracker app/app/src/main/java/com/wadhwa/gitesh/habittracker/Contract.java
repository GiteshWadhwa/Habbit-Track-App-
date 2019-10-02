package com.wadhwa.gitesh.habittracker;

import android.provider.BaseColumns;
public class Contract {
    private Contract() {
    }
    public class HabitEntry implements BaseColumns {
        /*first string table name for habits.*/
        public final static String TABLE_NAME = "Habits";
        /*second string for id.*/
        public final static String _ID = BaseColumns._ID;
        /*third string for column....habit*/
        public final static String COLUMN_HABIT = "habit";
        /*forth string for duration...*/
        public final static String COLUMN_DURATION = "duration";
        /*first integer for sleeping habbit*/
        public final static int HABIT_SLEEPING = 0;
        /*second integer for working habbit*/
        public final static int HABIT_WORK = 1;
        /*third integer for workout habbit..*/
        public final static int HABIT_WORKOUT = 2;
    }
}

