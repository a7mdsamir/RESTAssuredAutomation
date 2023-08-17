package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {

	@Test
	public void validateSoapXML() throws IOException {
		
		File file = new File("./SoapRequest/Add.xml");
		
		if (file.exists())
			System.out.println("  >> file exists");
		else
			System.out.println("  >> file doesn't exists");
			
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "https://ecs.syr.edu" ;
		
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx").
		then().
			statusCode(200).
			log().all().
		and().
			body("//*:AddResult.text()", equalTo("12"));
		
		
	}
}
