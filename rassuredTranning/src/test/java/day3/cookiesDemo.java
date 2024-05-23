package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class cookiesDemo {
/*	
@Test
void testCookies() {
	
	given()
	  .when()
	  .get("https://www.google.com")
	  .then()
	    .log().all();
}
*/
@Test
void getCookiesInfo() {
	
	Response res=given()
	  .when()
	  .get("https://www.google.com");
	      // get single cookie information
	      String cookie_value=res.getCookie("AEC");
	      System.out.println("El valor es: "+cookie_value);
          // get all the cookies information
	      Map<String,String>cookies_values=res.getCookies();
	      
	      System.out.println(cookies_values.keySet());
	      System.out.println(cookies_values);
	      
	      for(String k:cookies_values.keySet()) {
	    	  String cookie_value1=res.getCookie(k);
	    	  System.out.print(k+" VALOR  "+ cookie_value1);
	    	  
	      }
	      }

private ValidatableResponseOptions<ValidatableResponse, Response> then() {
	// TODO Auto-generated method stub
	return null;
}
 
}
