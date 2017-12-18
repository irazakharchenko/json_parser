import org.json.simple.JSONObject;

public class Visibility implements DataFactory {
    String vis ="";
    public String get(JSONObject data) {
        vis = data.get("visibility").toString();
        return vis;
    }

    public String last() {
        return vis;
    }
}
