package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        url = getIntent().getStringExtra("url"); // 전달받은 url값을 url이라는 변수에 저장


        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // javascript 허용

        if(url.startsWith("http://")){
            webView.loadUrl(url);
        } else if(url.startsWith("https://")) {
            webView.loadUrl(url);
        } else{
            webView.loadUrl("http://" + url);//
        }

        webView.setWebChromeClient(new WebChromeClient()); // chrome client
        webView.setWebViewClient(new WebViewClientClass()); // webview client

    }

    @Override
    // 안드로이드의 다양한 키사용에 대한 설정
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { // 뒤로가기 버튼 클릭시
            webView.goBack(); // webview 뒤로가기
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { // 현재 페이지 url을 읽어오는 메소드
            view.loadUrl(url);
            return true;
        }
    }
}
