package myFiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test(dataProvider="BookData")
	public void addBook(String aisle,String isbn) {
		RestAssured.baseURI= "http://216.10.245.166";
	
	String response=given().log().all().header("Content-Type","application/json")
			//("Content-Type","application/json")
		.body(Payload.addBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().statusCode(200)
		.extract().response().asString();
	
	          JsonPath js=ReUsaableMethods.rawToJSon(response);
	       String id= js.get("ID");
	       System.out.println(id);
	        		  }
//array  collection of eklements
	//muiltidimension array= colection of array
	@DataProvider(name = "BookData")
	public Object[][] getData() {
	return	new Object [][] { {"uhuu","3432"}, {"rtre","4543"},  {"yutr", "5654"} };
	}
}
