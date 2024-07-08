package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private AccountWeeklyOrderPage accountWeeklyOrderPage;
    private AccountHomePage accountHomePage;
    private EventsPage eventsPage;
    private MyEventsPage myEventsPage;


    public MyEventsPage getMyEventsPage() {
        if (myEventsPage == null) {
            myEventsPage = new MyEventsPage();
        }
        return myEventsPage;
    }

    public EventsPage getEventsPage() {
        if (eventsPage == null) {
            eventsPage = new EventsPage();
        }
        return eventsPage;
    }


    public WelcomePage getWelcomePage() {
        if (welcomePage == null) {
            welcomePage = new WelcomePage();
        }
        return welcomePage;
    }


    public AccountHomePage getAccountHomePage() {
        if (accountHomePage == null) {
            accountHomePage = new AccountHomePage();
        }
        return accountHomePage;
    }


    public AccountWeeklyOrderPage getAccountWeeklyOrderPage() {
        if (accountWeeklyOrderPage == null) {
            accountWeeklyOrderPage = new AccountWeeklyOrderPage();
        }
        return accountWeeklyOrderPage;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        return loginPage;
    }


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }


}