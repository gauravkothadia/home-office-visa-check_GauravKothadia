package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='gem-c-radio govuk-radios__item']/child::label")
    List<WebElement> selectJobTypeList;

    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
    }

    public void selectJobType(String job){
        for(WebElement ele : selectJobTypeList){
            if(getTextFromElement(ele).trim().contains(job)){
                clickOnElement(ele);
                break;
            }
        }
    }
}
