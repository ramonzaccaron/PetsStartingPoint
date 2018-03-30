package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by Ramon on 25/03/2018.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    private static  final int  DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "pets.db";

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
                PetContract.PetEntry._ID + " INTEGER PRIMARY KEY," +
                PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                PetContract.PetEntry.COLUMN_PET_BREED + " TEXT NOT NULL, " +
                PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
                PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL " +
                " );";

        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
