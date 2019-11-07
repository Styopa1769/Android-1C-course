package com.example.styopapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.styopapp.R;
import com.example.styopapp.adapter.NoteAdapter;
import com.example.styopapp.model.Note;
import com.example.styopapp.repo.NoteRepo;

public class NoteDetailFragment extends Fragment{

    public static final String TAG = "DetailFragment";

    private static final String ID_KEY = "ID_KEY";

    public NoteDetailFragment() {
        super();
    }

    public static Fragment newInstance(long id) {

        final Fragment fragment = new NoteDetailFragment();

        final Bundle args = new Bundle();
        args.putLong(ID_KEY,id);

        fragment.setArguments(args);

        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_note_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        final Note note = NoteRepo.getNoteById(getArguments().getLong(ID_KEY));

        final TextView noteTextView = view.findViewById(R.id.noteTextView);
        noteTextView.setText(note.getText());

        final ImageView noteImageView = view.findViewById(R.id.noteImageView);
        noteImageView.setImageResource(note.getDrawableIdRes());

    }
}
