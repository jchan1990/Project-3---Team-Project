package com.example.qube.jjspost.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qube.jjspost.R;
import com.example.qube.jjspost.api.UserData;
import com.example.qube.jjspost.models.Topic;

import java.util.LinkedList;
import java.util.List;

public class SubscriptionActivity extends AppCompatActivity {
    ListView mListView;
    BaseAdapter mAdapter;
    List<Topic> mTopicsList;
    private static final String TAG = "iiiiiiii";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTopicsList = UserData.getInstance().getTopicsList();

        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new BaseAdapter(){
            @Override
            public int getCount() {
                return mTopicsList.size();
            }

            @Override
            public Object getItem(int i) {
                return mTopicsList.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                View view = convertView;
                if (view == null){
                    LayoutInflater inflater = (LayoutInflater) SubscriptionActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.topic_layout, null);
                }

                TextView txtTopicName = (TextView) view.findViewById(R.id.txtName);
                CheckBox cboChecked = (CheckBox) view.findViewById(R.id.checkBox);

                Topic topic = mTopicsList.get(i);
                txtTopicName.setText(topic.getTopicName());
                cboChecked.setSelected(topic.isChecked());


                return view;
            }
        };
        mListView.setAdapter(mAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //TODO save to subscription list
                UserData.getInstance().setSubscriptions((LinkedList<Topic>) mTopicsList);
                Log.d(TAG, "onOptionsItemSelected: " + UserData.getInstance().getSubscriptionsAsString());
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
