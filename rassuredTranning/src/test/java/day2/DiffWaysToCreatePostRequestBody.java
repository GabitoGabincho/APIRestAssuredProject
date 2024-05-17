package day2;


import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class DiffWaysToCreatePostRequestBody {

	// post request body using Hashmap
	
	@Test(priority=1)
	void testPostusingHashMap() {
    	
    	HashMap<String, String> data= new HashMap<String, String>();
        data.put("name", "Gabito");
        data.put("location", "BUE");
        data.put("phone", "1146963030");
        // data.put("job", "QA");
        //String courseArr[]= {"C","C++"};
        //data.put("courses", courseArr);
        
        given()
      	      .contentType("application/json")
      	      .body(data)
      	 
      	  .when()
      	      .post("http://localhost:3000/students")
      	  .then()
               .statusCode(201)
               .body("name", equalTo("Gabito"))
               .body("location", equalTo("BUE"))
               .body("phone", equalTo("1146963030"))
               //.body("courses[0]", equalTo("C"))
               //.body("courses[1]", equalTo("C++"))
               //.header("Content-type","application/json; charset=utf-8")
               .log().all();

	}
	
	@Test(priority=2)
    public void deleteUser() {
    	
    	
    	given()
    	 
    	  .when()
    	      .delete("http://localhost:3000/students/6")
  	      .then()
              .statusCode(404);
	}}