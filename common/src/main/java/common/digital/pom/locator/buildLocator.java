package common.digital.pom.locator;

import org.openqa.selenium.By;

public class buildLocator
{
    protected By builePageModelImg;

    protected By engineNameList;

    protected By buildPageHeader;

    protected By helpMeChooseBtn;

    protected String chooseColor;

    protected By selectedColor;

    protected String chooseInterior;

    protected By selectedInterior;

    protected String chooseWheels;

    protected By selectedWheels;

    protected By selectedEngine;

    protected By continueBtn;

    protected By estimateRepayments;



    public void buildLocators()
    {
        builePageModelImg = By.xpath("//div[contains(@class,'ContainerInsideSection')]//img[@alt='Evolve']");
        engineNameList = By.xpath("//div[contains(@class,'CardAreaComponents')]//h6/b");
        buildPageHeader = By.xpath("//*[text()='CHOOSE YOUR POWER']");
        helpMeChooseBtn = By.xpath("//*[text()='Help me choose']");
        chooseColor = "//img[@alt='sampleColor']/../../../..";
        selectedColor = By.xpath("//h4[text()='YOUR COLOUR']/.." +
                "//div[contains(@class,'BuildToolBuildContentSectionSubtitle')]/div[1]");
        chooseInterior = "//img[@alt='sampleInterior']/../../../..";
        selectedInterior = By.xpath("(//h4[text()='YOUR INTERIOR']/.." +
                "//div[contains(@class,'BuildToolBuildContentSectionSubtitle')]/div)[1]");
        chooseWheels = "//img[@alt='sampleWheel']/../../../..";
        selectedWheels = By.xpath("//h4[text()='YOUR WHEELS']/.." +
                "//div[contains(@class,'BuildToolBuildContentSectionSubtitle')]/div");
        selectedEngine = By.xpath("//div[contains(@class,'SecondSectionActiveIcon')]" +
                "/following-sibling::div[2]//h6");
        continueBtn = By.xpath("//button[text()='Continue']");
        estimateRepayments = By.xpath("//div[text()='Estimate Repayments']");
    }
}
