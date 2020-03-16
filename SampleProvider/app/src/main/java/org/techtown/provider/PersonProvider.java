package org.techtown.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {
    public static final String AUTHORITY="org.techtown.provider";
    public static final String BASE_PATH="person";
    public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH);

    private static final int PERSONS=1;
    public static final int PERSON_ID=2;

    private static final UriMatcher uriMather=new UriMatcher(UriMatcher.NO_MATCH);

    static{
        uriMather.addURI(AUTHORITY,BASE_PATH,PERSONS);
        uriMather.addURI(AUTHORITY,BASE_PATH+"/#",PERSON_ID);
    }

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {

        DatabaseHelper databaseHelper=new DatabaseHelper(getContext());
        database=databaseHelper.getWritableDatabase();

        return true;
    }

    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1){
        Cursor cursor;
        switch(uriMather.match(uri)){
            case PERSONS:
                cursor=database.query(DatabaseHelper.TABLE_NAME,DatabaseHelper.ALL_COLUMNS,
                                        s,null,null,null,DatabaseHelper.PERSON_NAME+"ASC");

                break;
                default:
                    throw new IllegalArgumentException("알 수 없는 URI"+uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }

    public String getType(Uri uri) {
        switch(uriMather.match(uri)){
            case PERSONS:
                return "vnd.android.cursor.dir/persons";

                default:
                    throw new IllegalArgumentException("알 수 없는 URL"+uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues){
        long id=database.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

        if(id>0){
            Uri _uri= ContentUris.withAppendedId(CONTENT_URI,id);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        throw new SQLException("추가 실패->URL:"+uri);
    }

    public int delete(Uri uri, String s, String[] strings){
        int cnt=0;
        switch (uriMather.match(uri)){
            case PERSONS:
                cnt=database.delete(DatabaseHelper.TABLE_NAME,s,strings);
                break;

                default:
                    throw new IllegalArgumentException("알 수 없는 URI:"+uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return cnt;
    }

    public int update(Uri uri,ContentValues contentValues,String s,String[] strings){
        int cnt=0;
        switch (uriMather.match(uri)){
            case PERSONS:
                cnt=database.update(DatabaseHelper.TABLE_NAME,contentValues,s,strings);
                break;

            default:
                throw new IllegalArgumentException("알 수 없는 URI:"+uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return cnt;
    }
}
