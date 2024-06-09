package day6;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import io.restassured.internal.support.FileReader;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.Serializable;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;


import day2.PojoPostRequest;

//POJO  --->  Serilize -->	JSON Object -- De serilize  ----> POJO 

public class serializationDeseralization {
	
	@Test(priority=1) 
	void convertPojo2Json() throws JsonProcessingException {
		
		// create a Java Object using POJO class
		
		// POJO --> JSON -- SERILIZATION
		
        PojoPostRequest2 dataPojo= new PojoPostRequest2();      
		dataPojo.setName("Gabserdes");
        dataPojo.setLocation("Franceserdes");
        dataPojo.setPhone("1111111111serdes");
        dataPojo.setJob("QAserdes");
        
        //convert java object to json object
        
        ObjectMapper objMapper = new ObjectMapper();
        String jsonData= objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataPojo);
        System.out.println(jsonData);
	}
	@Test(priority=2)
	void convertJson2Pojo() throws JsonProcessingException {
		
		// JSON to POJO   - DE SERILIZATION
		
		String jsonData ="{\r\n"
				+ "  \"name\" : \"Gabserdes\",\r\n"
				+ "  \"location\" : \"Franceserdes\",\r\n"
				+ "  \"phone\" : \"1111111111serdes\",\r\n"
				+ "  \"job\" : \"QAserdes\"\r\n"
				+ "}";
		
        //convert java object to json object
        
        ObjectMapper objMapper = new ObjectMapper();
        PojoPostRequest2 pprPOJO = objMapper.readValue(jsonData,PojoPostRequest2.class);
        
        System.out.println("POJO NOMBRE: "+pprPOJO.getName());
        System.out.println("POJO LUGAR: "+pprPOJO.getLocation());
        System.out.println("POJO TELEFONO: "+pprPOJO.getPhone());
        System.out.println("POJO TRABAJO: "+pprPOJO.getJob());

        
	}

}
