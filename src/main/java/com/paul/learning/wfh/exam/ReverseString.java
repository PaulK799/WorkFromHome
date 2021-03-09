package com.paul.learning.wfh.exam;

public class ReverseString {

    public void reverseString(char[] s) {
        int n = s.length / 2;
        for (int i = 0; i < n; i++) {
            char temp  = s[i];
            int swapIndex = s.length - 1 - i;
            s[i] = s[swapIndex];
            s[swapIndex] = temp;
        }
    }
}
