package com.example.styopapp.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.styopapp.R;
import com.example.styopapp.adapter.NoteAdapter;
import com.example.styopapp.model.Note;

import java.text.DateFormat;

import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView noteTextView;
    private TextView noteDateView;
    private TextView noteTitleView;
    private ImageView noteImageView;
    private long id;
    private NoteAdapter.Listener listener;

    public NoteViewHolder(final View itemView, final NoteAdapter.Listener listener) {
        super(itemView);
        noteTextView = itemView.findViewById(R.id.noteTextView);
        noteDateView = itemView.findViewById(R.id.noteDateView);
        noteTitleView = itemView.findViewById(R.id.noteTitleView);
        noteImageView = itemView.findViewById(R.id.noteImageView);

        noteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (listener != null){
                    listener.onNoteClick(id);
                }
            }
        });
    }

    public void bind(final Note note) {
        noteTextView.setText(note.getText());

        DateFormat formatter = DateFormat.getDateInstance();
        noteDateView.setText(formatter.format(note.getDate()));

        noteTitleView.setText(note.getTitle());
        noteImageView.setImageResource(note.getDrawableIdRes());

        id = note.getId();
    }
}