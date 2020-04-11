package com.example.web_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private String htmlPageUrl  = "http://www.yonhapnews.co.kr/";

    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat = "";

    int cnt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textviewHtmlDocument = (TextView)findViewById(R.id.textView);
        textviewHtmlDocument.setMovementMethod(new ScrollingMovementMethod());

        Button htmlTitleButton = (Button)findViewById(R.id.button);
        htmlTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                System.out.println((cnt + 1) + "번째 파싱");
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
                cnt++;
            }
        });
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void...params) {
            try {

                Document doc = Jsoup.connect(htmlPageUrl).get();

                //test1
                Elements titles = doc.select("div.board-list div.inner_list");

                System.out.println("------------------------------------------------------------");
                for(Element e: titles){
                    System.out.println("title: "+ e.text());
                    htmlContentInStringFormat += e.text().trim() + "\n";
                }

                //test2
                titles = doc.select("td.td_article div.board-list div.inner_list");

                System.out.println("------------------------------------------------------------");
                for(Element e: titles){
                    System.out.println("title: "+ e.text());
                    htmlContentInStringFormat += e.text().trim() + "\n";
                }

                //test3
                titles = doc.select("div.board-list div.inner_list");

                System.out.println("------------------------------------------------------------");
                for(Element e: titles){
                    System.out.println("title: "+ e.text());
                    htmlContentInStringFormat += e.text().trim() + "\n";
                }
                System.out.println("------------------------------------------------------------");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        protected void onPostExcute(Void result) {
            textviewHtmlDocument.setText(htmlContentInStringFormat);
        }
    }
}

