import Utility.BaseDriver;
import Utility.MyFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;


public class _0601_Order extends BaseDriver {
    @Test
    public void test0601(){

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

        WebElement laptop = driver.findElement(By.linkText("14.1-inch Laptop"));
        laptop.click();

        WebElement addToCart = driver.findElement(By.cssSelector("input[class='button-1 add-to-cart-button']"));
        addToCart.click();

        WebElement shoppingCart = driver.findElement(By.linkText("Shopping cart"));
        shoppingCart.click();

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

        WebElement button1 = driver.findElement(By.cssSelector("[id='billing-buttons-container']>input"));
        button1.click();

        WebElement shipping = driver.findElement(By.id("opc-shipping"));
        wait.until(ExpectedConditions.visibilityOfAllElements(shipping));

        WebElement button2 = driver.findElement(By.cssSelector("[id='shipping-buttons-container']>input"));
        button2.click();

        WebElement shippingMethod = driver.findElement(By.id("opc-shipping_method"));
        wait.until(ExpectedConditions.visibilityOfAllElements(shippingMethod));

        WebElement button3 = driver.findElement(By.cssSelector("[id='shipping-method-buttons-container']>input"));
        button3.click();

        WebElement payment = driver.findElement(By.id("opc-payment_method"));
        wait.until(ExpectedConditions.visibilityOfAllElements(payment));

        WebElement button4 = driver.findElement(By.cssSelector("[id='payment-method-buttons-container']>input"));
        button4.click();

        WebElement paymentInfo = driver.findElement(By.id("opc-payment_info"));
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentInfo));

        WebElement button5 = driver.findElement(By.cssSelector("[id='payment-info-buttons-container']>input"));
        button5.click();

        WebElement confirm = driver.findElement(By.id("opc-confirm_order"));
        wait.until(ExpectedConditions.visibilityOfAllElements(confirm));

        WebElement button6 = driver.findElement(By.cssSelector("[id='confirm-order-buttons-container']>input"));
        button6.click();

        WebElement success = driver.findElement(By.cssSelector("div[class='title']"));
        String successText = success.getText();
        Assert.assertTrue("Success message is incorrect",successText.equals("Your order has been successfully processed!"));

        WebElement order = driver.findElement(By.cssSelector("ul[class='details']>li"));
        String orderText = order.getText();
        Assert.assertTrue("Order text is empty",!orderText.isEmpty());

        WaitClose();
    }

}