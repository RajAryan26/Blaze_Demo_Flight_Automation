package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By fromCity = By.name("fromPort");
    By toCity = By.name("toPort");
    By findFlightsBtn = By.cssSelector("input[type='submit']");

    public void selectCities() {

        Select from = new Select(driver.findElement(fromCity));
        from.selectByVisibleText("Paris");

        Select to = new Select(driver.findElement(toCity));
        to.selectByVisibleText("Berlin");
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsBtn).click();
    }
}