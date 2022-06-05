package day13;

import day11.IntStack;

import java.util.Scanner;

public class RecurX2 {
    //꼬리재귀를 제거했습니다.
    static void recur(int n) {
       IntStack s = new IntStack(n);

       while (true) {
           if (n > 0) {
               s.push(n);           //일단 n을 스택에 저장
               n = n - 1;
               continue;            //n - 1을 실행 = recur(n -1)
           }

           //n이 음수가 되어 재귀의 끝에 다다르면

           if (s.isEmpty() != true) {
               n = s.pop();         //n을 하나씩 꺼냄
               System.out.println(n);
               n = n - 2;           //n - 2를 실행 = recur(n - 2)
               continue;
           }
           break;
       }

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.：");
        int x = stdIn.nextInt();

        recur(x);
    }
}
