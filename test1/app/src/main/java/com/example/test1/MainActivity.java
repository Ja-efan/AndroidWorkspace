package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_addr; // 변수선언
    private Button btn_move; // 변수선언
    private Button btn_tor;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 'MainActivity'가 실행했을때 처음 동작하는 부분
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_addr = findViewById(R.id.et_addr); // 'et_addr' 아이디를 부여

        btn_move = findViewById(R.id.btn_move); // 'btn_move' 아이디 부여
        btn_tor = findViewById(R.id.btn_tor);

        btn_move.setOnClickListener(new View.OnClickListener() { // 버튼이 클릭될 때 동작 -> 화면 전환 후 webview 출력
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString(); // EditText에서 문자열 가져와서 url에 저장
                Intent intent = new Intent(MainActivity.this , WebActivity.class); // 현재 액티비티 , 이동할 액티비티

                intent.putExtra("url",url); // url의 값을 WebActivity에 전달
                startActivity(intent); // 액티비티 이동


            }
        });

        btn_tor.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                ComponentName compName = new ComponentName("org.torproject.android",
                        "org.torproject.android.OrbotMainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(compName);
                startActivity(intent);
            }
        });









    }
}
