package com.silogood.shop.user.user_shoes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.silogood.shop.R;
import com.silogood.shop.databasemanager.ShoesNote;
import com.silogood.shop.databasemanager.Shoes_NotesAdapter;

import java.util.ArrayList;

public class User_Shoes_History extends AppCompatActivity {

    private String TAG = "History";
    private ListView mListView;
    private ArrayList<ShoesNote> mPurchaed_list;
    private Shoes_NotesAdapter mPurchaced_notesAdapter;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mIntent = getIntent();
        ArrayList<ShoesNote> cn =  (ArrayList<ShoesNote>) mIntent.getSerializableExtra("purchaced");
        //ArrayList<ShoesNote> cn =  (ArrayList<ShoesNote>) mIntent.getExtras().getSerializable("purchaced");

        Log.d(TAG,"#SILOGOOD CN.GET(0).GETnAME : "+cn.get(0).getName());

        mPurchaed_list = new ArrayList<ShoesNote>();

        mPurchaced_notesAdapter = new Shoes_NotesAdapter(this,R.layout.custom_listview_item, mPurchaed_list);

        mListView = (ListView)findViewById(R.id.purchaced_listview);
        mListView.setAdapter(mPurchaced_notesAdapter);

        int i ;
        for (i = 0; i < cn.size(); i++) {
            mPurchaed_list.add(cn.get(i));
        }

        mPurchaced_notesAdapter.notifyDataSetChanged();

    }


}
