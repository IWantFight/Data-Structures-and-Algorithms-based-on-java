package P5.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.printf("");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):取出队列");
            System.out.println("h(head):查看头部数据");
            key = sc.next().charAt(0);//接受第一个字符
            switch (key) {
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
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头是%d\n", res);
                    } catch (Exception e) {
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

class CircleArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列头部
    private int rear;//队列尾部的下一个位置
    private int[] arr;

    //1、创建队列的构造器
    public CircleArrayQueue(int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部，指向队列的第一个数据。
        rear = 0;//指向队列尾部数据的下一个位置。
    }

    //判断队列是否满
    public boolean isfull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据队列
    public void addQueue(int n) {
        //首先判断是否满
        if (isfull()) {
            System.out.println("满");
            return;
        }
        //由于rear指的是当前元素的下一个位置，所以直接把要添加的元素赋值
        arr[rear] = n;
        //然后再对rear进行指针移动操作
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据可取");
        }
        //front指向队列的第一个元素。
        //先把front的值保留到一个临时变量，再讲front后移，最后在将临时变量保存
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
            return;
        }
        //从front开始遍历，并且思考要遍历多少个元素
        for (int i = front; i < front + getNumber(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //定义一个方法，求出当前队列中的有效数据个数
    public int getNumber() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front + 1];
    }
}
