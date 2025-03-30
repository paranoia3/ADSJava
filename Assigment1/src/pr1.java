import java.util.Scanner;

public class pr1 {
    static int findMin(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[0] > arr[i]){
                arr[0] = arr[i];
            }
        }
        return arr[0];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = findMin(arr);
        System.out.println(min);
    }
}