import java.util.Scanner;

public class pr8 {
    public static boolean isOnlyDigits(String s, int id) {
        if (id == s.length()) return true;

        if(!Character.isDigit(s.charAt(id))) return false;
        return isOnlyDigits(s, id + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isOnlyDigits(s, 0) ? "Yes" : "No");
    }
}
