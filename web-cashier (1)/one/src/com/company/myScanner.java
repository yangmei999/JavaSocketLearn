package com.company;

//派生类1
public class myScanner extends myComputer{
    //成员数据
    private String paperScan;
    //构造函数
    public myScanner(String inData)
    {
        this.paperScan = new String(inData);
    }
    //重新定义类方法

    @Override
    public void Run() {
        System.out.println("使用扫描仪扫描"+paperScan+"完成");
    }
}
