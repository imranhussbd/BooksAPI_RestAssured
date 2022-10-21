package books.apis.testPackage;

import org.testng.annotations.Test;

import books.apis.utils.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostBooksApiTest {

	Configuration config = Configuration.getInstance();
	
	@Test(enabled = false)
	public void negativePostBookOrder() {
		RestAssured
			.given()
			.body("{\"bookId\" : 1, \"customerName\" : \"John\"}")
			.contentType(ContentType.JSON)
			.log().all()
			.when()
			.post("https://simple-books-api.glitch.me/orders")
			.then()
			.statusCode(401) //unAuthorizied
			.log().all();
	}
	
	@Test(enabled = true)
	public void postBookOrder() {
		RestAssured
			.given().auth()
			.oauth2(config.get("accessToken"))
			.body("{\"bookId\" : 1, \"customerName\" : \"John\"}")
			.contentType(ContentType.JSON)
			.log().all()
			.when()
			.post("https://simple-books-api.glitch.me/orders")
			.then()
			.statusCode(201)
			.log().all();
		//created
		//"orderId" : "AyMjtXmAdwRwg00dJjTfC"
		}

}
