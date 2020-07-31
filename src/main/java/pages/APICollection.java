package pages;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.Asserts;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.helper.HttpConnection.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.fge.jsonschema.main.JsonValidator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.RequestLogSpecificationImpl;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import webBase.BasePage;
import webBase.BaseTest;
import webElements_Identifiers.Login_Identifiers;
import static org.testng.Assert.assertEquals;

public class APICollection extends BasePage {

	public static String BLNumber="";
	public ExtentTest logger;	
	BaseTest baseT = new BaseTest();
	AppstringsConstant appConst= new AppstringsConstant();
	
	public static String token=null;
	public static String assignmentDate=null;
			
	
//-------------------------- fetching JWT token from vision futee site ----------------------
	
	public void getJWTToken(String TestName, String url) throws Throwable {
			 
	try {
			
		System.out.println("fetching JWT token from vision futee site");
		
		logger = baseT.extent.startTest(TestName);			
		createDirectory("FACE"+TestName);
				
 	driver.navigate().to(url);
	
	 Select select=new Select(driver.findElement(By.id("region")));
	 select.selectByValue("900");
		
	 Thread.sleep(3000);
		
	 Select select1=new Select(driver.findElement(By.id("pool")));
	 
	 select1.selectByValue("1: PP ENSAL");
	 
	 driver.findElement(By.id("shippingAgency")).click();
	 
	 driver.findElement(By.id("ngb-typeahead-0"));
	 driver.findElement(By.xpath("//*[@id='ngb-typeahead-0-0']")).click();
	 
	 driver.findElement(By.xpath("//*[@id='app-transport-search-id']/div/app-transport-search/form/div[2]/div/button")).click();
    
Cookie cookieValue = driver.manage().getCookieNamed("SGDBFJWT");
	 

token=cookieValue.getValue().toString();	

System.out.println(token);
	 
logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying JWT token "+"<br/>"
		+"1:Redirected to the Vision futee site "+"<br/>"
		+"2:fetching token from browsers cookie"+"<br/>"
		+"<font color='green'>Result:token has been successfully fetched  <font/>"+"<b>");

		} catch (Exception e) {

			System.out.println( e.getMessage());
			logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying JWT token "+"<br/>"
					+"<font color='red'>Result:getting error while fetching token from test site  <font/>"+"<b>");
		
		
		}
	
}
	
	
	//----------get Files--------------------------
		public static String generateStringFromResource(String path) throws IOException {

		    return new String(Files.readAllBytes(Paths.get(path)));

		    
		    	}
	
	
	//------------VEGA Webservice API--------------------------------------
	
		public String vegaWebService( String url) throws IOException {
			
			 SoftAssert sa = new SoftAssert();

			 System.out.println("VEGA Webservice API");	
			
			String myRequest = generateStringFromResource(System.getProperty("user.dir")+"\\Files\\FACE_Vega_webService.xml");

				Response res = RestAssured.given()
		                .relaxedHTTPSValidation()
		              .body(myRequest)
	            .with()
	            .contentType("application/xml").post(url);
	            
			int status=	res.getStatusCode();
				
			String output= res.getBody().asString();
			System.out.println(status);
			System.out.println(output);
			BLNumber= StringUtils.substringBetween(output, "BL","</text>");
			System.out.println(BLNumber);
			try {
				sa.assertEquals(status, 200,"incorrect Status Code");
				sa.assertAll();
				
				logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying vegaWebService API functionality"+"<br/>"
						+"1:Read Xml File & set in request body"+"<br/>"
						+"2:sending Request as a POST"+"<br/>"
						+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+status);
			
				logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying vegaWebService API functionality"+"<br/>"
						+"1:Read Xml File & set in request body"+"<br/>"
						+"2:sending Request as a POST"+"<br/>"
						+"<font color='green'>Result:Order has been created Successfully:- <font/>"+"<b>"+BLNumber);
			

				} catch (AssertionError e) {
					
					System.out.println(e.getMessage());
					logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying vegaWebService API  functionality"+"<br/>"
							+"2:Read Xml File & set in request body"+"<br/>"
							+"3:sending Request as a POST"+"<br/>"
								+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+status);

					 logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying vegaWebService API functionality"+"<br/>"
							 +"2:Read Xml File & set in request body"+"<br/>"
								+"3:sending Request as a POST"+"<br/>"
									+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);	
					 
				}
				

			
			return this.BLNumber;
			
			
			
		}
		
	
	//------------login API--------------------------------------------------------
	public void loginAPI(String url) {
		 SoftAssert sa = new SoftAssert();
	
System.out.println("login API");	


RestAssured.useRelaxedHTTPSValidation(); 
RequestSpecification request=RestAssured.given(); 
 Response response= request.headers("Authorization","Bearer "+"sgdbf "+token).contentType("multipart/form-data").
 multiPart("userCode","S4333164").multiPart("userPassword","sg!t@2020")
 .post(url);
 
 
String getBody= response.getBody().asString();
		
int status=  response.getStatusCode();
 

System.out.println(status);

try {	

	sa.assertEquals(status, 404,"incorrect Status Code");
	sa.assertAll();


	
logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying Login API functionality for mobile vega version v2 api"+"<br/>"
		+"2:Enter valid userName & Password in Body"+"<br/>"
		+"2:sending Request as a POST"+"<br/>"
		+"<font color='green'>Result:Response Status Code is <font/>"+"<b>"+status);

/* String newBody=StringUtils.substringBetween(getBody, "id","token\":\"");
System.out.println(getBody);
System.out.println(newBody);*/

 // token= StringUtils.substringBetween(getBody, "token\":\"","\"}");

} catch (AssertionError e) {

	System.out.println(e.getMessage());
	logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying Login API functionality"+"<br/>"
			+"2:Enter valid userName & Password in Body"+"<br/>"
			+"2:sending Request as a POST"+"<br/>"
			+"<font color='red'>Result:getting incorrect Status code in Response <font/>"+"<b>"+status);
		
	}



}

	
	//------------ get Users Details API--------------------------------------	
	
		public void getUsersDetails(String url) throws Throwable {

			 SoftAssert sa = new SoftAssert();

			 System.out.println("get Users Details API"); 
			 
			RestAssured.useRelaxedHTTPSValidation();
			 RequestSpecification request=RestAssured.given(); 
			 
			Response response =
					
				        (Response) request.headers("Authorization","sgdbf "+token)
				        .header("Content-Type", "application/json; charset=utf-8")
				          .when().get(url);
			 
		int StatusCode=	response.getStatusCode();		
		 String body= response.body().asString();	
		
		try {
			
		
		sa.assertEquals(StatusCode, 200,"incorrect Status Code");	
		sa.assertAll();

	//JsonOutput test= (JsonOutput) new groovy.json.JsonSlurper().parseText();
		
	String JsonResponse	= response.body().asString().replace("\uFEFF","");	
		
	JSONParser parser = new JSONParser();
	JSONObject json = (JSONObject) parser.parse(JsonResponse);
	
	System.out.println(json.get("id"));
	 
String id=json.get("id").toString();
String zoneId=json.get("zoneId").toString();
String firstname=json.get("firstname").toString();
String lastname=json.get("lastname").toString();
String active=json.get("active").toString();
String sgid=json.get("sgid").toString();
String agencyId=json.get("agencyId").toString();
String role=json.get("role").toString();



logger.log(LogStatus.PASS,"<b>CASE:</b>Verifying get UsersDetails API Response"+"<br/>"
		+"1:Set Authorization code in Header as Brearer Token"+"<br/>"
		+"2:sending Request as a GET"+"<br/>"
		+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);	
	

	
		 logger.log(LogStatus.PASS,"<b>CASE:</b>Verifying UsersDetails API Schema"+"<br/>"
					+"1:Key userid has been verified Actual value is : "+"<font color='green'><b>"+id+"</b></font><br/>"
					+"2:Key zoneid has been verified Actual value is : "+"<font color='green'><b>"+zoneId+"</b></font/><br/>"
					+"3:Key firstname has been verified Actual value is : "+"<font color='green'><b>"+firstname+"</b></font><br/>"
					+"4:Key lastname has been verified Actual value is : "+"<font color='green'><b>"+lastname+"</b></font><br/>"
					+"5:Key active has been verified Actual value is : "+"<font color='green'><b>"+active+"</b></font><br/>"
					+"6:Key SGID has been verified Actual value is : "+"<font color='green'><b>"+sgid+"</b></font><br/>"
					+"7:Key agencyId has been verified Actual value is : "+"<font color='green'><b>"+agencyId+"</b></font><br/>"
					+"8:Key Role has been verified Actual value is : "+"<font color='green'><b>"+role+"</b></font><br/>"					
					+"<font color='green'>Result:Users Api schema has been verified<font/>");
	
	
	
		} catch (AssertionError e) {
		
			System.out.println(e.getMessage());
			
			logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying get UsersDetails API functionality"+"<br/>"
					+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"4:sending Request as a GET"+"<br/>"
					+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

			 logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying get UsersDetails API functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"4:sending Request as a GET"+"<br/>"
						+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+body);

		
		}
		
			
		}
		

	
	//------------ get Agencies API--------------------------------------	
	
	public void getAgenciesApi(String url,String AgencyCode) throws Throwable {

		 SoftAssert sa = new SoftAssert();

		 System.out.println("get Agencies API"); 
		 
		RestAssured.useRelaxedHTTPSValidation();
		 RequestSpecification request=RestAssured.given(); 

		Response response =
				
			          (Response) request.headers("Authorization","sgdbf "+token)
			          .params("agencyCode",AgencyCode)
			          .get(url);

		
	int StatusCode=	response.getStatusCode();
	String body= response.getBody().asString();	


	try {
		
	
	sa.assertEquals(StatusCode, 200,"incorrect Status Code");
	sa.assertAll();


	
	String JsonResponse	= response.body().asString().replace("\uFEFF","");	
	
	JSONParser parser = new JSONParser();
	JSONArray json = (JSONArray) parser.parse(JsonResponse);
	
	JSONObject newjosn= (JSONObject) json.get(0);
	
String id=newjosn.get("id").toString();
String code=newjosn.get("code").toString();
String label=newjosn.get("label").toString();
String zones=newjosn.get("zones").toString();
String gate=newjosn.get("gate").toString();

System.out.println(newjosn.get("zones"));
	
	logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying getAgencies API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"3:Set Agency Code 3323 in Params "+"<br/>"
			+"4:sending Request as a GET"+"<br/>"
			+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

	
	 System.out.println(StatusCode+"getAgenciesApi");
	 
	 System.out.println(body);

		
			 logger.log(LogStatus.PASS,"<b>CASE:</b>Verifying Agency Details API Schema"+"<br/>"
						+"1:Key agencyId has been verified Actual value is :"+"<font color='green'><b>"+id+"</b></font><br/>"
						+"2:Key agencycode has been verified Actual value is :"+"<font color='green'><b>"+code+"</b></font/><br/>"
						+"3:Key agencylabel has been verified Actual value is : "+"<font color='green'><b>"+label+"</b></font><br/>"
						+"4:Key agencylabel has been verified Actual Zones are :  "+"<font color='green'><b>"+zones+"</b></font><br/>"
						+"<font color='green'>Result:agency Api schema has been verified<font/>");
		
	} catch (AssertionError e) {
	
		System.out.println(e.getMessage());
		
		logger.log(LogStatus.FAIL,"<b>CASE:</b>Verifying getAgencies API functionality"+"<br/>"
				+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
				+"3:Set Agency Code 3323 in Params "+"<br/>"
				+"4:sending Request as a GET"+"<br/>"
				+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

		 logger.log(LogStatus.FAIL,"<b>CASE:</b>Verifying getAgencies API functionality"+"<br/>"
					+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"3:Set Agency Code 3323 in Params "+"<br/>"
					+"4:sending Request as a GET"+"<br/>"
					+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+body);

	
	}
	
		
	}
	


	
	//------------ get Orders By agency API--------------------------------------	
	
		public void getOrdersByAgencyAPI(String url) throws Throwable {
			 SoftAssert sa = new SoftAssert();
			 System.out.println("get Orders By agency API"); 
				
			 
			RestAssured.useRelaxedHTTPSValidation();
			 RequestSpecification request=RestAssured.given(); 

			Response response =
					
				          (Response) request.headers("Authorization","sgdbf "+token)
				          .params("status[1]","1")
				          .params("status[0]","0")
				          .get(url);

			
		int StatusCode=	response.getStatusCode();
		String body= response.getBody().asString();	

		System.out.println(StatusCode+"getOrdersByAgencyAPI ");
		 
		 System.out.println(body);
		try {
			
			
			sa.assertEquals(StatusCode, 200,"incorrect Status Code");
			sa.assertAll();

			
			String JsonResponse	= response.body().asString().replace("\uFEFF","");	
			
			JSONParser parser = new JSONParser();
			JSONArray json = (JSONArray) parser.parse(JsonResponse);
			
			JSONObject newjosn= (JSONObject) json.get(0);
			
			
			System.out.println(newjosn.toString()+" test");
		
			String id=newjosn.get("id").toString();
			String code=newjosn.get("code").toString();
			String nature=newjosn.get("nature").toString();
			String origin=newjosn.get("origin").toString();	
			String customerCode=newjosn.get("customerCode").toString();	
			String agencyId=newjosn.get("agencyId").toString();	
			String userFirstName=newjosn.get("userFirstName").toString();	
			String userLastName=newjosn.get("userLastName").toString();	
			String creationDate=newjosn.get("creationDate").toString();	
			String customerName=newjosn.get("customerName").toString();	
			String userCode=newjosn.get("userCode").toString();	
			String size=newjosn.get("size").toString();	
			String gate=newjosn.get("gate").toString();	
			String zoneId=newjosn.get("zoneId").toString();
			String taskId=newjosn.get("taskId").toString();
			
				
	if (newjosn.get("assignmentDate")!=null) {
			
				System.out.println(newjosn.get("assignmentDate"));
				assignmentDate=newjosn.get("assignmentDate").toString();
				
			} else {

				System.out.println("assignment is null");
				
				assignmentDate="null";
			} 
			
			
			logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying getOrdersByAgency API functionality"+"<br/>"
					+"1:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"2:Set Status Type 4(i.e cancel) in Params "+"<br/>"
					+"3:sending Request as a GET"+"<br/>"
					+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

		
		 

	logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying Orders By Agency API Schema"+"<br/>"
			+"1:Key ID has been verified Actual value is : "+"<font color='green'><b>"+id+"</b></font><br/>"
			+"2:Key code has been verified Actual value is : "+"<font color='green'><b>"+code+"</b></font/><br/>"
			+"3:Key nature has been verified Actual value is : "+"<font color='green'><b>"+nature+"</b></font><br/>"
			+"4:Key origin has been verified Actual value is : "+"<font color='green'><b>"+origin+"</b></font/><br/>"
			+"5:Key customerCode has been verified Actual value is : "+"<font color='green'><b>"+customerCode+"</b></font/><br/>"
			+"6:Key userFirstName has been verified Actual value is : "+"<font color='green'><b>"+userFirstName+"</b></font/><br/>"
			+"7:Key userLastName has been verified Actual value is : "+"<font color='green'><b>"+userLastName+"</b></font/><br/>"
			+"8:Key creationDate has been verified Actual value is : "+"<font color='green'><b>"+creationDate+"</b></font/><br/>"
			+"9:Key customerName has been verified Actual value is : "+"<font color='green'><b>"+customerName+"</b></font/><br/>"
			+"10:Key userCode has been verified Actual value is : "+"<font color='green'><b>"+userCode+"</b></font/><br/>"
			+"11:Key size has been verified Actual value is : "+"<font color='green'><b>"+size+"</b></font/><br/>"
			+"12:Key gate has been verified Actual value is : "+"<font color='green'><b>"+gate+"</b></font/><br/>"
			+"13:Key zoneId has been verified Actual value is : "+"<font color='green'><b>"+zoneId+"</b></font/><br/>"
			+"14:Key assignmentDate has been verified Actual value is : "+"<font color='green'><b>"+assignmentDate+"</b></font/><br/>"		
			+"15:Key taskId has been verified Actual value is : "+"<font color='green'><b>"+taskId+"</b></font/><br/>"	
			+"16:Articles are : "+"<font color='green'><b>"+newjosn.get("articles").toString()+"</b></font/><br/>"		
 			+"<font color='green'>Result:Orders By Agency API schema has been verified<font/>");
 
	

		 
			
		} catch (AssertionError e) {
			
			System.out.println(e.getMessage());
			logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByAgencyAPI  functionality"+"<br/>"
					+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"3:Set Status Type 4(i.e cancel) in Params "+"<br/>"
					+"4:sending Request as a GET"+"<br/>"
					+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

			 logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getAgencies API functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"3:Set Status Type 4(i.e cancel) in Params "+"<br/>"
						+"4:sending Request as a GET"+"<br/>"
						+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+body);

		
				}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByOrderID API  functionality"+"<br/>"
					+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"3:sending Request as a GET"+"<br/>"
					+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

			 logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByOrderID API functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"3:sending Request as a GET"+"<br/>"
						+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+body);			
		}
		

		}
		//------------ get Orders By Orders ID API--------------------------------------	
		
			public void getOrdersByOrderID_API(String url) throws Throwable {
				 SoftAssert sa = new SoftAssert();

				RestAssured.useRelaxedHTTPSValidation();
				 RequestSpecification request=RestAssured.given(); 

				Response response =
						
					          (Response) request.headers("Authorization","sgdbf "+token)
					          .get(url);

				
			int StatusCode=	response.getStatusCode();
			String body= response.getBody().asString();	

			try {
				
				
				sa.assertEquals(StatusCode, 200,"incorrect Status Code");
				sa.assertAll();

				String JsonResponse	= response.body().asString().replace("\uFEFF","");	
				
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(JsonResponse);	
				
				
				System.out.println(json.toString()+" test");
				
				String id=json.get("id").toString();
				String code=json.get("code").toString();
				String nature=json.get("nature").toString();
				String origin=json.get("origin").toString();	
				String customerCode=json.get("customerCode").toString();	
				String agencyId=json.get("agencyId").toString();	
				String userFirstName=json.get("userFirstName").toString();	
				String userLastName=json.get("userLastName").toString();	
				String creationDate=json.get("creationDate").toString();	
				String customerName=json.get("customerName").toString();	
				String userCode=json.get("userCode").toString();	
				String size=json.get("size").toString();	
				String gate=json.get("gate").toString();	
				String zoneId=json.get("zoneId").toString();
				String taskId=json.get("taskId").toString();
				
				
				if (json.get("assignmentDate")!=null) {
				
					System.out.println(json.get("assignmentDate"));
					assignmentDate=json.get("assignmentDate").toString();
					
				} else {

					System.out.println("assignment is null");
					
					assignmentDate="null";
				}

				
				logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying getOrdersByOrderID API functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"3:sending Request as a GET"+"<br/>"
						+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

			
			 System.out.println(StatusCode+"getOrdersByOrderID ");
			 
			 System.out.println(body);

			 
				logger.log(LogStatus.PASS,"<b>CASE:</b>Verifying get Order Details by Order ID API Schema"+"<br/>"
						+"1:Key ID has been verified Actual value is : "+"<font color='green'><b>"+id+"</b></font><br/>"
						+"2:Key code has been verified Actual value is : "+"<font color='green'><b>"+code+"</b></font/><br/>"
						+"3:Key nature has been verified Actual value is : "+"<font color='green'><b>"+nature+"</b></font><br/>"
						+"4:Key origin has been verified Actual value is : "+"<font color='green'><b>"+origin+"</b></font/><br/>"
						+"5:Key customerCode has been verified Actual value is : "+"<font color='green'><b>"+customerCode+"</b></font/><br/>"
						+"6:Key userFirstName has been verified Actual value is : "+"<font color='green'><b>"+userFirstName+"</b></font/><br/>"
						+"7:Key userLastName has been verified Actual value is : "+"<font color='green'><b>"+userLastName+"</b></font/><br/>"
						+"8:Key creationDate has been verified Actual value is : "+"<font color='green'><b>"+creationDate+"</b></font/><br/>"
						+"9:Key customerName has been verified Actual value is : "+"<font color='green'><b>"+customerName+"</b></font/><br/>"
						+"10:Key userCode has been verified Actual value is : "+"<font color='green'><b>"+userCode+"</b></font/><br/>"
						+"11:Key size has been verified Actual value is : "+"<font color='green'><b>"+size+"</b></font/><br/>"
						+"12:Key gate has been verified Actual value is : "+"<font color='green'><b>"+gate+"</b></font/><br/>"
						+"13:Key zoneId has been verified Actual value is : "+"<font color='green'><b>"+zoneId+"</b></font/><br/>"
						+"14:Key assignmentDate has been verified Actual value is : "+"<font color='green'><b>"+assignmentDate+"</b></font/><br/>"		
						+"15:Key taskId has been verified Actual value is : "+"<font color='green'><b>"+taskId+"</b></font/><br/>"	
						+"16:Articles are : "+"<font color='green'><b>"+json.get("articles").toString()+"</b></font/><br/>"		
						+"<font color='green'>Result:Orders By Agency API schema has been verified<font/>");
			 
			 
			} catch (AssertionError e) {
				
				System.out.println(e.getMessage());
				logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByOrderID API  functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"3:sending Request as a GET"+"<br/>"
						+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

				 logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByOrderID API functionality"+"<br/>"
							+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
							+"3:sending Request as a GET"+"<br/>"
							+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+body);			
			}
			
			catch (Exception e) {
				
				System.out.println(e.getMessage());
				logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByOrderID API  functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"3:sending Request as a GET"+"<br/>"
						+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+StatusCode);

				 logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying getOrdersByOrderID API functionality"+"<br/>"
							+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
							+"3:sending Request as a GET"+"<br/>"
							+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+body);			
			}
			

		}
		

	
	//-------------Update Order Api-------------------------------
	
	public void updateOrder_API(String url) throws IOException {

		 SoftAssert sa = new SoftAssert();

		RestAssured.useRelaxedHTTPSValidation();
		 RequestSpecification request=RestAssured.given(); 

		String myRequest = generateStringFromResource(System.getProperty("user.dir")+"\\Files\\orderupdate.json");

		
		Response res =(Response) request.headers("Authorization","sgdbf "+token)
                .relaxedHTTPSValidation()
              .body(myRequest)
        .with()
        .contentType("application/xml").post(url);
        
	int status=	res.getStatusCode();
		
	String output= res.getBody().asString();
	System.out.println(status+"json status");
	System.out.println(output);
		
	try {


if (status==201) {
	
	logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"2:Read Json File & set in request body"+"<br/>"
			+"3:sending Request as a POST"+"<br/>"
			+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+status +" new resource being created");
	
	logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"2:Read Json File & set in request body"+"<br/>"
			+"3:sending Request as a POST"+"<br/>"
			+"<font color='green'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);
		
	
} else if (status==403) {
	
	logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"2:Read Json File & set in request body"+"<br/>"
			+"3:sending Request as a POST"+"<br/>"
			+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+status +" Forbidden");
	
	logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"2:Read Json File & set in request body"+"<br/>"
			+"3:sending Request as a POST"+"<br/>"
			+"<font color='green'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);
	
} else {
	
	logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"2:Read Json File & set in request body"+"<br/>"
			+"3:sending Request as a POST"+"<br/>"
			+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+status);
	
	logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
			+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
			+"2:Read Json File & set in request body"+"<br/>"
			+"3:sending Request as a POST"+"<br/>"
			+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);

}	

	} catch (Exception e) {

		System.out.println(e.getMessage());
		logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying updateOrder API functionality"+"<br/>"
				+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
				+"2:Read Json File & set in request body"+"<br/>"
				+"3:sending Request as a POST"+"<br/>"
				+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+status);
		
		logger.log(LogStatus.FAIL,"<b>CASE:</b>Verifying updateOrder API functionality"+"<br/>"
				+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
				+"2:Read Json File & set in request body"+"<br/>"
				+"3:sending Request as a POST"+"<br/>"
				+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);
				 
	}
	

	
	}
	
	//-------------Update Order Api-------------------------------
	
		public void updateArticles_API(String url) throws IOException {

			 SoftAssert sa = new SoftAssert();

			RestAssured.useRelaxedHTTPSValidation();
			 RequestSpecification request=RestAssured.given(); 

			String myRequest = generateStringFromResource(System.getProperty("user.dir")+"\\Files\\updateArticles.json");

			
			Response res =(Response) request.headers("Authorization","sgdbf "+token)
	                .relaxedHTTPSValidation()
	              .body(myRequest)
	        .with()
	        .contentType("application/xml").post(url);
	        
		int statusupdateArticles=	res.getStatusCode();
			
		String output= res.getBody().asString();
		System.out.println(statusupdateArticles+"json status of Update Articles");
		System.out.println(output);
			
		try {
			
			sa.assertEquals(statusupdateArticles, 201,"incorrect Status Code");
			sa.assertAll();

			
			logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying updateArticles API functionality"+"<br/>"
					+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"2:Read Json File & set in request body"+"<br/>"
					+"3:sending Request as a POST"+"<br/>"
					+"<font color='green'>Result:Response Status Code is:- <font/>"+"<b>"+statusupdateArticles);
				
			logger.log(LogStatus.PASS,"<b>CASE:</b> Verifying updateArticles API functionality"+"<br/>"
					+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
					+"2:Read Json File & set in request body"+"<br/>"
					+"3:sending Request as a POST"+"<br/>"
					+"<font color='green'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);
				

			
			
			} catch (AssertionError e) {
				
				System.out.println(e.getMessage());
				
				logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying updateArticles API functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"2:Read Json File & set in request body"+"<br/>"
						+"3:sending Request as a POST"+"<br/>"
						+"<font color='red'>Result:Response Status Code is:- <font/>"+"<b>"+statusupdateArticles);
					
				logger.log(LogStatus.FAIL,"<b>CASE:</b> Verifying updateArticles API functionality"+"<br/>"
						+"2:Set Authorization code in Header as Brearer Token"+"<br/>"
						+"2:Read Json File & set in request body"+"<br/>"
						+"3:sending Request as a POST"+"<br/>"
						+"<font color='red'>Result:Response OutPut Body is:- <font/>"+"<b>"+output);
					
			}
			
			
		}
		

	
	
	
	
}
