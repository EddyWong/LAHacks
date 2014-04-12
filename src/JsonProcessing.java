import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class JsonProcessing{
static JSONObject jsonobject = new JSONObject();

static JSONObject getJSONArray(URL url) throws IOException, ParseException{
	String JsonString = IOUtils.toString(url);
	JSONObject JsonObject = (JSONObject) JSONValue.parseWithException(JsonString);
    return JsonObject;
}

static JSONArray getJSONArray(String KeyName){
	JSONArray JsonArray = (JSONArray) jsonobject.get(KeyName);
	return JsonArray;
}
	public static void main(String[] args) throws IOException, ParseException{
		JsonProcessing jp = new JsonProcessing();
		MySQLAccess mysql = new MySQLAccess();
		URL url = new URL("https://web-app.usc.edu/web/soc/api/classes/csci/20142");
		jsonobject = jp.getJSONArray(url);
//		System.out.println(jsonobject.toJSONString());
		if(jsonobject!=null){
//			JSONArray ja = jp.getJSONArray("course");
//			JSONObject obj = (JSONObject)ja.get(0);
//			String out = obj.get("PublishedCourseID").toString();
//			String out = jsonobject.get("Dept_Info").toString();
//			System.out.println(out);
			JSONObject OfferedCourses = (JSONObject)jsonobject.get("OfferedCourses");
			JSONArray course = (JSONArray) OfferedCourses.get("course");
//			System.out.println(course.toJSONString());
			JSONObject coursechildren = (JSONObject)course.get(0);
//			System.out.println(coursechildren.toJSONString());
			String ScheduledCourseID = coursechildren.get("ScheduledCourseID").toString();
			System.out.println(ScheduledCourseID);
			mysql.Connect();
			mysql.Insert(9, ScheduledCourseID.toString(), ScheduledCourseID.toString());
			mysql.Close();
			
		}else{
			System.out.println("Error with parsing Json!");
		}

	}
}
