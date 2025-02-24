package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    //**********************************LOGIN*************************************
    public void openLoginForm() {
        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submit() {
        click(By.cssSelector("[type='submit']"));
    }

    public String getMessage() {
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()= ' Logout ']"));
    }

    public void logout() {
        if (isElementPresent(By.cssSelector("[href='/logout?url=%2Fsearch']")))
            click(By.cssSelector("[href='/logout?url=%2Fsearch']"));

    }

    public void clickOkButton() {
        if (isElementPresent(By.cssSelector(".positive-button.ng-star-inserted")))
            click(By.cssSelector(".positive-button.ng-star-inserted"));
    }

    //**********************************REGISTRATION************************************
    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            // click(By.id("terms-of-use"));
            //click(By.cssSelector("label[for='terms-of-use']"));
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#terms-of-use').click();");
        }
    }
    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
       Rectangle rectangle =  label.getRect();
       int w = rectangle.getWidth();
        int xOffset = -w/2;

        //Dimension size = wd.manage().window().getSize();

        Actions actions = new Actions(wd);
        actions.moveToElement(label,xOffset,0).click().release().perform();

    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOkButton();
    }
}
