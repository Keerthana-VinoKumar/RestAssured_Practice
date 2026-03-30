package Day4_Framework;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class BaseTest {

	protected static RequestSpecification reqSpec;
	protected static ResponseSpecification resSpec;
	@BeforeClass
	public static  void setup() {
		// Request Specification
		reqSpec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
				.setContentType(ContentType.JSON)
				.build();
			
		
		//Response Specification
			resSpec = new ResponseSpecBuilder()
					.expectStatusCode(200)
					.expectContentType(ContentType.JSON)
					.build();
	}

}
