package parsejson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParseAndFilterJSON {
    public static void main(String[] args) {
        // path of json file
        String filePath = "src/main/java/parsejson/employee.json";

        try{
            // create object
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(filePath)); // read json file
            // iterate array of objects
            for (JsonNode data : jsonNode){
                // extract age from every object
                int age = data.get("age").asInt();
                // compare age and print result
                if(age > 25){
                    System.out.println(data);
                }
            }
        } catch (JsonProcessingException e) {
            System.out.println("Exception occurred: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
