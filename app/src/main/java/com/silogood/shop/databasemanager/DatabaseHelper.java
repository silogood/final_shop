package com.silogood.shop.databasemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    private static final String CLOTHES ="clothes";
    private static final String SHOES ="shoes";
    private static final String ACC ="acc";


    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(ClothesNote.CREATE_TABLE_CLOTHES);
        db.execSQL(ShoesNote.CREATE_TABLE_SHOES);
        db.execSQL(AccNote.CREATE_TABLE_ACC);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + ClothesNote.TABLE_NAME_CLOTHES);
        db.execSQL("DROP TABLE IF EXISTS " + ShoesNote.TABLE_NAME_SHOES);
        db.execSQL("DROP TABLE IF EXISTS " + AccNote.TABLE_NAME_ACC);

        // Create tables again

        onCreate(db);
    }

    public long setInsertNote(String type, String name , String code, int bqt)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        long id = 0;

        if( type == CLOTHES ){
            values.put(ClothesNote.COLUMN_NAME, name);
            values.put(ClothesNote.COLUMN_CODE, code);
            values.put(ClothesNote.COLUMN_BQT, bqt);
             id = db.insert(ClothesNote.TABLE_NAME_CLOTHES, null, values);
        }else if ( type == SHOES ){
            values.put(ShoesNote.COLUMN_NAME,name);
            values.put(ShoesNote.COLUMN_CODE,code);
            values.put(ShoesNote.COLUMN_BQT, bqt);
             id = db.insert(ShoesNote.TABLE_NAME_SHOES, null, values);
        }else if ( type == ACC ){
            values.put(AccNote.COLUMN_NAME,name);
            values.put(AccNote.COLUMN_CODE,code);
            values.put(AccNote.COLUMN_BQT,bqt);
             id = db.insert(AccNote.TABLE_NAME_ACC, null, values);
        }

        db.close();
        return id;
    }

    public ClothesNote getClothesNote(String code) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ClothesNote.TABLE_NAME_CLOTHES,
                new String[]{ClothesNote.COLUMN_NAME, ClothesNote.COLUMN_CODE, ClothesNote.COLUMN_BQT, ClothesNote.COLUMN_TIMESTAMP},
                ClothesNote.COLUMN_CODE + "=?",
                new String[]{code}, null, null, null, null);


        if(cursor.getCount() ==  0) {
            Log.d(TAG, "#### SILOGOOD cursor.getCount = 0 ");
            ClothesNote note_null = new ClothesNote(
                     " ", " ",-1, "");
            return note_null;
        }
        if (cursor != null) {
            cursor.moveToFirst();
        }else{
            cursor.close();
        }

        // prepare note object

        ClothesNote note = new ClothesNote(
                cursor.getString(cursor.getColumnIndex(ClothesNote.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(ClothesNote.COLUMN_CODE)),
                cursor.getInt(cursor.getColumnIndex(ClothesNote.COLUMN_BQT)),
                cursor.getString(cursor.getColumnIndex(ClothesNote.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public ShoesNote getShoesNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ShoesNote.TABLE_NAME_SHOES,
                new String[]{ShoesNote.COLUMN_ID, ShoesNote.COLUMN_NAME, ShoesNote.COLUMN_CODE, ShoesNote.COLUMN_BQT, ShoesNote.COLUMN_TIMESTAMP},
                ShoesNote.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        ShoesNote note = new ShoesNote(
                cursor.getInt(cursor.getColumnIndex(ShoesNote.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(ShoesNote.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(ShoesNote.COLUMN_CODE)),
                cursor.getInt(cursor.getColumnIndex(ShoesNote.COLUMN_BQT)),
                cursor.getString(cursor.getColumnIndex(ShoesNote.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public AccNote getAccNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(AccNote.TABLE_NAME_ACC,
                new String[]{AccNote.COLUMN_ID, AccNote.COLUMN_NAME, AccNote.COLUMN_CODE, AccNote.COLUMN_BQT, AccNote.COLUMN_TIMESTAMP},
                AccNote.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        AccNote note = new AccNote(
                cursor.getInt(cursor.getColumnIndex(AccNote.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(AccNote.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(AccNote.COLUMN_CODE)),
                cursor.getInt(cursor.getColumnIndex(AccNote.COLUMN_BQT)),
                cursor.getString(cursor.getColumnIndex(AccNote.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }


    public List<ClothesNote> getAllClothesNotes() {
        List<ClothesNote> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + ClothesNote.TABLE_NAME_CLOTHES + " ORDER BY " +
                ClothesNote.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ClothesNote note = new ClothesNote();
                note.setName(cursor.getString(cursor.getColumnIndex(ClothesNote.COLUMN_NAME)));
                note.setCode(cursor.getString(cursor.getColumnIndex(ClothesNote.COLUMN_CODE)));
                note.setBqt(cursor.getInt(cursor.getColumnIndex(ClothesNote.COLUMN_BQT)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(ClothesNote.COLUMN_TIMESTAMP)));
                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public List<ShoesNote> getAllShoesNote() {
        List<ShoesNote> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + ShoesNote.TABLE_NAME_SHOES + " ORDER BY " +
                ShoesNote.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ShoesNote note = new ShoesNote();
                note.setId(cursor.getInt(cursor.getColumnIndex(ShoesNote.COLUMN_ID)));
                note.setName(cursor.getString(cursor.getColumnIndex(ShoesNote.COLUMN_NAME)));
                note.setCode(cursor.getString(cursor.getColumnIndex(ShoesNote.COLUMN_CODE)));
                note.setBqt(cursor.getInt(cursor.getColumnIndex(ShoesNote.COLUMN_BQT)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(ShoesNote.COLUMN_TIMESTAMP)));
                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public List<AccNote> getAllAccNote() {
        List<AccNote> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + AccNote.TABLE_NAME_ACC + " ORDER BY " +
                AccNote.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AccNote note = new AccNote();
                note.setId(cursor.getInt(cursor.getColumnIndex(AccNote.COLUMN_ID)));
                note.setName(cursor.getString(cursor.getColumnIndex(AccNote.COLUMN_NAME)));
                note.setCode(cursor.getString(cursor.getColumnIndex(AccNote.COLUMN_CODE)));
                note.setBqt(cursor.getInt(cursor.getColumnIndex(AccNote.COLUMN_BQT)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(AccNote.COLUMN_TIMESTAMP)));
                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }


    public int getClothesNotesCount() {
        String countQuery = "SELECT  * FROM " + ClothesNote.TABLE_NAME_CLOTHES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int getShoesNotesCount() {
        String countQuery = "SELECT  * FROM " + ShoesNote.TABLE_NAME_SHOES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int getAccNotesCount() {
        String countQuery = "SELECT  * FROM " + AccNote.TABLE_NAME_ACC;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }


    public int updateClothesNoteBycode(ClothesNote note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ClothesNote.COLUMN_NAME, note.getName());
        values.put(ClothesNote.COLUMN_BQT,note.getBqt());
        values.put(ClothesNote.COLUMN_TIMESTAMP,note.getTimestamp());

        // updating row
        return db.update(ClothesNote.TABLE_NAME_CLOTHES, values, ClothesNote.COLUMN_CODE + " = ?",
                new String[]{note.getCode()});
    }

    public int updateShoesNote(ShoesNote note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ShoesNote.COLUMN_NAME, note.getName());

        // updating row
        return db.update(ShoesNote.TABLE_NAME_SHOES, values, ShoesNote.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public int updateAccNote(AccNote note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AccNote.COLUMN_NAME, note.getName());

        // updating row
        return db.update(AccNote.TABLE_NAME_ACC, values, AccNote.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }


    public void deleteClothesNote(ClothesNote note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ClothesNote.TABLE_NAME_CLOTHES, ClothesNote.COLUMN_CODE + " = ?",
                new String[]{note.getCode()});
        db.close();
    }

    public void deleteClothesNotebyname(String code) {
        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(ClothesNote.TABLE_NAME_CLOTHES, ClothesNote.COLUMN_CODE + " = ?",
                new String[]{code});
        Log.d(TAG,"###SILOGOOD result : "+result);
        db.close();
    }

    public void deleteShoesNote(ShoesNote note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ShoesNote.TABLE_NAME_SHOES, ShoesNote.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
    public void deleteAccNote(AccNote note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AccNote.TABLE_NAME_ACC, AccNote.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

}