package testMercuryTours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class loginWebTest {

    public WebDriver driver;
    loginWeb loginweb;

    @Before
    public void setUp() throws Exception {
        loginweb = new loginWeb(driver);
        driver = loginweb.chromeDriverConnection();
        loginweb.visit("http://newtours.demoaut.com/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void test() throws Exception{
        loginweb.login();
        assertEquals("Sign-on: Mercury Tours", driver.getTitle());
    }
}