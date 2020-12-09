import java.util.Scanner;
import java.util.HashSet;

public class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int yesCount = 0;

        // Hold a hashset for each group
        HashSet<Character> chars = new HashSet<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();

            // When empty, we have finished the group answers so add to count and reset
            // chars for new group
            if (str.isEmpty()) {
                yesCount += chars.size();
                chars.clear();
            } else {
                // Add the questions answered yes for current group
                for (int i = 0; i < str.length(); i++) {
                    chars.add(str.charAt(i));
                }
            }
        }

        // Add last group
        yesCount += chars.size();

        System.out.println(yesCount);
    }
}
