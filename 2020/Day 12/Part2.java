import java.util.Scanner;
import java.util.Arrays;

public class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] shipPosition = { 0, 0 };
        int degree = 90;

        while (sc.hasNext()) {
            String curInstruction = sc.next();
            char action = curInstruction.charAt(0);
            int value = Integer.parseInt(curInstruction.substring(1, curInstruction.length()));
            switch (action) {
                case 'F':
                    // Move forward dependent on degree
                    switch (degree) {
                        case 90:
                            shipPosition[0] += value;
                            break;
                        case 0:
                            shipPosition[1] += value;
                            break;
                        case 270:
                            shipPosition[0] -= value;
                            break;
                        case 180:
                            shipPosition[1] -= value;
                            break;
                    }
                    break;
                case 'R':
                    degree = (degree + value) % 360;
                    break;
                case 'L':
                    degree = degree - value;
                    if (degree < 0) {
                        degree = 360 + degree;
                    }
                    break;
                case 'E':
                    shipPosition[0] += value;
                    break;
                case 'N':
                    shipPosition[1] += value;
                    break;
                case 'W':
                    shipPosition[0] -= value;
                    break;
                case 'S':
                    shipPosition[1] -= value;
                    break;
            }
        }
        System.out.println(Math.abs(shipPosition[0]) + Math.abs(shipPosition[1]));
    }
}
