package co.westpac.pom;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import co.westpac.generic.SuperTestNg;
/**
 * This class consists of the web elements and functions 
 *  related to KiwiSaver Calculators page of the application
 * 
 * @author shruthi
 *
 */
public class KiwiSaverCalculatorPage extends SuperTestNg{
	
	private static Logger log= LogManager.getLogger(KiwiSaverCalculatorPage.class.getName());
	public KiwiSaverCalculatorPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/kiwisaver/calculators/kiwisaver-calculator/']")
	private WebElement getStartedButton;
	
	
	/**
	 * method to click on Click here to get started button - to navigate to retirement calculator
	 * @throws InterruptedException 
	 */
	
	public void openRetirementCalculator() throws InterruptedException{
		log.info("Inside openRetirementCalculator method");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		log.debug("Before scrolling window");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		getStartedButton.click();
		log.info("after clicking on get started");
	}
}
