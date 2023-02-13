package com.company;

public class CH01_04 {
    public static void main(String[] args) {
        //实现抽象类对象
        autoMobile myCar = null;
        //实现派生类对象
        BENZ_Serial SLK2000 = new BENZ_Serial("SLK2000");
        //实现多态
        myCar = SLK2000;
        myCar.setData();
        myCar.showData();
    }
}
