package com.company;

//以继承方式声明类
public class BMW_Motocycle extends BMW_Serial {
    @Override
    public void ShowData() {
        System.out.println("这是利用BMW_Motocycle类重新定义的showdata方法");
    }

//    public ShowData(String modelName, int price) //重载类方法
//    {
//        System.out.println("BMW_Motocycle类加载的showData方法");
//    }

    //主程序区块
    public static void main(String[] args) {
        BMW_Motocycle BMW322 = new BMW_Motocycle();
        BMW322.ShowData();
    }
}
