package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Rehovot","3/25/2025","3/27/2025");
        app.getHelperCar().getScreen("src/test/resources/screenshots/currentMonth.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }
    @Test
    public void searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Rehovot","4/27/2025","6/28/2025");
        app.getHelperCar().getScreen("src/test/resources/screenshots/currentYear.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }
    @Test
    public void searchCurrentAnyPeriodSuccess(){
       app.getHelperCar().searchCurrentAnyPeriod("Rehovot","11/15/2025","2/10/2026");
        app.getHelperCar().getScreen("src/test/resources/screenshots/any.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void negativeSearch(){
        app.getHelperCar().searchNotValidPeriod("Rehovot","2/15/2025","2/10/2026");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("You can't pick date before today"));

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperCar().navigatorByLogo();
    }
}
