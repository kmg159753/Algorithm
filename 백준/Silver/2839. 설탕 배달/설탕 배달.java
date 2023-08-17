import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int three = 0;
        while (true) {
            // 5kg 전부
            if (num % 5 == 0) {
                System.out.println(num / 5);
                break;
            } else {
                num -= 3;
                three += 1;
                if(num % 5 == 0){
                    System.out.println((num / 5) + three);
                    break;
                }
            }
            if(num < 0){
                System.out.println(-1);
                break;
            }

        }


    }
}