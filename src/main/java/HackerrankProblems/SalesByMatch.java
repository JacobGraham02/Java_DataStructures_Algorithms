package HackerrankProblems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SalesByMatch {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The problem we are trying to figure out is how many pairs of the same integer value there are in the argument list of integers.
     * For example, [10, 20, 20, 10] will return 2 because there are 2 pairs of the same integer value (10 and 20).
     * Create a HashSet because it cannot contain any duplicates. Then, loop through the list of socks and if the HashSet does not contain
     * the specified sock, add that sock to HashSet. If there is another sock of the same colour which is added to the HashSet, remove that specified
     * sock colour from the HashSet to signal a duplicate sock colour.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Set<Integer> socks = new HashSet<>(n);

        int pairs = 0;

        if (n == 1 || n == 0) return 0;

        for (int i = 0; i < n; i++) {
            if (socks.contains(ar.get(i))) {
                pairs++;
                socks.remove(ar.get(i));
            } else {
                socks.add(ar.get(i));
            }
        }

        return pairs;
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SalesByMatch.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
        List<Integer> arrList = Arrays.asList(10, 20, 10, 50, 60, 60, 90, 90, 30, 30);
        System.out.println(sockMerchant(arrList.size(), arrList));
    }
}
