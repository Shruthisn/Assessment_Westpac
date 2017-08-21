package co.westpac.generic;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class consists of the functions
 * to capture screenshots
 * 
 * @author shruthi
 *
 */

public class Screenshots extends SuperTestNg{
	
	private static Logger log= LogManager.getLogger(Screenshots.class.getName());
	
    public void getPassScreenshot(String result) throws IOException{
    	log.info("inside screenshots method");
    	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String passScreenshotPath=new File("PassScreenshots").getAbsolutePath(); 
    	System.out.println(passScreenshotPath);
    	FileUtils.copyFile(src, new File(passScreenshotPath+"//"+result+"screenshot.png"));
    	log.debug("after copying screenshot to a file");
    }
    
    public void getFailScreenshot(String result) throws IOException{
    	log.info("inside screenshots method");
    	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String failScreenshotPath=new File("FailScreenshots").getAbsolutePath();
    	FileUtils.copyFile(src, new File(failScreenshotPath+"//"+result+"screenshot.png"));
    	log.debug("after copying screenshot to a file");
    }
}
