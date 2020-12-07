import java.util.ArrayList;
import java.util.Scanner;

class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
       
        // Store previously scanned numbers to array
        ArrayList<Integer> oldNums = new ArrayList<>();
        while(sc.hasNextInt()) {
            int scannedNum = sc.nextInt();
            // Iterate through all old nums and compare to currently scanned number
            for(Integer oldNum : oldNums) {
                if(scannedNum + oldNum == 2020) {
                    // Print out multiplication of numbers that sum to 2020
                    System.out.println(scannedNum * oldNum);
                    System.exit(0);
                }
            }

            // Add scanned number to old numbers for comparison to future numbers
            oldNums.add(scannedNum);
        }
        System.out.println("Solution not found");
    }
}
