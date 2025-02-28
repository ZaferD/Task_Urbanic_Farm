package pages;

import enums.URL_LINKS;
import enums.USERCREDENTIAL;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

import java.util.List;

import static enums.URL_LINKS.LOGIN_URL;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitForPageToLoad;

public class LoginPage extends CommonPage{

    @FindBy(xpath = "//input[@name='email']")
    public WebElement input_email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement input_password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit_button;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert_message;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement LoginEmail;

    @FindBy(xpath = "//button[@class='btn alazea-btn']")
    public WebElement LoginSubmitButton;

    @FindBy (css="input[title='Zip code should be digit']")
    WebElement zipCodeInput;

    @FindBy (xpath="//div[@class='input-group']/button[contains(text(), 'go')]")
    WebElement zipCodeSubmit;

    @FindBy (xpath="//div/h3[contains(text(), 'Coming to you soon')]")
    WebElement zipCodeAlert;

    @FindBy (xpath="//p[contains(text(), 'Try another zip code')]")
    WebElement tryNewCodeBtn;

    @FindBy (xpath="//p[contains(text(), 'zip code: ')]")
    WebElement registeredZipCode;

    @FindBy(xpath = "(//a[@class='Navbar_textLink__f6_Al mr-4'])[6]")
    public WebElement loginButton;

    public void login(){
        ReusableMethods.waitForClickablility(LoginEmail,5).sendKeys("urbanicfarm2@gmail.com");
        ReusableMethods.waitForClickablility(input_password,5).sendKeys("Urbanicfarm2/");
        ReusableMethods.waitForClickablility(LoginSubmitButton,7).click();
    }

    //Enum classını yazarak credentiallerinle login olabilirsin
    public void login(USERCREDENTIAL usercredential){
        driver.get(URL_LINKS.LOGIN_URL.getLink());
        waitForPageToLoad(10);
        input_email.sendKeys(usercredential.getUsername());
        input_password.sendKeys(usercredential.getPassword());
        submit_button.click();
    }

    public void validCredential(){
        driver.get(LOGIN_URL.getLink());
        LoginEmail.sendKeys(USERCREDENTIAL.USERSELLER.getUsername());
        input_password.sendKeys(USERCREDENTIAL.USERSELLER.getPassword());
        submit_button.click();
    }

    public void loginWithCredentials(String email, String password){
        ReusableMethods.sendText(input_email, email);
        ReusableMethods.sendText(input_password, password);
        ReusableMethods.waitAndClickElement(submit_button, 5);
    }

    public void verifyZipCodeEntry(List<List<String>> listItems){
        String text="";
        Boolean isTrue;
        String alertMessage;

        for(int i=0; i<listItems.size(); i++){
            text = ((listItems.get(i).get(0)) == null) ? text : listItems.get(i).get(0);
            isTrue = Boolean.parseBoolean(listItems.get(i).get(1));

            ReusableMethods.sendText(zipCodeInput,text);
            ReusableMethods.waitAndClickElement(zipCodeSubmit, 2);
            if (!isTrue) {
                alertMessage = ReusableMethods.getElementText(zipCodeAlert);
                Assert.assertEquals( "Coming to you soon", alertMessage);
                ReusableMethods.waitForClickablility(tryNewCodeBtn, 2);
                tryNewCodeBtn.click();
            } else {
                Assert.assertEquals( "zip code: " + text, registeredZipCode.getAttribute("textContent"));
            }
        }
    }



}
