import java.util.Scanner;

class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int countValid = 0;

        while(sc.hasNextLine()) {
            String[] scannedLine = sc.nextLine().split(" ");
            String[] indexes = scannedLine[0].split("-");
            int lowIndex = Integer.parseInt(indexes[0]) - 1;
            int highIndex = Integer.parseInt(indexes[1]) - 1;
            char policyChar = scannedLine[1].charAt(0);
            String password = scannedLine[2];
            
            // Policy states that exactly 1 char must be the policy char
            if(password.charAt(lowIndex) != password.charAt(highIndex) && (password.charAt(lowIndex) == policyChar || password.charAt(highIndex) == policyChar)) {
                countValid++;
            }
        }

        System.out.println(countValid);
    }
}
