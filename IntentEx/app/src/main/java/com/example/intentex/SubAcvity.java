package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubAcvity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_acvity);

        tv_sub = findViewById(R.id.tv_sub);


        Intent intent = getIntent();
        String str = intent.getStringExtra("str");


        tv_sub.setText(str);






    }
}
