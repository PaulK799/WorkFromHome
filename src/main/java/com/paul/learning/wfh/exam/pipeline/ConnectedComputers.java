package com.paul.learning.wfh.exam.pipeline;

import java.util.HashMap;
import java.util.Map;

/**
 * There are "n" computers numbered from "0" to "n-1" connected by ethernet cables connections forming a network.
 * Where "connections[i] = [a, b]" represents a connection between computers a and b.
 * Any computer can reach any other computer directly or indirectly through the network.
 * <p>
 * Given an initial computer network "connections".
 * You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it's not possible, return "-1".
 */
public class ConnectedComputers {

    /**
     *
     */
    private ConnectedComputers() {
        // Private Constructor.
    }

    /**
     * You can extract certain cables between two directly connected computers,
     * and place them between any pair of disconnected computers to make them directly connected.
     * Return the minimum number of times you need to do this in order to make all the computers connected.
     * If it's not possible, return "-1".
     *
     * @param n           - The number of nodes in the network.
     * @param connections - The connected network.
     * @return The minimum number of times you need to remove cables to connect the full network.
     */
    public static int makeConnected(int n, int[][] connections) {
        int unmapped = 0;
        int cables = 0;

        Map<Integer, Integer> connectionMap = new HashMap<>();
        // Initialize a map of nodes.
        // Value = index initially.
        for (int index = 0; index < n; index++) {
            connectionMap.put(index, index);
        }

        // Iterate through each node connection.
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            // Check if the current node connection creates a union.
            boolean isUnionExist = isUnion(from, to, connectionMap);
            if (isUnionExist) {
                // Spare cable exists.
                cables++;
            }
        }

        // Count all of the unmapped nodes.
        for (int index = 0; index < n; index++) {
            int valueAtIndex = getValue(index, connectionMap);
            if (valueAtIndex == index) {
                unmapped++;
            }
        }

        // Spare cables exceeds the unmapped nodes - 1
        if (cables >= unmapped - 1) {
            return unmapped - 1;
        } else {
            // Not enough cables to link all nodes.
            return -1;
        }
    }

    /**
     * Check if a union exists between a connection.
     *
     * @param from          - The index of the from node to be processed.
     * @param to            - The index of the to node to be processed.
     * @param connectionMap - A map of connections.
     * @return A boolean indicating if a union exists for the requested connection.
     */
    private static boolean isUnion(int from, int to, Map<Integer, Integer> connectionMap) {
        int findFrom = getValue(from, connectionMap);
        int findTo = getValue(to, connectionMap);

        // If "from" doesn't match the "to".
        if (findFrom != findTo) {
            // Get connected node in the from node.
            int fromValue = connectionMap.get(from);
            // Get connected node in the to node.
            int toValue = connectionMap.get(to);

            // Update the "from" node value to the "to" value.
            connectionMap.put(fromValue, toValue);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets the value stored at the given node location.
     *
     * @param value         - The value being requested.
     * @param connectionMap - A map of all node connections.
     * @return The value stored at the given location.
     */
    private static int getValue(int value, Map<Integer, Integer> connectionMap) {
        // Get value at the location being requested.
        int nodeValue = connectionMap.get(value);

        // Node connection at location is not the index.
        if (nodeValue != value) {
            // Recursively iterate through the "connectionMap" map until the Node Value == the expected value.
            int findValue = getValue(nodeValue, connectionMap);
            // Update connection map at [value] with the value stored in the location.
            connectionMap.put(value, findValue);
        }

        return connectionMap.get(value);
    }
}
