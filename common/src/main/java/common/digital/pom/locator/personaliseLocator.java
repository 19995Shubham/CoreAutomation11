package common.digital.pom.locator;

import org.openqa.selenium.By;

public class personaliseLocator
{
    protected By personalizeLabel;

    protected By optionalPackTitle;

    protected By optionalPackList;

    protected String optionsPackBtn;

    protected By detailsTitle;

    protected By nextArrow;

    protected  By modalCloseBtn;

    protected By confirmBtn;

    protected By driveAwayPrice;



    public void personaliseLocators()
    {
        personalizeLabel = By.xpath("//span[text()='PERSONALISE']/../../" +
                "button[contains(@class,'active')]");
        optionalPackTitle = By.xpath("//h4[text()='CHOOSE AN OPTIONAL PACK']");
        optionalPackList = By.xpath("//div[contains(@class,'CardAreaComponents')]//h6[not(@style)]");
        optionsPackBtn = "//div[contains(@class,'BuildToolPersonaliseEnhancementButtons')]" +
                "//button[text()='sampleText']";
        detailsTitle = By.xpath("//div[contains(@class,'OptionPackGalleryModalBodyRight')]//h4");
        nextArrow = By.xpath("//div[contains(@class,'OptionPackGalleryModalFooterArrowRight')]");
        modalCloseBtn = By.xpath("//div[contains(@class,'ModalCloseDark')]");
        confirmBtn = By.xpath("//button[text()='Confirm']");
        driveAwayPrice = By.xpath("//div[contains(@class,'FooterRepaymentSummary')]//h4");
    }
}
