package com.example.qube.jjspost.recycler;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qube.jjspost.R;
import com.example.qube.jjspost.models.Articles;
import com.example.qube.jjspost.models.BookmarkArticle;
import com.example.qube.jjspost.setup.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by stacyzolnikov on 8/18/16.
 */
public class BookmarksRecyclerViewAdapter extends RecyclerView.Adapter<BookmarkViewHolder> {
    private static final String TAG = "BRVA";
    List<BookmarkArticle> mBookmarkList;
    List<Articles> mArticleList;
    BookmarkArticle article;
    Context mContext;
    OnItemClickListener mListener;
    DatabaseHelper mDatabaseHelper;
    public interface OnItemClickListener{

    }
    public void setItemClickListener (OnItemClickListener item){
        this.mListener = item;
    }

    public BookmarksRecyclerViewAdapter(List<BookmarkArticle> mBookmarkList) {
        this.mBookmarkList = mBookmarkList;
    }

    @Override
    public BookmarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.bookmarks_list_card_layout,parent,false);
        BookmarkViewHolder viewHolder = new BookmarkViewHolder(parentView);
        mContext=parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookmarkViewHolder holder, final int position) {
        final BookmarkArticle article = mBookmarkList.get(position);

        holder.mTitle.setText(mBookmarkList.get(position).getArticleName());
        Log.i(TAG, "BRVA: " + mBookmarkList.get(position).getUrlLink() + mBookmarkList.get(position).getThumbnailLink());

        String imgURL = mBookmarkList.get(position).getThumbnailLink();

        if(imgURL.equals(mBookmarkList.get(position).getThumbnailLink())){
            Picasso.with(holder.mPhoto.getContext()).load(imgURL).into(holder.getImageView());
        }
//

        holder.mDeleteArticle.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               // mDatabaseHelper = new DatabaseHelper(mContext);
                Log.i(TAG, "onClick: " + position);
                DatabaseHelper.getInstance(mContext).deleteBookmarkedArticle(mBookmarkList.get(position).getArticleID());
                mBookmarkList.remove(position);

                DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
                databaseHelper.deleteBookmarkedArticle(position);
                notifyDataSetChanged();
                updateList();

            }

        });

    }
    public void updateList(){

    }

    @Override
    public int getItemCount() {
        if (mBookmarkList == null){
            return 0;
        }
        else {
            return mBookmarkList.size();
        }
    }
}
