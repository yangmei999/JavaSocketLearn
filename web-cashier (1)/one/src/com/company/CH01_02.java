package com.company;


public class CH01_02 extends BMW_Serial {
    //构造函数
    public CH01_02(String name)
    {
        modelName = name;
    }
    //主程序区块
    public static void main(String[] args) {
        //实现对象
        CH01_02 BMW318 = new CH01_02("BMW 318i");
        BMW318.ShowData();
    }
}
