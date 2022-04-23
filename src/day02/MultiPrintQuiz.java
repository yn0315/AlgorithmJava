package day02;

public class MultiPrintQuiz {

    public static void main(String[] args) {

        String num = "    |";
        for(int n = 1; n <= 9; n++) {
            num += "  " + n ;
        }
        System.out.println(num);
        System.out.println("----+---------------------------");


        for(int i = 1; i <=9; i++) {
            System.out.printf("%3d |",i);
            for(int j = 1; j <=9; j++) {
                if(i * j ==j ) {
                }
                System.out.printf("%3d", i * j);

            }
            System.out.println();
        }
    }//end main
}
