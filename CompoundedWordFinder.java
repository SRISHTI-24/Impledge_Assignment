import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CompoundedWordFinder {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("C:\\Users\\Admin\\Downloads\\input_02.txt");

        long first = System.currentTimeMillis();

        Scanner s = new Scanner(f);
        List<String> rkwords = new ArrayList<>();
        while (s.hasNextLine())
            rkwords.add(s.nextLine());


        rkwords.sort(Comparator.comparingInt(String::length).reversed());

        Set<String> rkwordSets = new HashSet<>(rkwords);

        String longestrk = findLongestCompoundedWord(rkwords, rkwordSets);
        String secondrkLongest = findSecondLongestCompoundedWord(rkwords, rkwordSets);

        long last = System.currentTimeMillis();
        System.out.println("Longest Compounded Word = " + longestrk);
        System.out.println("Second Longest Compounded Word = " + secondrkLongest);
        System.out.println("Time Taken to Process " + f + " = " + (last - first) + " ms");
    }

    private static String findLongestCompoundedWord(List<String> words, Set<String> setofwords) {
        for (String rkw : words) {
            if (isCompoundedWord(rkw, setofwords)) {
                return rkw;
            }
        }
        return "";
    }

    private static String findSecondLongestCompoundedWord(List<String> rkw, Set<String> setofwords) {
        int count = 0;
        for (String word : rkw) {
            if (isCompoundedWord(word, setofwords)) {
                count++;
                if (count == 2) {
                    return word;
                }
            }
        }
        return "";
    }

    private static boolean isCompoundedWord(String word, Set<String> wordSet) {
        wordSet.remove(word);

        int len = word.length();
        for (int i = 1; i < len; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isCompoundedWord(suffix, wordSet))) {
                return true;
            }
        }

        wordSet.add(word);
        return false;
    }
}
