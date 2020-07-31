package testCases;

import java.io.IOException;
import org.testng.annotations.Test;


import pages.APICollection;
import webBase.BaseTest;

public class ApiTestCases extends BaseTest {

	APICollection api=new APICollection();
	

	@Test
	public void apiCollections() throws Throwable{
	
		api.getJWTToken("Verify API functionality","https://vision-futee.int.sgdbf.saint-gobain.net:8022/#/home");			
		api.vegaWebService("https://face.mutlp.test.pointp.saint-gobain.net/ws/index.php");	
		api.loginAPI("https://api.face.mutlp.test.pointp.saint-gobain.net/facews/v2/login");
		api.getUsersDetails("https://api.face.mutlp.test.pointp.saint-gobain.net/v2/user");
		api.getAgenciesApi("https://api.face.mutlp.test.pointp.saint-gobain.net/v2/agencies","3323");
		api.getOrdersByAgencyAPI("https://api.face.mutlp.test.pointp.saint-gobain.net/v2/agencies/26/orders");
		api.getOrdersByOrderID_API("https://api.face.mutlp.test.pointp.saint-gobain.net/v2/orders/1955212");
		api.updateOrder_API("https://api.face.mutlp.test.pointp.saint-gobain.net/v2/orders/1954748");
		api.updateArticles_API("https://api.face.mutlp.test.pointp.saint-gobain.net/v2/orders/1954748/articles");
		
		
	}
			
			
	
	
	
}
