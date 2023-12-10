import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        String csvFilePath = "sample.csv";

        String[] wordList = readCSVFile(csvFilePath);

        TopThreeRepeatingwords(wordList, 3);
    }

    private static String[] readCSVFile(String filePath) {
        String[] words = new String[100]; 
        int wordCount = 0;

        try {
            
            Scanner scn = new Scanner(new File(filePath));

            while (scn.hasNextLine() && wordCount < 100) {
                String word = scn.nextLine().trim();
                if (!word.isEmpty()) {
                    words[wordCount++] = word;
                }
            }

            
            scn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return words;
    }

    private static void TopThreeRepeatingwords(String[] words, int topN) {
        if (topN > words.length) {
            topN = words.length;
        }

        String word1 = null, word2 = null, word3 = null;
        int count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                break;
            }

            int currentCount = 1;

            for (int j = i + 1; j < words.length; j++) {
                if (words[j] != null && words[i].equalsIgnoreCase(words[j])) {
                    currentCount++;
                    words[j] = null;
                }
            }

            if (currentCount > count1) {
                count3 = count2;
                word3 = word2;
                count2 = count1;
                word2 = word1;
                count1 = currentCount;
                word1 = words[i];
            } else if (currentCount > count2) {
                count3 = count2;
                word3 = word2;
                count2 = currentCount;
                word2 = words[i];
            } else if (currentCount > count3) {
                count3 = currentCount;
                word3 = words[i];
            }
        }

        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3);
    }
}
