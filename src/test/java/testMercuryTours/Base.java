package testMercuryTours;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return  driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void wait(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void enter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public void visit(String url){
        driver.get(url);
    }
}