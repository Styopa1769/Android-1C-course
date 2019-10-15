package com.example.styopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class ShortTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_text);

        TextView dateTextView = findViewById(R.id.date);
        Date currentDate = new Date();
        DateFormat formatter = DateFormat.getDateInstance();
        dateTextView.setText(formatter.format(currentDate));

        ConstraintLayout constraintLayout = findViewById(R.id.simpleLyout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View event) {
                startActivity(new Intent(ShortTextActivity.this, FullTextActivity.class));
            }
        });

        Button email = findViewById(R.id.email);
        setEmailButtonListener(email);
    }

    private void setEmailButtonListener(Button email){
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , getString(R.string.feedbackEmail));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.notesFeedback));
                emailIntent.putExtra(Intent.EXTRA_TEXT   , getString(R.string.hello));

                emailIntent.setType("text/plain"); // <-- HERE
                startActivity(emailIntent); // <-- AND HERE

            }
        });
    }
}
