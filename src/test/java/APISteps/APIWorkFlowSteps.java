package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIWorkFlowSteps {
    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {
       request = given().header(APIConstants.Header_Content_type, APIConstants.Content_type).
               header(APIConstants.Header_Authorization, GenerateTokenSteps.token).
               body(APIPayloadConstants.createEmployeePayload());
    }

    @When("a Post call is made to create and employee")
    public void a_post_call_is_made_to_create_and_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("the employee create contains key {string} and value {string}")
    public void the_employee_create_contains_key_and_value(String message, String employeeCreatedValue) {
        response.then().assertThat().body(message, equalTo(employeeCreatedValue));
    }
    @Then("the employee id {string} is stored as a global variable to be used for other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {
       employee_id = response.jsonPath().getString(empID);
        System.out.println(employee_id);
    }
}
