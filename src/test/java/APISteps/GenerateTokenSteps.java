package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    public static String token;
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification generatedTokenRequest = given().header("Content-Type","application/json").
                body("{\n" +
                        "        \"email\": \"mike23412asd@abc.com\",\n" +
                        "        \"password\": \"test1\"\n" +
                        "}");
        Response generatedTokenResponse = generatedTokenRequest.when().post("/generateToken.php");
        generatedTokenResponse.prettyPrint();
        token = "Bearer " + generatedTokenResponse.jsonPath().getString("token");
        System.out.println(token);
    }
}
