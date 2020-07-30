package com.silogood.shop.databasemanager;

public class AllNote {

    public static final String TABLE_NAME_ACC = "all";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_BQT = "bqt";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private String path;
    private String name;
    private String code;
    private int bqt;
    private String timestamp;

    public AllNote() {
    }

    public AllNote(String path , String name, String code , int bqt , String timestamp) {
        this.path = path;
        this.name = name;
        this.code = code;
        this.bqt = bqt;
        this.timestamp = timestamp;
    }

    public String getPath(){return  path;}
    public String getName() { return name; }
    public String getCode(){ return code; }
    public int getBqt(){ return bqt; }
    public String getTimestamp() { return timestamp; }

    public  void setPath(String path){this.path = path;}
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setBqt(int bqt) {
        this.bqt = bqt;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
