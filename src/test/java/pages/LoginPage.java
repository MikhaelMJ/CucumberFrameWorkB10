package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id = "index_email")
    public WebElement usernameBox;

    @FindBy(id = "")
    public WebElement passwordBox;

    @FindBy(xpath = "//span[text()='Войти']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@role='alert']//span[@role]")
    public WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void login(String username){
        sendText(usernameBox, username);
        click(loginBtn);
    }
}
