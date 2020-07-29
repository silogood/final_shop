package com.silogood.shop.admin.admin_shoes.print;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.silogood.shop.R;
import com.silogood.shop.databasemanager.DatabaseHelper;
import com.silogood.shop.databasemanager.Shoes_NotesAdapter;
import com.silogood.shop.databasemanager.ShoesNote;

import java.util.ArrayList;

public class Admin_Shoes_Print extends AppCompatActivity {
    private ListView mListView;
    private TextView mTextView;
    private DatabaseHelper mDatabaseHelper;
    private String TAG = "ADMIN_SHOES_PRINT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_shoes_print);
        mDatabaseHelper= new DatabaseHelper(this);
        init_view();
    }

    private void init_view() {
        mListView = (ListView)findViewById(R.id.listview);
        mTextView = (TextView)findViewById(R.id.selected_item_textview);

        ArrayList<ShoesNote> list = new ArrayList<ShoesNote>();

        Shoes_NotesAdapter adapter = new Shoes_NotesAdapter(this,R.layout.custom_listview_item,list);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                ShoesNote selected_item = (ShoesNote)adapterView.getItemAtPosition(position);

                mTextView.setText(selected_item.getName());
                ShoesNote sn = new ShoesNote(selected_item.getId(),selected_item.getName(),selected_item.getCode(),selected_item.getBqt()-1,selected_item.getTimestamp());
                mDatabaseHelper.updateShoesNote(sn);

            }
        });



        int i = mDatabaseHelper.getShoesNotesCount();
        long index ;
        for( index = 1 ; index < i ; index++ ){
            ShoesNote admin_shoes = mDatabaseHelper.getShoesNote(index);
            list.add(admin_shoes);

        }

    }
}