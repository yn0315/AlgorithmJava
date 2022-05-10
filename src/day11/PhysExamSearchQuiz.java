package day11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearchQuiz {
    //신체검사 데이터 배열에서 이진검색하기
    //시력에 대한 내림차순 정렬의 신체검사 데이터에서 특정 시력을 가진 사람을 검색
    //신체검사 데이터를 정의
    static class PhyscData {
        private String name; //이름
        private int height; //키
        private double vision; //시력

        //생성자

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        //문자열을 반환하는 메서드(정보확인용)
        public String toString() {
            return name + " " + height + " " + vision;
        }

        //내림차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> VISION_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return  (d1.vision > d2.vision) ? -1 :
                        (d1.vision < d2.vision) ? 1 : 0;

            }//end compare
        }//end class HeightOrderComparator
    }//end class PhyscData

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = { //시력의 내림차순으로 정렬돼야함
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이나령", 162, 0.3),
        };
        System.out.print("시력이 몇인 사람을 찾고 있나요? : ");
        double vi = sc.nextDouble(); //키 값 입력
        System.out.println(Arrays.toString(x));
        int idx = Arrays.binarySearch(x, //배열 x에서
                new PhyscData("", 0,vi), //시력이 vi인 요소를
                PhyscData.VISION_ORDER); //VISION_ORDER에 의해 검색

        if (idx < 0) {
            System.out.println("요소가 없습니다.");
        } else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }//end if

        sc.close();
    }//end main
}//end class
