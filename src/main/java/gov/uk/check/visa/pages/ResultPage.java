package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@data-flow-name='check-uk-visa']/child::div[1]/child::h2")
    WebElement resultMessage;

    public String getResultMessage(){
        return getTextFromElement(resultMessage);
    }

    public void confirmResultMessage(String expectedMessage){
        Assert.assertTrue(getResultMessage().equals(expectedMessage));
    }


}
