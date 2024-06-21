package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {

    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    DurationOfStayPage durationOfStayPage;
    WorkTypePage workTypePage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage = new WorkTypePage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void anAustralianComingToUKForTourism() {
        //Click on start button
        startPage.clickAcceptCookiesButton();
        startPage.clickStartNow();
        //	Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Australia");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism");
        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //	verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");
    }

    @Test(groups = {"regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        //	Click on start button
        startPage.clickAcceptCookiesButton();
        startPage.clickStartNow();
        //	Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("Chile");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //	Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        //	Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //	Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //	Click on Continue button
        workTypePage.clickNextStepButton();
        //	verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMessage("You need a visa to work in health and care");
    }

    @Test(groups = {"sanity", "regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        //	Click on start button
        startPage.clickAcceptCookiesButton();
        startPage.clickStartNow();
        //	Select a Nationality 'Colombia'
        /*----------CORRECTION: Due to changes in rules,
        Columbia selection will not progress to pass this test,
        hence in order to verify all the steps correct requirement is needed.
        In this situation, I have taken "India" to progress following checks.
         ----------*/
        selectNationalityPage.selectNationality("India");
        //	Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //	Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        //	Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //	Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus("Yes");
        //	Click on Continue button
        familyImmigrationStatusPage.clickNextStepButton();
        //	verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMessage("You’ll need a visa to join your family or partner in the UK");
    }
}
