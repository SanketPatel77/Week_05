package basicproblems.writedatatocsvfile;

import java.io.*;

public class WriteEmployeeDetails {
    public static void main(String[] args) {
        // path of csv file
        String filePath = "src/main/java/basicproblems/writedatatocsvfile/employee.csv";

        try(
                // create FileWriter and BufferedWriter object
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        )
        {
            // writing data to employee.csv
            bufferedWriter.write("ID,Name,Department,Salary\n");
            bufferedWriter.write("1,Sandeep,Engineering,50000\n");
            bufferedWriter.write("2,Sanket,IT,50000\n");
            bufferedWriter.write("3,Pranav,Sales,60000\n");
            bufferedWriter.write("4,Yuvraj,HR,50000\n");
            bufferedWriter.write("5,Shivam,Engineering,750000\n");

        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        }

    }

}
