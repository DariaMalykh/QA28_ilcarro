package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("d@gmail.com").setPassword("DariaM1991!"));
        }

    }

    @Test
    public void addNewCarSuccessAllFields(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2024")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("678-900-"+i)
                .price(50)
                .about("My car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        app.getHelperCar().attachPhoto("C:\\QA_28\\QA28_ilcarro\\400.jpg");
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car.getManufacture()+ " "+car.getModel()+ " added successful");
    }

    @Test
    public void addNewCarSuccessReq(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("KIA")
                .model("Sportage")
                .year("2021")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("568-900-"+i)
                .price(40)
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car.getManufacture()+ " "+car.getModel()+ " added successful");
    }
    @AfterMethod
    public void postCondition(){
       app.getHelperCar().returnToHomePage();
    }
}
