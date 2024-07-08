package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsPage extends CommonPage{
    @FindBy(xpath = "//div/a[text()='Events']")
    public WebElement events;
    @FindBy(xpath = "//button[text()='Scheduled Events']")
    public WebElement scheduledEvents;
    @FindBy(xpath = "//button[text()='Registered Events']")
    public WebElement registeredEvents;
    @FindBy(xpath = "//button[text()='Attended Events']")
    public WebElement attendedEvents;


}
