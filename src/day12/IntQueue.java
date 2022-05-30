package day12;


public class IntQueue {//링버퍼
    private int max; //큐의 용량
    private int front; //첫번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    //실행 시 예외 : 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }

    //실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    //생성자
    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max]; //큐 본체용 배열을 생성
        }catch (OutOfMemoryError e) {//생성할 수 없음
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if(num >= max) {
            throw new OverflowIntQueueException(); //큐가 가득참
        }
        que[rear++] = x;
        num++;
        if(rear == max) {//데이터가 꽉 차면 rear를 0으로 맞춤
            rear = 0;
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException(); //큐가 비어있음
        }
        int x = que[front++];
        num--;
        if(front == max) {//front가 max랑 같다는 건 데이터가 다 빠졌다는 거니까 0으로 맞춤
            front = 0;
        }
        return x;
    }

    //큐에서 데이터를 피크(프런트 데이터를 들여다봄)
    public int peek() throws EmptyIntQueueException{
        if(num <= 0) {
            throw new EmptyIntQueueException(); //큐가 비어있음
        }
        return que[front];
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max; //검색성공//front와 rear의 배열인덱스가 이어지지 않기 때문에 이렇게 작성
            if(que[idx] == x) {
                return idx;
            }
        }
        return -1; //검색실패
    }

    //큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    //큐의 용량을 반환
    public int capacity() {
        return max;
    }

    //큐에 쌓여있는 데이터 수를 반환
    public int size() {
        return num;
    }

    //큐가 비어있나?
    public boolean isEmpty() {
        return num <= 0;
    }

    //큐가 가득 찼나?
    public boolean isFull() {
        return num >= max;
    }

    //큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void dump() {
        if(num <= 0) {
            System.out.println("큐가 비어있습니다.");
        }else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }

    //임의의 데이터 검색, 인덱스 말고 몇 번째 자리인지 반환, 없으면 0반환
    public int search(int x) {
        for (int i = 0; i < num; i++) {
            if(que[(i + front) % max] == x)
                return i + 1;//검색성공
        }
        return 0;//검색실패
    }


}
