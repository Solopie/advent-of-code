import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Hold the keys for each passport
        ArrayList<HashMap<String, String>> passports = new ArrayList<>();

        HashMap<String, String> curPassportData = new HashMap<>();
        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();

            if (curLine.isEmpty()) {
                // Reset current passport for new passport
                passports.add(curPassportData);
                curPassportData = new HashMap<String, String>();
            } else {
                // Retrieve all data from current line
                ArrayList<String> pairs = new ArrayList<>(Arrays.asList(curLine.split(" ")));
                HashMap<String, String> tempPassportData = new HashMap<>();
                for (String pair : pairs) {
                    String[] pairSplit = pair.split(":");
                    tempPassportData.put(pairSplit[0], pairSplit[1]);
                }
                // Add all data to current passport
                curPassportData.putAll(tempPassportData);
            }
        }

        // Add the last passport
        passports.add(curPassportData);

        // Required keys for valid passport
        ArrayList<String> requiredKeys = new ArrayList<>(
                Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

        // Count how many valid passports
        int countValid = 0;
        for (HashMap<String, String> passport : passports) {
            // Ensure all keys are in the passport
            boolean isValid = true;
            for (String rk : requiredKeys) {
                if (!passport.containsKey(rk)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                countValid++;
            }
        }

        System.out.println(countValid);
    }
}
