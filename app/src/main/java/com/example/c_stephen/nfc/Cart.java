package com.example.c_stephen.nfc;

import java.util.ArrayList;

class Cart {
    private ArrayList<Goods> goods;
    private double totalPrice;

    Cart(ArrayList<Goods> goods) {
        this.goods = goods;

        totalPrice = 0;
        for (Goods good : goods) {
            totalPrice += good.getTotalPrice();
        }
    }

    ArrayList<Goods> getGoods() {
        return goods;
    }

    double getTotalPrice() {
        return totalPrice;
    }
}
