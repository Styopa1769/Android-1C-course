package com.example.styopapp.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.styopapp.R;
import com.example.styopapp.adapter.NoteAdapter;
import com.example.styopapp.repo.NoteRepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoteListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        final RecyclerView recyclerView = findViewById(R.id.noteRecyclerView);

        LinearLayoutManager linearLayoutManager;

        if (getResources().getBoolean(R.bool.is_landscape)){
            linearLayoutManager = new GridLayoutManager(this,2);
        } else {
            linearLayoutManager = new LinearLayoutManager(this);
        }

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 15);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoteList(NoteRepo.getNoteList());
    }
}
