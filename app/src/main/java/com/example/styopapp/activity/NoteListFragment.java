package com.example.styopapp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.styopapp.R;
import com.example.styopapp.adapter.NoteAdapter;
import com.example.styopapp.repo.NoteRepo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteListFragment extends Fragment implements NoteAdapter.Listener{

    public static final String TAG = "ListFragment";

    public NoteListFragment(){}

    public static Fragment newInstance() {
        return new NoteListFragment();
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

        if ((getResources().getBoolean(R.bool.is_landscape) && getResources().getBoolean(R.bool.is_phone)) || (!getResources().getBoolean(R.bool.is_landscape) && !getResources().getBoolean(R.bool.is_phone))){
            linearLayoutManager = new GridLayoutManager(getContext(),2);
        } else {
            linearLayoutManager = new LinearLayoutManager(getContext());
        }

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 6);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoteList(NoteRepo.getNoteList());
        adapter.setListener(this);

        FloatingActionButton fab = view.findViewById(R.id.addNoteButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"camera pressed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNoteClick(long id) {
        ((MainActivity) getActivity()).showDetailFragment(id);
    }
}
