import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Description implements DataFactory {
    String desc = "";
    static Description description = new Description();
    ArrayList<JSONObject> array ;
    public String get(JSONObject data) {
        //array = (ArrayList<JSONObject>) get_weather(data);
        return ((JSONObject)((JSONArray)data.get("weather")).get(0)).get("description").toString();
    }


    public String last() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        String city = "Lviv";
        URLReader reader = new URLReader();
        JSONObject data = reader.parser(city);
        System.out.println(description.get(data));
    }
}
