package co.westpac.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import co.westpac.generic.ExcelUtil;
import co.westpac.generic.SuperTestNg;
import co.westpac.pom.HomePage;
import co.westpac.pom.KiwiSaverCalculatorPage;
import co.westpac.pom.RetirementCalculatorPage;

/**
 * This class validates if a self-employed user is able to calculate his
 * projected balances at retirement
 * 
 * @author shruthi
 *
 */
public class KiwiCal_SelfEmployed_Balance extends SuperTestNg {
	
	private static Logger log= LogManager.getLogger(KiwiCal_SelfEmployed_Balance.class.getName());

	@Test
	public void calculateBalanceForSelfEmployed(){
		
		String age=ExcelUtil.getCellData(3, 1, "CalculateBalance");
		String employmentStatus=ExcelUtil.getCellData(3,2, "CalculateBalance");
		String investorRate=ExcelUtil.getCellData(3, 5, "CalculateBalance");
		String kiwiSaverBalance=ExcelUtil.getCellData(3, 6, "CalculateBalance");
		String voluntaryContributionsAmount=ExcelUtil.getCellData(3, 7, "CalculateBalance");
		String riskProfile=ExcelUtil.getCellData(3, 8, "CalculateBalance");
		String savingsGoalAmount=ExcelUtil.getCellData(3, 9, "CalculateBalance");
		
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
        rp.enterAge(age);
        rp.selectEmploymentStatus(employmentStatus);
        rp.selectInvestorRate(investorRate);
        rp.enterKiwiSaverBalance(kiwiSaverBalance);
        rp.enterVoluntaryContributions(voluntaryContributionsAmount);
        rp.selectFortnightlyFrequency();
        rp.selectRiskProfile(riskProfile);
        rp.enterSavingsGoalAtRetirement(savingsGoalAmount);
        rp.viewRetirementProjections();
        if(rp.validateProjectedBalance())
        {
            log.info("User is able to calculate his projected balance at retirement");
            Reporter.log("User is able to calculate his projected balance at retirement");
        }
        else
        {
            log.error("User is not able to calculate his projected balance at retirement");
            Assert.fail();
        }	
	}
}
