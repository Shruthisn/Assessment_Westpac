package co.westpac.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import co.westpac.generic.ExcelUtil;
import co.westpac.generic.SuperTestNg;
import co.westpac.pom.HomePage;
import co.westpac.pom.KiwiSaverCalculatorPage;
import co.westpac.pom.RetirementCalculatorPage;

/**
 * This class validates if an user who is not employed is able to calculate his
 * projected balances at retirement
 * 
 * @author shruthi
 *
 */
@Listeners(co.westpac.generic.Listeners.class)
public class KiwiCal_NotEmployed_Balance extends SuperTestNg{
	
	private static Logger log= LogManager.getLogger(KiwiCal_NotEmployed_Balance.class.getName());

	
	@Test
	public void calculateBalanceForNotEmployed(){
		
		String age=ExcelUtil.getCellData(2, 1, "CalculateBalance");
		String employmentStatus=ExcelUtil.getCellData(2,2, "CalculateBalance");
		String investorRate=ExcelUtil.getCellData(2, 5, "CalculateBalance");
		String kiwiSaverBalance=ExcelUtil.getCellData(2, 6, "CalculateBalance");
		String voluntaryContributionsAmount=ExcelUtil.getCellData(2, 7, "CalculateBalance");
		String riskProfile=ExcelUtil.getCellData(2, 8, "CalculateBalance");
		String savingsGoalAmount=ExcelUtil.getCellData(2, 9, "CalculateBalance");
		
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
        rp.selectannualFrequency();
        rp.selectRiskProfile(riskProfile);
        rp.enterSavingsGoalAtRetirement(savingsGoalAmount);
        rp.viewRetirementProjections();
        if(rp.validateProjectedBalance())
        {
            log.info("User is able to calculate his projected balance at retirement");
            Reporter.log("User is able to calculate his projected balance at retirement");
        } else
        {
            log.error("User is not able to calculate his projected balance at retirement");
            Assert.fail();
        }    		
	}	
}

