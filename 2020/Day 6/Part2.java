import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Sum of how many questions everyone said yes for each group
        int result = 0;
        // Count number of people for each group
        int numPeople = 0;

        // Count how many times question has been answered with "yes"
        HashMap<Character, Integer> questionCounts = new HashMap<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();

            // When empty, check how many questions all members of group said "yes" and
            // clear questionCounts
            if (str.isEmpty()) {
                for (Integer count : questionCounts.values()) {
                    if (count == numPeople) {
                        result++;
                    }
                }
                numPeople = 0;
                questionCounts.clear();
            } else {
                // For each person, add their answers to counts
                for (int i = 0; i < str.length(); i++) {
                    questionCounts.put(str.charAt(i), questionCounts.getOrDefault(str.charAt(i), 0) + 1);
                }

                numPeople++;
            }
        }

        // Calculate for last group
        for (Integer count : questionCounts.values()) {
            if (count == numPeople) {
                result++;
            }
        }

        System.out.println(result);
    }
}
