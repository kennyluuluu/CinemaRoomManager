import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prev = sc.next();
        while(sc.hasNext()) {
            String next = sc.next();
            if(prev.compareTo(next) > 0) {
                System.out.print("false");
                return;
            }
            prev = next;
        }
        System.out.print("true");
    }
}