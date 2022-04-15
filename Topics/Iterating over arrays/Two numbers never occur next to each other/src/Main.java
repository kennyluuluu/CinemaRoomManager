import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < size - 1; i++) {
            if (nums[i] == n) {
                if (nums[i + 1] == m) {
                    System.out.print("false");
                    return;
                }
            } else if (nums[i] == m) {
                if (nums[i + 1] == n) {
                    System.out.print("false");
                    return;
                }
            }
        }
        System.out.print("true");
    }
}
