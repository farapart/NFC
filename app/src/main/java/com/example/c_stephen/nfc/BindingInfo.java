package com.example.c_stephen.nfc;

import java.io.Serializable;

public class BindingInfo implements Serializable {

    private String childName;
    private String childPhone;
    private String parentName;
    private String parentPhone;

    public BindingInfo(String childName, String childPhone, String parentName, String parentPhone) {
        this.childName = childName;
        this.childPhone = childPhone;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
    }

    public BindingInfo() {}

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildPhone() {
        return childPhone;
    }

    public void setChildPhone(String childPhone) {
        this.childPhone = childPhone;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    @Override
    public String toString() {
        return "BindingInfo{" +
                "childName='" + childName + '\'' +
                ", childPhone='" + childPhone + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                '}';
    }
}
