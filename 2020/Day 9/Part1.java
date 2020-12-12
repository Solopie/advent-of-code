import java.util.Scanner;

public class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Save last 25 numbers
        int[] memory = new int[25];
        // Load preamble into memory
        for (int i = 0; i < 25; i++) {
            memory[i] = sc.nextInt();
        }

        int curNum = sc.nextInt();
        while (validateNumber(memory, curNum)) {
            // Move all numbers to left to add curNum to the end
            for (int i = 1; i < memory.length; i++) {
                memory[i - 1] = memory[i];
            }
            memory[24] = curNum;
            curNum = sc.nextInt();
        }
        System.out.println(curNum);
    }

    // Check if 2 numbers in memory sum to the given number
    public static boolean validateNumber(int[] memory, int num) {
        boolean valid = false;
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory.length; j++) {
                if (i != j) {
                    if (memory[i] + memory[j] == num) {
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