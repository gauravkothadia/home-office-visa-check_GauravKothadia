package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DurationOfStayPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='6 months or less']")
    WebElement lessThanSixMonths;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='longer than 6 months']")
    WebElement moreThanSixMonths;

    public void selectLengthOfStay(String moreOrLess){

        switch (moreOrLess){
            case "longer than 6 months":{
                clickOnElement(moreThanSixMonths);
                break;
            }
            case "6 months or less":{
                clickOnElement(lessThanSixMonths);
                break;
            }
            default:{

            }
        }
    }

    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
    }
}
