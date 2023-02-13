package com.company;

public class BENZ_Serial extends autoMobile {
    //成员数据
    private int carLength,engCC,maxSpeed;
    //构造函数
    public BENZ_Serial(String modelName){
        System.out.println("BENZ系列：" + modelName + "基本数据");
    }

    //重新定义抽象方法
    public void setData()
    {
        carLength = 400;
        engCC = 3200;
        maxSpeed = 280;
    }
    public void showData()
    {
        System.out.println(carLength);
        System.out.println(engCC);
        System.out.println(maxSpeed);
    }
}
