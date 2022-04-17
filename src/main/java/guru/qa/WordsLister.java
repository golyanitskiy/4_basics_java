package guru.qa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsLister {

     public static List<String> lister() {

        List<String> sufferList = new LinkedList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/voyna.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\s\\S*страда\\S+[^а-я]", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String sufferWord = line.substring(matcher.start(), matcher.end())
                            .trim()
                            .replaceAll("[^а-я]", "");
                    sufferList.add(sufferWord);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return sufferList;
    }
}