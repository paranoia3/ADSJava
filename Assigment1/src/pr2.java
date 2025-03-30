import java.util.Scanner;

public class pr2 {
    public static double average(int[] arr, int id, double sum){
        if(id == arr.length){
            return sum/arr.length;
        }
        sum += arr[id];
        return average(arr, id + 1, sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(average(arr, 0, 0));
    }
}
