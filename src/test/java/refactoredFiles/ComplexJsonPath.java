package refactoredFiles;

import io.restassured.path.json.JsonPath;
import myFiles.Payload;

public class ComplexJsonPath {

	public static void main(String[] args) {
	
		JsonPath js = new JsonPath(Payload.CoursePrice());
		//get number of courses
	int count =	js.getInt("courses.size()");
	System.out.println("total number counted is "+count);
	
	//print purchased amount
	int totalAmount = js.getInt("dashboard.purchaseAmount");
	System.out.println("the total amount is "+totalAmount);
	
	//print title of first course
String titleFirstCourse=js.get("courses[0].title");
String titleFirstCourse1=js.get("courses[2].title");
System.out.println(titleFirstCourse);
System.out.println(titleFirstCourse1);
	//print all courses title and price
for(int i=0;i<count;i++) {
	String  courseTitle=js.get("courses["+i+"].title");
	System.out.println("the title of the courses are  " +courseTitle);
	//for price
	     // int totalPrice= js.getInt("courses["+i+"].price");
	     // System.out.println(totalPrice);
	System.out.println(js.getInt("courses["+i+"].price".toString()));
	  //  js.getInt("courses["+i+"].copies");
	    System.out.println(js.getInt("courses["+i+"].copies"));
	    //js.getInt("dashboard.purchaseAmount");
	    System.out.println(js.getInt("dashboard.purchaseAmount"));
	    //js.get("dashboard.website")
	    System.out.println( js.get("dashboard.website"));	
}

System.out.println("print number off copies sold by RPA");
for(int i=0; i<count;i++) {
	String myCourseTitle= js.get("courses["+i+"].title");
	if(myCourseTitle.equalsIgnoreCase("RPA")) {
		//RETURN COPIES
	int copies=	js.getInt("courses["+i+"].copies");
	System.out.println(copies);
	break;
	}
}
//for(int i=0;i<count;i++) {
//	
//int cd=	js.getInt("courses["+i+"].copies");
//     if(cd.equals("6"))
//}
	}

}
