package intermediateproblems.modifycsvfile;

import java.io.*;

public class ModifyFile {
    public static void main(String[] args) {
        // path of csv file
        String filePath = "src/main/java/intermediateproblems/modifycsvfile/employee.csv";
        String destinationPath = "src/main/java/intermediateproblems/modifycsvfile/updatedEmployee.csv";

        try(
                // create FileReader and BufferedReader object
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(destinationPath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        )
        {
            // line variable to iterate line by line in source file
            String line;
            // skip header
            bufferedReader.readLine();
            // adding header
            bufferedWriter.write("ID,Name,Department,Salary\n");
            while((line = bufferedReader.readLine()) != null){
                // create array of data, using split method to split text;
                String [] data = line.split(",");
                // check if employee is available
                if(data[2].equalsIgnoreCase("IT")){
                    int salary = Integer.parseInt(data[3]); // ex
                    salary += (salary * 10 ) / 100;
                    bufferedWriter.write(data[0]+","+data[1]+","+data[2]+","+salary+"\n");
                }
                else{
                    bufferedWriter.write(data[0]+","+data[1]+","+data[2]+","+data[3]+"\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception "+e.getMessage());
        }
    }
}
