import java.util.ArrayList;
import java.util.Scanner;

class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Store previously scanned numbers to array
        ArrayList<Integer> oldNums = new ArrayList<>();
        while(sc.hasNextInt()) {
            int scannedNum = sc.nextInt();
            // Iterate through all old nums and compare to currently scanned number
            for(int i = 0; i < oldNums.size(); i++) {
                for(int j = 0; j < oldNums.size(); j++) {
                    // Ensure unique indexes (non duplicate)
                    if(i != j) {
                        if(scannedNum + oldNums.get(i) + oldNums.get(j) == 2020) {
                            // Print out multiplication of numbers that sum to 2020
                            System.out.println(scannedNum * oldNums.get(i) * oldNums.get(j));
                            System.exit(0);
                        }
                    }

                }
            }

            // Add scanned number to old numbers for comparison to future numbers
            oldNums.add(scannedNum);
        }
        System.out.println("Solution not found");
    }
}
