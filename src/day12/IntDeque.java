package day12;

public class IntDeque {
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
        que[front] = x;//////////////////////////?그냥 front라고..?!
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




}
