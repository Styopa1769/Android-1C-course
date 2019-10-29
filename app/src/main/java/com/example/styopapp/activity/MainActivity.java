package com.example.styopapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.styopapp.R;

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
                    .replace(R.id.mainContainer, NoteListFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    }

    /*public void showDetailFragment(@NonNull final String name) {
        final View detailView = findViewById(R.id.demoDetailContainer);
        if (detailView == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.demoMainContainer, DetailFragment.newInstance(name))
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.demoDetailContainer, DetailFragment.newInstance(name))
                    .addToBackStack(null)
                    .commit();
        }
    }*/

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
