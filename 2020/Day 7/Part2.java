import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Part2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, HashMap<String, Integer>> bags = new HashMap<>();
        while (sc.hasNextLine()) {
            String parentBag = sc.next() + sc.next();
            // bag/bags
            sc.next();
            // contain
            sc.next();
            String childrenBagsLine = sc.nextLine().strip();

            // Nothing to process if there is no children bags
            if (childrenBagsLine.equals("no other bags.")) {
                bags.put(parentBag, new HashMap<String, Integer>());
                continue;
            }

            // Process the children bags
            String[] childrenBagsLineSplit = childrenBagsLine.split(", ");
            HashMap<String, Integer> childrenBags = new HashMap<>();

            // For each child: bagId -> quantity
            for (int i = 0; i < childrenBagsLineSplit.length; i++) {
                String[] splitBagWords = childrenBagsLineSplit[i].split(" ");
                childrenBags.put(splitBagWords[1] + splitBagWords[2], Integer.parseInt(splitBagWords[0]));
            }

            bags.put(parentBag, childrenBags);
        }

        System.out.println(findNumberBagsRequired(bags, "shinygold"));
    }

    public static Integer findNumberBagsRequired(HashMap<String, HashMap<String, Integer>> bags, String target) {
        HashMap<String, Integer> targetBag = bags.get(target);

        // When a bag has no sub bag then we return 0 as we are trying to return the
        // amount of EXTRA bags needed for that bag
        if (targetBag.size() == 0) {
            return 0;
        }

        // Accumulate the sub/children bags
        int total = 0;
        for (Map.Entry<String, Integer> bag : targetBag.entrySet()) {
            // Where the magic happens: (how many of current bag) + (how many of current
            // bag)*(amount of children bags in total for current bag)
            total += bag.getValue() + bag.getValue() * findNumberBagsRequired(bags, bag.getKey());
        }

        return total;
    }
}