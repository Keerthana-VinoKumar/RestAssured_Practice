package Day3;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChainingRequest {

	public static void main(String[] args) {
		// chain requests
		System.out.println("Contract 3");
		 int userId = given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.body("{\n"
				+ "  \"title\"  : \"my first post\",    \n"
				+ "  \"body\"   : \"learning restassured\",\n"
				+ "  \"userId\" : 1                   \n"
				+ "}\n"
				+ "")
		.when().post("/posts")
		.then().log().all()
		.extract().path("userId");
		 System.out.println("postId:" +userId);
		 
		 given().baseUri("https://jsonplaceholder.typicode.com")
			.contentType(ContentType.JSON)
			.when().get("/posts/" +userId)
			.then().log().all()
			.statusCode(200)
			.body("title",notNullValue());

	}

}
