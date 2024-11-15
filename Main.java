import java.util.Scanner;

public class Main {

    public static int calculateOverlap(String s) {
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1, j = 0; i < n; ++i) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        StringBuilder output = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            String[] input = scanner.nextLine().split(" ");
            String s = input[0];
            int k = Integer.parseInt(input[1]);

            int lenS = s.length();
            int overlapLen = calculateOverlap(s);

            int minLength = lenS + (k - 1) * (lenS - overlapLen);
            output.append(minLength).append("\n");
        }

        System.out.print(output.toString());

        scanner.close();
    }
}

