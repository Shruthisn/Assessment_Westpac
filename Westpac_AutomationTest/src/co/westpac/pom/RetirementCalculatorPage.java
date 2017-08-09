package co.westpac.pom;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.westpac.generic.SuperTestNg;

/**
 * This class consists of the web elements and functions 
 *  related to KiwiSaver Retirement Calculator page of the application
 * 
 * @author shruthi
 *
 */
 
public class RetirementCalculatorPage extends SuperTestNg{
	
	private static Logger log= LogManager.getLogger(RetirementCalculatorPage.class.getName());
	
	public RetirementCalculatorPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor exec= (JavascriptExecutor)driver;
	
	@FindBy(xpath="//div[@id='calculator-embed']/iframe")
	private WebElement calculatorFrame;
	
	@FindBy(xpath="//div[@class='field-message message-info ng-binding']/p")
	private WebElement helpText;
	
	/************************************************************************************************
	 * info icon objects of Retirement Calculator
	 */
	
	@FindBy(xpath="//div[@help-id='CurrentAge']//following-sibling::button")
	private WebElement currentAgeInfoIcon;
	
	@FindBy(xpath="//div[@help-id='EmploymentStatus']//following-sibling::button")
	private WebElement empStatusInfoIcon;
	
	@FindBy(xpath="//div[@help-id='AnnualIncome']//following-sibling::button")
	private WebElement salaryInfoIcon;
	
	@FindBy(xpath="//div[@help-id='KiwiSaverMemberContribution']//following-sibling::button")
	private WebElement memberContributionInfoIcon;
	
	@FindBy(xpath="//div[@help-id='PIRRate']//following-sibling::button")
	private WebElement pirInfoIcon;
	
	@FindBy(xpath="//div[@help-id='PIRRate']//a[@class='external-link-control ng-scope']")
	private  WebElement findMyRateLink;
	
	@FindBy(xpath="//div[@help-id='FindMyPIRRateQ1']//following-sibling::button")
	private WebElement findMyRateInfoIcon;
	
	@FindBy(xpath="//div[@help-id='KiwiSaverBalance']//following-sibling::button")
	private WebElement kiwiSaverBalanceInfoIcon;
	
	@FindBy(xpath="//div[@help-id='VoluntaryContributions']//following-sibling::button")
	private WebElement voluntaryContributionsInfoIcon;
	
	@FindBy(xpath="//div[@help-id='RiskProfile']//following-sibling::button")
	private WebElement riskProfileInfoIcon;
	
	@FindBy(xpath="//div[@help-id='SavingsGoal']//following-sibling::button")
	private WebElement savingsGoalInfoIcon;
	
	/***********************************************************************************************************************
	 * text boxes and drop down objects of Retirement Calculator
	 */
	
	@FindBy(xpath="//div[@class='wpnib-field-current-age field-group ng-isolate-scope']//input")
	private WebElement currentAgeTextBox;
	
	@FindBy(xpath="//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']//div[@class='control-well']/i[@class='ir dropdown-arrow']")
	private WebElement employmentStatusDropDown;
	
	@FindBy(xpath="//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']//div[@class='dropdown']/ul/li[2]")
	private WebElement employedOption;
	
	@FindBy(xpath="//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']//div[@class='dropdown']/ul/li[3]")
	private WebElement selfEmployedOption;
	
	@FindBy(xpath="//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']//div[@class='dropdown']/ul/li[4]")
	private WebElement notEmployedOption;
	
	@FindBy(xpath="//div[@class='wpnib-field-annual-income field-group ng-scope ng-isolate-scope']//input")
	private WebElement salaryTextBox;
	
	@FindBy(xpath="//div[@class='wpnib-field-kiwisaver-member-contribution field-group ng-scope ng-isolate-scope']//input[@id='radio-option-06B']")
	private WebElement threePercentContribution;
	
	@FindBy(xpath="//div[@class='wpnib-field-kiwisaver-member-contribution field-group ng-scope ng-isolate-scope']//input[@id='radio-option-06E']")
	private WebElement fourPercentContribution;
	
	@FindBy(xpath="//div[@class='wpnib-field-kiwisaver-member-contribution field-group ng-scope ng-isolate-scope']//input[@id='radio-option-06H']")
	private WebElement eightPercentContribution;
	
	@FindBy(xpath="//div[@class='wpnib-field-pir-rate field-group ng-isolate-scope']//div[@class='control-well']/i[@class='ir dropdown-arrow']")
	private WebElement pirDropDown;
	
	@FindBy(xpath="//div[@class='wpnib-field-pir-rate field-group ng-isolate-scope']//div[@class='dropdown']//ul//li[@class='option-item ng-isolate-scope first-non-empty-option-item']")
	private WebElement tenAndHalfOption;
	
	@FindBy(xpath="//div[@class='wpnib-field-pir-rate field-group ng-isolate-scope']//div[@class='dropdown']//ul//li[@class='option-item ng-isolate-scope']")
	private WebElement seventeenAndHalfOption;
	
	@FindBy(xpath="//div[@class='wpnib-field-pir-rate field-group ng-isolate-scope']//div[@class='dropdown']//ul//li[@class='option-item ng-isolate-scope last-option-item']")
	private WebElement twentyEightOption;
	
	@FindBy(xpath="//div[@class='wpnib-field-kiwi-saver-balance field-group ng-isolate-scope']//input")
	private WebElement kiwiSaverBalanceTextBox;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//input")
	private WebElement voluntaryContributionsTextBox;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//div[@class='control select-control  no-selection']//i[@class='ir dropdown-arrow']")
	private WebElement frequencyDropDown;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//ul//li[2]")
	private WebElement oneOffFrequency;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//ul//li[3]")
	private WebElement weeklyFrequency;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//ul//li[4]")
	private WebElement fortNightlyFrequency;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//ul//li[5]")
	private WebElement monthlyFrequency;
	
	@FindBy(xpath="//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//ul//li[6]")
	private WebElement annualFrequency;
	
	@FindBy(xpath="//div[@class='wpnib-field-risk-profile field-group ng-isolate-scope']//input[@id='radio-option-01V']")
	private WebElement lowProfileRadioButton;
	
	@FindBy(xpath="//div[@class='wpnib-field-risk-profile field-group ng-isolate-scope']//input[@id='radio-option-01Y']")
	private WebElement mediumProfileRadioButton;
	
	@FindBy(xpath="//div[@class='wpnib-field-risk-profile field-group ng-isolate-scope']//input[@id='radio-option-021']")
	private WebElement highProfileRadioButton;
	
	@FindBy(xpath="//div[@class='wpnib-field-savings-goal field-group ng-isolate-scope']//input")
	private WebElement goalAtRetirementTextBox; 
	
	@FindBy(xpath="//div[@class='field-group-set']/button[@class='btn btn-regular btn-results-reveal btn-has-chevron']")
	private WebElement viewProjectionsButton;
	
	@FindBy(xpath="//div[@ng-show='ctrl.view.resultsPanelRevealed']")
	private WebElement projectedBalance;
	
	@FindBy(xpath="//div[@ng-show='ctrl.view.resultsPanelRevealed']//div[@class='results-heading']//span[@class='result-value result-currency ng-binding']")
	private WebElement projectedBalanceValue;
	
	/**
	 * method to switch to frame 
	 */
	public void switchToFrame() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorFrame));
		log.debug("after switching to iframe");	
	}
	
	/**
	 * method to get current age info icon
	 * @return currentAgeInfoIcon
	 */
	public WebElement getCurrentAgeInfoIcon(){
		return currentAgeInfoIcon;
	}
	
	/**
	 * method to get employment status info icon
	 * @return empStatusInfoIcon
	 */
	public WebElement getEmpStatusInfoIcon(){																					
		return empStatusInfoIcon;
	}
	
	/**
	 * method to get salaryInfoIcon
	 * @return salaryInfoIcon
	 */
	public WebElement getSalaryPerYearInfoIcon(){
		return salaryInfoIcon;
	}
	
	/**
	 * method to get memberContributionInfoIcon
	 * @return memberContributionInfoIcon
	 */
	public WebElement getMemberContributionInfoIcon(){
		return memberContributionInfoIcon;
	}
	
	/**
	 * method to get pirInfoIcon
	 * @return pirInfoIcon
	 */
	public WebElement getPIRInfoIcon(){
		return pirInfoIcon;
	}
	
	/**
	 * method to get findMyRateInfoIcon
	 * @return findMyRateInfoIcon
	 */
	public WebElement getFindMyRateInfoIcon(){
		findMyRateLink.click();
		return findMyRateInfoIcon;
	}
	
	/**
	 * method to get kiwiSaverBalanceInfoIcon
	 * @return kiwiSaverBalanceInfoIcon
	 */
	public WebElement getKiwiSaverBalanceInfoIcon(){
		return kiwiSaverBalanceInfoIcon;
	}
	
	/**
	 * method to get voluntaryContributionsInfoIcon
	 * @return voluntaryContributionsInfoIcon
	 */
	public WebElement getVoluntaryContributionsInfoIcon(){
		return voluntaryContributionsInfoIcon;
	}
	
	/**
	 * method to get riskProfileInfoIcon
	 * @return riskProfileInfoIcon
	 */
	public WebElement getRiskProfileInfoIcon(){
		return riskProfileInfoIcon;
	}
	
	/**
	 * method to get savingsGoalInfoIcon
	 * @return savingsGoalInfoIcon
	 */
	public WebElement getSavingsGoalInfoIcon(){
		return savingsGoalInfoIcon;
	}
	
	/**
	 * method to retrieve help text displayed after clicking on the icon
	 * @param icon
	 * @return
	 */
	public String getHelpText(WebElement icon){	
		if(icon.isDisplayed()){
		log.info("Info icon is displayed");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", icon);
		String infoMessage = helpText.getText();
		return infoMessage;		
	}else{
		log.error("Info icon is not displayed");
	return "info icon is not displayed";
	}
	}
	
	/**
	 * method to enter current age
	 * @param age
	 */
	public void enterAge(String age){
		currentAgeTextBox.clear();
		currentAgeTextBox.sendKeys(age);
	}
	
	/**
	 * method to select employed employment status
	 * @param status
	 */
    public void selectEmploymentStatus(String status){    
        if(status.equals("Employed")) {
            exec.executeScript("arguments[0].click()", employmentStatusDropDown);
            employedOption.click();
        }else if(status.equals("SelfEmployed")){
            exec.executeScript("arguments[0].click()", employmentStatusDropDown);
            selfEmployedOption.click();
        }else if(status.equals("NotEmployed")){
            exec.executeScript("arguments[0].click()", employmentStatusDropDown);
            notEmployedOption.click();
        }
    }

	
	/**
	 * method to enter salary per year
	 * @param salary
	 */
	
	public void enterSalaryPerYear(String salary){
		salaryTextBox.clear();
		salaryTextBox.sendKeys(salary);		
	}
	
	/**
	 * method to select kiwi saver member contribution
	 * @param percent
	 */
    public void selectMemberContribution(String percent){
        if(Integer.parseInt(percent) == 3) {
        	threePercentContribution.click();     
        }else if(Integer.parseInt(percent)==4){
        	 fourPercentContribution.click();	 
        }else if(Integer.parseInt(percent)==8){
        	eightPercentContribution.click();
        }else{
        	log.error("Invalid input");
        }
    }

	/**
	 * method to select  prescribed investor rate
	 * @param rate
	 */
    public void selectInvestorRate(String rate){
        if(Double.parseDouble(rate)==10.5){
            exec.executeScript("arguments[0].click()", pirDropDown);
            tenAndHalfOption.click();
        } else if(Double.parseDouble(rate)==17.5){
            exec.executeScript("arguments[0].click()", pirDropDown);
            seventeenAndHalfOption.click();
        } else if(Double.parseDouble(rate)==28) {
            exec.executeScript("arguments[0].click()", pirDropDown);
            twentyEightOption.click();
        }else{
        	log.error("Invalid input");
        }
    }


	/**
	 * method to enter current kiwi saver balance
	 * @param balance
	 */
	public void enterKiwiSaverBalance(String balance){
		kiwiSaverBalanceTextBox.clear();
		kiwiSaverBalanceTextBox.sendKeys(balance);
	}
	
	/**
	 * method to enter voluntary contributions
	 * @param voluntaryContributions
	 */
	public void enterVoluntaryContributions(String voluntaryContributions){
		exec.executeScript("window.scrollBy(0,150)", "");
		voluntaryContributionsTextBox.sendKeys(voluntaryContributions);
	}
	
	/**
	 * method to select fortnightly contribution frequency
	 */
	public void selectFortnightlyFrequency(){
		exec.executeScript("arguments[0].click()", frequencyDropDown);
		fortNightlyFrequency.click();
	}
	
	/**
	 * method to select annual contribution frequency
	 */
	public void selectannualFrequency(){
		exec.executeScript("arguments[0].click()", frequencyDropDown);
		annualFrequency.click();
	}
	
	/**
	 * method to select  risk profile
	 * @param profile
	 */
	public void selectRiskProfile(String profile) {
        if(profile.equals("Low")){
            lowProfileRadioButton.click();
        }else if(profile.equals("Medium")){
            mediumProfileRadioButton.click();
        } else if(profile.equals("High")) {
            highProfileRadioButton.click();
        }else{
        	log.error("Invalid input");
        }
    }
	
	/**
	 * method to enter savings goal at retirement
	 * @param savingsGoal
	 */
	public void enterSavingsGoalAtRetirement(String savingsGoal){
		goalAtRetirementTextBox.clear();
		goalAtRetirementTextBox.sendKeys(savingsGoal);
	}
	
	/**
	 * method to click on view projection button
	 */
	public void viewRetirementProjections(){
		viewProjectionsButton.click();
	}
	
	/**
	 * method to validate if projected balance is displayed
	 */
	public boolean validateProjectedBalance(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		if((projectedBalance.isDisplayed())&&(projectedBalanceValue.isDisplayed())){
			log.info("Projected balance at retirement is displayed--"+projectedBalanceValue.getText());
			return true;
		}else{
			log.error("Projected balance at retirement is not displayed");
			return false;
		}
	}
	
}
