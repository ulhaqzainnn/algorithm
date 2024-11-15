package Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int[] computePrefixFunction(String pattern) {
        int[] prefix = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }

    private static List<Integer> KMPSearch(String s1, String s2) {
        int[] prefix = computePrefixFunction(s1);
        List<Integer> occurrences = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < s2.length(); i++) {
            while (j > 0 && s2.charAt(i) != s1.charAt(j)) {
                j = prefix[j - 1];
            }
            if (s2.charAt(i) == s1.charAt(j)) {
                j++;
            }
            if (j == s1.length()) {
                occurrences.add(i - j + 2);
                j = prefix[j - 1];
            }
        }
        return occurrences;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();

        List<Integer> occurrences = KMPSearch(s1, s2);

        System.out.println(occurrences.size());

        for (int index : occurrences) {
            System.out.print(index + " ");
        }
        System.out.println();

        scanner.close();
    }
}


