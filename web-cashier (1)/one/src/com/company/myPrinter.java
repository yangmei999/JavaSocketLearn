package com.company;

//派生类2
public class myPrinter extends myComputer {
    //成员数据
    private String paperPrint;
    //构造函数
    public myPrinter(String inData){this.paperPrint = new String(inData);}
    //重新定义类方法

    @Override
    public void Run() {
        System.out.println("使用打印机打印"+paperPrint+"完成");
    }
}
