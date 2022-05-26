package day11;

public class IntStackX {
    private int max; //스택용량(AB의 합계)
    private int ptrA; //스택 포인터 A
    private int ptrB; //스택 포인터 B
    private int[] stk; //스택 본체

    public enum AorB {
        StackA, StackB
    };

    //실행예외 : 스택 비어있음
    public class EmptyIntStackXException extends RuntimeException {
        public EmptyIntStackXException() {

        }
    }

    //실행예외 : 스택이 가득 참
    public class OverFlowIntStackXException extends RuntimeException {
        public OverFlowIntStackXException() {

        }
    }

    //생성자
    public IntStackX(int capacity) {
        max = capacity;
        ptrA = 0;
        ptrB = capacity - 1;
        try {
            stk = new int[max]; //스택 본체용 배열을 생성
        }catch (OutOfMemoryError e) { //생성할 수 없습니다.
            max = 0;
        }
    }

    //스택에 x를 푸시
    public int push(AorB sw, int x) throws OverFlowIntStackXException {
        if(ptrA>= ptrB + 1) { //스택이 가득 참
            throw new OverFlowIntStackXException();
        }
        switch (sw) {
            case StackA:
                stk[ptrA++] = x;
                break;
            case StackB:
                stk[ptrB--] = x;
                break;
        }
            return x;
    }

    //스택에 (꼭대기 데이터를) 팝
    public int pop(AorB sw) throws EmptyIntStackXException {
        int x = 0;
        switch (sw) {
            case StackA:
                if(ptrA <= 0) //스택 A가 비어있음
                    throw new EmptyIntStackXException();
                x = stk[--ptrA];
                break;
            case StackB:
                if(ptrB >= max - 1)
                    throw new EmptyIntStackXException();
                x = stk[++ptrB];
                break;
        }
        return x;
    }

    //스택에서 데이터를 피크(꼭대기 데이터를 살펴봄)
    public int peek(AorB sw) throws EmptyIntStackXException {
        int x = 0;
        switch (sw) {
            case StackA:
                if(ptrA <= 0)
                    throw new EmptyIntStackXException();
                x = stk[ptrA - 1];
                break;
            case StackB:
                if(ptrB >= max -1)
                    throw new EmptyIntStackXException();
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }

    //스택에서 x를 검색하여 있으면 index(찾지못하면 -1)반환
    public int indexOf(AorB sw, int x) {
        switch (sw) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--) {//꼭대기쪽부터 선형검색
                    if(stk[i] == x)
                        return i; //검색성공
                }break;
            case StackB:
                for (int i = ptrB + 1; i < max; i++) {
                    if(stk[i] == x)
                        return i; //검색성공
                }break;
        }
        return -1; //검색실패
    }

    //스택을 비움
    public void clear(AorB sw) {
        switch (sw) {
            case StackA:
              ptrA = 0;
              break;
            case StackB:
                ptrB = max - 1;
                break;
        }
    }









}
