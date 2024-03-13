import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class _0801_CouponGiftCard extends BaseDriver {
    @Test
    public void test0801(){

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

        WebElement computers = driver.findElement(By.cssSelector("ul[class='top-menu']>li+li>a"));
        Actions actionDriver = new Actions(driver);
        Action action = actionDriver.moveToElement(computers).build();
        action.perform();

        WebElement notebooks = driver.findElement(By.linkText("Notebooks"));
        notebooks.click();

        wait.until(ExpectedConditions.urlContains("notebooks"));

        WebElement laptop = driver.findElement(By.linkText("14.1-inch Laptop"));
        laptop.click();

        wait.until(ExpectedConditions.urlContains("141-inch-laptop"));

        WebElement addToCart = driver.findElement(By.cssSelector("input[class='button-1 add-to-cart-button']"));
        addToCart.click();

        WebElement shoppingCart = driver.findElement(By.linkText("Shopping cart"));
        shoppingCart.click();

        wait.until(ExpectedConditions.urlContains("cart"));

        WebElement applyCoupon = driver.findElement(By.name("applydiscountcouponcode"));
        applyCoupon.click();

        WebElement messageCoupon = driver.findElement(By.cssSelector("div[class='message']"));
        Assert.assertTrue("warning message is not displayed",
                messageCoupon.getText().equals("The coupon code you entered couldn't be applied to your order"));

        WebElement addGiftCard = driver.findElement(By.name("applygiftcardcouponcode"));
        addGiftCard.click();
        WebElement messageGift = driver.findElement(By.cssSelector("div[class='message']"));
        Assert.assertTrue("warning message is not displayed",
                messageGift.getText().equals("The coupon code you entered couldn't be applied to your order"));

        WebElement country = driver.findElement(By.id("CountryId"));
        Select countryMenu = new Select(country);
        countryMenu.selectByVisibleText("Canada");

        WebElement state = driver.findElement(By.id("StateProvinceId"));
        Select stateMenu = new Select(state);
        stateMenu.selectByVisibleText("Alberta");

        WebElement terms = driver.findElement(By.id("termsofservice"));
        terms.click();

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        wait.until(ExpectedConditions.urlContains("onepagecheckout"));

        WebElement nameBill = driver.findElement(By.id("BillingNewAddress_FirstName"));

        if(nameBill.isDisplayed()){
            WebElement countryBill = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select countryBillMenu = new Select(countryBill);
            countryBillMenu.selectByVisibleText("Canada");

            WebElement stateBill = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
            Select stateBillMenu = new Select(stateBill);
            stateBillMenu.selectByVisibleText("Alberta");

            WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("city");

            WebElement adress = driver.findElement(By.id("BillingNewAddress_Address1"));
            adress.sendKeys("adress");

            WebElement zipPostalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipPostalCode.sendKeys("38500");

            WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("0123546824");
        }

        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[id='billing-buttons-container']>input")));
        button1.click();

        WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[id='shipping-buttons-container']>input")));
        button2.click();

        WebElement button3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[id='shipping-method-buttons-container']>input")));
        button3.click();

        WebElement button4 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[id='payment-method-buttons-container']>input")));
        button4.click();

        WebElement button5 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[id='payment-info-buttons-container']>input")));
        button5.click();

        WebElement button6 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[id='confirm-order-buttons-container']>input")));
        button6.click();

        wait.until(ExpectedConditions.urlContains("completed"));

        WebElement success = driver.findElement(By.cssSelector("div[class='title']"));
        Assert.assertTrue("Success message is incorrect",success.getText().equals("Your order has been successfully processed!"));

        WebElement order = driver.findElement(By.cssSelector("ul[class='details']>li"));
        Assert.assertTrue("Order text is empty",!order.getText().isEmpty());

        WaitClose();
    }

}
