package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import pojo.AddEmployeeSerialize;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild BuildData = new TestDataBuild();
	JsonPath js;
	int IDis;
	APIResources[] signals;

	@Given("createEmp Payload with {string} {string}")
	public void createEmp_payload_with(String name, String salary) throws IOException {

		res = given().spec(resSpecifications()).body(BuildData.addempload(name, salary));

	}

	@When("user call {string} with {string} http request")
	public void user_call_with_post_http_request(String resource, String method) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		// resourceAPI.getresource();

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST"))

			response = res.when().post(resourceAPI.getresource());
		else if (method.equalsIgnoreCase("GET"))

			response = res.when().get(resourceAPI.getresource());
	}

	@Then("the API call is success with message success")
	public void the_api_call_is_success_with_message_success() {
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("status in response body is success")
	public void status_in_response_body_is_success() {
		String responseString = response.asString();
		js = new JsonPath(responseString);
		js.get("success");
		// System.out.println(responseString);
	}

	@Then("name in response body is Ganusalunkhe")
	public void in_response_body_is() {
		String responseString = response.asString();
		js = new JsonPath(responseString);

		String nameis = js.get("data.name");
		int IDis = js.get("data.id");
		System.out.println("Added EMP Name is : " + nameis);
		System.out.println("Added EMP Name is : " + IDis);
		this.IDis = IDis;
		System.out.println(this.IDis);

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_get_http_request(String resource, String method) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(resource);
		// resourceAPI.getresource();

		
		if (method.equalsIgnoreCase("POST"))

			response = res.when().post(resourceAPI.getresource());
		else if (method.equalsIgnoreCase("GET")) 

			res = given().spec(resSpecifications());

			System.out.println(resourceAPI.getresource() + IDis);
			response = given().spec(resSpecifications()).get(resourceAPI.getresource() + IDis);

			System.out.println(response.getBody().asString());

	}
		@When("user calling {string} with {string} http request")
		public void user_calling_with_delete_http_request(String resource, String method) throws IOException {

			APIResources resourceAPI = APIResources.valueOf(resource);
			// resourceAPI.getresource();

			
			if (method.equalsIgnoreCase("POST")) 

				response = res.when().post(resourceAPI.getresource());
			else if (method.equalsIgnoreCase("GET")) 

				res = given().spec(resSpecifications());
			
				else if (method.equalsIgnoreCase("DELETE")) 
				
						res = given().spec(resSpecifications());
				
				System.out.println(resourceAPI.getresource() + IDis);
				response = given().spec(resSpecifications()).delete(resourceAPI.getresource() + IDis);

				System.out.println(response.getBody().asString());

			}

	}

