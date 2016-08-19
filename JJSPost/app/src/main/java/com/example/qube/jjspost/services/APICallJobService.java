package com.example.qube.jjspost.services;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.qube.jjspost.R;
import com.example.qube.jjspost.activities.ArticleDetailActivity;
import com.example.qube.jjspost.api.APIConstants;
import com.example.qube.jjspost.api.NYTAPIService;
import com.example.qube.jjspost.models.Articles;
import com.example.qube.jjspost.models.breaking_news.BreakingNews;
import com.example.qube.jjspost.recycler.ArticleRecyclerViewAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by roosevelt on 8/18/16.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class APICallJobService extends JobService {
//    private AsyncTask<String, Void, String> mAPICallAsyncTask;
private static final String TAG = "iiiiii";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle bundle = jobParameters.getExtras();
        final String topicString = bundle.getString("topics");

        ConnectivityManager connMgr = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
//
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(APIConstants.NEWSWIRE_BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            //get an instance of GitHubService
//            NYTAPIService service = retrofit.create(NYTAPIService.class);
//
//            //Get a Call of type User with the service and getUser method
//            Call<BreakingNews> breakingNewsCall = service.getBreakingNews(topicString);
//
//            //use .enqueue to get the response.
//            breakingNewsCall.enqueue(new Callback<BreakingNews>() {
//                @Override
//                public void onResponse(Call<BreakingNews> call, Response<BreakingNews> response) {
//                    //TODO Get Notification details
//                    Log.d(TAG, "onResponse: got here");
//                    String imgURL = response.body().getResults()
//                            .get(0).getMultimedia().get(3).getUrl();
//                    String newsText = response.body().getResults()
//                            .get(0).getAbstract();
//
//                    //TODO Notification!
//                    NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(getApplicationContext());
//                     notifBuilder.setSmallIcon(R.drawable.ic_star);
//                     notifBuilder.setContentTitle("Breaking News");
//                     notifBuilder.setContentText(newsText);
//                     notifBuilder.setAutoCancel(true);
//
//                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                    notificationManager.notify(1, notifBuilder.build());
//                }
//
//                @Override
//                public void onFailure(Call<BreakingNews> call, Throwable t) {
//
//                    Log.d("iiiiiiiiii", "should notify now failed");
//                }
//            });



            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIConstants.TOP_STORIES_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //get an instance of GitHubService
            NYTAPIService service = retrofit.create(NYTAPIService.class);
//            NYTAPIService service = ServiceGenerator.createService(NYTAPIService.class);

            //Get a Call of type User with the service and getUser method
            Call<Articles> storiesCall = service.getTopStories("home");

            //use .enqueue to get the response.
            storiesCall.enqueue(new Callback<Articles>() {
                @Override
                public void onResponse(Call<Articles> call, Response<Articles> response) {
                    if (!response.isSuccessful()) {
                        String str = response.toString();
                        Log.d("iiiiiii", str);
                    }
                    try {
                        String newsTitle = response.body().getResults().get(0).getTitle();
                        String newsText = response.body().getResults().get(0).getAbstract();
                        String linkUrl = response.body().getResults().get(0).getUrl();

                        Intent intent = new Intent(getApplicationContext(), ArticleDetailActivity.class);
                        intent.putExtra("URL", linkUrl);

                        PendingIntent pendingIntent = PendingIntent
                                .getActivity(getApplicationContext(), 123, intent, 0);


                    //TODO Notification!
                    NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(getApplicationContext());notifBuilder.setSmallIcon(R.drawable.ic_star);
                        notifBuilder.setContentTitle(newsTitle);
                        notifBuilder.setContentText(newsText);
                        notifBuilder.setContentIntent(pendingIntent);
                        notifBuilder.setAutoCancel(true);


                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(1, notifBuilder.build());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(Call<Articles> call, Throwable t) {

                }
            });
        }


        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
