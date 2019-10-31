package com.example.styopapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.styopapp.R;
import com.example.styopapp.adapter.NoteAdapter;
import com.example.styopapp.repo.NoteRepo;

public class NoteDetailFragment extends Fragment {

    private long noteId;

    public NoteDetailFragment(long noteId) {
        super();
        this.noteId = noteId;
    }

    public static Fragment newInstance(long id) {
        return new NoteDetailFragment(id);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.noteRecyclerView);

        LinearLayoutManager linearLayoutManager;

        if (getResources().getBoolean(R.bool.is_landscape)){
            linearLayoutManager = new GridLayoutManager(getContext(),2);
        } else {
            linearLayoutManager = new LinearLayoutManager(getContext());
        }

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 15);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoteList(NoteRepo.getNoteList());
    }
}
