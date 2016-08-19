package com.example.qube.jjspost.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.qube.jjspost.R;
import com.example.qube.jjspost.models.BookmarkArticle;
import com.example.qube.jjspost.recycler.BookmarksRecyclerViewAdapter;
import com.example.qube.jjspost.setup.DatabaseHelper;

import java.util.List;

public class ArticleDetailActivity extends AppCompatActivity {
    private static final String TAG = "ArticleDetailActivity";
    private ShareActionProvider mShareActionProvider;
    private String url, title, image;
    DatabaseHelper mDatabaseHelper;
    List<BookmarkArticle> articleLost;
    BookmarkArticle article;
    private String usersEmail = "users-email";
    private String userID;
    BookmarksRecyclerViewAdapter mAdapterDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        url = getIntent().getStringExtra("URL");
        title = getIntent().getStringExtra("Title");
        image =  getIntent().getStringExtra("Image");
        Log.d(TAG, "onCreate: " + url);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        mDatabaseHelper = DatabaseHelper.getInstance(getApplicationContext());
       SharedPreferences sharedPreferences = getSharedPreferences("com.example.qube.jjspost.activities", Context.MODE_PRIVATE);
        userID = sharedPreferences.getString("submittedEmail", "DEFAULT EMAIL");
        boolean isLogin = sharedPreferences.getBoolean("isLoggedIn", false);
        mDatabaseHelper.addUser(userID);
      // mDatabaseHelper.getUser();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.article_detail_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Intent intent = new Intent();

        switch(itemId){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_share:
                Toast.makeText(this, "Sharing", Toast.LENGTH_SHORT).show();
                intent.setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, url)
                        .putExtra(Intent.EXTRA_SUBJECT, "New York Times News Article")
                        .setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share via"));

                break;
            case R.id.action_bookmark:
                Log.d(TAG, "onOptionsItemSelected: In action " + url + image);
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                long id = db.addBookmarkedArticles(userID, title ,url, image);
               // db.getUser();
                Log.i(TAG, "onOptionsItemSelected: title: " + getIntent().getStringExtra("Title") + getIntent().getStringExtra("Image") + getIntent().getStringExtra("URL"));

                Toast.makeText(ArticleDetailActivity.this, "Added to Bookmarks", Toast.LENGTH_SHORT).show();

               // Log.d(TAG, "onOptionsItemSelected: BookmarksTest: " + usersEmail);

                Log.d(TAG, "onOptionsItemSelected: getting id " + userID);
                //mAdapterDetail = new BookmarksRecyclerViewAdapter(mDatabaseHelper.getBookmarkedArticles(userID));
              //  Log.d(TAG, "onOptionsItemSelected: getting email: " + mDatabaseHelper.getBookmarkedArticles(userID));

        }

        return super.onOptionsItemSelected(item);
    }
}
