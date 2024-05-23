package day3;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class pathAndQueryParameters {
	
	// https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryAndPathParameters() {
	
		
	given()
          .pathParam("mypath","users")	//Path parameters
          .queryParam("page",2)
          .queryParam("id",5)
		.when()
		  .get("https://reqres.in/api/{mypath}")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}

}
