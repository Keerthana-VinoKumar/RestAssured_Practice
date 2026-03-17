package Day1;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class DifferentMethods {
	public static void main(String[] args) {
		
	
	//status code validation - GET Method
	//Gets Single User
		System.out.println("----------------GET METHOD-----------------");
	given().baseUri("https://jsonplaceholder.typicode.com")
	.contentType(ContentType.JSON)
	.when().get("/users/1")
	.then().log().status()
	.statusCode(200); // this will check only status code - whether 200 is returned
	
	//status code validation - POST Method
	System.out.println("-------------POST METHOD----------------");
	given().baseUri("https://jsonplaceholder.typicode.com")
	.contentType(ContentType.JSON)
	.body("{\"title\"  : \"my first post\",   \n"
			+ "	  \"body\"   : \"learning restassured\", \n"
			+ "	  \"userId\" : 2  }")
	.when().post("/posts")
	.then().log().status()
	.statusCode(201);
	       
	//status code validation - PUT Method
	System.out.println("----------------PUT METHOD---------------");
	given().baseUri("https://jsonplaceholder.typicode.com")
	.contentType(ContentType.JSON)
	.body("{\n"
			+ "        \"id\": 1,\n"
			+ "        \"name\": \"Manoj\",\n"
			+ "        \"username\": \"Manju\",\n"
			+ "        \"email\": \"Sincere@april.biz\",\n"
			+ "        \"address\": {\n"
			+ "            \"street\": \"Kulas Light\",\n"
			+ "            \"suite\": \"Apt. 556\",\n"
			+ "            \"city\": \"Gwenborough\",\n"
			+ "            \"zipcode\": \"92998-3040\",\n"
			+ "            \"geo\": {\n"
			+ "                \"lat\": \"-37.3159\",\n"
			+ "                \"lng\": \"81.1496\"\n"
			+ "            }\n"
			+ "        },\n"
			+ "        \"phone\": \"1-770-736-8031 x56442\",\n"
			+ "        \"website\": \"hildegard.org\",\n"
			+ "        \"company\": {\n"
			+ "            \"name\": \"Romaguera-Crona\",\n"
			+ "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n"
			+ "            \"bs\": \"harness real-time e-markets\"\n"
			+ "        }\n"
			+ "    }")
	.when().put("posts/1")
	.then().log().status()
	.statusCode(200);
	
	//status code validation - PATCH Method
			System.out.println("----------------PATCH METHOD---------------");
			given().baseUri("https://jsonplaceholder.typicode.com")
			.contentType(ContentType.JSON)
			.body("{\"name\": \"Vino Kumar\"}")
			.when()
			.patch("https://jsonplaceholder.typicode.com/posts/4")
			.then().log().all()
			.statusCode(200);
			
			//status code validation - DELETE Method
			System.out.println("----------------DELETE METHOD---------------");
			given().baseUri("https://jsonplaceholder.typicode.com")
			.contentType(ContentType.JSON)
			.when()
			.delete("https://jsonplaceholder.typicode.com/posts/4")
			.then().log().all()
			.statusCode(200);

}
	
		
		
}
