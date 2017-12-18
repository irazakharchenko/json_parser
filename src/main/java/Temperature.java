import org.json.simple.JSONObject;

public class Temperature implements DataFactory {
    String temp ="";
    public String get(JSONObject data) {
        temp = get_main(data).get("temp").toString();
        return temp;
    }

    public JSONObject get_main(JSONObject data){
        return (JSONObject)data.get("main");
    }
    public String last(){
        return temp;
    }
}
