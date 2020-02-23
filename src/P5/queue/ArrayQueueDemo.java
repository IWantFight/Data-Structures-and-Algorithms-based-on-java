package P5.queue;

import java.util.Random;
import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):取出队列");
            System.out.println("h(head):查看头部数据");
            key = sc.next().charAt(0);//接受第一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int i = sc.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            //System.out.println(arrayQueue.front);
        }
        System.out.println("程序退出");
    }
}
class ArrayQueue{
    private int maxSize;//最大容量
    private int front;//队列头部
    private int rear;//队列尾部
    private int[] arr;

    //1、创建队列的构造器
    public ArrayQueue(int arrmaxSize){
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，在未存入数据的时候，指向数据的前一个位置。
        rear = -1;//指向队列尾部。
    }

    //判断队列是否满
    public boolean isfull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据队列
    public void addQueue(int n){
        //首先判断是否满
        if (isfull()){
            System.out.println("满");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    //获取队列数据，出列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无数据可取");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，无数据");
            return;
        }
        for (int i = 0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列头部数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front+1]; 
    }
}
