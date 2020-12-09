import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class Part2 {
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

            // Key value validation
            for (Map.Entry<String, String> field : passport.entrySet()) {
                switch (field.getKey()) {
                    case "byr":
                        // Ensure valid number
                        try {
                            int year = Integer.parseInt(field.getValue());
                            // Ensure number is within range
                            if (year < 1920 || year > 2002) {
                                isValid = false;
                            }
                        } catch (Exception e) {
                            isValid = false;
                        }
                        break;
                    case "iyr":
                        // Ensure valid number
                        try {
                            int year = Integer.parseInt(field.getValue());
                            // Ensure number is within range
                            if (year < 2010 || year > 2020) {
                                isValid = false;
                            }
                        } catch (Exception e) {
                            isValid = false;
                        }
                        break;
                    case "eyr":
                        // Ensure valid number
                        try {
                            int year = Integer.parseInt(field.getValue());
                            // Ensure number is within range
                            if (year < 2020 || year > 2030) {
                                isValid = false;
                            }
                        } catch (Exception e) {
                            isValid = false;
                        }
                        break;
                    case "hgt":
                        // Ensure there is enough characters for measurement type to be checked
                        if (field.getValue().length() < 3) {
                            isValid = false;
                            break;
                        }
                        // Get the measurement type
                        String measurement = field.getValue().substring(field.getValue().length() - 2,
                                field.getValue().length());

                        // Ensure number is a valid number
                        try {
                            // Get the measurement value
                            int number = Integer.parseInt(field.getValue().substring(0, field.getValue().length() - 2));

                            // Ensure measurement type is either "cm" or "in" and within specified number
                            // range
                            if (measurement.equals("cm")) {
                                if (number < 150 || number > 193) {
                                    isValid = false;
                                    break;
                                }
                            } else if (measurement.equals("in")) {
                                if (number < 59 || number > 76) {
                                    isValid = false;
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            isValid = false;
                            break;
                        }
                        break;
                    case "hcl":
                        if (field.getValue().length() != 7) {
                            isValid = false;
                            break;
                        }

                        // First character must be a '#'
                        if (field.getValue().charAt(0) != '#') {
                            isValid = false;
                            break;
                        }

                        // Validate each character is between '0' - '9' or 'a' - 'f'
                        String chars = field.getValue().substring(1, field.getValue().length());
                        for (int i = 0; i < chars.length(); i++) {
                            if (!((int) chars.charAt(i) >= 48 && (int) chars.charAt(i) <= 57)
                                    && !(chars.charAt(i) >= 97 && chars.charAt(i) <= 102)) {
                                isValid = false;
                                break;
                            }
                        }

                        break;
                    case "ecl":
                        // Check eye colour is a specified valid eye colour
                        ArrayList<String> validEyeColours = new ArrayList<>(
                                Arrays.asList(new String[] { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" }));
                        if (!validEyeColours.contains(field.getValue())) {
                            isValid = false;
                        }
                        break;
                    case "pid":
                        // Ensure length of number is 9
                        if (field.getValue().length() != 9) {
                            isValid = false;
                            break;
                        }

                        // Ensure it is a valid number
                        try {
                            Integer.parseInt(field.getValue());
                        } catch (Exception e) {
                            isValid = false;
                            break;
                        }
                        break;
                }
            }

            // Check if passport is valid
            if (isValid) {
                countValid++;
            }
        }

        System.out.println(countValid);
    }
}
