package co.westpac.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import co.westpac.generic.ExcelUtil;
import co.westpac.generic.SuperTestNg;
import co.westpac.pom.HomePage;
import co.westpac.pom.RetirementCalculatorPage;
import co.westpac.pom.KiwiSaverCalculatorPage;

/**
 * This class validates the information icon
 * present against each field in the retirement calculator
 * 
 * @author shruthi
 *
 */
@Listeners(co.westpac.generic.Listeners.class)
public class KiwiCal_InfoIconValidation extends SuperTestNg{
	
	private static Logger log= LogManager.getLogger(KiwiCal_InfoIconValidation.class.getName());

	String currentAgeHelpText=ExcelUtil.getCellData(1, 1, "HelpTexts");
	String employmentStatusHelpText=ExcelUtil.getCellData(1, 2, "HelpTexts");
	String salaryPerYearHelptext=ExcelUtil.getCellData(1, 3, "HelpTexts");
	String memberContributionHelpText =ExcelUtil.getCellData(1, 4, "HelpTexts");
	String pirHelpText=ExcelUtil.getCellData(1, 5, "HelpTexts");
	String findMyRateHelpText=ExcelUtil.getCellData(1, 6, "HelpTexts");
	String kiwiSaverbalanceHelpText=ExcelUtil.getCellData(1, 7, "HelpTexts");
	String voluntaryContributionsHelpText=ExcelUtil.getCellData(1, 8, "HelpTexts");
	String riskProfileHelpText=ExcelUtil.getCellData(1, 9, "HelpTexts");
	String savingsGoalHelpText=ExcelUtil.getCellData(1, 10, "HelpTexts");
		
	@Test(priority=1)
	public void navigateToCalculator(){
		HomePage hp = new HomePage(driver); 
		hp.selectKiwiCalculator();
		KiwiSaverCalculatorPage cp= new KiwiSaverCalculatorPage(driver);
		try {
			cp.openRetirementCalculator();
		} catch (InterruptedException e) {
			log.error("retirement calculator not opened");
			e.printStackTrace();
		}
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		rp.switchToFrame();
	}
	
	
	@Test(priority=2)
	public void validateCurrentAgeInfoIcon(){
		String currentAgeHelpText=ExcelUtil.getCellData(1, 1, "HelpTexts");
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement currentAgeInfoIcon=rp.getCurrentAgeInfoIcon();
		String helpText=rp.getHelpText(currentAgeInfoIcon);
		if(helpText.equals(currentAgeHelpText)){
			Reporter.log("Expected message is displayed after clicking on Current Age help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Current Age help icon");
			Assert.fail();
		}
		
	}
	
	@Test(priority=3)
	public void validateEmploymentStatusInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement empStatusInfoIcon=rp.getEmpStatusInfoIcon();		
		String helpText=rp.getHelpText(empStatusInfoIcon);
		if(helpText.equals(employmentStatusHelpText)){
			Reporter.log("Expected message is displayed after clicking on Employment Status help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Employment Status help icon");
			Assert.fail();
		}	
	}
	
	@Test(priority=4)
	public void validateSalaryPerYearInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		 rp.selectEmploymentStatus("Employed");
		WebElement salaryPerYearInfoIcon=rp.getSalaryPerYearInfoIcon();		
		String helpText=rp.getHelpText(salaryPerYearInfoIcon);
		if(helpText.equals(salaryPerYearHelptext)){
			Reporter.log("Expected message is displayed after clicking on salary per year help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on salary per year help icon");
			Assert.fail();
		}		
	}
	
	@Test(priority=5)
	public void validateMemberContributionInfoIcon() throws Exception{
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement memberContributionInfoIcon=rp.getMemberContributionInfoIcon();		
		String helpText=rp.getHelpText(memberContributionInfoIcon);
		if(helpText.equals(memberContributionHelpText)){
			Reporter.log("Expected message is displayed after clicking on Member Contribution help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Member Contribution help icon");
			Assert.fail();
		}		
	}
	
	@Test(priority=6)
	public void validatePirInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement pirInfoIcon=rp.getPIRInfoIcon();
		String helpText=rp.getHelpText(pirInfoIcon);
		if(helpText.equals(pirHelpText)){
			Reporter.log("Expected message is displayed after clicking on PIR help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on PIR help icon");
			Assert.fail();
		}	
	}
	
	@Test(priority=7)
	public void validateFindMyRateInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement findMyRateInfoIcon=rp.getFindMyRateInfoIcon();
		String helpText=rp.getHelpText(findMyRateInfoIcon);
		if(helpText.equals(findMyRateHelpText)){
			Reporter.log("Expected message is displayed after clicking on Find My Rate help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Find My Rate help icon");
			Assert.fail();
		}	
	}
	
	@Test(priority=8)
	public void validateKiwiSaverBalanceInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		WebElement kiwiSaverBalanceInfoIcon=rp.getKiwiSaverBalanceInfoIcon();
		String helpText=rp.getHelpText(kiwiSaverBalanceInfoIcon);
		if(helpText.equals(kiwiSaverbalanceHelpText)){
			Reporter.log("Expected message is not displayed after clicking on Kiwi Saver Balance help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Kiwi Saver Balance help icon");
			Assert.fail();
		}	
	}
	
	@Test(priority=9)
	public void validateVoluntaryContributionsInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement voluntaryContributionsInfoIcon=rp.getVoluntaryContributionsInfoIcon();
		String helpText=rp.getHelpText(voluntaryContributionsInfoIcon);
		if(helpText.equals(voluntaryContributionsHelpText)){
			Reporter.log("Expected message is displayed after clicking on Voluntary Contributions help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Voluntary Contributions help icon");
			Assert.fail();
		}	
	}
	
	@Test(priority=10)
	public void validateRiskProfileInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement riskProfileInfoIcon=rp.getRiskProfileInfoIcon();
		String helpText=rp.getHelpText(riskProfileInfoIcon);
		if(helpText.equals(riskProfileHelpText)){
			Reporter.log("Expected message is displayed after clicking on Risk Profile help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Risk Profile help icon");
			Assert.fail();
		}	
	}
	
	@Test(priority=11)
	public void validateSavingsGoalInfoIcon(){
		RetirementCalculatorPage rp= new RetirementCalculatorPage(driver);
		WebElement savingsGoalInfoIcon=rp.getSavingsGoalInfoIcon();
		String helpText=rp.getHelpText(savingsGoalInfoIcon);
		if(helpText.equals(savingsGoalHelpText)){
			Reporter.log("Expected message is displayed after clicking on Savings Goal help icon");
		}else{
			log.error("inside assert false");
			Reporter.log("Expected message is not displayed after clicking on Savings Goal help icon");
			Assert.fail();
		}	
	}
	
}
