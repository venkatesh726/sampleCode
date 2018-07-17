package day3;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AutomateRestDemo1 {
	

	@Test(enabled=false)
	public void test1(){
		Response res=given().param("q","london").param("appid","b6907d289e10d714a6e88b30761fae22").
		get("https://samples.openweathermap.org/data/2.5/weather");
		
		String serverName=res.getHeader("server");
		System.out.println(serverName);
	    System.out.println(res.getHeader("date"));
	    System.out.println(res.getHeader("content-type"));
	    System.out.println(res.getHeader("content-encoding"));
	    
	}
	
	@Test
	public void test2(){
		given().param("q","london").param("appid","b6907d289e10d714a6e88b30761fae22").
		get("https://samples.openweathermap.org/data/2.5/weather").
		then().
		body("name",equalToIgnoringCase("LONDON"));
	  
	}
	
	@Test
	public void test3(){
		given().param("q","london").param("appid","b6907d289e10d714a6e88b30761fae22").
		get("https://samples.openweathermap.org/data/2.5/weather").
		then().
		body("weather[0].description",is("light intensity drizzle"));
		  
	}
	
	@Test
	public void test4(){
		String data = given().param("q","london").param("appid","b6907d289e10d714a6e88b30761fae22").
		get("https://samples.openweathermap.org/data/2.5/weather").asString();
		
		JsonPath json=new JsonPath(data);
		System.out.println(json.get("name"));
		System.out.println(json.get("weather[0].main"));
		
	
	}
}
