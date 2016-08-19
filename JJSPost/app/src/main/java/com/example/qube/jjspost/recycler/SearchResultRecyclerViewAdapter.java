package com.example.qube.jjspost.recycler;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qube.jjspost.activities.ArticleDetailActivity;
import com.example.qube.jjspost.R;
import com.example.qube.jjspost.models.search_result.SearchResult;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Qube on 8/15/16.
 */
public class SearchResultRecyclerViewAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    List<SearchResult.Doc> mSearchResults;

    public SearchResultRecyclerViewAdapter(List<SearchResult.Doc> mSearchResults) {
        this.mSearchResults = mSearchResults;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.article_list_card_layout, parent, false);

        return new ArticleViewHolder(parentView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        final SearchResult.Doc article = mSearchResults.get(position);

        holder.setTitle(article.getHeadline().getMain());

        String imgURL = "";

        //get image url (
        if (article.getMultimedia().size() > 0) {
            imgURL = "https://static01.nyt.com/" + article.getMultimedia().get(0).getUrl();
        }

        //set image
        if (!imgURL.equals("")) {
            Picasso.with(holder.itemView.getContext())
                    .load(imgURL)
                    .into(holder.getImgView());
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ArticleDetailActivity.class);
                intent.putExtra("URL", article.getWebUrl());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSearchResults.size();
    }
}