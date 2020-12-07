import java.util.Scanner;

class Part1 { 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int curX = 0;
        int countTrees = 0;
        // Skip first line and use to get string length
        int lineLength = sc.nextLine().length();

        while(sc.hasNextLine()) {
            String curLine = sc.nextLine();

            // Go back to index 0 when passed line length as grid repeats
            curX = (curX + 3) % lineLength;
            if(curLine.charAt(curX) == '#') {
                countTrees++;
            }
        }

        System.out.println(countTrees);
    }
}
