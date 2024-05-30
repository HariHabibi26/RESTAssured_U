package osandadeshan;

import io.restassured.RestAssured;

public class Token {
	public static String getToken() {
		return RestAssured.get("https://intelliapi-mockserver.herokuapp.com/auth").jsonPath().get("token");
	}
}
