package com.example.c_stephen.nfc;

class Goods {
    private String name;
    private double price;
    private int amount;

    Goods(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    int getAmount() {
        return amount;
    }

    double getTotalPrice() {
        return price * amount;
    }
}