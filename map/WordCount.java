package map;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args)
    {
        try {
            System.out.println("Most common word is: " + maxWord("textfile.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String maxWord(String filePath) throws IOException {
        Scanner in = new Scanner(new FileReader(filePath)).useDelimiter("[^a-zA-Z]+");
        Map<String, Integer> freqMap = new ProbeHashMap<>(19);
        while(in.hasNext()) //fill in map
        {
            String word = in.next().toLowerCase();
            Integer count = freqMap.get(word);
            if(count==null) count=0;
            freqMap.put(word, ++count);
        }
        in.close();

        //find most frequent
        int maxCount = 0;
        String maxWord = "(no word)";
        for(Entry<String, Integer> entry: freqMap.entrySet())
        {
            if(entry.getValue() > maxCount) {
                maxWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxWord;
    }

}
