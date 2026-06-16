package pages;

import org.openqa.selenium.*;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zipCode = By.id("zipCode");

    By cardType = By.id("cardType");
    By creditCardNumber = By.id("creditCardNumber");
    By creditCardMonth = By.id("creditCardMonth");
    By creditCardYear = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");

    By purchaseFlightBtn =
            By.cssSelector("input[type='submit']");

    public void enterPassengerDetails() {

        driver.findElement(name).sendKeys("Pankaj");

        driver.findElement(address)
                .sendKeys("Delhi");

        driver.findElement(city)
                .sendKeys("Delhi");

        driver.findElement(state)
                .sendKeys("Delhi");

        driver.findElement(zipCode)
                .sendKeys("110001");
    }

    public void enterPaymentDetails() {

        driver.findElement(creditCardNumber)
                .clear();

        driver.findElement(creditCardNumber)
                .sendKeys("123456789012");

        driver.findElement(creditCardMonth)
                .clear();

        driver.findElement(creditCardMonth)
                .sendKeys("12");

        driver.findElement(creditCardYear)
                .clear();

        driver.findElement(creditCardYear)
                .sendKeys("2028");

        driver.findElement(nameOnCard)
                .sendKeys("Raj Aryan");
    }

    public void purchaseFlight() {

        driver.findElement(purchaseFlightBtn)
                .click();
    }
}