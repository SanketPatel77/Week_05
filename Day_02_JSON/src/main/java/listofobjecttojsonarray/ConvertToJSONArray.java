package listofobjecttojsonarray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class ConvertToJSONArray {
    public static void main(String[] args) {

        // create objects of Employee class
        Employee employee1 = new Employee(101,"Shivam",25000);
        Employee employee2 = new Employee(102,"Yuvraj",50000);
        Employee employee3 = new Employee(103,"Pranav",70000);

        // create list of Employee type
        ArrayList<Employee> listOfEmployees = new ArrayList<>();

        // adding objects to ArrayList
        listOfEmployees.add(employee1);
        listOfEmployees.add(employee2);
        listOfEmployees.add(employee3);

        try{
            // create ObjectMapper object
            ObjectMapper objectMapper = new ObjectMapper();
            // convert java object to json
            String jsonArray  = objectMapper.writeValueAsString(listOfEmployees);
            // print the result
            System.out.println(jsonArray);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
