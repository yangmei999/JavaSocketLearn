package com.company;

public class linkedListTest
{
    //删除列表第一个节点
    if(first.data == deleteNode.data)
    {
        first = first.next;
    }

    //删除列表的中间节点——将删除节点的前一个节点的指针指向删除节点的后一个节点即可
    newNode = first；
    tmp = first;
    while(NewNode.data!=deleteNode.data)
    {
        tmp = newNode;
        newNode = newNode.next;
    }
    tmp.next = delNode.next;


    //删除列表的最后一个节点
    //只要将指向最后一个节点的指针直接指向null就可以
    if（last.data == deleteNode.data)
    {
        newNode = first;
        while(newNode.next != last) {
            newNode = newNode.next;
        }
        newNode.next = last.next;
        last = newNode;
    }

    //Java语言实现建立一组学生成绩的单向链表程序，包括学号姓名成绩，单个删除，全部删除-1
    class{
        int data;
        int np;
        String names;
        Node next;

        public  Node (int data, String names, int np)
    {
        this.np = np;
        this.names = names;
        this.data = data;
        this.next = null;
    }
    }

    public class StuLinkedList
    {
        public Node first;
        public Node last;
        public boolean isEmpty()
        {
            return first==null;
        }
        public void print()
        {
            Node current = first;
            while(current != null){
                System.out.println(
                        current.names + current.data + current.np
                );
            current = current.next;
            }
            System.out.println();
        }
        public void insert(int data,String names, int np)
        {
            Node newNode = new Node(data, names, np);
            if(this.isEmpty()){
                first = newNode;
                last = newNode;
            }else{
                last.next = newNode;
                last = newNode;
            }
        }
        public void delete(Node delNode)
        {
            Node newNode;
            Node tmp;
            if(first.data == delNode.data){
                first = first.next;
            }
            else if(last.data == delNode.data)
            {
                newNode = first;
                while(newNode.next != last) newNode = newNode.next;
                newNode.next = last.next;
                last = newNode;
            }else{
                newNode = first;
                tmp=first;
                while(newNode.data != delNode.data)
                {
                    newNode = first;
                    tmp = newNode;
                    while(newNode.data != delNode.data)
                    {
                        tmp = newNode;
                        newNode = newNode.next;
                    }
                    tmp.next = delNode.next;
                }
            }
        }


        //插入
        public  void insert(Node ptr)
        {
            Node tmp;
            Node newNode;
            if(this.isEmpty())
            {
                first = ptr;
                last = ptr;
            }
            else{
                //插入第一个节点
                if(ptr.next == first)
                {
                    ptr.next = first;
                    first = ptr;
                }else{
                    if(ptr.next == null)
                    {
                        last.next = ptr;
                        last = ptr;
                    }else {
                        newNode = first;
                        tmp=first;
                        while(ptr.next != newNode.next)
                        {
                            tmp = newNode;
                            newNode = newNode.next;
                        }
                        tmp.next = ptr;
                        ptr.next = newNode;
                    }
                }
            }
        }
    }
}



//单向链表的的反转
class Node
{
    int data;
    int np;
    String names;
    Node next;
    public Node(int data, String names, int np)
    {
        this.np = np;
        this.names = names;
        this.data = data;
        this.next = null;
    }
}

public class StuLinkedListReverse
{
    public Node first;
    public Node last;
    public boolean isEmpty(){
        return first == null;
    }
    public void print()
    {
        Node current = first;
        while(current!=null){
            System.out.println(current.data+current.np+current.names);
            current = current.next;
        }
        System.out.println();
    }
    public void insert(int data, String names, int np)
    {
        Node newNode = new Node(data,names,np);
        if(this.isEmpty())
        {
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }
}


//环形链表的节点插入——将新节点的指针指向原表头； 找到原表的最后一个节点，并将指针指向新的及诶单；将表头指向新节点
public void insert(Node trp)
{
    Node tmp;
    Node newNode;
    if(this.isEmpty()){
        first = trp;
        last = trp;
        last.next = first;
    }else if(trp.next == null){
        last.next = trp;
        last = trp;
        last.next = first;
    }else{
        newNode = first;
        tmp = first;
        while(newNode.next != trp.next){
            if(tmp.next == first)
                break;
            tmp = newNode;
            newNode = newNode.next;
        }
        tmp.next = trp;
        trp.next = newNode;
    }
}

//环形链表删除节点
public void delete(Node delNode)
{
    Node newNode;
    Node tmp;
    if(this.isEmpty()){
        return ;
    }
    if(first.data == delNode.data){
        first = first.next;
        if(first == null)
            System.out.println("环形链表已经为空");
        return;
    }else if(last.data == delNode.data){
        newNode = first;
        while(newNode.next != last)
            newNode = newNode.next;
        last = newNode;
        last.next = first;
    }else{
        newNode = first;
        tmp = first;
        while(newNode.data != delNode.data){
            tmp = newNode;
            newNode = newNode.next;
        }
    }
}

//环形链表的串联——不需要遍历表去寻找表尾，直接改变两个指针就可以把两个环形列表串联在一起



//双向链表——在单向链表或者环形链表中，只能沿着同一个方向查找数据，如果有一个链接断裂，后面的链表就会消失而无法救回。
//双向链表可以改善两个缺点，因为它的基本结构和单向链表类似，至少有一个字段存放数据，它有两个字段存放指针，其中一个指向后面的节点，另一个则指向前面的节点


//双向链表的定义：具有三个字段（每个节点），通常加上一个表头。表中不存任何数据，其左边连接字段指向表中最后一个节点，右边链接指向第一个节点
//假设ptr为一指向此表上任节点的连接