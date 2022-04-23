package day02;

public class Multi99Table {
    //곱셈표 출력하기
    public static void main(String[] args) {
        System.out.println("==== 곱셈표 ====");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=9; j++) {
                System.out.printf("%3d", i * j);//3자리로 출력해야 보기 좋음
            }
            System.out.println();
        }

    }
}
