package AtmosphereStore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.atmosphere.AtmosphereCartPage;
import pageobject.atmosphere.AtmosphereMainPage;
import pageobject.atmosphere.AtmosphereParkasPage;

import java.util.concurrent.TimeUnit;

public class AtmosphereTestsSuite {

  private WebDriver webDriver;

  @Before
  public void initDriver(){
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
  }

  @Test
  public void verifyAddItemToCartFunctionality (){
    webDriver.get("https://www.atmosphere.ca/");
    webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

    AtmosphereMainPage searchPage = new AtmosphereMainPage(webDriver);
    searchPage.searchForParkas("PARKAS");
    searchPage.searchParkasPage();

    AtmosphereParkasPage parkasPage = new AtmosphereParkasPage(webDriver);
    JavascriptExecutor jsx = (JavascriptExecutor)webDriver;
    jsx.executeScript("window.scrollBy(0,1400)", "");

    parkasPage.choiceParakasItem();

    JavascriptExecutor jsx1 = (JavascriptExecutor)webDriver;
    jsx1.executeScript("window.scrollBy(0,400)", "");
    parkasPage.choiseParakasColourItem();

    parkasPage.choiseParakasSizeItem();
    parkasPage.enterButtonParakasCardItem();

    AtmosphereCartPage cartPage = new AtmosphereCartPage(webDriver);
    cartPage.parakasItemInCart();

    String textChoiceName = parkasPage.getChoiceItem().getText();
    Assert.assertEquals("Helly Hansen Men's Svalbard Insulated Parka",textChoiceName);

  }

//  @After
//  public void hutDownDriver(){
//    webDriver.close();
//    webDriver.quit();
//  }
}
