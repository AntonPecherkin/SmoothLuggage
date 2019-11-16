package com.manager.direct.blockchalleng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //WebView webView = findViewById(R.id.webView);
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("http://mapchain.000webhostapp.com/charging.html");
        Button button = (Button)findViewById(R.id.finishButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                        startActivity(intent);
            }
        });
    }
}
