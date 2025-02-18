package basicproblems.readcsvfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {
    public static void main(String[] args) {
        // path of csv file
        String filePath = "src/main/java/basicproblems/readcsvfile/source.csv";

        try(
                // create FileReader and BufferedReader object
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            // line variable to iterate line by line in source file
            String line;
            bufferedReader.readLine(); // skip header
            while((line = bufferedReader.readLine()) != null){
                // create array of data, using split method to split text;
                String [] data = line.split(",");
                // print result
                System.out.println("ID : "+data[0]+", Name : "+data[1]+", Age : "+data[2]+", Marks : "+data[3]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        }
    }
}
