
import java.util.Scanner;

public class Foobar1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("" + reId(i));
    }

    private static String reId(int i) {
        StringBuilder str = new StringBuilder();
            int n = 2;
        while (str.length() < i + 5) {
            if (isPrime(n)) {
                str.append(n);
                n=n+1;
            } else {
                n++;
            }
        }
        return str.toString().substring(i, i+5);
    }

    private static boolean isPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if(n%j==0) return false;
        }
        return true;
    }

}
