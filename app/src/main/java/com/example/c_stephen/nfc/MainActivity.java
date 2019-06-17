package com.example.c_stephen.nfc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        btn_register.setOnClickListener(new View.OnClickListener(){            @Override
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

                UserInfo user_temp = new UserInfo();
//                Intent intent=new Intent(MainActivity.this,MainMenu.class);
//                startActivity(intent);

                if(!DBManager.getUser(user_name.getText().toString(), user_temp)){
                    Toast.makeText(MainActivity.this, "该用户不存在！", Toast.LENGTH_LONG).show();
                }else{
                    if(user_temp.getPassword().equals(password.getText().toString())){
                        Toast.makeText(MainActivity.this, "登陆成功！", Toast.LENGTH_LONG).show();
                        if(user_temp.getRole() == 3){
                            Intent intent = new Intent(MainActivity.this, MainMenu.class);
                            startActivity(intent);
                        }else if(user_temp.getRole() == 2){
                            Intent intent = new Intent(MainActivity.this, parentLogo.class);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
