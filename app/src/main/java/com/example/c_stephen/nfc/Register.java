package com.example.c_stephen.nfc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Create the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Create a button of registering
        Button btn_register = (Button) findViewById(R.id.button_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                EditText user_name = findViewById(R.id.user_name);
                EditText password_1 = findViewById(R.id.password_1);
                EditText password_2 = findViewById(R.id.password_2);
//                if(!password_1.getText().toString().equals(password_2.getText().toString())){
//                    Toast.makeText(Register.this, "两次密码输入不一致！", Toast.LENGTH_LONG).show();
//                }
                EditText phone = findViewById(R.id.phone);
                EditText id_card = findViewById(R.id.idCard);
                RadioGroup roleRg = (RadioGroup)findViewById(R.id.radioGroup);
                int role = 0;
                int role_num = roleRg.getCheckedRadioButtonId();
                if(role_num == R.id.btnSeller){
                    role = 1;
                }else if(role_num == R.id.btnParents){
                    role = 2;
                }else if(role_num == R.id.btnChildren){
                    role = 3;
                }else{
                    Toast.makeText(Register.this, "请选择一个您对应的角色！", Toast.LENGTH_LONG).show();
                }
                if(password_1.getText() == null || password_2.getText() == null){
                    Toast.makeText(Register.this, "密码不可为空", Toast.LENGTH_LONG).show();
                }else if(!password_1.getText().toString().equals(password_2.getText().toString())){
                    Toast.makeText(Register.this, "两次密码输入不一致！", Toast.LENGTH_LONG).show();
                }else{
                    UserInfo new_user = new UserInfo(user_name.getText().toString(), id_card.getText().toString()
                            , phone.getText().toString(), password_1.getText().toString(), role);
                    DBManager.newAccount(new_user);
                    Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
