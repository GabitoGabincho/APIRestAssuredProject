package day1;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class HTTPRequest {
    ValidatableResponse id; //global variable
    
    @Test(priority=1)
    public void getUsers(){

        given()
                .when()
                  .get("https://reqres.in/api/users?page=2")
                .then()
                   .statusCode(200)
                   .body("page",equalTo(2));
                   //.log().all();
       
    }
    @Test(priority=2)
    public void createUser() {
    	
    	HashMap<String, String> data= new HashMap<String, String>();
        data.put("name", "Gabito");
        data.put("job", "QA");
    	
    	id=given()
    	      .contentType("application/json")
    	      .body(data)
    	 
    	  .when()
    	      .post("https://reqres.in/api/users")
    	  .then()
             .statusCode(201)
             .log().all();
    	
    }
   
    @Test(priority=3, dependsOnMethods= {"createUser"})
    public void updateUser() {
    	
    	HashMap<String, String> data= new HashMap<String, String>();
        data.put("name", "Gabito");
        data.put("job", "ANALISTA");
    	
    	
    	given()
    	      .contentType("application/json")
    	      .body(data)
    	 
    	  .when()
    	     // .put("https://reqres.in/api/users/2")
    	  .put("https://reqres.in/api/users/"+id)
  	      .then()
              .statusCode(200)
    	      .log().all();
	
    	
    }
    
    @Test(priority=4)
    public void deleteUser() {
    	
    	
    	given()
    	 
    	  .when()
    	      //.delete("https://reqres.in/api/users/2")
    	        .delete("https://reqres.in/api/users/"+id)
  	      .then()
              .statusCode(204);
    }
}