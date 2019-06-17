package com.example.c_stephen.nfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class parentLogo extends AppCompatActivity {

    private Button btnTransport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_logo);
        btnTransport = (Button) findViewById(R.id.beginTransport);
        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentLogo.this, nfcLoading.class);
                startActivity(intent);
            }
        });
    }
}
