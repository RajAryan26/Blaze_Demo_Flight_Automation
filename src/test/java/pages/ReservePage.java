package pages;

import org.openqa.selenium.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservePage {

    WebDriver driver;

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    By flightTable = By.xpath("//table/tbody/tr");

    public boolean flightsDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            By.xpath("//input[@value='Choose This Flight']")));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public void chooseFirstFlight() {

        driver.findElement(
        By.xpath("(//input[@value='Choose This Flight'])[1]"))
        .click();
    }
}