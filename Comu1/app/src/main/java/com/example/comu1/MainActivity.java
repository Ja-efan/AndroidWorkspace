package com.example.comu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_addr;
    private Button btn_move;
    private Button btn_proxy;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_addr = findViewById(R.id.et_addr);

        btn_move = findViewById(R.id.bt_move);
        btn_proxy = findViewById(R.id.bt_proxy);

        /*
        btn_move 클릭
         */

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();

                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url",url); // url을 WebActivity에 전달

                startActivity(intent); // 액티비티 이동
            }
        });

    }
}
