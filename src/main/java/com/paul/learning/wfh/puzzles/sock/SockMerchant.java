package com.paul.learning.wfh.puzzles.sock;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    // Complete the sockMerchant function below.
    public int sockMerchant(int n, int[] ar) {
        int totalSocks=0;
        Map<Integer, Integer> sockCountMap = new HashMap<>();
        // Sum up count of each sock.
        for (int sock : ar) {
            if (sockCountMap.containsKey(sock)) {
                Integer count = sockCountMap.get(sock) + 1;
                sockCountMap.put(sock, count);
            } else {
                sockCountMap.put(sock, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : sockCountMap.entrySet()) {
            int value = entry.getValue()/ 2;
            totalSocks += value;
        }

        return totalSocks;
    }
}
