import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class _0901_Invoice extends BaseDriver {
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

        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='account']")));
        username.click();

        WebElement orders = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Orders")));
        orders.click();

        WebElement details = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Details']")));
        details.click();

        WebElement pdf = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PDF Invoice")));
        pdf.click();

        WaitClose();
    }

}
