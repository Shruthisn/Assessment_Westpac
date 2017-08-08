package co.westpac.generic;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * This class consists of the methods to initiate the browser 
 * and launch URL
 * 
 * @author shruthi
 *
 */
public class SuperTestNg {
	
	public static WebDriver driver;

		    @BeforeTest
		    public void BrowserInit(){
		        if(Constant.Browser.equals("Firefox")){
		        	String firefoxDriverPath=new File("Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe").getAbsolutePath();
		        	System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
		        	DesiredCapabilities dc = DesiredCapabilities.firefox();
		        	dc.setCapability("marionette", true);
		        	 driver =  new FirefoxDriver(dc);
				}else if(Constant.Browser.equals("Chrome")){
					String chromeDriverPath=new File("Drivers\\chromedriver_win32\\chromedriver.exe").getAbsolutePath();
					System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver();
				}else{
					String ieDriverPath= new File("Drivers\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe").getAbsolutePath();
					System.setProperty("webdriver.ie.driver",ieDriverPath);
                    DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
                    cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					driver = new InternetExplorerDriver(cap);				
                    }
		     }
		    
		    @BeforeClass
		    public void LaunchURL() throws IOException{
		    	driver.get(Constant.URL);
		    	driver.manage().window().maximize();   
		    }
		    
		    @AfterTest
		    public void CloseBrowser(){
		        driver.close();
		    }
		
	}

