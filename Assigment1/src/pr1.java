import java.util.Scanner;

public class pr1 {
    static int findMin(int[] arr, int id, int min){
        //base case
        if(arr.length == id) return min;

        if(arr[id] < min) min = arr[id];

        return findMin(arr, id + 1, min);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int min = findMin(arr, 1, arr[0]);

        System.out.println(min);
    }
}