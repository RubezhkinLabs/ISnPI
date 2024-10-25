package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text: ");
        char[] txt = sc.nextLine().toCharArray();

        System.out.println("Enter key: ");
        String key = sc.nextLine();

        char[] res = vigenereCrypt(txt, key);
        System.out.println(res);
        System.out.println(vigenereDeCrypt(res, key));
    }

    static char[] vigenereCrypt(char[] txt, String key) {
        char[] result = txt;
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) ('a' + (((result[i] - 'a') + (key.charAt(i % key.length()) - 'a')) % 26));
        }
        return result;
    }

    static char[] vigenereDeCrypt(char[] txt, String key) {
        char[] result = txt;
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) ('a' + ((26 + (result[i] - 'a') - (key.charAt(i % key.length()) - 'a')) % 26));
        }
        return result;
    }
}