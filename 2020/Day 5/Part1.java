import java.util.Scanner;

public class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int maxSeatId = 0;

        while (sc.hasNextLine()) {
            String chars = sc.nextLine();

            int[] rowRange = new int[] { 0, 127 };
            int[] colRange = new int[] { 0, 7 };

            // Calculate row
            for (int i = 0; i < 7; i++) {
                if (chars.charAt(i) == 'F') {
                    rowRange[1] -= (rowRange[1] - rowRange[0] + 1) / 2;
                } else if (chars.charAt(i) == 'B') {
                    rowRange[0] += (rowRange[1] - rowRange[0] + 1) / 2;
                } else {
                    System.out.println("Huh Row");
                }
            }

            // Calculate col
            for (int i = 7; i < 10; i++) {
                if (chars.charAt(i) == 'L') {
                    colRange[1] -= (colRange[1] - colRange[0] + 1) / 2;
                } else if (chars.charAt(i) == 'R') {
                    colRange[0] += (colRange[1] - colRange[0] + 1) / 2;
                } else {
                    System.out.println("Huh Col");
                }
            }

            // Update max seat id if bigger
            maxSeatId = Math.max(rowRange[0] * 8 + colRange[0], maxSeatId);
        }
        System.out.println(maxSeatId);
    }
}
