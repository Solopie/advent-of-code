import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static final int PREAMBLE_LENGTH = 25;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Save all the numbers in a list
        ArrayList<Integer> numbers = new ArrayList<>();
        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }

        // Current number index starts after preamble (25)
        int curNumIndex = PREAMBLE_LENGTH;

        // Find invalid number
        while (validateNumber(numbers.subList(curNumIndex - PREAMBLE_LENGTH, curNumIndex), numbers.get(curNumIndex))) {
            curNumIndex++;
        }

        int invalidNum = numbers.get(curNumIndex);

        // Find contiguous set of at least two numbers that sum up to invalid number
        for (int i = 0; i < numbers.size() - 2; i++) {
            // Start with two elements in sub array
            int subEndIndex = i + 1;
            int subArraySum = numbers.get(i) + numbers.get(i + 1);
            // Save min and max of subarray for result
            int maxNum = numbers.get(i);
            int minNum = numbers.get(i);

            // Grow subarray until sum is less than or equal to invalid number
            while (subArraySum < invalidNum) {
                subEndIndex++;
                if (subEndIndex >= numbers.size()) {
                    break;
                }
                subArraySum += numbers.get(subEndIndex);
                maxNum = Math.max(maxNum, numbers.get(subEndIndex));
                minNum = Math.min(minNum, numbers.get(subEndIndex));
            }

            // Check if we found subarray that sums to invalid number
            if (subArraySum == invalidNum) {
                System.out.println(maxNum + minNum);
                System.exit(0);
            }
        }

        System.out.println("Found nothing");
    }

    // Check if 2 numbers in memory sum to the given number
    public static boolean validateNumber(List<Integer> memory, int num) {
        boolean valid = false;
        for (int i = 0; i < memory.size(); i++) {
            for (int j = 0; j < memory.size(); j++) {
                if (i != j) {
                    if (memory.get(i) + memory.get(j) == num) {
                        valid = true;
                        break;
                    }
                }
            }
            if (valid) {
                break;
            }
        }
        return valid;
    }
}