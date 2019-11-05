package com.example.styopapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.styopapp.R;
import com.example.styopapp.holder.NoteViewHolder;
import com.example.styopapp.model.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    public interface Listener{
        void onNoteClick(long id);
    }

    private List<Note> noteList = new ArrayList<>();

    private Listener listener;

    public void setListener(final Listener listener){
        this.listener = listener;
    }

    public void setNoteList(final List<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_list_item, parent,
                false
        );
        return new NoteViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoteViewHolder holder, final int position) {
        holder.bind(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}