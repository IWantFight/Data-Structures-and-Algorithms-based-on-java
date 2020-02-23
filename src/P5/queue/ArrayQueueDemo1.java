package P5.queue;

import java.util.Scanner;

public class ArrayQueueDemo1 {
    public static void main(String[] args) {
        ArrayQueue1 arrayQueue1 = new ArrayQueue1(3);
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop){
            System.out.println("s:展示队列");
            System.out.println("g:移除数据");
            System.out.println("a:添加数据");
            System.out.println("h:获取队列头部数据");
//            key = sc.next().charAt(0);
            switch (sc.next().charAt(0)){
                case 's':
                    arrayQueue1.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    try {
                        arrayQueue1.addQueue(sc.nextInt());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        arrayQueue1.getHeadQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    try {
                        arrayQueue1.getQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayQueue1 {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //构造器
    public ArrayQueue1(int maxSize) {
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear < maxSize - 1;
    }

    //add
    public void addQueue(int b) {
        if (isFull()){
            System.out.println("已满");
            return;
        }
        arr[++rear] = b;
    }

    //get
    public int getQueue(){
        if (isEmpty()){
            System.out.println("空");
            throw new RuntimeException("空");
        }
        return arr[++front];
    }

    //show
    public void showQueue(){
        if (isEmpty()){
            return;

        }
        for (int i =0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //head
    public int  getHeadQueue(){
        if (isEmpty()){
            System.out.println("空");
            throw new RuntimeException("空");
        }
        return arr[front+1];
    }
}
