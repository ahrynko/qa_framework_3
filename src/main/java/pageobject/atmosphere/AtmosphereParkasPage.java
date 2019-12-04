package pageobject.atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtmosphereParkasPage {

  @FindBy(xpath = "//span[contains(text(),\"Helly Hansen Men's Svalbard Insulated...\")]")
  private WebElement choiceItem;

  @FindBy(xpath = "//div[@class='product-detail__color']//a[3]")
  private WebElement choiceColourItem;

  @FindBy(xpath = "//a[@class='option-tiles__item '][2]")
  private WebElement choiceSizeItem;

  @FindBy(xpath = "//button[@class='add-cart product-detail__button product-detail__button-icon']")
  private WebElement addToCardItem;

  public AtmosphereParkasPage(WebDriver webDriver){  //constructor class
    PageFactory.initElements(webDriver,this);
  }

  public void choiceParakasItem(){
    choiceItem.click();
  }

  public void choiseParakasColourItem(){
    choiceColourItem.click();
  }

  public void choiseParakasSizeItem(){
    choiceSizeItem.click();
  }

  public void enterButtonParakasCardItem(){
    addToCardItem.click();
  }


  public WebElement getChoiceItem() {
    return choiceItem;
  }
}
