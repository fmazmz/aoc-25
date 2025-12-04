package org.aoc.day3;

import java.util.*;

/**
 * <p>
 * Advent of Code Day 3: Lobby
 * </p>
 * <p>
 * Reads rotations from CLI input (one per line), simulates battery banks, and calculates the total output joltage.
 * </p>
 *
 * <p>Usage:</p>
 * <ul>
 *   <li>javac -d out src/main/java/org/aoc/<day>/<className>.java </li>
 *   <li>java -cp out org.aoc.<day>.<className></li>
 *   <li>Paste raw input from AOC.com::/2025/day/<dayNumber>/input</li>
 * </ul>
 */

public class Day3Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> banks = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            banks.add(line);
        }
        scanner.close();
        int totalOutputJoltage = calculateTotalOutputJoltage(banks);
        System.out.println("Total Output Joltage: " + totalOutputJoltage);
    }

    static int calculateTotalOutputJoltage(List<String> banks) {
        int totalJoltage = 0;

        for (String bank : banks) {
            totalJoltage += getMaxJoltageFromBank(bank);
        }

        return totalJoltage;
    }

    static int getMaxJoltageFromBank(String bank) {
        int maxJoltage = 0;
        int length = bank.length();

        // Compare each pair of digits
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // Create the potential joltage by concatenating two battery values
                String battery1 = String.valueOf(bank.charAt(i));
                String battery2 = String.valueOf(bank.charAt(j));

                // String concat
                String joltageStr = battery1 + battery2;
                int joltage = Integer.parseInt(joltageStr);  // resolve back to int for calculation

                // Update maxJoltage if a larger value is found
                if (joltage > maxJoltage) {
                    maxJoltage = joltage;
                }
            }
        }
        return maxJoltage;
    }

}
