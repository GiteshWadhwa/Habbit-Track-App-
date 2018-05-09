package com.wadhwa.gitesh.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView displayView = (TextView) findViewById(R.id.View);
        /*---------------------here we set all habbits according to habit db helper..---------------------------------------*/
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        habitDbHelper.insertHabit(Contract.HabitEntry.HABIT_WORK,
                "2 hours");
        habitDbHelper.insertHabit(Contract.HabitEntry.HABIT_SLEEPING,
                "8 hours");
        habitDbHelper.insertHabit(Contract.HabitEntry.HABIT_WORKOUT,
                "1 hour");
        Cursor cursor = habitDbHelper.readHabits();
        /*for displaying the database..*/
        displayView.setText("The habit table contains " + cursor.getCount() + " habits.\n\n");
        /*for append the database....*/
        displayView.append(Contract.HabitEntry._ID + " - " +
                Contract.HabitEntry.COLUMN_HABIT + "-" +
                Contract.HabitEntry.COLUMN_DURATION + "\n");
        //first int is for id & second column is for habit &third int is for duration...
        int idColumnIndex = cursor.getColumnIndex(Contract.HabitEntry._ID);
        int habitColumnIndex = cursor.getColumnIndex(Contract.HabitEntry.COLUMN_HABIT);
        int durationColumnIndex = cursor.getColumnIndex(Contract.HabitEntry.COLUMN_DURATION);
        /*conditions for moving habbits..*/
        while (cursor.moveToNext())
        {
            int currentID = cursor.getInt(idColumnIndex);
            String currentHabit = cursor.getString(habitColumnIndex);
            String currentDuration = cursor.getString(durationColumnIndex);
            displayView.append(("\n" + currentID + " - " +
                    currentHabit + " - " +
                    currentDuration));
        }
        cursor.close();
    }
}