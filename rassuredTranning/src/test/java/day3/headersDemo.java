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

public class headersDemo {
	
	@Test
	void testHeaders() {
		
		given()
		  .when()
		      .get("https://www.google.com")
          .then()
              .header("Content-Type","text/html; charset=ISO-8859-1")
              .and()
              .header("Content-Encoding", "gzip")
              .and()
		      .header("Server", "gws")
		      .log().headers();
		
		Response res=given()
		   .when()
		      .get("https://www.google.com");
		// get a single header info
	
		String headerValue=res.getHeader("Content-Type");
		System.out.println(headerValue);
		
		// get multiple headers info
		Headers myHeaders=res.getHeaders();
	
		for(Header hd:myHeaders)
		{
			System.out.println(hd.getName()+"  "+hd.getValue());
		}
	}
		

	private ValidatableResponseOptions<ValidatableResponse, Response> then() {
		// TODO Auto-generated method stub
		return null;
	}}
