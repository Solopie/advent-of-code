import java.util.Scanner;
import java.util.Arrays;

class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String firstLine = sc.nextLine();
        char[][] chairs = new char[firstLine.length()][firstLine.length()];

        chairs[0] = firstLine.toCharArray();

        int rowIndex = 1;

        while (sc.hasNextLine()) {
            chairs[rowIndex] = sc.nextLine().toCharArray();
            rowIndex++;
        }

        // Change state until the state doesn't change
        // Old state | current state | new state
        //
        // Initial: 0 | A | B
        // ? A == B
        // 0: A | B | C
        // ? B == C
        // 1: B | C | D

        char[][][] chairsStates = new char[3][firstLine.length()][firstLine.length()];

        // 1st state will be the old state, 2nd state will be the current state and 3rd
        // state is the future state
        chairsStates[1] = chairs;
        chairsStates[2] = createNewState(chairs);

        // First loop doesn't matter because old state will be empty array
        while (!Arrays.deepEquals(chairsStates[1], chairsStates[2])) {
            chairsStates[0] = chairsStates[1];
            chairsStates[1] = chairsStates[2];

            // New state is at index 2
            chairsStates[2] = createNewState(chairsStates[1]);
        }

        // Count how many seats are occupied in the future state as it is equal to the
        // old state
        int countOccupied = 0;
        for (int i = 0; i < chairsStates[2].length; i++) {
            for (int j = 0; j < chairsStates[2][i].length; j++) {
                if (chairsStates[2][i][j] == '#') {
                    countOccupied++;
                }
            }
        }
        System.out.println(countOccupied);

    }

    public static char[][] createNewState(char[][] chairs) {
        char[][] newState = new char[chairs.length][chairs.length];

        // Deep copy for new state
        for (int i = 0; i < newState.length; i++) {
            for (int j = 0; j < newState[i].length; j++) {
                newState[i][j] = chairs[i][j];
            }
        }

        for (int i = 0; i < chairs.length; i++) {
            for (int j = 0; j < chairs[i].length; j++) {
                if (chairs[i][j] == 'L') {
                    // Check if seats are occupied around it if 'L'
                    boolean valid = true;
                    // Top
                    if (i - 1 >= 0) {
                        // Top-left
                        if (j - 1 >= 0) {
                            if (chairs[i - 1][j - 1] == '#') {
                                valid = false;
                            }
                        }
                        // Top-right
                        if (j + 1 < chairs[i].length) {
                            if (chairs[i - 1][j + 1] == '#') {
                                valid = false;
                            }
                        }
                        // Top-middle
                        if (chairs[i - 1][j] == '#') {
                            valid = false;
                        }
                    }
                    // Bottom
                    if (i + 1 < chairs.length) {
                        // Bot-left
                        if (j - 1 >= 0) {
                            if (chairs[i + 1][j - 1] == '#') {
                                valid = false;
                            }
                        }
                        // Bot-right
                        if (j + 1 < chairs[i].length) {
                            if (chairs[i + 1][j + 1] == '#') {
                                valid = false;
                            }
                        }
                        // Bot-middle
                        if (chairs[i + 1][j] == '#') {
                            valid = false;
                        }
                    }
                    // Middle
                    // Middle-left
                    if (j - 1 >= 0) {
                        if (chairs[i][j - 1] == '#') {
                            valid = false;
                        }
                    }
                    // Middle-right
                    if (j + 1 < chairs[i].length) {
                        if (chairs[i][j + 1] == '#') {
                            valid = false;
                        }
                    }
                    // Middle-middle is not adjacent
                    // Occupy seat if valid
                    if (valid) {
                        newState[i][j] = '#';
                    }
                } else if (chairs[i][j] == '#') {
                    // Count amount of seats occuppied adjacent
                    int countOccupied = 0;
                    // Top
                    if (i - 1 >= 0) {
                        // Top-left
                        if (j - 1 >= 0) {
                            if (chairs[i - 1][j - 1] == '#') {
                                countOccupied++;
                            }
                        }
                        // Top-right
                        if (j + 1 < chairs[i].length) {
                            if (chairs[i - 1][j + 1] == '#') {
                                countOccupied++;
                            }
                        }
                        // Top-middle
                        if (chairs[i - 1][j] == '#') {
                            countOccupied++;
                        }
                    }
                    // Bottom
                    if (i + 1 < chairs.length) {
                        // Bot-left
                        if (j - 1 >= 0) {
                            if (chairs[i + 1][j - 1] == '#') {
                                countOccupied++;
                            }
                        }
                        // Bot-right
                        if (j + 1 < chairs[i].length) {
                            if (chairs[i + 1][j + 1] == '#') {
                                countOccupied++;
                            }
                        }
                        // Bot-middle
                        if (chairs[i + 1][j] == '#') {
                            countOccupied++;
                        }
                    }
                    // Middle
                    // Middle-left
                    if (j - 1 >= 0) {
                        if (chairs[i][j - 1] == '#') {
                            countOccupied++;
                        }
                    }
                    // Middle-right
                    if (j + 1 < chairs[i].length) {
                        if (chairs[i][j + 1] == '#') {
                            countOccupied++;
                        }
                    }
                    // Middle-middle is not adjacent

                    // If 4 occupied adjacent empty seat
                    if (countOccupied >= 4) {
                        newState[i][j] = 'L';
                    }
                }
            }
        }
        return newState;
    }
}