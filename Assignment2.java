import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
     
        Scanner scn = new Scanner(System.in);

        ArrayList<String> KList = new ArrayList<>();
        HashSet<String> KSet = new HashSet<>();
        HashMap<String, Integer> KMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            String input = scn.nextLine();
            KList.add(input);
            KSet.add(input);
            KMap.put(input, KMap.getOrDefault(input, 0) + 1);
        }

        scn.close();

        System.out.println("\nList Contains:\n");
        for (String str : KList) {
            System.out.println(str);
        }

        System.out.println("\nSet Contains:\n");
        for (String str : KSet) {
            System.out.println(str);
        }

        System.out.println("\nFrequency of the words:\n");
        for (Map.Entry<String, Integer> entry : KMap.entrySet()) {
            System.out.println("Word = " + entry.getKey() + ", Frequency = " + entry.getValue());
        }
    }
}
