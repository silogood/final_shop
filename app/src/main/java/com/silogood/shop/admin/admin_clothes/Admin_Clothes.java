package com.silogood.shop.admin.admin_clothes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.silogood.shop.R;

import com.silogood.shop.databasemanager.AccNote;
import com.silogood.shop.databasemanager.ClothesNote;
import com.silogood.shop.databasemanager.Clothes_NotesAdapter;
import com.silogood.shop.databasemanager.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Admin_Clothes extends AppCompatActivity {


    private String TAG = "ADMIN_CLOTHES";

    private DatabaseHelper mDatabaseHelper;

    private EditText mEditText_Product;
    private EditText mEditText_Code;
    private EditText mEditText_Bqt;
    private Button mAddBtn;
    private Button mDelBtn;
    private Button mModifyBtn;
    private ListView mListView;

    private ArrayList<ClothesNote> mClothes_list;
    private Clothes_NotesAdapter mClothes_notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_clothes);

        mDatabaseHelper= new DatabaseHelper(this);

        init_view();
    }

    private void init_view() {

        mClothes_list = new ArrayList<ClothesNote>();
        mClothes_notesAdapter = new Clothes_NotesAdapter(this,R.layout.custom_listview_item, mClothes_list);


        mEditText_Product = (EditText)findViewById(R.id.admin_clothes_edittxt_1);

        mEditText_Code = (EditText)findViewById(R.id.admin_clothes_edittxt_2) ;

        mEditText_Bqt = (EditText)findViewById(R.id.admin_clothes_edittxt_3) ;

        mAddBtn = (Button)findViewById(R.id.admin_clothes_addbtn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText_Product.getText();

                int parse = Integer.parseInt(mEditText_Bqt.getText().toString());
                mDatabaseHelper.setInsertNote("clothes",mEditText_Product.getText().toString(),mEditText_Code.getText().toString(),parse);

                Toast.makeText(Admin_Clothes.this, "새 아이템 추가 완료", Toast.LENGTH_SHORT).show();

                renew_list();
                mClothes_notesAdapter.notifyDataSetChanged();
            }
        });

        mDelBtn = (Button)findViewById(R.id.admin_clothes_purchace_btn);
        mDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteClothesNotebyname(mEditText_Code.getText().toString());

                Toast.makeText(Admin_Clothes.this, "제거 완료", Toast.LENGTH_SHORT).show();
                renew_list();
                mClothes_notesAdapter.notifyDataSetChanged();
            }
        });

        mModifyBtn = (Button)findViewById(R.id.admin_clothes_go_history_btn);
        mModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int parse = Integer.parseInt(mEditText_Bqt.getText().toString());
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                ClothesNote cn = new ClothesNote(mEditText_Product.getText().toString(),mEditText_Code.getText().toString(), parse ,mDate.toString() );

                mDatabaseHelper.updateClothesNoteBycode(cn);

                Toast.makeText(Admin_Clothes.this, "변경 되었습니다.", Toast.LENGTH_SHORT).show();
                renew_list();
                mClothes_notesAdapter.notifyDataSetChanged();
            }
        });

        mListView = (ListView)findViewById(R.id.admin_clothes_listview);
        mListView.setAdapter(mClothes_notesAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //List Item click
                ClothesNote selected_item = (ClothesNote) parent.getItemAtPosition(position);
                mEditText_Product.setText(selected_item.getName());
                mEditText_Code.setText(selected_item.getCode());
                mEditText_Bqt.setText(Integer.toString(selected_item.getBqt()));
            }
        });

        renew_list();

    }


    private void renew_list(){

        mClothes_list.clear();


        List<ClothesNote> a = mDatabaseHelper.getAllClothesNotes();
        int i;
        for (i = 0; i < a.size(); i++){
            mClothes_list.add(a.get(i));
        }


        mClothes_notesAdapter.notifyDataSetChanged();
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