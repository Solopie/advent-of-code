import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Part1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, HashSet<String>> bags = new HashMap<>();
        while (sc.hasNextLine()) {
            String parentBag = sc.next() + sc.next();
            // bag/bags
            sc.next();
            // contain
            sc.next();
            String childrenBagsLine = sc.nextLine().strip();

            // Nothing to process if there is no children bags
            if (childrenBagsLine.equals("no other bags.")) {
                bags.put(parentBag, new HashSet<String>());
                continue;
            }
            String[] childrenBags = childrenBagsLine.split(", ");

            for (int i = 0; i < childrenBags.length; i++) {
                String[] splitBagWords = childrenBags[i].split(" ");
                childrenBags[i] = splitBagWords[1] + splitBagWords[2];
            }

            // For a parent bag we map to it's children
            bags.put(parentBag, new HashSet<String>(Arrays.asList(childrenBags)));
        }

        // Find how many ways the shiny gold bag can be stored
        HashSet<String> possibleBags = getPossibleBags(bags, "shinygold", new HashSet<String>());

        System.out.println(possibleBags.size());

    }

    public static HashSet<String> getPossibleBags(HashMap<String, HashSet<String>> bags, String target,
            HashSet<String> used) {
        // Return count for the target

        HashSet<String> possibleBags = new HashSet<>();
        for (Map.Entry<String, HashSet<String>> bag : bags.entrySet()) {
            if (!used.contains(bag.getKey()) && bag.getValue().contains(target)) {
                possibleBags.add(bag.getKey());
                possibleBags.addAll(getPossibleBags(bags, bag.getKey(), possibleBags));
            }
        }
        return possibleBags;
    }
}