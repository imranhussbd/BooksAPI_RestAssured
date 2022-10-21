package books.apis.testPackage;

import org.testng.annotations.Test;

import books.apis.utils.Configuration;
import io.restassured.RestAssured;

public class GetSimpleBooksStatusTest {
	
	Configuration config = Configuration.getInstance();
	
	@Test
	public void getSimpleStatus() {
		RestAssured
			.given()
			.baseUri(config.get("baseUrl"))
			.get(config.get("statusEndpoint"))
			.prettyPrint();
	}

}
