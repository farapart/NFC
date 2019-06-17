package com.example.c_stephen.nfc;

import java.io.Serializable;

public class CartInfo implements Serializable {

    private int cartID;

    private int shopperID;

    private int parentID;

    private int childID;

    private int appleNumber;

    private double applePrice;

    private int pearNumber;

    private double pearPrice;

    private int bananaNumber;

    private double bananaPrice;

    private int watermelonNumber;

    private double watermelonPrice;

    private double totalPrice;

    private int payFlag;

    /**
     * A constructor with cartID
     * @param cartID
     * @param shopperID
     * @param parentID
     * @param childID
     * @param appleNumber
     * @param applePrice
     * @param pearNumber
     * @param pearPrice
     * @param bananaNumber
     * @param bananaPrice
     * @param watermelonNumber
     * @param watermelonPrice
     * @param totalPrice
     * @param payFlag
     */
    public CartInfo(int cartID, int shopperID, int parentID, int childID, int appleNumber, double applePrice, int pearNumber, double pearPrice, int bananaNumber, double bananaPrice, int watermelonNumber, double watermelonPrice, double totalPrice, int payFlag) {
        this.cartID = cartID;
        this.shopperID = shopperID;
        this.parentID = parentID;
        this.childID = childID;
        this.appleNumber = appleNumber;
        this.applePrice = applePrice;
        this.pearNumber = pearNumber;
        this.pearPrice = pearPrice;
        this.bananaNumber = bananaNumber;
        this.bananaPrice = bananaPrice;
        this.watermelonNumber = watermelonNumber;
        this.watermelonPrice = watermelonPrice;
        this.totalPrice = totalPrice;
        this.payFlag = payFlag;
    }

    /**
     * A constructor without cartID
     * @param shopperID
     * @param parentID
     * @param childID
     * @param appleNumber
     * @param applePrice
     * @param pearNumber
     * @param pearPrice
     * @param bananaNumber
     * @param bananaPrice
     * @param watermelonNumber
     * @param watermelonPrice
     * @param totalPrice
     * @param payFlag
     */
    public CartInfo(int shopperID, int parentID, int childID, int appleNumber, double applePrice, int pearNumber, double pearPrice, int bananaNumber, double bananaPrice, int watermelonNumber, double watermelonPrice, double totalPrice, int payFlag) {
        this.shopperID = shopperID;
        this.parentID = parentID;
        this.childID = childID;
        this.appleNumber = appleNumber;
        this.applePrice = applePrice;
        this.pearNumber = pearNumber;
        this.pearPrice = pearPrice;
        this.bananaNumber = bananaNumber;
        this.bananaPrice = bananaPrice;
        this.watermelonNumber = watermelonNumber;
        this.watermelonPrice = watermelonPrice;
        this.totalPrice = totalPrice;
        this.payFlag = payFlag;
    }

    public CartInfo() {}

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getShopperID() {
        return shopperID;
    }

    public void setShopperID(int shopperID) {
        this.shopperID = shopperID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public int getAppleNumber() {
        return appleNumber;
    }

    public void setAppleNumber(int appleNumber) {
        this.appleNumber = appleNumber;
    }

    public double getApplePrice() {
        return applePrice;
    }

    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
    }

    public int getPearNumber() {
        return pearNumber;
    }

    public void setPearNumber(int pearNumber) {
        this.pearNumber = pearNumber;
    }

    public double getPearPrice() {
        return pearPrice;
    }

    public void setPearPrice(double pearPrice) {
        this.pearPrice = pearPrice;
    }

    public int getBananaNumber() {
        return bananaNumber;
    }

    public void setBananaNumber(int bananaNumber) {
        this.bananaNumber = bananaNumber;
    }

    public double getBananaPrice() {
        return bananaPrice;
    }

    public void setBananaPrice(double bananaPrice) {
        this.bananaPrice = bananaPrice;
    }

    public int getWatermelonNumber() {
        return watermelonNumber;
    }

    public void setWatermelonNumber(int watermelonNumber) {
        this.watermelonNumber = watermelonNumber;
    }

    public double getWatermelonPrice() {
        return watermelonPrice;
    }

    public void setWatermelonPrice(double watermelonPrice) {
        this.watermelonPrice = watermelonPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(int payFlag) {
        this.payFlag = payFlag;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "cartID=" + cartID +
                ", shopperID=" + shopperID +
                ", parentID=" + parentID +
                ", childID=" + childID +
                ", appleNumber=" + appleNumber +
                ", applePrice=" + applePrice +
                ", pearNumber=" + pearNumber +
                ", pearPrice=" + pearPrice +
                ", bananaNumber=" + bananaNumber +
                ", bananaPrice=" + bananaPrice +
                ", watermelonNumber=" + watermelonNumber +
                ", watermelonPrice=" + watermelonPrice +
                ", totalPrice=" + totalPrice +
                ", payFlag=" + payFlag +
                '}';
    }
}
