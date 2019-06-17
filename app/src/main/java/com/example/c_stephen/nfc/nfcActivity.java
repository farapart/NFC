package com.example.c_stephen.nfc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class nfcActivity extends AppCompatActivity {

    //private CartInfo cartInfo = new CartInfo(11, 12, 13, 14, 2, 1.2, 1, 1.5, 3, 1.2, 1, 1.25,25,1);
    private UserInfo userInfo = new UserInfo(1, "liujiahao", "123456789", "18868102705", "123", 2);
    private Cart cart;
    private CartInfo cartInfo = new CartInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        //cartInfo.setParentID(userInfo.getID());
        Goods apple = new Goods("apple", 2.0, 2);
        Goods pear = new Goods("pear", 1.5, 3);
        Goods banana = new Goods("banana", 3.0, 3);
        Goods watermelon = new Goods("watermelon", 10.0, 3);

        ArrayList<Goods> goods = new ArrayList<>();
        goods.add(apple);
        goods.add(pear);
        goods.add(banana);
        goods.add(watermelon);

        cart = new Cart(goods);
        showCartInfo();
        Button btnConfirmCart = (Button)findViewById(R.id.confirmCart);
        btnConfirmCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nfcActivity.this, parentsActivity.class);
                intent.putExtra("cart", cartInfo);
                intent.putExtra("user", userInfo);
                startActivity(intent);
            }
        });
    }

    /**
     * 显示购物车信息
     */
    private void showCartInfo() {
        int counter = 1;

        ImageView fruit_image;
        TextView price;
        TextView amount;
        TextView kind_total_price;

        for(Goods good : cart.getGoods()) {
            if(good.getAmount() == 0) {
                continue;
            }
            if(counter == 1) {
                fruit_image = findViewById(R.id.imageView_first);
                price = findViewById(R.id.textView_first);
                amount = findViewById(R.id.textView_amount_first);
                kind_total_price = findViewById(R.id.textView_price_first);
            } else if(counter == 2) {
                fruit_image = findViewById(R.id.imageView_second);
                price = findViewById(R.id.textView_second);
                amount = findViewById(R.id.textView_amount_second);
                kind_total_price = findViewById(R.id.textView_price_second);
            } else if(counter == 3) {
                fruit_image = findViewById(R.id.imageView_third);
                price = findViewById(R.id.textView_third);
                amount = findViewById(R.id.textView_amount_third);
                kind_total_price = findViewById(R.id.textView_price_third);
            } else {
                fruit_image = findViewById(R.id.imageView_fourth);
                price = findViewById(R.id.textView_fourth);
                amount = findViewById(R.id.textView_amount_fourth);
                kind_total_price = findViewById(R.id.textView_price_fourth);
            }

            if(good.getName().equals("apple")) {
                fruit_image.setImageDrawable(getDrawable(R.mipmap.apple));
                cartInfo.setAppleNumber(good.getAmount());
                cartInfo.setApplePrice(good.getPrice());
            } else if (good.getName().equals("pear")) {
                fruit_image.setImageDrawable(getDrawable(R.mipmap.pear));
                cartInfo.setPearNumber(good.getAmount());
                cartInfo.setPearPrice(good.getPrice());
            }
            else if (good.getName().equals("banana")) {
                fruit_image.setImageDrawable(getDrawable(R.mipmap.banana));
                cartInfo.setBananaNumber(good.getAmount());
                cartInfo.setBananaPrice(good.getPrice());
            }
            else {
                fruit_image.setImageDrawable(getDrawable(R.mipmap.watermelon));
                cartInfo.setWatermelonNumber(good.getAmount());
                cartInfo.setWatermelonPrice(good.getPrice());
            }

            price.setText(Double.valueOf(good.getPrice()).toString());
            amount.setText(String.valueOf(good.getAmount()));
            kind_total_price.setText(Double.valueOf(good.getTotalPrice()).toString());

            counter += 1;
        }
        TextView total_price = findViewById(R.id.textView_total_price);
        total_price.setText(Double.valueOf(cart.getTotalPrice()).toString());
        cartInfo.setTotalPrice(cart.getTotalPrice());
    }
}
