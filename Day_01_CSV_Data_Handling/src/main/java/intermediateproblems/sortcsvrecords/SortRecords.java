package intermediateproblems.sortcsvrecords;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SortRecords {
    public static void main(String[] args) {
        // path of csv file
        String filePath = "src/main/java/intermediateproblems/sortcsvrecords/employee.csv";

        try(
//                create object of CSVReader
                CSVReader reader = new CSVReader(new FileReader(filePath));
        )
        {

            String [] line;
            ArrayList<String[]> employeeList = new ArrayList<>();
            // Skip the header
            reader.readNext();
            // Read all records into the list
            while((line = reader.readNext()) != null){
                employeeList.add(line);
            }
            // Sort the list based on the salary column (index 3) in descending order
            employeeList.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3])));

            // Print the top 5 records
            for(int i = 0; i<5;i++){
                String[] data = employeeList.get(i);
                System.out.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println("Invalid CSV "+e.getMessage());
        }
    }
}
