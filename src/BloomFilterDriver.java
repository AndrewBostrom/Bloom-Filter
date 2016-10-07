/**
 * Created by Andrew on 4/5/2016.
 */
public class BloomFilterDriver {

    public static void main(String args[]) {
        int M = 6400;
        BloomFilter bloomFilter = new BloomFilter(M);

        LineReader lineReader = new LineReader("src/basic.txt");

        int words = 0;
        while (lineReader.hasNext()) {
            String line = lineReader.next();
            bloomFilter.add(line);
            words++;
        }
        System.out.println(words + " words successfully added");

        System.out.println("Misspelled words:");
        lineReader = new LineReader("src/basic.txt");
        while (lineReader.hasNext()) {
            String line = lineReader.next();
            if (!bloomFilter.isIn(line)) {
                System.out.println(line);
            }
        }

        System.out.println("Accuracy: " + bloomFilter.accuracy());
    }
}

// Output:

// 850 words successfully added
// Misspelled words:
// Accuracy: 0.001028013293300886