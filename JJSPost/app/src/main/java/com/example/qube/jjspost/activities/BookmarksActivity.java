package com.example.qube.jjspost.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.qube.jjspost.R;
import com.example.qube.jjspost.models.BookmarkArticle;
import com.example.qube.jjspost.recycler.BookmarksRecyclerViewAdapter;
import com.example.qube.jjspost.setup.DatabaseHelper;

import java.util.List;

public class BookmarksActivity extends AppCompatActivity {
    private static final String TAG = "BookmarksActivity";
    List<BookmarkArticle> bookmarkArticleList;
    RecyclerView mRecyclerViewBookmarks;
    BookmarksRecyclerViewAdapter mAdapter;
    DatabaseHelper mDatabaseHelper;
    String userID;
    String bookmarkArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        SharedPreferences sharedPreferences = getSharedPreferences("com.example.qube.jjspost.activities", Context.MODE_PRIVATE);
       userID = sharedPreferences.getString("submittedEmail", "DEFAULT EMAIL");
        boolean isLogin = sharedPreferences.getBoolean("isLoggedIn", false);
       Log.i(TAG, "onCreate: Getting userID: " + userID);
      //  mDatabaseHelper.addUser2(userID);
//        Log.i(TAG, "onCreate: " +  String.valueOf(mDatabaseHelper.getBookmarkedArticles(userID)));
       // Log.i(TAG, "onCreate: getting DB id: " + mDatabaseHelper.getUser().toString()+ "" + userID);



        if(isLogin){
            Toast.makeText(BookmarksActivity.this, "You are logged in!", Toast.LENGTH_SHORT).show();
            mRecyclerViewBookmarks = (RecyclerView) findViewById(R.id.bookmarksRecyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            mRecyclerViewBookmarks.setLayoutManager(linearLayoutManager);

            mDatabaseHelper = DatabaseHelper.getInstance(BookmarksActivity.this);
            bookmarkArticleList = mDatabaseHelper.getBookmarkedArticles(userID);
            Log.i(TAG, "onCreate: Size: " + bookmarkArticleList.size());

            mAdapter = new BookmarksRecyclerViewAdapter(bookmarkArticleList);
            mRecyclerViewBookmarks.setAdapter(mAdapter);
           // Log.i(TAG, "onBookMarksActivity: userID = " + userID);
          //  Log.i(TAG, "onCreate: " +  (bookmarkArticleList.get(0).getArticleName()));
           // Log.i(TAG, "onBookMarksActivity: userID = " + bookmarkArticleList);
           // Log.i(TAG, "onCreate: " + (bookmarkArticleList.get(0).getThumbnailLink()));

        }
        else {
            Toast.makeText(BookmarksActivity.this, "You need to login!", Toast.LENGTH_SHORT).show();
            signInDialog();


        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to Search", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void signInDialog() {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(BookmarksActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.sign_in_dialog, null);
        dialogBuilder.setView(dialogView);
        //final Button logIn = (Button) dialogView.findViewById(R.id.dialogLogInButton);
       // alertDialog.setTitle("Not Signed In!");
       // alertDialog.setMessage("You need to sign in");
        dialogBuilder.setPositiveButton("Go to Login", null);

  //     dialogBuilder.setPositiveButton("Sign in", new DialogInterface.OnClickListener(){

  //         @Override
  //         public void onClick(DialogInterface dialogInterface, int i) {
  //             Intent intent = new Intent(BookmarksActivity.this, LoginActivity.class);
  //             startActivity(intent);
  //         }
  //     });
       final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarksActivity.this, LoginActivity.class);
                startActivity(intent);
                alertDialog.dismiss();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
