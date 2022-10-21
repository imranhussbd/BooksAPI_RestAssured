package books.apis.testPackage;

import org.testng.annotations.Test;

import books.apis.utils.Configuration;
import io.restassured.RestAssured;

public class GetBookOrders {
	
	Configuration config = Configuration.getInstance();
	
	@Test(enabled = true)
	public void getAllOrdersResponse() {
		RestAssured
		.given().auth()
		.oauth2(config.get("accessToken"))
		.baseUri(config.get("baseUrl"))
		.get(config.get("ordersEndpoint"))
		.then()
		.extract()
		.response()
		.prettyPrint();
		
		// orders, id = AyMjtXmAdwRwg00dJjTfC
	}

}
