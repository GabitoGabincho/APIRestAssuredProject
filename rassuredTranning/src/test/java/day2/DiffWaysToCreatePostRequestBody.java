package day2;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

//import io.restassured.internal.support.FileReader;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;


public class DiffWaysToCreatePostRequestBody {

	// #1 post request body using Hashmap
	
	@Test(priority=1)
	void testPostusingHashMap() {
    	
    	HashMap<String, String> data= new HashMap<String, String>();
        data.put("name", "Gabito");
        data.put("location", "BUE");
        data.put("phone", "1146963030");
        data.put("job", "QA");
        //String courseArr[]= {"C","JAVA"};
        //data.put("courses", courseArr[0]);
        //data.put("courses", courseArr[1]);

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
               //.body("courses[1]", equalTo("JAVA"))
               //.header("Content-Type","application/json; charset=utf-8")
               .log().all();

	}
	
	@Test(priority=2)
    public void deleteUser() {
    	
    	
    	given()
    	 
    	  .when()
    	      .delete("http://localhost:3000/students/6")
  	      .then()
              .statusCode(404);
	}
	
	// #2 post request body using org.json lib
	
		@Test(priority=3)
		void testPostusingJsonLib() {
	    	
	    JSONObject data=new JSONObject();
	    
        data.put("name", "Gab");
        data.put("location", "France");
        data.put("phone", "1111111111");
        data.put("job", "QAE");
        
        System.out.println(data);
        
	        given()
	      	      .contentType("application/json")
	      	      .body(data.toString())
	      	 
	      	  .when()
	      	      .post("http://localhost:3000/students")
	      	  .then()
	               .statusCode(201)
	               .body("name", equalTo("Gab"))
	               .body("location", equalTo("France"))
	               .body("phone", equalTo("1111111111"))
	               .log().all();

		}
		
		@Test(priority=4)
	    public void deleteUser2() {
	    	
	    	
	    	given()
	    	 
	    	  .when()
	    	    .delete("http://localhost:3000/students/7")
	  	      .then()
	              .statusCode(404);
		}
		
		// #3 POJO (Plain Old Java Object)
		
		@Test(priority=5)
		void testPostusingPOJO() {
	    	
	    
		PojoPostRequest data= new PojoPostRequest();
        
		data.setName("GabOld");
        data.setLocation("FranceOld");
        data.setPhone("1111111111Old");
        data.setJob("QAEold");
        
        
	        given()
	      	      .contentType("application/json")
	      	      .body(data)
	      	 
	      	  .when()
	      	      .post("http://localhost:3000/students")
	      	  .then()
	               .statusCode(201)
	               .body("name", equalTo("GabOld"))
	               .body("location", equalTo("FranceOld"))
	               .body("phone", equalTo("1111111111Old"))
	               .log().all();

		}
		
		// #4 Json external file 
		
				@Test(priority=6)
				void testPostusingExternalJsonFile() throws FileNotFoundException {
			    	
			    File f = new File(".//body.json");
			    FileReader fr = new FileReader(f);
			    
			    JSONTokener jt = new JSONTokener(fr);
			    
			    JSONObject data = new JSONObject(jt);
		        
			        given()
			      	      .contentType("application/json")
			      	      .body(data.toString())
			      	 
			      	  .when()
			      	      .post("http://localhost:3000/students")
			      	  .then()
			               .statusCode(201)
			               .body("name", equalTo("GabjsonFile"))
			               .body("location", equalTo("FrancejsonFile"))
			               .body("phone", equalTo("1111111111jsonFile"))
			               .log().all();

				}
}