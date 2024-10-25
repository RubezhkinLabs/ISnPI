package com.example;

public class Main {
    public static void main(String[] args) {
        char[] txt = "brian".toCharArray();
        int p = 13;
        int q = 19;

        int[] keys = getKeys(p, q);

        int n = keys[0];
        int ph = keys[1];
        int e = keys[2];
        int d = keys[3];

        System.out.println(txt);
        System.out.println("p: " + p + " q: " + q);
        System.out.println("n: " + n + " ph: " + ph + " e: " + e + " d: " + d);

        int[] cryptedText = code(charToInt(txt), e, n);
        printArr(cryptedText);

        int[] res = decode(cryptedText, d, n);
        printArr(res);
        System.out.println(intToChars(res));
    }

    static int[] getKeys(int p, int q) {
        int[] res = new int[4];
        res[0] = p * q;
        res[1] = (p - 1) * (q - 1);
        int e = 2;
        boolean flag = false;
        while (!flag) {
            for (int i = 2; i <= Math.sqrt(e); i++) {
                if (e % i == 0) {
                    e++;
                    i = 2;
                }
            }
            if (euclideanAlgorithm(res[1], e) == 1) {
                flag = true;
            } else {
                e++;
            }
        }
        res[2] = e;
        int d = 2;
        while ((e * d) % res[1] != 1) {
            d++;
        }
        res[3] = d;
        return res;
    }

    static int euclideanAlgorithm(int n1, int n2) {
        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        return Math.max(n1, n2);
    }

    static int[] code(int[] txt, int e, int n) {
        int[] res = new int[txt.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = txt[i];
            for (int j = 1; j < e; j++) {
                res[i] = (res[i] * txt[i]) % n;
            }
        }
        return res;
    }

    static int[] decode(int[] txt, int d, int n) {
        int[] res = new int[txt.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = txt[i];
            for (int j = 1; j < d; j++) {
                res[i] = res[i] * txt[i] % n;
            }
        }
        return res;
    }

    static int[] charToInt(char[] txt) {
        int[] res = new int[txt.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = txt[i] - 'a' + 1;
        }
        return res;
    }

    static char[] intToChars(int[] arr) {
        char[] res = new char[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (char) (arr[i] - 1 + 'a');
        }
        return res;
    }

    static void printArr(int[] arr){
        System.out.print("{ ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
    }
}