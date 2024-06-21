package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FamilyImmigrationStatusPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement yesLink;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='No']")
    WebElement noLink;

    public void selectImmigrationStatus(String status) {
        switch (status) {
            case "Yes": {
                clickOnElement(yesLink);
                break;
            }
            case "No": {
                clickOnElement(noLink);
                break;
            }
            default: {

            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(nextStepButton);
    }
}
