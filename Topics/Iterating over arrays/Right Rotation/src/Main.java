import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrString = sc.nextLine();
        int rotate = sc.nextInt();

        int arrSize = 0;
        Scanner strSc = new Scanner(arrString);
        while (strSc.hasNext()) {
            strSc.nextInt();
            arrSize++;
        }

        int[] arr = new int[arrSize];
        strSc = new Scanner(arrString);
        rotate = rotate%arrSize;
        for (int i = 0; i < arrSize; i++) {
            arr[(i + rotate) % arrSize] = strSc.nextInt();
        }

        for (int i = 0; i < arrSize; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}
