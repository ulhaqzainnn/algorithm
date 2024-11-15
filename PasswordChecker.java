import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        int K = scanner.nextInt();

        scanner.nextLine();
        String T = scanner.nextLine();

        int count = 0;
        int index = 0;

        while ((index = T.indexOf(s, index)) != -1) {
            count++;
            index += s.length();
        }

        if (count >= K) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
