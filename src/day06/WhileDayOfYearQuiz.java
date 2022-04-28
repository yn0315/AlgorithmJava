package day06;

import java.util.Scanner;

public class WhileDayOfYearQuiz {
    //for문 말고 while문으로 i와 days없이 구현
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
    };

    //윤년인지 여부 판단 메서드
    public static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) ? 1 : 0;//1이면 윤년
    }//end isLeap

    //서기 y년 m월 d일의 그 해 경과 일 수를 구함
    public static int dayOfYear(int y, int m, int d) {
//        int days = d; //일 수
//        for (int i = 1; i < m; i++) {
//            days += mdays[isLeap(y)][i - 1];//인덱스 0번부터 시작하니까 1빼줌
//        }
//        return days;

    while (--m != 0) {//거꾸로 줄여가며 더하는 방식........d에 이미 일수가 들어있으니 이전 달부터 시작하면...
        d += mdays[isLeap(y)][m - 1];
    }
        return d;

    }//end dayOfYear

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int retry;  //다시 한번 ?

        System.out.println("그 해 경과 일수를 구합니다.");

        do {
            System.out.print("년: ");
            int year = sc.nextInt();
            System.out.print("월: ");
            int month = sc.nextInt();
            System.out.print("일: ");
            int day = sc.nextInt();

            System.out.printf("그 해 %d 일 째 입니다.\n", dayOfYear(year, month, day));

            System.out.println("한 번 더 할까요? (1. 예 / 2. 아니오)");
            retry = sc.nextInt();
        } while (retry == 1);
    }
}
