package com.paul.learning.wfh.core.sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity.
 * If the amount spent by a client on a particular day is greater than or equal to 2x the client's median spending for a trailing number of days,
 * they send the client a notification about potential fraud.
 * The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.
 */
public class FraudulentActivityNotifications {

    private FraudulentActivityNotifications() {
        // Private Constructor
    }

    /**
     * Needs further optimization to pass time constraints. Potential option being using a PriorityQueue.
     *
     * @param expenditure - An array of integers representing daily expenditures
     * @param d           - The look back days for median spending
     * @return The number of fraudulent notifications triggered.
     */
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int expenditureEntries = expenditure.length;

        // Ensure not attempting to sort full list with no trailing days.
        if (d > expenditureEntries) {
            return notifications;
        }

        LinkedList<Integer> processedExpenditure = new LinkedList<>();
        for (int i = 0; i < d; i++) {
            // Add current days expenditure to processing data structure.
            addBinarySearch(processedExpenditure, expenditure[i]);
        }

        // Always adding and removing from list so a fixed size. Index's will remain the same.
        int processingListSize = processedExpenditure.size();
        int middleIndex = (processingListSize - 1) / 2;
        int middleIndexPlusOne = middleIndex + 1;

        // Process trailing days expenditure
        for (int i = d; i < expenditureEntries; i++) {
            int currentDaysExpenditure = expenditure[i];

            if (currentDaysExpenditure <= 200 && currentDaysExpenditure >= 0) {
                // Odd
                double median = processedExpenditure.get(middleIndex);

                // Even
                if (processingListSize % 2 == 0) {
                    double middlePlusOne = processedExpenditure.get(middleIndexPlusOne);
                    // Median is average of two middle values
                    median = (median + middlePlusOne) / 2;
                }

                // Check if notification required.
                if (currentDaysExpenditure >= median * 2) {
                    notifications++;
                }
            } else {
                notifications++;
            }

            // Remove first item from list for processing. Complexity O(1)
            processedExpenditure.removeFirst();

            // Add current days expenditure to processing data structure.
            addBinarySearch(processedExpenditure, currentDaysExpenditure);
        }

        return notifications;
    }

    /**
     * Binary Search Add method for inserting into {@link List}.
     *
     * @param list  - The {@link List} to be processed.
     * @param value - The value to be added.
     */
    public static void addBinarySearch(List<Integer> list, Integer value) {
        int position = Collections.binarySearch(list, value);
        ListIterator<Integer> listIterator = list.listIterator(position < 0 ? -position - 1 : position);
        listIterator.add(value);
    }
}
