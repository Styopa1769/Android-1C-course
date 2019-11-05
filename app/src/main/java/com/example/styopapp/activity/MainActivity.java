package com.example.styopapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.styopapp.R;
import com.example.styopapp.adapter.NoteAdapter;

public class MainActivity extends AppCompatActivity {

    public static Intent getIntent(@NonNull final Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContainer, NoteListFragment.newInstance(), NoteListFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void showDetailFragment(final long id) {
        if (getSupportFragmentManager().findFragmentByTag(NoteDetailFragment.TAG) != null) {
            getSupportFragmentManager().popBackStack();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, NoteDetailFragment.newInstance(id), NoteDetailFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
