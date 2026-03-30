package Day2;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
public class ReponseLevelValidation {

	public static void main(String[] args) {
		// Contract 1 - validating status code,status line
		//content - type header , x-powered-By header
		System.out.println("Contract 1");
		given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.when().get("users/1")
		.then().log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		//exact match
		.header("Content-Type","application/json; charset=utf-8")
		//partial match
		.header("Content-Type", containsString("application/json"))
		.header("X-Powered-By",equalTo("Express"));
		
		// Contract 2 - validating status code,status line
				System.out.println("Contract 2");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.when().post("Posts")
				.then().log().all()
				.statusCode(201)
				//partial match
				.header("Content-Type", containsString("application/json"))
				//.body("title", equalTo("my post"))
				.body("id",equalTo(101));
				
				// Contract 3 - validating status code,status line
				System.out.println("Contract 3");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.when().delete("/Posts/1")
				.then().log().all()
				.statusCode(200)
				//partial match	
				.header("Content-Type", containsString("application/json"))
				.body(equalTo("{}"))
				.time(lessThan(2000L));

	}

}
