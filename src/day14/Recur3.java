package day14;

public class Recur3 {
    /*
        static void recur(int n) {
        if(n > 0) {
            recur(n - 1);
            recur(n - 2);//n을 프린트 하기 전의 재귀함수 -> head recursion이라고 함
            System.out.println(n);
            ->프린트 이후에 재귀함수 쓰면 tail recursion
        }
           //을 비재귀적으로 표현하라.
     */
    static void recur3(int n) {
        //head recursion이 두개임 -> 재귀가 돌아가는 동안 n을 잠깐 저장해둬야할 변수 필요
        //재귀처리 후 다시 n을 불러와야 함 -> 재귀함수 처리 여부 구분 변수도 필요
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;//반복상태 완료를 구분

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)//어떠한 재귀문도 실행되지 않은 상태
                    n = n - 1;
                else if (sw == 1) {//recur(n -1)까지 처리된 상태
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {//recur(n -2)까지 처리된 상태
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }
}
