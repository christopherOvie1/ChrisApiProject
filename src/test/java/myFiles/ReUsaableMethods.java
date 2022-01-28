package myFiles;

import io.restassured.path.json.JsonPath;

public class ReUsaableMethods {

	
	public static JsonPath rawToJSon(String Response) {
		
		JsonPath js1= new JsonPath(Response);
		return js1;
	}
}
