package day05;

public class PrimeNumber3 {
    //1000이하의 소수를 열거(버전3)

    public static void main(String[] args) {
        int counter = 0;            //곱셈과 나눗셈의 횟수
        int ptr = 0;                //찾은 소수의 개수
        int[] prime = new int[500]; //소수를 저장하는 배열

        prime[ptr++] = 2; //2는 소수임, prime[0]에 2를 넣고 ptr을 1로 증가시킴
        prime[ptr++] = 3; //3은 소수임, prime[1]에 3을 넣고 ptr을 2로 증가시킴


        for (int n = 5; n <= 1000; n += 2) {//대상은 홀수만 3,5,7 ...
            boolean flag = false;
            System.out.println("=============================");

            for (int i = 1; prime[i] * prime[i] <= n; i++) {//이미 찾은 소수로 나누어 봄
                counter += 2;//곱셈과 나눗셈의 횟수이므로 두개씩 증가시킴

                /////////////////////////////////////////////////
                System.out.println("ptr = " + ptr);
                if(ptr == 2) {
                    System.out.println("counter = " + counter);
                }
                System.out.println("i = "+ i);
                ////////////////////////////////////////////////

                if (n % prime[i] == 0) { //나누어떨어지면 소수가 아니므로
                    flag = true;
                    break;              //더이상 반복은 불필요
                }
            }//end inner for

            if (!flag) {          //마지막까지 나누어떨어지지 않음
                prime[ptr++] = n; //소수라고 배열에 저장
                counter++;        //prime[i]*prime[i]<=n이 성립하지 않는 경우 for문으로 들어가지 않으므로 counter를 여기서 포함시킴

            }
        }//end outer for
        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]); //찾은 ptr개의 소수를 나타냄

        }


        System.out.printf("나눗셈을 수행한 횟수: %d", counter);
    }
}
