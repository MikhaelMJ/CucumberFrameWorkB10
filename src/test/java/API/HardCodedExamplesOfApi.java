package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamplesOfApi {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTkwMzI5OTksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxOTA3NjE5OSwidXNlcklkIjoiNjYxNSJ9.cV7ex1Qt1KRzYcGqvo5eHiJSTincVvujujBwDkANgZc";
    static String employee_id;

    /*@Test
    public void getDetailsOfOneEmployee() {

        //given
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", "25598A");

        //when-endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.ph");

        System.out.println(response.asString());

        //then - result/assertion
        response.then().assertThat().statusCode(200);
    }*/

    @Test
    public void acreateEmployee() {
        //given
        RequestSpecification preparedRequest = given().header("Authorization", token).
                header("Content-Type", "application/json").body("{\n" +
                        "    \"emp_firstname\":\"mish123456\",\n" +
                        "    \"emp_lastname\":\"Dzhen1234\",\n" +
                        "    \"emp_middle_name\":\"Vale1234\",\n" +
                        "    \"emp_gender\":\"M\",\n" +
                        "    \"emp_birthday\":\"1989-01-03\",\n" +
                        "    \"emp_status\":\"Employee\",\n" +
                        "    \"emp_job_title\":\"Api Tester\"\n" +
                        "}");

        //when
        Response response = preparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();//что и sout

        //jsonPath() для получения специальной информации из объекта json
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);


        //then
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_firstname", equalTo("mish123456"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));

    }

    /*@Test
    public void createUser() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").body("{\n" +
                        "    \"name\":\"Mike2345\",\n" +
                        "    \"email\":\"mike2341234asd@abc.com\",\n" +
                        "    \"password\":\"test12\"\n" +
                        "}");

        Response response = preparedRequest.when().post("/createUser.php");
        response.prettyPrint();

        response.then().assertThat().body("Message", equalTo("User Created"));
    }*/

    @Test
    public void bgetCratedEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");


        String empID = response.jsonPath().getString("employee.employee_id");
        boolean comparingEmpID = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpID);


        String lastName = response.jsonPath().getString("employee.emp_lastname");
        Assert.assertTrue(lastName.contentEquals("Dzhen1234"));
    }

    @Test
    public void cupdateCreatedEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token).
                header("Content-Type", "application/json").body("{\n" +
                        "        \"employee_id\": \"" + employee_id + "\",\n" +
                        "        \"emp_firstname\": \"misha1234\",\n" +
                        "        \"emp_middle_name\": \"Valer1234\",\n" +
                        "        \"emp_lastname\": \"Dzhenk1234\",\n" +
                        "        \"emp_birthday\": \"1989-01-04\",\n" +
                        "        \"emp_job_title\": \"UI Tester\",\n" +
                        "        \"emp_status\": \"Active\"\n" +
                        "    }");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();


    }

}
