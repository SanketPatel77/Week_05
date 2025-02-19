package validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJSON {

    public static void main(String[] args) {
        // data.json file's path
        String filePath = "src/main/java/validatejson/data.json";
        // schema.json file's path
        String schemaPath = "src/main/java/validatejson/schema.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            //Load json schema
            JsonNode schemaNode = objectMapper.readTree(new File(schemaPath));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // load json data
            JsonNode jsonData = objectMapper.readTree(new File(filePath));

            // validate json
            if(schema.validate(jsonData).isSuccess()){
                System.out.println("JSON is valid.");
            }else {
                System.out.println("Invalid JSON!");
            }

        }catch (IOException e){
            System.out.println("Exception occurred : "+e.getMessage());
        } catch (ProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
