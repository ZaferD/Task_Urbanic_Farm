package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private LoginPage loginPage;
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

    public AccountHomePage getAccountHomePage() {
        if (accountHomePage == null) {
            accountHomePage = new AccountHomePage();
        }
        return accountHomePage;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        return loginPage;
    }

}