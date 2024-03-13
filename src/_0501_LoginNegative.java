import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class _0501_LoginNegative extends BaseDriver {
    @Test
    public void test0501(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys("");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("");

        WebElement submit = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        submit.click();

        WebElement message = driver.findElement(By.cssSelector("div[class='validation-summary-errors']"));

        Assert.assertTrue("Login is successful",
                message.getText().equals("Login was unsuccessful. Please correct the errors and try again.\n" +
                        "No customer account found"));

        // WaitClose();
    }

    @Test
    public void test0502(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys(MyFunctions.getEmail());

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("");

        WebElement submit = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        submit.click();

        WebElement message = driver.findElement(By.cssSelector("div[class='validation-summary-errors']"));

        Assert.assertTrue("Login is successful",
                message.getText().equals("Login was unsuccessful. Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect"));

        // WaitClose();
    }

    @Test
    public void test0503(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys("");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys(MyFunctions.getPassword());

        WebElement submit = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        submit.click();

        WebElement message = driver.findElement(By.cssSelector("div[class='validation-summary-errors']"));

        Assert.assertTrue("Login is successful",
                message.getText().equals("Login was unsuccessful. Please correct the errors and try again.\n" +
                        "No customer account found"));

        // WaitClose();
    }

    @Test
    public void test0504(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys("yuenv");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("7390");

        WebElement submit = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        submit.click();

        WebElement message = driver.findElement(By.cssSelector("span[class='field-validation-error']"));

        Assert.assertTrue("Login is successful",
                message.getText().equals("Please enter a valid email address."));

        WaitClose();
    }

}
