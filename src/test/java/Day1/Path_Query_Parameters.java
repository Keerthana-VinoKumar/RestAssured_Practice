package Day1;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class Path_Query_Parameters {

	public static void main(String[] args) {
		//Path Parameter
		System.out.println("-------------------PathParameter--------------------");
		given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.pathParam("id", 10)
		.when()
		.get("/users/{id}")
		.then().log().all()
		.statusCode(200);
		
		//Query parameter 
		System.out.println("-------------------QueryParameter--------------------");
		given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.queryParam("userId",1)
		.when()
		.get("/posts")
		.then()
		.log()
		.all()
		.statusCode(200);
		
		//Query parameter 
				System.out.println("-------------------QueryParameter--------------------");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.queryParam("postId",2)
				.when()
				.get("/comments")
				.then()
				.log()
				.all()
				.statusCode(200);
	}

}
