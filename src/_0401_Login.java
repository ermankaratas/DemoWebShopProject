import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class _0401_Login extends BaseDriver {
    @Test
    public void test0401(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys(MyFunctions.getEmail());

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys(MyFunctions.getPassword());

        WebElement submit = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        submit.click();

        WebElement username = driver.findElement(By.cssSelector("a[class='account']"));

        Assert.assertTrue("username is false",
                username.getText().equals(MyFunctions.getEmail()));

        WaitClose();
    }

}
