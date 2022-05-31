package day12;

import day11.Gstack;

public class Gqueue<E> {
    private int max; //큐의 용량
    private int num; //현재 데이터 수
    private int front; //프런트 요소 커서
    private int rear; //리어 요소 커서
    private E[] que; //큐의 본체

    //실행 시 예외 : 큐가 비어있음
    public static class EmptyGqueueException extends RuntimeException {
        public EmptyGqueueException () {
        }
    }

    //실행 시 예외 : 큐가 가득 참
    public static class OverFlowGqueueException extends RuntimeException {
        public OverFlowGqueueException() {

        }
    }

    //생성자
    public Gqueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];//큐 본체용 배열을 생성
        }catch (OutOfMemoryError error) {//생성할 수 없음
            max = 0;
        }
    }

    //큐에 데이터를 인큐
    public E enque(E x) throws OverFlowGqueueException {
        if(num >= max) {
            throw new OverFlowGqueueException();//큐가 가득 참
        }
        que[rear++] = x;
        num++;
        if(rear == max) //데이터가 꽉 차면 rear를 0으로 맞춤
            rear = 0;
        return x;
    }

    //데이터를 디큐
    public E deque() throws EmptyGqueueException {
        if(num <= 0) {
            throw new EmptyGqueueException(); //큐가 비었음
        }
        E x = que[front++];
        num--;
        if(front == max)//front가 max랑 같다는 건 데이터가 다 빠졌다는 뜻이니까 0으로 맞춤
            front = 0;
        return x;
    }

    //데이터를 피크(프런트 데이터를 들여다 봄)
    public E peek() throws EmptyGqueueException{
        if(num <= 0) {
            throw new EmptyGqueueException();//큐가 비어있음
        }
        return que[front];
    }

    //큐에서 x를 검색하여 반환
    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max; //선형구조가 아니기 때문에!
            if(que[idx] == x)
                return idx;
        }
        return -1;
    }

    //큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    //큐의 용량을 반환
    public int capacity() {
        return max;
    }

    //큐에 쌓인 데이터 수를 반환
    public int size() {
        return num;
    }

    //큐가 비었는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    //큐가 가득 찼는가?
    public boolean isFull() {
        return num >= max;
    }

    //큐를 프런트 -> 리어 순으로 출력
    public void dump() {
        if(num <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            for (int i = 0; i < num; i++) {
                System.out.println(que[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }

    //임의의 데이터 검색, 인덱스 말고 몇 번째 자리인지 반환, 없으면 0반환
    public int search(E x) {
        for (int i = 0; i < num; i++) {
            if(que[(i + front) % max] == x) 
                return i + 1;
        }
        return 0;
    }

}
