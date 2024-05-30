package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {

	public static ResourceBundle getURLS() {
		return ResourceBundle.getBundle("routes");
	}

	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(getURLS().getString("post_url"));
		return response;
	}

	public static Response readUser(String userName) {
		Response response = given().pathParam("username", userName).when().get(getURLS().getString("get_url"));
		return response;
	}

	public static Response updateUser(String userName, User payload) {
		Response response = given().pathParam("username", userName).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload).when().put(getURLS().getString("update_url"));
		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("username", userName).when().delete(getURLS().getString("delete_url"));
		return response;
	}
}