import java.util.Scanner;

public class pr6 {
    public static int power(int a, int b){
        if(b > 1) return a * power(a, b-1);
        else return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(power(n,m));
    }
}
