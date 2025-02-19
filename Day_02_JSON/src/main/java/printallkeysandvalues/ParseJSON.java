package printallkeysandvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParseJSON {
    public static void main(String[] args) {
        // Define the path to the JSON file
        String filePath = "src/main/java/printallkeysandvalues/data.json";

        try {
            // Create an instance of ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file and parse it into a JsonNode object
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // Iterate through the key-value pairs in the JSON object
            jsonNode.fields().forEachRemaining(entry -> {
                // Get the key
                String key = entry.getKey();
                // Get the corresponding value
                JsonNode value = entry.getValue();
                // Print the key-value pair
                System.out.println("Key is :" + key + ", and value is : " + value);
            });

        } catch (IOException e) {
            // Handle any IO exceptions
            throw new RuntimeException(e);
        }
    }
}
