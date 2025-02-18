package advancedproblems.validatecsvdata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/advancedproblems/validatecsvdata/data.csv";

        // Regex patterns for validation
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
        String phonePattern = "^\\d{10}$";

        // Compile regex patterns
        Pattern emailRegex = Pattern.compile(emailPattern);
        Pattern phoneRegex = Pattern.compile(phonePattern);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // Read and store headers
            String[] line;
            int rowIndex = 0; // Track row index for error messages

            while ((line = reader.readNext()) != null) {
                rowIndex++;
                List<String> errors = new ArrayList<>();

                // Validate email (assuming email is in the second column, index 1)
                if (!emailRegex.matcher(line[1]).matches()) {
                    errors.add("Invalid email format");
                }

                // Validate phone number (assuming phone is in the third column, index 2)
                if (!phoneRegex.matcher(line[2]).matches()) {
                    errors.add("Phone number must be exactly 10 digits");
                }

                // Print invalid rows with error messages
                if (!errors.isEmpty()) {
                    System.out.println("Row " + rowIndex + " is invalid: " + String.join(", ", errors));
                    System.out.println("Data: " + String.join(", ", line));
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println("CSV Validation Exception: " + e.getMessage());
        }
    }
}