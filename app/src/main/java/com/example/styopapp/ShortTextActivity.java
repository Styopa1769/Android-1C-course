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

        TextView date = findViewById(R.id.date);
        Date currentDate = new Date();
        DateFormat formatter = DateFormat.getDateInstance();
        date.setText(formatter.format(currentDate));

        ConstraintLayout constraintLayout = findViewById(R.id.simpleLyout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View event) {
                startActivity(new Intent(ShortTextActivity.this, FullTextActivity.class));
            }
        });

        Button email = findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL  , "shc-stepan@yandex.ru");
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                    emailIntent.putExtra(Intent.EXTRA_TEXT   , "Hello world!");

                    emailIntent.setType("text/plain"); // <-- HERE
                    startActivity(emailIntent); // <-- AND HERE

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
