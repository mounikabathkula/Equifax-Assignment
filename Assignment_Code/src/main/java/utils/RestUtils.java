package utils;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {
	static Response response;
	public static void setBaseUri()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com";
		RestAssured.useRelaxedHTTPSValidation();
		
	}
	public static void get()
	{
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("Connection", "Keep-Alive");
		setBaseUri();
		response=RestAssured.given().headers(map).get("/api/v1/employees");
	}
	public static void delete()
	{
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("Connection", "Keep-Alive");
		setBaseUri();
		response=RestAssured.given().headers(map).delete("/api/v1/delete/2");
	}
}
