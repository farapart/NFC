package com.example.c_stephen.nfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class parentsActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnSendCart;
    private CartInfo cartInfo;
    private Button btnGoBack;
    private UserInfo userInfo;
    private String userName;
    private ArrayList<BindingInfo> bindingInfos;
    private static final String TAG = "parentsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents);
        cartInfo = (CartInfo)getIntent().getSerializableExtra("cart");
        userInfo = (UserInfo)getIntent().getSerializableExtra("user");
        Log.e(TAG, "A: " + cartInfo.toString());
        Log.e(TAG, "B: " + userInfo.toString());
        radioGroup = (RadioGroup) findViewById(R.id.childGroup);
        addRadioButton(radioGroup);
        btnSendCart = (Button)findViewById(R.id.sendCart);
        btnSendCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cartInfo.setChildID(bindingInfos.get());
                //DBManager.insertCartInfo(cartInfo);
            }
        });
        btnGoBack = (Button) findViewById(R.id.goBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentsActivity.this, nfcActivity.class);
                startActivity(intent);
            }
        });
    }

    public List<String> getListSize(){
        if(!DBManager.getUser(userName,userInfo)) {
            return null;
        }
        if(!DBManager.getChildInfo(userInfo, bindingInfos)){
            return null;
        }
        List<String> childInfos = new ArrayList<String>();
        for(BindingInfo bindingInfo : bindingInfos) {
            childInfos.add(bindingInfo.toString());
        }
        childInfos.add("大儿子");
        childInfos.add("二儿子");
        return childInfos;
    }

    public void addRadioButton(RadioGroup radioGroup) {
        int index = 0;

        for(String ss:getListSize()) {
            RadioButton radioButton = new RadioButton(this);
            radioGroup.addView(radioButton);
            setRadioButtonAttribute(radioButton, ss, index);
            index++;
        }
    }

    public void setRadioButtonAttribute(final RadioButton radioButton, String buttonContent, int id) {
        if(radioButton == null) {
            return;
        }
        radioButton.setId(id);
        radioButton.setText(buttonContent);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parentsActivity.this, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                UserInfo childInfo = new UserInfo();
                boolean result = DBManager.getUser(bindingInfos.get(id).getChildName(), childInfo);
                cartInfo.setChildID(childInfo.getID());
                //cartInfo.setChildID(bindingInfos.get(id));
            }
        });
    }
}