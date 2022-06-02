package day12;

import java.util.Deque;

public class IntDeque {

    ///////////rear----------------------------front////////////////
    private int max; //덱의 용량
    private int num; //현재 데이터 수
    private int front; //맨 앞 커서
    private int rear; //맨 뒤 커서
    private int[] que; //덱 본체

    //실행할 때 예외 : 큐가 비었음
    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException(){
        }
    }

    //실행할 때 예외 : 큐가 가득 참
    public class OverFlowIntDequeException extends RuntimeException {
        public OverFlowIntDequeException(){
        }
    }

    //생성자
    public IntDeque(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];//덱 본체용 배열을 생성
        }catch (OutOfMemoryError e) {//생성할 수 없습니다.
            max = 0;
        }
    }

    //데이터를 머리쪽부터 인큐
    public int enqueFront(int x) throws OverFlowIntDequeException{
        if(num >= max)
            throw new OverFlowIntDequeException();//덱이 가득 참
        num++;
        if(--front < 0)
            front = max - 1;
        que[front] = x;/////////////////////////////////////////////
        return x;
    }

    //데이터를 꼬리쪽부터 인큐
    public int enqueRear(int x) throws OverFlowIntDequeException {
        if(num >= max)
            throw new OverFlowIntDequeException(); //덱이 가득 참
        que[rear++] = x;
        num++;
        if(rear == max)
            rear = 0;
        return x;
    }

    //덱의 머리쪽부터 디큐
    public int dequeFront() throws EmptyIntDequeException {
        if(num <= 0)
            throw new EmptyIntDequeException();
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    //덱의 꼬리쪽부터 디큐
    public int dequeRear() throws EmptyIntDequeException {
        if(num <= 0)
            throw new EmptyIntDequeException();
        num--;
        if(--rear < 0)
           rear = max - 1;
        return que[rear];/////////////////////////
    }

    // 덱(deck)의 머리부터 데이터를 피크(머리데이터를 살펴봄)
    public int peekFront() throws EmptyIntDequeException{
        if(num <= 0)
            throw new EmptyIntDequeException();
        return que[front];
    }

    // 덱(deck)의 꼬리부터 데이터를 피크(꼬리데이터를 살펴봄)
    public int peekRear() throws EmptyIntDequeException{
        if(num <= 0)
            throw new EmptyIntDequeException();
        return que[rear == 0 ? max - 1 : rear - 1];/////////
    }

    // 덱(deck)에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if(que[(i + front) % max] == x)
                return i + front; //검색성공
        }
        return -1;
    }

    // 덱(deck)에서 x를 검색하여 머리부터 몇 번 째인가(찾지 못하면 0)를 반환
    public int search(int x) {
        for (int i = 0; i < num; i++) {
            if(que[(i + front) % max] == x)
                return i + 1; //검색성공
        }
        return 0;
    }

    // 덱(deck)을 비움
    public void clear() {
        rear = front = num = 0;
    }

    // 덱(deck)의 용량을 반환
    public int capacity() {
        return max;
    }

    // 덱(deck)에 쌓인 데이터 수를 반환
    public int size() {
        return num;
    }

    // 덱(deck)이 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 덱(deck)이 가득 찼는가?
    public boolean isFull() {
        return num >= max;
    }

    // 덱(deck)내의 데이터를 머리→꼬리의 차례로 나타냄
    public void dump() {
        if(num <= 0)
            System.out.println("덱이 비었습니다.");
        for (int i = 0; i < num; i++) {
            System.out.print(que[(i + front) % max] + " ");
        }System.out.println();
    }
    
//    Deque


}
