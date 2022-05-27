package day11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class IntStackX {
    private int max; //스택용량(AB의 합계)
    private int ptrA; //스택 포인터 A
    private int ptrB; //스택 포인터 B
    private int[] stk; //스택 본체

    public enum AorB {
        StackA, StackB
    }

    ;

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
        } catch (OutOfMemoryError e) { //생성할 수 없습니다.
            max = 0;
        }
    }

    //스택에 x를 푸시
    public int push(AorB sw, int x) throws OverFlowIntStackXException {
        if (ptrA >= ptrB + 1) { //스택이 가득 참
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
                if (ptrA <= 0) //스택 A가 비어있음
                    throw new EmptyIntStackXException();
                x = stk[--ptrA];
                break;
            case StackB:
                if (ptrB >= max - 1)
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
                if (ptrA <= 0)
                    throw new EmptyIntStackXException();
                x = stk[ptrA - 1];
                break;
            case StackB:
                if (ptrB >= max - 1)
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
                    if (stk[i] == x)
                        return i; //검색성공
                }
                break;
            case StackB:
                for (int i = ptrB + 1; i < max; i++) {
                    if (stk[i] == x)
                        return i; //검색성공
                }
                break;
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

    //스택 용량 반환(A와 B의 합계)
    public int capacity() {
        return max;
    }

    //스택에 쌓여있는 데이터 수를 반환
    public int size(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA;
            case StackB:
                return max - ptrB - 1;
        }
        return 0;
    }

    //스택이 비어있는가?
    public boolean isEmpty(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA <= 0;
            case StackB:
                return ptrB >= max - 1;
        }
        return false;
    }

    //스택이 가득 찼는가?
    public boolean isFull(AorB sw) {
        return ptrA >= ptrB + 1;
    }

    //스택 안의 데이터를 바닥-> 꼭대기 차례로 나타냄
    public void dump(AorB sw) {
        switch (sw) {
            case StackA:
                if (ptrA <= 0)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = 0; i < ptrA; i++) {
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;
            case StackB:
                if (ptrB >= max - 1)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = max - 1; i > ptrB; i--) {
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }

    public static void main(String[] args) {
        //int형 스택의 사용 예

        Scanner sc = new Scanner(System.in);
//        IntStack s = new IntStack(64); //최대 64개를 푸시할 수 있는 스택
        IntStackX s = new IntStackX(20);
//        AorB sw = AorB.StackA; //enum사용법
        AorB sw = AorB.StackB;


        while (true) {
            System.out.println("현재 데이터 수: " + s.size(sw) + " / " + s.capacity());
            System.out.print("1.푸시 2.팝 3.피크 4.덤프 5.검색 6.비움 7.정보표시 0.종료: ");
            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1://푸시
                    System.out.print("데이터: ");
                    x = sc.nextInt();
                    try {
                        s.push(sw, x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2://팝
                    try {
                        x = s.pop(sw);
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 3://피크
                    try {
                        x = s.peek(sw);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 4://덤프 -> 모든 데이터를 표시하는 메서드 바닥에서 꼭대기 순
                    s.dump(sw);
                    break;

                case 5://검색
                    System.out.print("검색할 데이터:");
                    x = sc.nextInt();
                    int num = s.indexOf(sw, x);
                    switch (sw) {
                        case StackA:
                            if (num >= 0) {
                                System.out.println("꼭대기부터 " + (s.size(sw) - num) + "번째에 있습니다.");
                            } else {
                                System.out.println("데이터가 없습니다.");
                            }
                            break;
                        case StackB:
                            if(num >= 0){
                                System.out.println("꼭대기부터 " + (s.size(sw) - 1) + "번째에 있습니다.");
                            }else {
                                System.out.println("데이터가 없습니다.");
                            }
                            break;
                    }
                    break;

                case 6://비움
                    s.clear(sw);
                    break;

                case 7://정보표시
                    System.out.println("용량: " + s.capacity());
                    System.out.println("데이터 수: " + s.size(sw));
                    System.out.println("비어" + (s.isEmpty(sw) ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (s.isFull(sw) ? "차 있습니다." : "차 있지 않습니다."));
//                    System.out.println(Arrays.toString(s.stk));//여기서는 팝한 데이터가 왜 전부 뜨는걸까

            }//end switch
        }


    }

}
