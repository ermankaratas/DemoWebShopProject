import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class _0701_Poll extends BaseDriver {

    String email = "6xqw@email.com";
    @Test
    public void test0701(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement answer = driver.findElement(By.id("pollanswers-1"));
        answer.click();

        WebElement vote = driver.findElement(By.id("vote-poll-1"));
        vote.click();

        WebElement voteError = driver.findElement(By.cssSelector("div[id='block-poll-vote-error-1']"));
        wait.until(ExpectedConditions.textToBePresentInElement(voteError,"Only registered users can vote."));

        Assert.assertTrue("messages are not same",
                voteError.getText().equals("Only registered users can vote."));

        // WaitClose();
    }

    @Test
    public void test0702(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys(MyFunctions.getEmail());

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys(MyFunctions.getPassword());

        WebElement submit = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        submit.click();

        WebElement answer = driver.findElement(By.cssSelector("span.poll-total-votes"));

        Assert.assertTrue("This user has not voted before",
                !answer.getText().isEmpty());

        WebElement logoutLink = driver.findElement(By.linkText("Log out"));
        logoutLink.click();

        // WaitClose();
    }

    @Test
    public void test0703(){

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
        emailBox.sendKeys(email);

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys(MyFunctions.getPassword());

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys(MyFunctions.getPassword());

        WebElement submit = driver.findElement(By.id("register-button"));
        submit.click();

        WebElement cntButton = driver.findElement(By.cssSelector("input[class='button-1 register-continue-button']"));
        cntButton.click();

        WebElement answer = driver.findElement(By.id("pollanswers-1"));
        answer.click();

        WebElement vote = driver.findElement(By.id("vote-poll-1"));
        vote.click();

        WebElement answerLast = driver.findElement(By.cssSelector("span.poll-total-votes"));

        Assert.assertTrue("This user has not voted before",
                !answerLast.getText().isEmpty());

        WaitClose();
    }

}
