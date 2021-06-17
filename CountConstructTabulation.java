import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class CountConstructTabulation {


    /**
     * Write a function `countConstruct(target, wordBank)` that accepts a
     * target string and an array of strings.
     * 
     * The function should return the number of ways that the `target` can
     * be constructed by concatenating elements of the `wordBank` array.
     * 
     * You may reuse elements of `wordBank` as many times as needed.
     * 
     * m = target.length
     * n = wordBank.length
     * 
     * Time: O(m^2 * n)  Space: O(m)
     */
    static int countConstruct(String target, String[] wordBank) {

        // **** sanity check(s) ****
        if (target.length() == 0) return 0;

        // **** initialization ****
        int[] table = new int[target.length() + 1];
        table[0] = 1;               // seed value

        // ???? ????
        System.out.println("<<< table: " + Arrays.toString(table));

        // **** iterate through the table ****
        for (int i = 0; i < table.length; i++) {

            // **** check if this table entry may NOT contribute ****
            if (table[i] == 0)
                continue;

            // **** traverse the word bank looking for candidates ****
            for (int j = 0; j < wordBank.length; j++) {

                // **** for ease of use ****
                String word = wordBank[j];

                // **** if out of bounds (skip) ****
                if (i + word.length() > target.length())
                    continue;

                // **** extract prefix from target ****
                String prefix = target.substring(i, i + word.length());

                // **** compare word with prefix ****
                boolean match = word.equals(prefix);

                // **** word and prefix match ****
                if (match) {

                    // **** compute index to update ****
                    int ndx = i + word.length();

                    // **** if out of bounds (skip) ****
                    if (ndx >= table.length)
                        continue;

                    // **** update table at specified index ****
                    table[ndx] += table[i];

                    // ???? ????
                    System.out.println("<<< i: " + i + " table: " + Arrays.toString(table));
                }
            }
        }

        // ???? ????
        // System.out.println("<<< table: " + Arrays.toString(table));

        // **** return last table entry ****
        return table[table.length - 1];
    }


    /**
     * This code is for a CS50 question.
     * Has nothing to do with the main subject in this class.
     * 
     * Yes you can use an if() else statament.
     * Need to declare values and perhaps functions.
     */
    static void func () {

        // **** initialization () ****
        int a = 0, 
            b = 0, 
            CN = 0, 
            sum2 = 0, 
            x = 0,         // not used
            y = 0, 
            z = 0;

        do  {
            x = CN % 10;
            CN = CN / 10;
            y = CN % 10;
            z = y * 2;

            // **** if then else statement ****
            if (z > 9)
                {

                // **** are these assignments in th eproper order ****
                // z % 10 = b
                // (z - b) / 10 = a

                sum2 = a + b + sum2;
                }
            else
                {
                sum2 = z + sum2;
                }

        } while (CN > 0);
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read target string ****
        String target = br.readLine().trim();

        // **** read word bank array ****
        String[] wordBank = br.readLine().trim().split(",");

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< target ==>" + target + "<==");
        System.out.println("main <<< wordBank: " + Arrays.toString(wordBank));

        // **** call function of interest and display result ****
        System.out.println("main <<< countConstruct: " + countConstruct(target, wordBank));
    }
}