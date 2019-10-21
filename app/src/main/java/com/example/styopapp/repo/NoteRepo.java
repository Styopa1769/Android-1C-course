package com.example.styopapp.repo;

import android.content.Context;
import android.content.res.Resources;

import com.example.styopapp.R;
import com.example.styopapp.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteRepo {
    private static final Map<Long, Note> NOTE_LIST = new HashMap<>();
    private static final String[] names = {"android","mops","labrador","shiba"};

    public static void initialize(final Context context) {
        Resources resources = context.getResources();
        int imgId;
        int stringId;
        long id = 1;
        for (String name : names){
            imgId = resources.getIdentifier(name, "drawable", context.getPackageName());
            stringId = resources.getIdentifier(name, "string", context.getPackageName());
            NOTE_LIST.put(id,new Note(id,new Date(),context.getString(stringId),name,imgId));
            id++;
        }
    }

    public static List<Note> getNoteList() {
        return new ArrayList<>(NOTE_LIST.values());
    }

    public static Note getNoteById(final long id) {
        return NOTE_LIST.get(id);
    }
}
