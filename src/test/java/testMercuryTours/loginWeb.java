package testMercuryTours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.security.util.Password;


public class loginWeb extends Base{

    By imgPage = By.cssSelector("td > img");
    By register = By.linkText("REGISTER");
    By user = By.id("email");
    By password = By.name("password");
    By ConfirmPassword = By.name("confirmPassword");
    By buttonRegister = By.name("register");

    By ButtonSingOff = By.linkText("SIGN-OFF");

    By ButtonSingOn = By.xpath("//*/text()[normalize-space(.)='INICIAR SESIÓN']/parent::*");
    By userName = By.name("userName");
    By ButtonSubmit = By.name("login");
    By textWelcome = By.cssSelector("b");


    public loginWeb(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {

        if(isDisplayed(imgPage)){
            //register page
            wait(register);
            click(register);
            wait(user);
            type("merlin", user);
            type("123456", password);
            type("123456", ConfirmPassword);
            wait(buttonRegister);
            click(buttonRegister);

            Thread.sleep(3000);
            //login page
            wait(ButtonSingOff);
            click(ButtonSingOff);
            wait(userName);
            type("merlin", userName);
            type("123456", password);
            click(ButtonSubmit);
            wait(textWelcome);
            String text = getText(textWelcome);
            System.out.println("ingreso a la aplicacion" + text);
        }else{
            System.out.println("Register pages was not found");
        }
    }
}
