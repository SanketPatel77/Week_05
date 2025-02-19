package convertjavaobjecttojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // create object of Car class
        Car car = new Car("Baleno","1000cc","Petrol");

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            // convert Java object to json
            String jsonString = objectMapper.writeValueAsString(car);
            // print json
            System.out.println(jsonString);
        }catch (IOException e){
            System.out.println("Exception occurred : "+e.getMessage());
        }
    }
}
