package package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class tests extends TestBase {
    @Test
    public void automationExerciseCase25(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://www.google.com");
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePageIcon = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homePageIcon.isDisplayed());

        //4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        for (int i = 0; i < 14; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscriptionText = driver.findElement(By.xpath("(//h2)[82]"));
        Assert.assertTrue(subscriptionText.isDisplayed());

        //6. Click on arrow at bottom right side to move upward
        WebElement arrowButton = driver.findElement(By.xpath("//i[@class='fa fa-angle-up']"));
        actions.click(arrowButton).perform();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement fullPledgedPractice = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(fullPledgedPractice.isDisplayed());
    }
}
