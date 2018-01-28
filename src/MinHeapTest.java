
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author OMER
 */
public class MinHeapTest {

    public static void main(String[] args) {
        MinHeap minHeap = minHeapCreator();

        for (int i = 1; i < minHeap.size; i++) {
            System.out.println(minHeap.getMinValue());
        }

    }

    public static MinHeap minHeapCreator() {
        MinHeap minHeap = null;

        try {
            FileReader fileReader = new FileReader("data/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> lineArray = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                lineArray.add(line);
                line = bufferedReader.readLine();
            }

            minHeap = new MinHeap(lineArray.size());

            for (String str : lineArray) {
                int data = Integer.parseInt(str);
                minHeap.insertData(data);

            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return minHeap;
    }

}
