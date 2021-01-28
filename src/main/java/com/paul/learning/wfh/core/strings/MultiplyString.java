package com.paul.learning.wfh.core.strings;

public class MultiplyString {

    public static int solution(int D, String S) {
        int result = 0;
            switch (S) {
                case "one":
                    result = D;
                    break;
                case "two":
                    result = D * 2;
                    break;
                case "three":
                    result = D * 3;
                    break;
                case "four":
                    result = D * 4;
                    break;
                case "five":
                    result = D * 5;
                    break;
                default:
                    break;
            }
        return result;
    }
}
