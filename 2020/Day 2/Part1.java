import java.util.Scanner;

class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int countValid = 0;
        
        while(sc.hasNextLine()) {
            String[] scannedLine = sc.nextLine().split(" ");
            String[] range = scannedLine[0].split("-");
            int min = Integer.parseInt(range[0]);
            int max = Integer.parseInt(range[1]);
            char policyChar = scannedLine[1].charAt(0);
            String password = scannedLine[2];

            // Count number of occurences of the character restricted by policy
            int policyCharCount = 0;
            for(int i = 0; i < password.length(); i++) {
                if(password.charAt(i) == policyChar) {
                    policyCharCount++;

                    // Break out early if we've already passed the max for the policy
                    if(policyCharCount > max) {
                        break;
                    }
                }
            }

            // Ensure password meets policy
            if(policyCharCount <= max && policyCharCount >= min) {
                countValid++;
            }
        }

        System.out.println(countValid);
    }
}
