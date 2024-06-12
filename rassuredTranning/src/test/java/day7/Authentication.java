package day7;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Authentication {
	
	@Test(priority=1)  // BASIC 
	void testBasicAutentification() {
		given()
		  .auth().basic("postman", "password")
		  // .auth().digest("postman", "password")
		   .when()
		      .get("https://postman-echo.com/basic-auth")
		   .then()
		      .statusCode(200)
		      .body("authenticated",equalTo(true))
		      .log().all();
	}
	
	@Test(priority=2)  // DIGEST
	void testDigestAutentification() {
		given()
		   .auth().digest("postman", "password")
		   .when()
		      .get("https://postman-echo.com/basic-auth")
		   .then()
		      .statusCode(200)
		      .body("authenticated",equalTo(true))
		      .log().all();
	}
	
	@Test(priority=3)  // PREEMPTIVE
	void testPreemptiveAutentification() {
		given()
		   .auth().preemptive().basic("postman", "password")
		   .when()
		      .get("https://postman-echo.com/basic-auth")
		   .then()
		      .statusCode(200)
		      .body("authenticated",equalTo(true))
		      .log().all();
	}
	
	@Test(priority=4)  // BEARER TOKEN
	void testBearerTokenAutentification() {
		String bearerToken = "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";
		given()
		      .headers("Authorization","Bearer "+bearerToken) 
		  .when()
		      .get("https://api.github.com/user/repos")
		   .then()
		      .statusCode(200)
		      .log().all();
	}
	
	//@Test(priority=5)  // OAUTH1.0.2.0
	/*void testOauth1Autentification() {
		String bearerToken = "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";
		given()
		      .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret") 
		  .when()
		      .get("https://api.github.com/user/repos")
		   .then()
		      .statusCode(200)
		      .log().all();
	}*/
	
	@Test(priority=5)  // OAUTH1.0.2.0
	void testOauth2Autentification() {
		//String bearerToken = "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";
		given()
		      .auth().oauth2("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") 
		  .when()
		      .get("https://api.github.com/user/repos")
		   .then()
		      .statusCode(200)
		      .log().all();
	}
}
