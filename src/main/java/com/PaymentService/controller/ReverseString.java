
package com.PaymentService.controller;

import java.util.Objects;

public class ReverseString {
    /*
     @INFO I am proficient in Java, so I solved the problem using Java. But I know Python Basic.
     */
    public static void main(String[] args) {
        String s = "Hello     World ".trim();
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Objects.equals(arr[i], "")) {
                continue;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
