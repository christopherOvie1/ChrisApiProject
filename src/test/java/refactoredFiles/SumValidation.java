package refactoredFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import myFiles.Payload;

public class SumValidation {
	
	int sum =0;
	
	
@Test
public void sumOfCouses() {
	
	JsonPath js = new JsonPath(Payload.CoursePrice());
	int  count=js.getInt("courses.size()");
	for(int i=0; i<count; i++) {
		int price=	js.getInt("courses["+i+"].price");
		int copies=	js.getInt("courses["+i+"].copies");
		
		int amount =price*copies;
		System.out.println(amount);
		sum = sum+amount;
	}
	System.out.println("total sum is "+sum);
	int purchaseAmount=js.getInt("dashboard.purchaseAmount");
	Assert.assertEquals(sum, purchaseAmount);
}
	

}
