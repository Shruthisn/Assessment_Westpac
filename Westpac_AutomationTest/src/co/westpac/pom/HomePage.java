package co.westpac.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import co.westpac.generic.SuperTestNg;
/**
 * This class consists of the web elements and functions 
 *  related to Home page of the application
 * 
 * @author shruthi
 *
 */
public class HomePage extends SuperTestNg {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@FindBy(xpath="//a[@id='ubermenu-section-link-kiwisaver-ps']")
	private WebElement kiwiSaverTab;
	
	@FindBy(xpath="//a[@id='ubermenu-item-cta-kiwisaver-calculators-ps']")
	private WebElement kiwiSaverCalculator;
	
	
	/**
	 * method to select kiwi calculator
	 */
	
	public void selectKiwiCalculator(){
		log.info("inside selectKiwiCalculator method");
		Actions act = new Actions(driver);
		act.moveToElement(kiwiSaverTab).build().perform();
		log.info("after moving to kiwi saver");
		kiwiSaverCalculator.click();
		log.info("after clicking on kiwi calculator");
	
	}
}
