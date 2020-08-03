package com.silogood.shop.databasemanager;

import android.os.Parcelable;

import java.io.Serializable;

public class AccNote {

    public static final String TABLE_NAME_ACC = "acc";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_BQT = "bqt";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private String name;
    private String code;
    private int bqt;
    private String timestamp;
    private  String TAG = "ACC NOTE";

    // Create table SQL query
    public static final String CREATE_TABLE_ACC =
            "CREATE TABLE " + TABLE_NAME_ACC + "("
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_CODE + " TEXT UNIQUE,"
                    + COLUMN_BQT + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public AccNote() {
    }

    public AccNote(String name, String code , int bqt , String timestamp) {
        this.name = name;
        this.code = code;
        this.bqt = bqt;
        this.timestamp = timestamp;
    }

    public String getName() { return name; }
    public String getCode(){ return code; }
    public int getBqt(){ return bqt; }
    public String getTimestamp() { return timestamp; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setBqt(int bqt) {
        this.bqt = bqt;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
