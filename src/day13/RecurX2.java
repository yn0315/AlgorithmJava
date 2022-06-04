package day13;

import day11.IntStack;

public class RecurX2 {
    //꼬리재귀를 제거했습니다.
    static void recur(int n) {
       IntStack s = new IntStack(n);

       while (true) {
           if (n > 0) {
               s.push(n);
               n = n - 1;
               continue;
           }

           if (s.isEmpty() != true) {
               n = s.pop();
               System.out.println(n);
               n = n - 2;
               continue;
           }
           break;
       }





    }
}
