import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int seats = sc.nextInt();
        int[][] cinema = new int[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            int j = 0;
            while (j < seats) {
                if (cinema[i][j] == 0) {
                    int consecutive = 0;
                    while (j < seats && cinema[i][j] == 0) {
                        consecutive++;
                        j++;
                    }
                    if (consecutive >= k) {
                        System.out.print(i + 1);
                        return;
                    }
                } else {
                    j++;
                }
            }
        }
        System.out.print(0);
    }
}
