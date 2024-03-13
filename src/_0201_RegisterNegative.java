import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class _0201_RegisterNegative extends BaseDriver {
    @Test
    public void test0201(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        WebElement genderMale = driver.findElement(By.id("gender-male"));
        genderMale.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("firstName");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("lastName");

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys(MyFunctions.getEmail());

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys(MyFunctions.getPassword());

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys(MyFunctions.getPassword());

        WebElement submit = driver.findElement(By.id("register-button"));
        submit.click();

        MyFunctions.wait(1);
        WebElement result = driver.findElement(By.cssSelector("div[class='validation-summary-errors']"));

        Assert.assertTrue("Registration is not failed",
                result.getText().equals("The specified email already exists") );

        WaitClose();
    }

}
