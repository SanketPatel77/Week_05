package mergetwojsonobjects;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;

public class MergeObject {
    public static void main(String[] args) {
        //JSONObject 1
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","Sandeep");
        jsonObject1.put("age",22);

        //JSONObject 2
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("email","sandeep123@gmail.com");
        jsonObject2.put("salary",30000);

        // merging two objects
        for(String key : jsonObject1.keySet()){
            jsonObject2.put(key,jsonObject1.get(key));
        }

        // print the final object
        System.out.println(jsonObject2);
    }
}
