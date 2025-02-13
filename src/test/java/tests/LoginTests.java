package tests;

import models.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("d@gmail.com", "DariaM1991!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
    }

    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("d@gmail.com").setPassword("DariaM1991!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("d@gmail.com", "DariaM1991!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
    }

    @Test
    public void loginWrongEmail() {
        User user = new User().setEmail("dgail.com").setPassword("DariaM1991!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @Test
    public void loginWrongPassword() {
        User user = new User().setEmail("d@gail.com").setPassword("DriaM1991!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }
    @Test
    public void loginUnregisterUser() {
        User user = new User().setEmail("daria@gail.com").setPassword("DariaM1991!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @Test
    public void loginEmptyEmail() {
        User user = new User().setEmail(" ").setPassword("DariaM1991!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }
    @Test
    public void loginEmptyPassword() {
        User user = new User().setPassword("").setEmail("d@gail.com");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
        app.getHelperUser().logout();
    }
}
