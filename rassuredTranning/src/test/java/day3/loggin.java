package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class loggin {
	@Test
	void testLogs() {
		// https://reqres.in/api/users?page=2
		
		given()
		  .when()
		   // .get("https://reqres.in/api/users?page=2")
		  .get("https://www.google.com/")
		  .then()
		      //.log().all()
		      //.log().body();
		      //.log().cookies();
		      .log().headers();
		
		
	}

}
