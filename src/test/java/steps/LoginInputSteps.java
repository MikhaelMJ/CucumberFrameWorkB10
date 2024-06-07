package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;
import utils.ExcelReading;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginInputSteps extends CommonMethods {


    @Given("user is navigate to the page authorization")
    public void user_is_navigate_to_the_page_authorization() throws IOException {
        openBrowser();
    }

    @When("user enters valid email")
    public void user_enters_valid_email() {
        LoginPage loginPage = new LoginPage();

        List<Map<String, String>> loginFromExcel = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, "LoginData");
        Iterator<Map<String, String>> it = loginFromExcel.iterator();
        while (it.hasNext()) {
            Map<String, String> maploginFromExcel = it.next();
            sendText(loginPage.usernameBox, maploginFromExcel.get("username"));
        }
    }

    @When("click on input button")
    public void click_on_input_button() {
        LoginPage loginPage = new LoginPage();
        click(loginPage.loginBtn);
    }

    @Then("is displayed {string}")
    public void is_displayed(String string) {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.inputCod.isDisplayed());
        tearDown();
        }



    @When("user enters invalid email")
    public void user_enters_invalid_email() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("invalidUsername"));
    }

    @Then("user see invalid credentials message on login page")
    public void user_see_invalid_credentials_message_on_login_page() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.invalidLoginMessage.isDisplayed());

    }

    @When("user enters {string}")
    public void user_enters(String email) {
        LoginPage loginPage = new LoginPage();

            sendText(loginPage.usernameBox, email);
        }
    }
