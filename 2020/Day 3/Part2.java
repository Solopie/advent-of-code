import java.util.Scanner;
import java.util.Arrays;

class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Pre-defined slopes
        int[][] slopes = new int[5][2];
        slopes[0] = new int[] { 1, 1 };
        slopes[1] = new int[] { 3, 1 };
        slopes[2] = new int[] { 5, 1 };
        slopes[3] = new int[] { 7, 1 };
        slopes[4] = new int[] { 1, 2 };

        // Positions for each slope
        int[] curX = new int[5];
        for (int i = 0; i < curX.length; i++) {
            curX[i] = 0;
        }
        // Start at 1 as we skipped the first line
        int curY = 1;
        // Answers for different slopes
        int[] countTrees = new int[5];
        for (int i = 0; i < countTrees.length; i++) {
            countTrees[i] = 0;
        }
        // Skip first line and use to get string length
        int lineLength = sc.nextLine().length();

        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();

            // Check tree for each slope
            for (int i = 0; i < slopes.length; i++) {
                // Ensure that we check at the correct y level for each defined slope
                if (curY % slopes[i][1] == 0) {
                    // Go back to index 0 when passed line length as grid repeats
                    curX[i] = (curX[i] + slopes[i][0]) % lineLength;

                    // Check if position is at a tree
                    if (curLine.charAt(curX[i]) == '#') {
                        countTrees[i]++;
                    }
                }
            }

            curY++;
        }

        // Multiply the tree counts for each slope
        long result = countTrees[0];
        for (int i = 1; i < countTrees.length; i++) {
            result *= countTrees[i];
        }
        System.out.println(result);
        System.out.println(Arrays.toString(countTrees));
    }
}
