package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ConfirmationPage;
import pages.HomePage;
import pages.PurchasePage;
import pages.ReservePage;
import utils.DriverFactory;

public class FlightBookingTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.getDriver();
        driver.get("https://blazedemo.com/");
    }

    @Test
    public void verifyFlightBooking() {

        HomePage home = new HomePage(driver);

        System.out.println("Departure City : Paris");
        System.out.println("Destination City : Berlin");

        home.selectCities();
        home.clickFindFlights();

        // Results Page

        String resultsHeading =
                driver.findElement(By.tagName("h3")).getText();

        System.out.println("Results Page Heading : " + resultsHeading);

        ReservePage reserve = new ReservePage(driver);

        int availableFlights =
                driver.findElements(
                        By.xpath("//input[@value='Choose This Flight']"))
                        .size();

        System.out.println("Available Flights : " + availableFlights);

        Assert.assertTrue(reserve.flightsDisplayed(),
                "Flights are not displayed");

        reserve.chooseFirstFlight();

        System.out.println("First flight selected successfully");

        // Purchase Page

        String purchaseHeading =
                driver.findElement(By.tagName("h2")).getText();

        System.out.println("Purchase Page Heading : "
                + purchaseHeading);

        PurchasePage purchase =
                new PurchasePage(driver);

        System.out.println("Flight details verified successfully");

        purchase.enterPassengerDetails();

        System.out.println("Passenger details entered");

        purchase.enterPaymentDetails();

        System.out.println("Payment details entered");

        purchase.purchaseFlight();

        System.out.println("Purchase Flight button clicked");

        // Confirmation Page

        ConfirmationPage confirmation =
                new ConfirmationPage(driver);

        String confirmationMessage =
                confirmation.getConfirmationMessage();

        System.out.println("Confirmation Message : "
                + confirmationMessage);

        Assert.assertEquals(
                confirmationMessage,
                "Thank you for your purchase today!");

        String purchaseId =
                driver.findElement(
                        By.xpath("//td[text()='Id']/following-sibling::td"))
                        .getText();

        System.out.println("Purchase ID : " + purchaseId);

        System.out.println("Flight booking completed successfully");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}