package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email,String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void submitLogin(){
        click(By.cssSelector("[type='submit']"));
    }

    public String getMessage() {
        //pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[text()= ' Logout ']"));
    }

    public void logout() {
        click(By.cssSelector("href='/logout?url=%2Fsearch']"));

    }

    public void clickOkButton() {
        click(By.cssSelector(".positive-button.ng-star-inserted"));
    }
}


