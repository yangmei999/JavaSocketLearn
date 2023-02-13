package com.company;

//建立单向链表
public class Node {
    int data;
    int np;
    String names;
    Node next;
    public Node(int data, String names, int np)//节点声明的构造函数
    {
        this.np = np;
        this.names = names;
        this.data = data;
        this.next = null;
    }
}
