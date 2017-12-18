
import java.net.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class URLReader {
    Temperature temperature = new Temperature();
    Visibility visibility = new Visibility();
    Description description = new Description();
    public  JSONObject parser(String city) throws Exception {
        //JSONParser parser = new JSONParser();

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=5496614f4ca95e6dcc0445c1e7f3916d";
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine = in.readLine();
        in.close();
        JSONParser jParser = new JSONParser();
        return (JSONObject) jParser.parse(inputLine);
//        Object obj=JSONValue.parse(inputLine);
//        JSONObject jsonObject = (JSONObject) obj;
//
//        String name = (String) jsonObject.get("weather");
//        double salary = (Double) jsonObject.get("main");
//        long age = (Long) jsonObject.get("age");
//        System.out.println(name+" "+salary+" "+age);
//        System.out.println(name);

    }

    public String getTemp(JSONObject data){

        return temperature.get(data);
    }
    public String getLastTemp(JSONObject data){
        return temperature.last();
    }

    public String getVis(JSONObject data){
        return visibility.get(data);
    }
    public String getLastVis(JSONObject data){
        return visibility.last();
    }

    public String getDes(JSONObject data){
        return description.get(data);
    }

    public static void main(String[] args) throws Exception {
        String city = "Lviv";
        URLReader reader = new URLReader();
        JSONObject data = reader.parser(city);
        System.out.println(data);

        double tempC = Double.parseDouble(reader.getTemp(data)) - 273.15;
        System.out.println("temperature in Kelvin:" + reader.getTemp(data));
        System.out.println("temperature in Celsius:" + tempC);
        System.out.println("visibility" + reader.getVis(data));

    }

}