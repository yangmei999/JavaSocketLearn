package com.company;

//类继承


//基类
public class BMW_Serial {
    //成员数据
    private int carLength, engCC, maxSpeed;
    public String modelName;
    //类方法
    public void ShowData()
    {
        carLength = 423;
        engCC = 3000;
        maxSpeed = 250;
        System.out.println(modelName + "基本数据");
        System.out.println("车身长度" + carLength);
        System.out.println("汽缸CC数" + engCC);
        System.out.println("最高车速" + maxSpeed);
    }
}



