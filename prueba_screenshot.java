package selenium;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class prueba_screenshot {

public static void main(String[] args) throws IOException {
	
System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
WebDriver driver  = new ChromeDriver();	

driver.get("http://demo.guru99.com/test/guru99home/");
driver.manage().window().maximize();
		
Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

ImageIO.write(Screenshot.getImage(), "jpg", new File(".\\screenshot\\fullimage.jpg"));
	
	}

}
