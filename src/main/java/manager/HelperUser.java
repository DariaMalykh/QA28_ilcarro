package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));
    }

    public void fillLoginRegistrationForm(String email,String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void submitLogin(){
        click(By.cssSelector("[type='submit']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//h1[text()='Logged in']"));
    }

    public void logout() {
        click(By.cssSelector(".positive-button.ng-star-inserted"));
        click(By.cssSelector("[href='/logout?url=%2Fsearch']"));

    }

}


