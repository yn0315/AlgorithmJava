package day01;

public class Max {

    //최댓값 구하기
    static int max3(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        return max;
    }//end max3

    static int max4(int a, int b, int c, int d) {
        int max = a;

        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        if(d > max) {
            max = d;
        }
        return max;
    }//end max4


    public static void main(String[] args) {
        int result = max3(1,2,3);

        System.out.println(result);

        int result2 = max4(1,2,3,4);

        System.out.println(result2);
    }//end main
}//end class
