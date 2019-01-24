package com.prestashop.tests.functional_tests;

import com.github.javafaker.Faker;
import com.prestashop.pages.MyAccount;
import com.prestashop.pages.PrestaShopHomePage;
import com.prestashop.pages.ProductController;
import com.prestashop.pages.Registration;
import com.prestashop.utilities.Base;
import com.prestashop.utilities.ConfigReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RegistrationTest extends Base {

    private WebElement product;

    @Test
    public void registration() {
        PrestaShopHomePage hp = new PrestaShopHomePage();
        MyAccount ma = new MyAccount();
        hp.open();
        Registration reg = new Registration();
        reg.signIn.click();
        Random random = new Random();
        int emailNo = random.nextInt(1000000);
        String email = "austintexas" + emailNo + "@mail.com";
        reg.emailCreate.sendKeys(email);
        reg.submitCreate.click();

        Assert.assertEquals(reg.emailCreate.getAttribute("value"), email);

        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        reg.customerFirsName.sendKeys(firstname);
        String lastname = faker.name().lastName();
        reg.customerLastName.sendKeys(lastname);
        String streetName = faker.address().streetAddress();
        reg.custmerAddress.sendKeys(streetName);
        reg.customerPhone.sendKeys(faker.phoneNumber().cellPhone());
        reg.customerPassword.sendKeys(ConfigReader.getProperty("password"));
        String city = faker.address().city();
        reg.customerCity.sendKeys(city);
        String zip = faker.address().zipCode().substring(0, 5);
        reg.customerZip.sendKeys(zip);
        reg.customerState.sendKeys("Texas");


        reg.costomerRegister.click();

        Assert.assertEquals(ma.viewMyCostumerAccount.getText(), firstname + " " + lastname);

        ma.MyPersonalInfo.click();
        Assert.assertEquals(ma.layerFirstName.getAttribute("value"), firstname);
        Assert.assertEquals(ma.layerLastName.getAttribute("value"), lastname);

        ma.viewMyCostumerAccount.click();
        ma.myAdress.click();
        Assert.assertEquals(ma.myAddressLine.getText(), streetName);
        String expectesCityStateZip = city + ", Texas " + zip;
        Assert.assertEquals(ma.cityStateZip.getText(), expectesCityStateZip);

        ma.signOut.click();

    }

    @Test
    public void validation() {
        PrestaShopHomePage hp = new PrestaShopHomePage();
        MyAccount ma = new MyAccount();
        hp.open();
        Registration reg = new Registration();
        reg.signIn.click();
        Random random = new Random();
        int emailNo = random.nextInt(1000000);
        String email = "austintexas" + emailNo + "@mail.com";
        reg.emailCreate.sendKeys(email);
        reg.submitCreate.click();

        Assert.assertEquals(reg.emailCreate.getAttribute("value"), email);

        Faker faker = new Faker();
        String firstname = "";
        reg.customerFirsName.sendKeys(firstname);
        String lastname = faker.name().lastName();
        reg.customerLastName.sendKeys(lastname);
        String streetName = faker.address().streetAddress();
        reg.custmerAddress.sendKeys(streetName);
        reg.customerPhone.sendKeys(faker.phoneNumber().cellPhone());
        reg.customerPassword.sendKeys(ConfigReader.getProperty("password"));
        String city = faker.address().city();
        reg.customerCity.sendKeys(city);
        String zip = faker.address().zipCode().substring(0, 5);
        reg.customerZip.sendKeys(zip);
        reg.customerState.sendKeys("Texas");


        reg.costomerRegister.click();

        Assert.assertEquals(ma.layerPwdError.getText(),"firstname is required.");
    }

    @Test
    public void getDetails() {
        PrestaShopHomePage hp=new PrestaShopHomePage();
        ProductController pc=new ProductController();
        hp.open();
        product = hp.pickProduct("Blouse");
        product.click();
        pc.quantity.clear();

        Random random=new Random();
        int sendQt=random.nextInt(3);
        String sendNow=""+(sendQt+2);
        pc.quantity.sendKeys(""+sendNow);

        int sizeNo=random.nextInt(3);
        String actualSize="";
        switch (sizeNo){
            case 0: Driver.getDriver().findElement(By.xpath("//option[@title='S']")).click(); break;
            case 1: Driver.getDriver().findElement(By.xpath("//option[@title='M']")).click(); ; break;
            case 2: Driver.getDriver().findElement(By.xpath("//option[@title='L']")).click(); ; break;

        }

        pc.addToCardBt.click();
        pc.layerConfirmationText.click();

        Assert.assertEquals(pc.layerConfirmationText.getText(),"Product successfully added to your shopping cart");

        pc.closeCheckout.click();

        actions.moveToElement(pc.hoverOverCart).build().perform();


    }
}