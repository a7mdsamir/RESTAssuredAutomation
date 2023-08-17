package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestsOnLocalAPI {

	
	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000" ;
		
		given()
			.get("/users").
		then().
			statusCode(200)
			.log().all();	
	}
	
	//@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "mohamed");
		request.put("lastName", "zakaria");
		request.put("subjectId", 2);
		//System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000" ;
		
		given().
			//header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
	}
	
	//@Test
	public void put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "eslam");
		request.put("lastName", "gamal");
		request.put("subjectId", 2);
		//System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000" ;
		
		given().
			//header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200)
			.log().all();
	}
	
	//@Test
	public void patch() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "eslam");
		request.put("lastName", "gamal");
		request.put("subjectId", 1);
		//System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000" ;
		
		given().
			//header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000" ;
		
		when().
		delete("/users/4").
		then().
			statusCode(200)
			.log().all();
	}
	
}
