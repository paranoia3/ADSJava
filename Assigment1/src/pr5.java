import java.util.Scanner;

public class pr5 {
    public static int fibbo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibbo(n - 1) + fibbo(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibbo(n));
    }
}
