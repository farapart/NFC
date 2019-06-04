package com.example.c_stephen.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Create the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Create a button of registering
        Button btn_register = (Button) findViewById(R.id.button_register);
    }
}
