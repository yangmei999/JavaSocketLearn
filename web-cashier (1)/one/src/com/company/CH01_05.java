package com.company;

public class CH01_05 implements autoMobile_setData, autoMobile_showData {
    //成员数据
    int carLength, engCC, maxSpeed;
    //构造函数
    public CH01_05 (String modelName){
        System.out.println("BENZ系列：" + modelName + "基本数据");
    }
    //重新定义抽象方法
    public void setData(){
        carLength = 400;
        engCC = 3200;
        maxSpeed = 280;
    }
    public void showData(){
        System.out.println(carLength);
        System.out.println(engCC);
        System.out.println(maxSpeed);
    }
    //主程序区块
    public static void main(String[] args) {
        CH01_05 SLK2000 = new CH01_05("SLK2000");
        SLK2000.setData();
        SLK2000.showData();
    }
}
