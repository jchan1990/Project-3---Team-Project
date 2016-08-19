package com.example.qube.jjspost.models;

/**
 * Created by stacyzolnikov on 8/18/16.
 */
public class BookmarkArticle {
    private String email;
    private String articleName;
    private String thumbnailLink;
    private String urlLink;
    private long articleID;

  //  public BookmarkArticle() {
//
  //  }


    public long getArticleID() {
        return articleID;
    }

    public void setArticleID(long articleID) {
        this.articleID = articleID;
    }

    public BookmarkArticle(String email, String articleName, String thumbnailLink, String urlLink) {
        this.email = email;
        this.articleName = articleName;
        this.thumbnailLink = thumbnailLink;
        this.urlLink = urlLink;
    }



    // public String getEmail() {
    //     return email;
    // }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }


    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }



}
