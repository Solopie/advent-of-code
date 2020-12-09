import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> seatIds = new ArrayList<>();

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
            seatIds.add(rowRange[0] * 8 + colRange[0]);
        }

        Collections.sort(seatIds);

        for (int i = 0; i < seatIds.size() - 1; i++) {
            if (seatIds.get(i + 1) - seatIds.get(i) != 1) {
                System.out.println(seatIds.get(i) + " " + seatIds.get(i + 1));
            }
        }
    }
}
