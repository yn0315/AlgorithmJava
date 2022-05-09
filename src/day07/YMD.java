package day07;

import java.util.Scanner;

public class YMD {

    int y; //년
    int m; //월
    int d; //일

    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
    };

    //윤년인지 여부 판단 메서드
    public static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) ? 1 : 0;//1이면 윤년
    }//end isLeap


    public YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;

    }

    YMD after(int n) {//여기에 static쓰면 this.사용 못함
        //n일 뒤의 날짜를 반환
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return (before(-n));

        temp.d += n;

        while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if (++temp.m > 12) {
                temp.y++;
                temp.m = 1;
            }
        }
        return temp;
    }

    YMD before(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return (after(-n));

        temp.d -= n;

        while (temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--;
                temp.m = 12;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("날짜를 입력하세요.\n");
        System.out.print("년：");
        int y = stdIn.nextInt();
        System.out.print("월：");
        int m = stdIn.nextInt();
        System.out.print("일：");
        int d = stdIn.nextInt();
        YMD date = new YMD(y, m, d);

        System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
        int n = stdIn.nextInt();

        YMD d1 = date.after(n);
        System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d);

        YMD d2 = date.before(n);
        System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d);

        stdIn.close();

    }


}
