package package01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class tests extends TestBase {
    @Before
    public void beforeTests(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://www.google.com");
        driver.navigate().to("http://automationexercise.com");
    }
    @Test
    public void automationExerciseCase25(){

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

    @Test
    public void automationExerciseCase18() throws InterruptedException {
        Actions actions = new Actions(driver);

        //3. Verify that categories are visible on left side bar
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-3']")).isDisplayed());

        //4. Click on 'Women' category
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();

        WebElement categoryElement = driver.findElement(By.xpath("//a[@href='#Women']"));
        actions.moveToElement(categoryElement).perform();
        Thread.sleep(2000);
        actions.click(categoryElement).perform();
        Thread.sleep(2000);

        //5. Click on any category link under 'Women' category, for example: Dress
        WebElement dressElement = driver.findElement(By.xpath("//*[text()='Dress ']"));
        actions.moveToElement(dressElement).perform();
        Thread.sleep(2000);
        actions.click(dressElement).perform();
        Thread.sleep(2000);

        //6. Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
        Assert.assertTrue(driver.getCurrentUrl().contains("category"));
        Assert.assertEquals("WOMEN - DRESS PRODUCTS",driver.findElement(By.xpath("//h2[@class='title text-center']")).getText());

        //7. On left side bar, click on any sub-category link of 'Men' category
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();

        WebElement mencategoryElement = driver.findElement(By.xpath("//a[@href='#Men']"));
        actions.moveToElement(mencategoryElement).perform();
        Thread.sleep(2000);
        actions.click(mencategoryElement).perform();
        Thread.sleep(2000);

        WebElement tshirtElement = driver.findElement(By.xpath("//*[text()='Tshirts ']"));
        actions.moveToElement(tshirtElement).perform();
        Thread.sleep(2000);
        actions.click(tshirtElement).perform();
        Thread.sleep(2000);

        //8. Verify that user is navigated to that category page
        Assert.assertEquals("MEN - TSHIRTS PRODUCTS",driver.findElement(By.xpath("//h2[@class='title text-center']")).getText());


    }
}
