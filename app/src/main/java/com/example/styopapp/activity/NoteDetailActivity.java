package com.example.styopapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.styopapp.R;
import com.example.styopapp.model.Note;
import com.example.styopapp.repo.NoteRepo;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";

    public static Intent getIntent(final Context context, final long id) {
        final Intent intent = new Intent(context, NoteDetailActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        final long id = getIntent().getLongExtra(ID_KEY, -1);
        final Note note = NoteRepo.getNoteById(id);

        final TextView noteTextView = findViewById(R.id.noteTextView);
        noteTextView.setText(note.getText());

        final ImageView noteImageView = findViewById(R.id.noteImageView);
        noteImageView.setImageResource(note.getDrawableIdRes());

    }
}