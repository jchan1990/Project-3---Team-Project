package com.example.qube.jjspost.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qube.jjspost.activities.ArticleDetailActivity;
import com.example.qube.jjspost.R;
import com.example.qube.jjspost.models.Result;
import com.example.qube.jjspost.setup.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Qube on 8/15/16.
 */
public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private static final String TAG = "ARVA";
    List<Result> mResultList;
    Context mContext;

    public ArticleRecyclerViewAdapter(List<Result> mResultList) {
        this.mResultList = mResultList;
    }

    public ArticleRecyclerViewAdapter(Context mContext, List<Result> mResultList) {
        this.mContext = mContext;
        this.mResultList = mResultList;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.article_list_card_layout, parent, false);

        mContext = parent.getContext();
        return new ArticleViewHolder(parentView);

    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, int position) {
        final Result article = mResultList.get(position);

        holder.setTitle(article.getTitle());


        String imgURL = "";

        //get image url (
        if (article.getMultimedia().size() > 2){
            imgURL = article.getMultimedia().get(3).getUrl();
        }
        Log.i(TAG, "onBindViewHolder: img url:" + article.getMultimedia());

        //set image
        if(!imgURL.equals("")){
            Picasso.with(holder.itemView.getContext())
                    .load(imgURL)
                    .into(holder.getImgView());
            Log.d("iiiii", "onBindViewHolder: article " + imgURL);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ArticleDetailActivity.class);
                intent.putExtra("URL", article.getUrl());
                intent.putExtra("Title", article.getTitle());
                intent.putExtra("Image",article.getMultimedia().get(0).getUrl());
                view.getContext().startActivity(intent);
                Log.i(TAG, "onBindViewHolder: title: " + article.getTitle());

            }
        });





    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }
}
