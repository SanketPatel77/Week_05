package createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSON {
    public static void main(String[] args) {
        // create JSONObject
        JSONObject student = new JSONObject();

        // add properties to json objects
        student.put("Name","Sanket");
        student.put("Age",21);

        // create JSONArray of subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");
        subjects.put("Chemistry");
        student.put("Subjects",subjects);

        // print student object
        System.out.println(student);

    }
}
