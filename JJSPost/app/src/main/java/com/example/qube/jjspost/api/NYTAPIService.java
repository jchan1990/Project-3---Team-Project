package com.example.qube.jjspost.api;

import com.example.qube.jjspost.api.APIConstants;
import com.example.qube.jjspost.models.Articles;
import com.example.qube.jjspost.models.breaking_news.BreakingNews;
import com.example.qube.jjspost.models.search_result.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by roosevelt on 8/15/16.
 */
public interface NYTAPIService {


    //use @GET to get the path to the users: /users/{username}
    //then create a Call of type User to get the path, taking an input of the username
    @GET("{section}.json?api-key=" + APIConstants.TOP_STORIES_API_KEY)
    Call<Articles> getTopStories(@Path("section") String section);

//    @GET("articlesearch.json?q={query}&api-key=" + APIConstants.API_KEY)
//    Call<SearchResult> searchArticles(@Path("query") String query);

    @GET("articlesearch.json?fq=type_of_material:(!\"Letter\")&api-key=" + APIConstants.API_KEY)
    Call<SearchResult> searchArticles(@Query("q") String query);


//    @GET("articlesearch.json?api-key=" + APIConstants.API_KEY)
//    Call<SearchResult> searchArticles(@Query("q") String query);

//    @GET("nyt/{topics}/2.json?api-key=" + APIConstants.TOP_STORIES_API_KEY)
//    Call<BreakingNews> getBreakingNews(@Path("topics") String topics);
        @GET("nyt/{topics}/2.json")
        Call<BreakingNews> getBreakingNews(@Path("topics") String topics);



}
