package basicproblems.readandcountrow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRow {
    public static void main(String[] args) {
        // path of csv file
        String filePath = "src/main/java/basicproblems/readandcountrow/data.csv";

        try(
                // create FileReader and BufferedReader object
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            // line variable to iterate line by line in source file
            String line;
            int count = 0; // counter holds number of rows, initially 0
            while((line = bufferedReader.readLine()) != null){
               count++; // for each line count increase
            }

            // print count-1 (after excluding header)
            System.out.println("Total number of rows : "+(count-1));
        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        }
    }
}
