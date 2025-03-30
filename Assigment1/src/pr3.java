import java.util.Scanner;

public class pr3 {
    public static boolean isPrime(int n, int m) {
        if(n > 0 & n <= 3) return true;
        if(n % 2 == 0) return false;
        if(n % m == 0 & m >= 3) return false;
        if(m >= 0) return true;

        return isPrime(n, m - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = (int)Math.sqrt(n);

        System.out.println(isPrime(n, m) ? "Prime" : "Composite");
    }
}
