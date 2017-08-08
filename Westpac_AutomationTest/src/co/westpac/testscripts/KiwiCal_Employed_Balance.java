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
 * This class validates if an employed user is able to calculate his
 * projected balances at retirement
 * 
 * @author shruthi
 *
 */

public class KiwiCal_Employed_Balance extends SuperTestNg {
	
	private static Logger log= LogManager.getLogger(KiwiCal_Employed_Balance.class.getName());
		
	@Test
	public void calculateBalanceForEmployed() {
		
		String age=ExcelUtil.getCellData(1, 1, "CalculateBalance");
		String employmentStatus=ExcelUtil.getCellData(1,2, "CalculateBalance");
		String salaryPerYear=ExcelUtil.getCellData(1,3, "CalculateBalance");
		String memberContribution=ExcelUtil.getCellData(1, 4, "CalculateBalance");
		String investorRate=ExcelUtil.getCellData(1, 5, "CalculateBalance");
		String riskProfile=ExcelUtil.getCellData(1, 8, "CalculateBalance");
		
		
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
        rp.enterSalaryPerYear(salaryPerYear);
        rp.selectMemberContribution(memberContribution);
        rp.selectInvestorRate(investorRate);
        rp.selectRiskProfile(riskProfile);
        rp.viewRetirementProjections();
		if(rp.validateProjectedBalance()){
			log.info("User is able to calculate his projected balance at retirement");
			Reporter.log("User is able to calculate his projected balance at retirement");
		}else{
			log.error("User is not able to calculate his projected balance at retirement");
			Assert.fail();
		}
		
	}
}
