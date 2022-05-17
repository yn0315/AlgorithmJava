package day12;

import java.util.Scanner;

public class LastNElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N]; //입력받은 값을 저장
        int cnt = 0; //입력받은 개수
        int retry; //다시한번?

        System.out.println("정수를 입력하세요.");

        do{
            System.out.printf("%d번째 정수: ", cnt + 1 );
            a[cnt++ % N] = sc.nextInt();

            System.out.println("계속 할까요? 1.예 /0.아니오.");
            retry = sc.nextInt();
        }while (retry == 1);

        int i = cnt - N;
        if(i < 0) i = 0;
        for ( ; i < cnt; i++) {
            System.out.printf("%2d번째의 정수 = %d\n", i + 1, a[i % N]);
        }
    }
}
