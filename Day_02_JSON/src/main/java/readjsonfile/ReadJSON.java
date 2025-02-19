package readjsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJSON {
    public static void main(String[] args) {
        // path of data.json
        String filePath = "src/main/java/readjsonfile/data.json";

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            // JsonNode to read json file
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // print name from json
            System.out.println(jsonNode.get("name"));

            // print email from json
            System.out.println(jsonNode.get("email"));
        }catch (IOException e){
            System.out.println("Exception occurred : "+e.getMessage());
        }
    }
}
