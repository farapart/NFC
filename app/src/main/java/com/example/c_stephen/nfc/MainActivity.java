package com.example.c_stephen.nfc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


//This is the first activity of our application.You can login or choose to register a new account
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Create the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button for register
        Button btn_register = (Button)findViewById(R.id.button_goto_register);

        //Button for login
        Button btn_login = (Button)findViewById(R.id.button_login);

        //If you push the button of registering, you'll jump to activity "register
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        //If you push the button of login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                //Get user_name and password
                EditText user_name = findViewById(R.id.user_name);
                EditText password = findViewById(R.id.password);

//                //User_info struct includes all information of a user
//                user_info info = new user_info(user_name.getText().toString(), password.getText().toString(), "NUll");
//
//                //Post the information into server and get message from it
//                msg_token result = ConnectServer.Login(info);
//
//                //Give a hint
//                Toast.makeText(MainActivity.this, result.msg, Toast.LENGTH_LONG).show();
//                String temp = result.msg;
//
//                //If login successfully
//                if (temp.equals("登录成功")) {
//                    Intent intent = new Intent(MainActivity.this, Select.class);
//                    startActivity(intent);
//
//                }

            }
        });
    }
}
