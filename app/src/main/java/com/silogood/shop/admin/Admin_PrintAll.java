package com.silogood.shop.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.silogood.shop.R;
import com.silogood.shop.databasemanager.AccNote;
import com.silogood.shop.databasemanager.ClothesNote;
import com.silogood.shop.databasemanager.Clothes_NotesAdapter;
import com.silogood.shop.databasemanager.DatabaseHelper;
import com.silogood.shop.databasemanager.ShoesNote;

import java.util.ArrayList;
import java.util.List;

public class Admin_PrintAll extends AppCompatActivity {

    private DatabaseHelper mDatabaseHelper;
    private ListView mListView;


    private ArrayList<ClothesNote> mClothes_list;
    private ArrayList<ShoesNote> mShoes_list;
    private ArrayList<AccNote>   mAcc_list;

    private ArrayList<ClothesNote> mAll_list;

    private Clothes_NotesAdapter mAllItem_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_print_all);

        mDatabaseHelper= new DatabaseHelper(this);

        mAll_list = new ArrayList<ClothesNote>();

        mClothes_list = new ArrayList<ClothesNote>();
        mShoes_list = new ArrayList<ShoesNote>();
        mAcc_list = new ArrayList<AccNote>();

        mAllItem_Adapter = new Clothes_NotesAdapter(this,R.layout.custom_listview_item, mAll_list);

        mListView = (ListView)findViewById(R.id.admin_print_all_view_list);
        mListView.setAdapter(mAllItem_Adapter);

        renew_list();
    }

    private void renew_list(){

        mClothes_list.clear();
        mShoes_list.clear();
        mAcc_list.clear();
        mAll_list.clear();

        List<ClothesNote> clothesNoteList = mDatabaseHelper.getAllClothesNotes();
        List<ShoesNote> shoesNoteList = mDatabaseHelper.getAllShoesNotes();
        List<AccNote> accNoteList = mDatabaseHelper.getAllAccNotes();

        int c_index;
        int s_index;
        int a_index;

        for(c_index = 0; c_index < clothesNoteList.size(); c_index++){
            mAll_list.add(clothesNoteList.get(c_index));
        }

        for(s_index = 0; s_index < shoesNoteList.size(); s_index++){

            ClothesNote dummy =  new ClothesNote();
            dummy.setName(shoesNoteList.get(s_index).getName());
            dummy.setCode(shoesNoteList.get(s_index).getCode());
            dummy.setBqt(shoesNoteList.get(s_index).getBqt());
            dummy.setTimestamp(shoesNoteList.get(s_index).getTimestamp());

            mAll_list.add(dummy);
        }

        for(a_index = 0; a_index < accNoteList.size(); a_index++){

            ClothesNote dummy =  new ClothesNote();
            dummy.setName(accNoteList.get(a_index).getName());
            dummy.setCode(accNoteList.get(a_index).getCode());
            dummy.setBqt(accNoteList.get(a_index).getBqt());
            dummy.setTimestamp(accNoteList.get(a_index).getTimestamp());

            mAll_list.add(dummy);
        }

        mAllItem_Adapter.notifyDataSetChanged();
    }
}
