package books.apis.testPackage;

import org.testng.annotations.Test;

import books.apis.utils.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class PostBooksAuthentication {

	Configuration config = Configuration.getInstance();
	
	@Test(enabled = false)
	public void createAuthentication() {
		RestAssured
		.given()
		.baseUri(config.get("baseUrl"))
		.contentType(ContentType.JSON)
		.body("{\"clientName\" : \"Postman\", \"clientEmail\" : \"wick@example.com\"}")
		.log().all()
		.post(config.get("authenticateEndpoint"))
		.prettyPrint();
	}
	
	//accessToken created
	//"accessToken": "ff88ea69a288e7dd02482354795f458e712361b3f22b54d94426817b9fe51213"

	@Test(enabled = true)
	public void negativeTestAuthentication() {
		RestAssured
		.given()
		.baseUri(config.get("baseUrl"))
		.contentType(ContentType.JSON)
		.body("{\"clientName\" : \"Postman\", \"clientEmail\" : \"wick@example.com\"}")
		.log().all()
		.post(config.get("authenticateEndpoint"))
		.then()
		.statusCode(409)
		.log().all();
		}

}
