package com.silogood.shop.admin.admin_shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.silogood.shop.R;

import com.silogood.shop.databasemanager.ClothesNote;
import com.silogood.shop.databasemanager.ShoesNote;
import com.silogood.shop.databasemanager.Shoes_NotesAdapter;
import com.silogood.shop.databasemanager.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Admin_Shoes extends AppCompatActivity {
    
    private String TAG = "ADMIN SHOES";

    private DatabaseHelper mDatabaseHelper;

    private EditText mEditText_Product;
    private EditText mEditText_Code;
    private EditText mEditText_Bqt;
    private Button mAddBtn;
    private Button mDelBtn;
    private Button mModifyBtn;
    private ListView mListView;

    private ArrayList<ShoesNote> mShoes_list;
    private Shoes_NotesAdapter mShoes_NotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_shoes);

        mDatabaseHelper= new DatabaseHelper(this);

        init_view();
    }

    private void init_view() {

        mShoes_list = new ArrayList<ShoesNote>();
        mShoes_NotesAdapter = new Shoes_NotesAdapter(this,R.layout.custom_listview_item, mShoes_list);


        mEditText_Product = (EditText)findViewById(R.id.admin_shoes_edittxt_1);

        mEditText_Code = (EditText)findViewById(R.id.admin_shoes_edittxt_2) ;

        mEditText_Bqt = (EditText)findViewById(R.id.admin_shoes_edittxt_3) ;

        mAddBtn = (Button)findViewById(R.id.admin_shoes_addbtn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText_Product.getText();

                int parse = Integer.parseInt(mEditText_Bqt.getText().toString());
                mDatabaseHelper.setInsertNote("shoes",mEditText_Product.getText().toString(),mEditText_Code.getText().toString(),parse);

                Toast.makeText(Admin_Shoes.this, "새 아이템 추가 완료", Toast.LENGTH_SHORT).show();

                renew_list();
                mShoes_NotesAdapter.notifyDataSetChanged();
            }
        });

        mDelBtn = (Button)findViewById(R.id.admin_shoes_purchace_btn);
        mDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteShoesNotebyname(mEditText_Code.getText().toString());

                Toast.makeText(Admin_Shoes.this, "제거 완료", Toast.LENGTH_SHORT).show();
                renew_list();
                mShoes_NotesAdapter.notifyDataSetChanged();
            }
        });

        mModifyBtn = (Button)findViewById(R.id.admin_shoes_go_history_btn);
        mModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int parse = Integer.parseInt(mEditText_Bqt.getText().toString());
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                ShoesNote cn = new ShoesNote(mEditText_Product.getText().toString(),mEditText_Code.getText().toString(), parse ,mDate.toString() );

                mDatabaseHelper.updateShoesNoteBycode(cn);

                Toast.makeText(Admin_Shoes.this, "변경 되었습니다.", Toast.LENGTH_SHORT).show();
                renew_list();
                mShoes_NotesAdapter.notifyDataSetChanged();
            }
        });

        mListView = (ListView)findViewById(R.id.admin_shoes_listview);
        mListView.setAdapter(mShoes_NotesAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //List Item click
                ShoesNote selected_item = (ShoesNote) parent.getItemAtPosition(position);
                mEditText_Product.setText(selected_item.getName());
                mEditText_Code.setText(selected_item.getCode());
                mEditText_Bqt.setText(Integer.toString(selected_item.getBqt()));
            }
        });

        renew_list();

    }


    private void renew_list(){

        mShoes_list.clear();


        List<ShoesNote> a = mDatabaseHelper.getAllShoesNotes();
        int i;
        for (i = 0; i < a.size(); i++){
            mShoes_list.add(a.get(i));
        }


        mShoes_NotesAdapter.notifyDataSetChanged();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}