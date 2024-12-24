package ADTS;

import java.io.File;
import java.util.*;

public class countUniqueWords {
    public static List<String> getWords(String inputFileName){
        List<String> words = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(inputFileName))) {
            while(sc.hasNext()){
                words.add(sc.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return words;
    }
    public static int countWords(List<String> words){
        Set<String> uniqueWords = new HashSet<>(words);
        uniqueWords.addAll(words);
        return uniqueWords.size();
    }
    public static Map<String,Integer> collectWords(List<String> words,List<String> targets){
        Map<String,Integer> wordCount = new HashMap<>();
        for(String s:targets){
            wordCount.put(s,0);
        }
        for(String s:words){
            if(wordCount.containsKey(s)){
                wordCount.compute(s, (_, count) -> count + 1);
            }
        }
        return wordCount;
    }
}
