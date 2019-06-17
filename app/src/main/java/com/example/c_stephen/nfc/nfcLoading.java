package com.example.c_stephen.nfc;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.c_stephen.nfc.NfcUtils.mNfcAdapter;

public class nfcLoading extends AppCompatActivity {

    private static final String TAG = "nfcLoading";
    //private Cart cart = new Cart();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_loading);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
            Toast.makeText(this, "该设备不支持NFC功能", Toast.LENGTH_LONG).show();
        }
        else if (mNfcAdapter.isEnabled()) {
            Toast.makeText(this, "NFC功能已经打开", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "请前往设置打开NFC功能", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        // super.onNewIntent(intent);

        setIntent(intent);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            processIntent(getIntent());
        }
    }

    void processIntent(Intent intent) {
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];

        String carJson = new String(msg.getRecords()[0].getPayload());
        Log.e(TAG, carJson);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Cart cart = objectMapper.readValue(carJson, Cart.class);

            Log.e(TAG, cart.getGoods().get(1).getName() + cart.getGoods().get(1).getAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
