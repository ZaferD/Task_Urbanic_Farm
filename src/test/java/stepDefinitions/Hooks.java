package stepDefinitions;

import enums.URL_LINKS;
import enums.USERCREDENTIAL;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static enums.USERCREDENTIAL.*;
import static io.restassured.RestAssured.given;


public class Hooks extends CommonPage {


    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;
    public static boolean isHeadless = false;
    public static String browserType = "chrome";
    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @Before(value = "@Login")
    public void login() {

        System.out.println("Login metodu calıstı");
        driver.get(URL_LINKS.LOGIN_URL.getLink());
        getLoginPage().LoginEmail.sendKeys(USERSELLER.getUsername());
        getLoginPage().input_password.sendKeys(USERSELLER.getPassword());
        getLoginPage().submit_button.click();
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.hover(getAccountHomePage().zipCodeBoxCloseButton);
        getAccountHomePage().zipCodeBoxCloseButton.click();
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }

}

