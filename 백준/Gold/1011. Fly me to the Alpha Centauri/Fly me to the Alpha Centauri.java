import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int k =0;

        for(int i=0; i<T; i++){
            int start = in.nextInt();
            int end = in.nextInt();

            int distance = end - start;


            //

            int a = (int)Math.sqrt(distance);

            if(distance == a*a){
                System.out.println(2*a-1);
            }
            else if( a*a + a >= distance ){
                System.out.println(2*a);
            }

            else{
                System.out.println(2*a +1);
            }

        }

    }
}



