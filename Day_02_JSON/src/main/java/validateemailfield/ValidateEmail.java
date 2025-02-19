package validateemailfield;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateEmail {
    public static void main(String[] args) {
        // Define the  paths for schema and JSON data file
        String schemaPath = "src/main/java/validateemailfield/schema.json";
        String filePath = "src/main/java/validateemailfield/data.json";

        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read and parse the JSON Schema file into a JsonNode
            JsonNode schemaNode = objectMapper.readTree(new File(schemaPath));

            // Create a JSON Schema Factory instance
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

            // Convert the schemaNode to a JsonSchema object
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Read and parse the JSON data file into a JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // Validate the JSON data against the schema
            if (schema.validate(jsonNode).isSuccess()) {
                System.out.println("Valid email");
            } else {
                System.out.println("Invalid email");
            }
        } catch (ProcessingException | IOException e) {
            // Catch and handle exceptions for schema processing and file I/O
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
