package day04;

import java.util.Scanner;

public class CardConvRevQuiz {

    //입력받은 10진수를 2~32진수로 변환하여 나타냄
    //정수 x를 r 진수로 변환하여 배열 d에 윗자리부터 넣고 자릿 수 반환
    public static int cardConv(int x, int r, char[]d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do{
            d[digits++] = dchar.charAt(x % r); //r로 나눈 나머지 문자로 변환해서 저장
            x /= r;
        }while (x != 0);

        //정답
        //위에는 그대로 두고 역순으로 돌려버리기
        for(int i = 0; i < digits/2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];//첫 번째 인덱스와 마지막 인덱스 교체
            d[digits - i - 1] = temp;
        }

        return digits;
    }//end cardConvR

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int no; //변환하는 정수
        int cd; //기수
        int dno; //변환 후의 자릿수
        int retry; //다시 한 번?
        char[] cno = new char[32]; //변환 후 각 자리의 숫자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수변환합니다.");
        do{
            do{
                System.out.print("변환하는 음이 아닌 정수: ");
                no = sc.nextInt();
            } while (no < 0);

            do{
                System.out.println("어떤 진수로 변환할까요? (2~36): ");
                cd = sc.nextInt();
            }while (cd < 2 || cd > 36);

            dno = cardConv(no,cd,cno);

            System.out.print(cd + "진수로는 ");
            for (int i = dno - 1; i >= 0; i--) {//윗자리부터 차례로 나타냄
                System.out.print(cno[i]);
            }

            System.out.println("입니다.");

            System.out.println("한 번 더 할까요?( 1.예 / 2.아니오) : ");
            retry = sc.nextInt();

        }while (retry == 1);

        sc.close();
    }
}
