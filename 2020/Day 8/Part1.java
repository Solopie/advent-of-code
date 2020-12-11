import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Part1 {
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

        // Run code till instruction is visited again
        while (!visited.contains(ip)) {
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

        System.out.println(accumulator);
    }
}
