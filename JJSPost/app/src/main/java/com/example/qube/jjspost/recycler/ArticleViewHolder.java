package com.example.qube.jjspost.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qube.jjspost.R;

/**
 * Created by Qube on 8/15/16.
 */
public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTitle;
    private ImageView imgView;


    public ArticleViewHolder(View itemView) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        imgView = (ImageView) itemView.findViewById(R.id.imageView);

    }

    public void setTitle(String title){
        txtTitle.setText(title);
    }

    public ImageView getImgView(){
        return this.imgView;
    }


}
