package com.example;

public class Main {
    public static void main(String[] args) {
        String str = "шифрование перестановкой ";
        char[] masive = str.toCharArray();
        crypto cr = new crypto();
        System.out.println(masive);
        char[] masive2 = cr.encrypt(masive);
        System.out.println(masive2);
        masive2 = cr.deencrypt(masive2);
        System.out.println(masive2);
    }
}