import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> instructions = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        while (sc.hasNextLine()) {
            instructions.add(sc.next());
            values.add(Integer.parseInt(sc.next()));
        }

        // Instruction pointer
        int ip = 0;
        int accumulator = 0;
        HashSet<Integer> visited = new HashSet<>();

        // Brute force every jmp instruction and test if changing to nop works
        for (int i = 0; i < instructions.size(); i++) {
            // Run code till program finished or instruction is visited again
            if (instructions.get(i).equals("jmp")) {
                instructions.set(i, "nop");

                while (ip < instructions.size() && !visited.contains(ip)) {
                    visited.add(ip);
                    switch (instructions.get(ip)) {
                        case "nop":
                            ip++;
                            break;
                        case "jmp":
                            ip += values.get(ip);
                            break;
                        case "acc":
                            accumulator += values.get(ip);
                            ip++;
                            break;
                    }
                }

                // Found answer when we have reached the end of the program which is when ip
                // surpasses last instruction in file
                if (ip >= instructions.size()) {
                    System.out.println(accumulator);
                    break;
                } else {
                    // Reset everything for next attempt
                    visited.clear();
                    ip = 0;
                    accumulator = 0;
                    instructions.set(i, "jmp");
                }
            }
        }
    }
}
