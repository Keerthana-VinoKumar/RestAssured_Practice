package Day2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.*;


public class OnlyVerify {

	public static void main(String[] args) {
		//status code validation - GET Method
		//Gets Single User
		//Verify Exact Data - Contract 1
		System.out.println("Contract 1");
		given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.when().get("/users/1")
		.then().log().all()
		.statusCode(200)
		.body("id",equalTo(1))
		.body("name",equalTo("Leanne Graham"))
		.body("username", equalTo("Bret"))
		.body("website" , equalTo("hildegard.org"))
		.body("address.city",equalTo("Gwenborough"))
		.body("company.name", equalTo("Romaguera-Crona"))
		//checks if email contains @
		.body("email", containsString("@"))
		//checks if phone number is not null
		.body("phone",notNullValue())
		.body("address.zipcode",notNullValue());
		
		//Verify array size,first user id ,first user name ,email list,every id is greater than 0 - Contract 2
				System.out.println("");
				System.out.println("Contract 2");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.when().get("/users")
				.then().log().all()
				.statusCode(200)
				//checks if array size is 10
				.body("",hasSize(10))
				//check first value in array
				.body("[0].id", equalTo(1))
				.body("[0].username" , equalTo("Bret"))
				//checks if email list contains this value "Sincere@april.biz"
				.body("email", hasItem("Sincere@april.biz"))
				//checks every id is greaterThan 0
				.body("id",everyItem(greaterThan(0)));
				
				//Verify array Size - Contract 3
				System.out.println("Contract 3");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.queryParam("userId" , 1)
				.when().get("/posts")
				.then().log().all()
				.statusCode(200)
				//verify array size is 10
				.body("",hasSize(10))
				//first id is 10
				.body("[0].id",equalTo(1))
				//first user id is 10
				.body("[0].userId", equalTo(1))
				//every id in the array is equal to 1 
				.body("userId", everyItem(equalTo(1)))
				//title is not null
				.body("title", notNullValue());
				
				//Verify exact value - Contract 4
				System.out.println("Contract 4");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.body("{\n"
						+ "  \"title\"  : \"my first post\",\n"
						+ "  \"body\"   : \"learning restassured\",\n"
						+ "  \"userId\" : 1\n"
						+ "}")
				.when().post("/posts")
				.then().log().all()
				.statusCode(201)
				.body("id", equalTo(101))
				.body("title", equalTo("my first post"))
				.body("body", equalTo("learning restassured"))
				.body("userId", equalTo(1));
				
				//Verify array Size - Contract 5
				System.out.println("Contract 5");
				given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.pathParam("id",1)
				.when().get("/posts/{id}")
				.then().log().all()
				.statusCode(200)
				.body("id", equalTo(1))
				.body("userId", equalTo(1))
				.body("title", notNullValue())
				.body("body", notNullValue());
				
				
		
	}

	

}
