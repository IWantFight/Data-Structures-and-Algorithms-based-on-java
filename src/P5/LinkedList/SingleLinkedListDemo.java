package P5.LinkedList;

import java.awt.*;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建几个节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");

        SingleLinkedList list = new SingleLinkedList();
        list.addByNo(hero2);
        list.addByNo(hero1);
        list.addByNo(hero3);
        list.show();
    }
}


//定义SingleLinkerList管理Hero
class SingleLinkedList{
    //初始化头结点
    //头结点不要动
    //不存放具体数据
    private HeroNode head = new HeroNode(0,"","");



    //add2 根据排名将元素添加到指定位置，
    public void addByNo(HeroNode heroNode){
        //头结点不动，仍然通过一个辅助指针找到指定的位置
        //因为单链表，找的temp位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//b标志添加的编号是否存在
        while (true){
            if (temp.next == null){
                //说明temp在链表最后
                break;
            }
            if (temp.next.no>heroNode.no){
                //位置已找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){
                //添加的heroNode的编号已经存在，不能添加
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag){
            //编号存在，插入的英雄不能添加
            System.out.printf("准备插入的英雄编号%d已存在\n",heroNode.no);
        }else{
            //插入到链表中，位于temp后面的位置
            heroNode.next = temp.next;
            temp.next = heroNode;//这里的
        }
    }



    //添加节点到单向链表
    //思路：不考虑编号顺序时，1找到当前链表的最后节点，2、将这个节点的next域指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，需要一个辅助节点
        HeroNode temp = head;
        //遍历找到最后
        while (true){
            //
            if (temp.next == null){
                break;
            }
            //如果没有找到，就将temp后移
            temp = temp.next;
        }
        //退出while循环时，temp已经指向了链表的最后
        temp.next = heroNode;
    }

    //显示链表
    public void show(){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，需要辅助节点
        HeroNode temp = head.next;
        while (true){
            //判断链表是否到最后
            if (temp == null){
                break;
            }
            //s输出节点信息
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }
}

//先定义一个hero节点，每个hero对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int herono,String heroname,String heronickname){
        this.no = herono;
        this.nickname = heronickname;
        this.name = heroname;
    }
    //重写toString


    @Override
    public String toString() {
        return "HeroNode【" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '】';
    }
}
