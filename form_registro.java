package selenium;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class form_registro {
	private WebDriver driver;
	By registerPageLocator = By.linkText("//img[@src='/images/masts/mast_register.gif']");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	
	@Test
	  public void test_uno() throws InterruptedException {
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		//información personal
		driver.findElement(By.name("firstName")).sendKeys("Mario");
		driver.findElement(By.name("lastName")).sendKeys("de la Rosa");
		driver.findElement(By.name("phone")).sendKeys("5566778899");
		driver.findElement(By.name("userName")).sendKeys("mario.delarosa@live.com.mx");
		
		//dirección
		driver.findElement(By.name("address1")).sendKeys("rio de los remedios 55");
		driver.findElement(By.name("city")).sendKeys("puebla de juarez");
		driver.findElement(By.name("state")).sendKeys("puebla");
		driver.findElement(By.name("postalCode")).sendKeys("55060");
		Select country = new Select (driver.findElement(By.name("country")));
		country.selectByVisibleText("ANDORRA");
		
		//información del usuario
		driver.findElement(usernameLocator).sendKeys("mario");
		driver.findElement(passwordLocator).sendKeys("contraseñ@");
		driver.findElement(confirmPasswordLocator).sendKeys("contraseñ@");
		driver.findElement(registerBtnLocator).click();
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is mario.", fonts.get(5).getText());
		
	}
	
	@After 
	public void main() throws IOException {
				
		Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(Screenshot.getImage(), "jpg", new File(".\\screenshot\\fullimage.jpg"));
				
        driver.quit();
	}

}
