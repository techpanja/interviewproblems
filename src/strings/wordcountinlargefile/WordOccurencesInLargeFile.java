package strings.wordcountinlargefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Find number of occurences of a word in a large file.
 * Created by: techpanja
 * Created on: 1/14/14
 */
public class WordOccurencesInLargeFile {

    private WordOccurencesInLargeFile() {

    }

    /*
    * InputStreamReader can be used to read files like images, zip etc. Its superclass of FileReader.
    * */
    public static int countWordsBufferedReaderInputStreamReader(String filePath, String searchText) {
        long start = System.currentTimeMillis();
        int counter = 0;
        String path = new File("").getAbsoluteFile().getAbsolutePath() + "//" + filePath;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            counter = readAndCountSearchText(bufferedReader, searchText, counter);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Total time (ms): " + total);
        System.out.println("Count of searchText: " + counter);
        return counter;
    }

    /*
    * FileReader is a sub-class of InputStreamReader. Its used for text files. It uses system default encoding.
    * */
    public static int countWordsBufferedReaderFileReader(String filePath, String searchText) {
        long start = System.currentTimeMillis();
        int counter = 0;
        String path = new File("").getAbsoluteFile().getAbsolutePath() + "\\" + filePath;
        // try-with-resources. We dont have to explicitly close the file using finally block.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            counter = readAndCountSearchText(bufferedReader, searchText, counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Total time (ms): " + total);
        System.out.println("Count of searchText: " + counter);
        return counter;
    }

    /*
    * BufferedReader is a wrapper
    * */
    private static int readAndCountSearchText(BufferedReader bufferedReader, String searchText, int counter) throws IOException {
        String line;
        String token;
        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ().\"");
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                if (token.equalsIgnoreCase(searchText)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        countWordsBufferedReaderFileReader("largefile.txt", "foo");
        countWordsBufferedReaderInputStreamReader("largefile.txt", "foo");
    }
}
