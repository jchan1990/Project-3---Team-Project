package com.example.qube.jjspost.recycler;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.qube.jjspost.R;

/**
 * Created by stacyzolnikov on 8/18/16.
 */
public class BookmarkViewHolder extends RecyclerView.ViewHolder {
    TextView mTitle;
    ImageView mPhoto;
    ImageView mDeleteArticle;


    public BookmarkViewHolder(View itemView) {
        super(itemView);
       mTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        mPhoto = (ImageView) itemView.findViewById(R.id.imageView);
        mDeleteArticle = (ImageView) itemView.findViewById(R.id.deleteFavoritesArticle);
    }

    public void setTitle(String title){
        mTitle.setText(title);
    }

    public ImageView getmDeleteArticle() {
        return mDeleteArticle;
    }

    public void setmDeleteArticle(ImageView mDeleteArticle) {
        this.mDeleteArticle = mDeleteArticle;
    }

    public ImageView getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(ImageView mPhoto) {
        this.mPhoto = mPhoto;
    }

    public ImageView getImageView(){
        return this.mPhoto;
    }



}
