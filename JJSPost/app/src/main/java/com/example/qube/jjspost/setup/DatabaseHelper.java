package com.example.qube.jjspost.setup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.qube.jjspost.models.BookmarkArticle;

import java.util.ArrayList;

/**
 * Created by stacyzolnikov on 8/18/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=2;
    public static final String DATABASE_NAME = "NewsApp";

    //Below is for the news table
    public static final String NEWS_TABLE = "news";
    public static final String NEWS_COL_ID = "_id";
    public static final String NEWS_COL_HEADLINE = "headline";
    public static final String NEWS_COL_LINK_URL = "link_url";
    public static final String NEWS_COL_THUMBNAIL_URL = "thumbnail_url";
    public static final String NEWS_COL_DATE_STAMP = "date_stamp";
    public static final String NEWS_COL_AUTHOR = "article_author";
    public static final String NEWS_COL_CATEGORY = "artile_category";
    public static final String NEWS_COL_LOCATION = "article_location";
    public static final String[] NEWS_COLUMNS = new String[]{NEWS_COL_ID, NEWS_COL_HEADLINE, NEWS_COL_LINK_URL, NEWS_COL_THUMBNAIL_URL, NEWS_COL_DATE_STAMP, NEWS_COL_AUTHOR, NEWS_COL_CATEGORY, NEWS_COL_LOCATION };

    //Below is for the Bookmarks Table
    public static final String BOOKMARKS_TABLE = "bookmarks";
    public static final String BOOKMARKS_COL_ID = "_id";
    public static final String BOOKMARKS_USERS_COL_ID = "userID";

    //Below is for the Facebook Sharing table
    public static final String FACEBOOK_TABLE = "facebook";
    public static final String FACEBOOK_COL_ID = "_id";
    public static final String FACEBOOK_COL_USER = "facebook_user";
    public static final String FACEBOOK_COL_STATUS_UPDATE = "facebook_status_update";
    public static final String[] FACEBOOK_COLUMNS = new String[]{FACEBOOK_COL_ID, FACEBOOK_COL_USER, FACEBOOK_COL_USER, FACEBOOK_COL_STATUS_UPDATE};

    //Below is for the Twitter Sharing table
    public static final String TWITTER_TABLE = "twitter";
    public static final String TWITTER_COL_ID = "_id";
    public static final String TWITTER_COL_USER = "twitter_user";
    public static final String TWITTER_COL_STATUS_UPDATE = "twitter_status_update";
    public static final String[] TWITTER_COLUMNS = new String[]{TWITTER_COL_ID, TWITTER_COL_USER, TWITTER_COL_USER, TWITTER_COL_STATUS_UPDATE};

    //Below is for the Reminders table
    public static final String REMINDERS_TABLE = "reminders";
    public static final String REMINDERS_COL_ID = "_id";
    public static final String REMINDERS_COL_DATE = "reminder_date_time";
    public static final String REMINDERS_COL_NOTE = "reminder_note_text";
    public static final String[] REMINDERS_COLUMNS = new String[]{REMINDERS_COL_ID, REMINDERS_COL_DATE, REMINDERS_COL_NOTE};

    //Below is for the Users table
    public static final String USERS_TABLE = "users";
    public static final String USERS_COL_ID = "_id";
    public static final String USERS_COL_EMAIL = "users_email";
    public static final String USERS_COL_FIRST_NAME = "first_name";
    public static final String USERS_COL_LAST_NAME = "last_name";
    public static final String USERS_COLUMNS[] = new String[]{USERS_COL_ID, USERS_COL_EMAIL, USERS_COL_FIRST_NAME, USERS_COL_LAST_NAME};

    //To create the tables
    public static final String NEWS_CREATE = "CREATE TABLE " + NEWS_TABLE + " ("
            + NEWS_COL_ID + " INTEGER PRIMARY KEY, "
            + NEWS_COL_HEADLINE + " TEXT, "
            + NEWS_COL_LINK_URL + " TEXT, "
            + NEWS_COL_THUMBNAIL_URL + " TEXT, "
            + NEWS_COL_DATE_STAMP + " TEXT, "
            + NEWS_COL_AUTHOR + " TEXT, "
            + NEWS_COL_CATEGORY + " TEXT, "
            + NEWS_COL_LOCATION + " TEXT "
            + ")";

    public static final String FACEBOOK_CREATE = "CREATE TABLE " + FACEBOOK_TABLE + " ("
            + FACEBOOK_COL_ID + " INTEGER PRIMARY KEY, "
            + FACEBOOK_COL_USER + " TEXT, "
            + FACEBOOK_COL_STATUS_UPDATE + " TEXT "
            + ")";

    public static final String TWITTER_CREATE = "CREATE TABLE " + TWITTER_TABLE + " ("
            + TWITTER_COL_ID + " INTEGER PRIMARY KEY, "
            + TWITTER_COL_USER + " TEXT, "
            + TWITTER_COL_STATUS_UPDATE + " TEXT "
            + ")";

    public static final String REMINDERS_CREATE= "CREATE TABLE " + REMINDERS_TABLE + " ("
            + REMINDERS_COL_ID + " INTEGER PRIMARY KEY, "
            + REMINDERS_COL_DATE + " TEXT, "
            + REMINDERS_COL_NOTE + " TEXT "
            + ")";

    public static final String USERS_CREATE = "CREATE TABLE " + USERS_TABLE + " ("
            + USERS_COL_ID + " INTEGER PRIMARY KEY, "
            + USERS_COL_EMAIL + " TEXT, "
            + USERS_COL_FIRST_NAME + " TEXT,"
            + USERS_COL_LAST_NAME + " TEXT "
            + ")";

  //  public static final String BOOKMARKS_CREATE = "CREATE TABLE " + BOOKMARKS_TABLE + " ("
  //          + BOOKMARKS_COL_ID + " INTEGER PRIMARY KEY, "
  //          + NEWS_COL_HEADLINE + " TEXT, "
  //          + NEWS_COL_LINK_URL + " TEXT, "
  //          + NEWS_COL_THUMBNAIL_URL + " TEXT, "
  //          + NEWS_COL_DATE_STAMP + " TEXT, "
  //          + NEWS_COL_AUTHOR + " TEXT, "
  //          + NEWS_COL_CATEGORY + " TEXT, "
  //          + NEWS_COL_LOCATION + " TEXT, "
  //          + BOOKMARKS_USERS_COL_ID + " TEXT "
  //          + ")";

    public static final String BOOKMARKS_CREATE = "CREATE TABLE " + BOOKMARKS_TABLE + " ("
            + BOOKMARKS_COL_ID + " INTEGER PRIMARY KEY, "
            + NEWS_COL_HEADLINE + " TEXT, "
            + NEWS_COL_LINK_URL + " TEXT, "
            + NEWS_COL_THUMBNAIL_URL + " TEXT, "
            + NEWS_COL_DATE_STAMP + " TEXT, "
            + NEWS_COL_AUTHOR + " TEXT, "
            + NEWS_COL_CATEGORY + " TEXT, "
            + NEWS_COL_LOCATION + " TEXT,  "
            + BOOKMARKS_USERS_COL_ID + " TEXT,  " +
            "FOREIGN KEY("+ BOOKMARKS_USERS_COL_ID +") REFERENCES " + USERS_TABLE
            +"("+ USERS_COL_ID + ") )";

    private static DatabaseHelper mInstance;
    public static synchronized DatabaseHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return mInstance;
    }



    public DatabaseHelper(Context context) {
        super(context,"db",null,1);
    }



    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NEWS_CREATE);
        db.execSQL(FACEBOOK_CREATE);
        db.execSQL(TWITTER_CREATE);
        db.execSQL(REMINDERS_CREATE);
        db.execSQL(USERS_CREATE);
        db.execSQL(BOOKMARKS_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NEWS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FACEBOOK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TWITTER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + REMINDERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BOOKMARKS_TABLE);
        onCreate(db);

    }

    public long addNews(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long rowId = db.insert(NEWS_TABLE, null, values);
        return rowId;
    }
    public long addBookmarkedArticles(String userID, String articleName, String articleLink, String thumbnailLink){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOKMARKS_USERS_COL_ID, userID);
        values.put(NEWS_COL_HEADLINE, articleName);
        values.put(NEWS_COL_LINK_URL, articleLink);
        values.put(NEWS_COL_THUMBNAIL_URL, thumbnailLink);
        long id = db.insert(BOOKMARKS_TABLE, null, values);
        db.close();
        return id;
    }
   public void addUser(String email){
       SQLiteDatabase db = getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(USERS_COL_EMAIL, email);
       db.insert(USERS_TABLE, null, values);
       db.close();
   }

  // public void addUser2(String email){
  //     SQLiteDatabase db = getWritableDatabase();
  //     ContentValues values = new ContentValues();
  //     values.put(BOOKMARKS_USERS_COL_ID, email);
  //     db.insertOrThrow(BOOKMARKS_TABLE, null, values);
  //     db.close();
  // }

  public String getUser(){
      SQLiteDatabase db =  getReadableDatabase();
      Cursor cursor = null;
      String query = "SELECT " + BOOKMARKS_USERS_COL_ID + " FROM " + BOOKMARKS_TABLE;
      cursor = db.rawQuery(query,null);
       String email = null;
      if (cursor.moveToFirst()){
          while (!cursor.isAfterLast()) {
              Log.d("Blah",cursor.getString(cursor.getColumnIndex(BOOKMARKS_USERS_COL_ID)));
              email = cursor.getString(cursor.getColumnIndex(BOOKMARKS_USERS_COL_ID));
               cursor.moveToNext();

          }
          cursor.close();

      }
      return email;

  }

    public void deleteBookmarkedArticle(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] input = new String[]{String.valueOf(id)};
        db.delete(BOOKMARKS_TABLE, BOOKMARKS_COL_ID + "=?", input);
        db.close();
    }

    public void deleteAllBookmarkedArticles(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BOOKMARKS_TABLE, null, null);
        db.close();
    }
//
    public ArrayList<BookmarkArticle> getBookmarkedArticles(String userID){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        ArrayList<BookmarkArticle> articles = new ArrayList<>();
//
        String query = "SELECT * FROM " + BOOKMARKS_TABLE +
                " WHERE " + BOOKMARKS_USERS_COL_ID + " = " + "\'" + userID+"\'";
                //+ userID;
               // + " = " + "ppp";
        cursor = db.rawQuery(query, null ,null);
        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                BookmarkArticle article = new BookmarkArticle(userID,"Title","Image","URL");
                article.setEmail(cursor.getString(cursor.getColumnIndex(BOOKMARKS_USERS_COL_ID)));
                article.setArticleID(cursor.getLong(cursor.getColumnIndex(BOOKMARKS_COL_ID)));
                article.setUrlLink(cursor.getString(cursor.getColumnIndex(NEWS_COL_LINK_URL)));
                article.setArticleName(cursor.getString(cursor.getColumnIndex(NEWS_COL_HEADLINE)));
                article.setThumbnailLink(cursor.getString(cursor.getColumnIndex(NEWS_COL_THUMBNAIL_URL)));
//
                articles.add(article);
                cursor.moveToNext();
            }
        }
        cursor.close();
//
//
        return articles;

    }
    //public String getBookmarkedArticles(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
     //  ArrayList<BookmarkArticle> articles = new ArrayList<>();

     //  String query = "SELECT * FROM " + BOOKMARKS_TABLE +
     //          " WHERE " + BOOKMARKS_USERS_COL_ID;
     //  //+ " = " + userID;
     //  cursor = db.rawQuery(query,null, null);
     //  if (cursor.moveToFirst()){
     //      while(!cursor.isAfterLast()){
     //          BookmarkArticle article = new BookmarkArticle();
     //          article.setEmail(cursor.getString(cursor.getColumnIndex(BOOKMARKS_USERS_COL_ID)));
     //          article.setUrlLink(cursor.getString(cursor.getColumnIndex(NEWS_COL_LINK_URL)));
     //          article.setUrlLink(cursor.getString(cursor.getColumnIndex(NEWS_COL_HEADLINE)));
     //          article.setUrlLink(cursor.getString(cursor.getColumnIndex(NEWS_COL_THUMBNAIL_URL)));

     //          articles.add(article);
     //          cursor.moveToNext();
     //      }
     //  }
     //  cursor.close();


      //  return "Database is working";

    }




