package day11;

import java.util.Arrays;
import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        //int형 스택의 사용 예

        Scanner sc = new Scanner(System.in);
        IntStack s = new IntStack(64); //최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("1.푸시 2.팝 3.피크 4.덤프 5.검색 6.비움 7.정보표시 0.종료: ");
            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1://푸시
                    System.out.print("데이터: ");
                    x = sc.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2://팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 3://피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 4://덤프 -> 모든 데이터를 표시하는 메서드 바닥에서 꼭대기 순
                    s.dump();
                    break;

                case 5://검색
                    System.out.print("검색할 데이터:");
                    x = sc.nextInt();
                    int num = s.indexOf(x);
                    if(num >= 0) {
                        System.out.println("꼭대기부터 " + (s.size()-num) + "번째에 있습니다.");
                    }else {
                        System.out.println("데이터가 없습니다.");
                    }
                    break;

                case 6://비움
                    s.clear();
                    break;

                case 7://정보표시
                    System.out.println("용량: " + s.capacity());
                    System.out.println("데이터 수: " + s.size());
                    System.out.println("비어" + (s.isEmpty()? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (s.isFull()? "차 있습니다." : "차 있지 않습니다."));

            }//end switch
        }
    }
}
