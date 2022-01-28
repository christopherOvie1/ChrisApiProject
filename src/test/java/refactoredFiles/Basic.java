package refactoredFiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import myFiles.Payload;
import myFiles.ReUsaableMethods;

public class Basic {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response= given().queryParam("key", "qaclick123").header("Content-Type","application/json")
			
				.body(Payload.addPlace()).when().post("/maps/api/place/add/json")
			.then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
			System.out.println(response);
			
			JsonPath js= new JsonPath(response);
		String  placeid=	js.getString("place_id");
         System.out.println(placeid);
		
		//update
		String newAddress= "70 Summer walkin, USA";
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				//+ "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				//+ "\"address\":\"70 Summer walkin, USA\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//Get Place

		String getPlaceResponse= given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeid)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1=ReUsaableMethods.rawToJSon(getPlaceResponse);
		String actualAddress=js1.getString("address");
		System.out.println("my address is "+actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
	    
	}
	
}
