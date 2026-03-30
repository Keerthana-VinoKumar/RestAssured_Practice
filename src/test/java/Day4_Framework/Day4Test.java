package Day4_Framework;
import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class Day4Test extends BaseTest {
	
	@Test
	public void getpost() {
		given()
		.spec(reqSpec)
		.when().get("/posts/1")
		.then().log().all()
		.spec(resSpec) // checks 200 + JSON content type
		.body("id", equalTo(1))
		.body("title", notNullValue());
	}
	@Test
	public void getallpost()
	{
		given()
		.spec(reqSpec)
		.when().get("/posts")
		.then().log().all()
		.spec(resSpec) // checks 200 + JSON content type
		.body("", hasSize(100));
	}
	@Test
	public void createPost()
	{
		given()
		.spec(reqSpec)
		.body("{\n"
				+ "  \"title\"  : \"my first post\",    \n"
				+ "  \"body\"   : \"learning restassured\",\n"
				+ "  \"userId\" : 1                   \n"
				+ "}")
		.when().post("/posts")
		.then().log().all()
		.statusCode(201)
		.body("id", notNullValue())
		.body("title" , equalTo("my first post"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
