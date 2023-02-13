package com.company;

//主要类
public class CH01_03 {
    //成员数据
    private String inputData;
    //构造函数
    public CH01_03(){
        System.out.println("用户想要先扫描文件A！！再将A文件打印");
        System.out.println("它的流程为：");
        inputData = "文件A";
    }

    public static void main(String[] args) {
        //实现对象
        CH01_03 computerUser = new CH01_03();
        myComputer MyComputer;
        myScanner MyScanner = new myScanner("对象A");
        myPrinter MyPrinter = new myPrinter("对象A");
        System.out.println("将对象计算机转变成对象扫描仪执行run方法！！");
        //实现多态
        MyComputer = MyScanner;
        MyComputer.Run();
        System.out.println("将对象计算机转变成对象打印机执行Run方法！！");
        //实现多态
        MyComputer = MyPrinter;
        MyComputer.Run();
    }
}
