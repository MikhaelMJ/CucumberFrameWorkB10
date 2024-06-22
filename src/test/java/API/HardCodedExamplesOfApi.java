package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class HardCodedExamplesOfApi {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTkwMzI5OTksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxOTA3NjE5OSwidXNlcklkIjoiNjYxNSJ9.cV7ex1Qt1KRzYcGqvo5eHiJSTincVvujujBwDkANgZc";
    static String employee_id;

    @Test
    public void getDetailsOfOneEmployee() {

        //given
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", "25598A");

        //when-endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.ph");

        System.out.println(response.asString());

        //then - result/assertion
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void createEmployee() {
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
    @Test
    public void createUser(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").body("{\n" +
                        "    \"name\":\"Mike2345\",\n" +
                        "    \"email\":\"mike2341234asd@abc.com\",\n" +
                        "    \"password\":\"test12\"\n" +
                        "}");

        Response response = preparedRequest.when().post("/createUser.php");
        response.prettyPrint();

        response.then().assertThat().body("Message", equalTo("User Created"));
    }
}
