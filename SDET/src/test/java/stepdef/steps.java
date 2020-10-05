package stepdef;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

public class steps {
WebDriver driver;
WebElement UserName;
String un;
String nametext;
String check;

	@Before
	public void beforetest()
	{
		System.setProperty("webdriver.chrome.driver", "C://MyProject//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void aftertest()
	{
		driver.close();
	}
	
	
	@Given("User must be able to navigate to the application URL")
	public void user_must_be_able_to_navigate_to_the_application_url() throws InterruptedException {
		driver.get("http://elearningm1.upskills.in/");
		
			String expected = "English";
			String nameu = driver.findElement(By.xpath("//button[@class='btn btn-default dropdown-toggle']")).getText();
			assertTrue(nameu.contains(expected));
			driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();
			Thread.sleep(4000);
				
	}
	@When("User must be able to signup on the application")
	public void user_must_be_able_to_signup_on_the_application() throws InterruptedException {
		if(driver.findElement(By.xpath("//h2[contains(text(),'Registration')]")).isDisplayed())
{
	driver.findElement(By.id("registration_firstname")).sendKeys("Nisha");
	driver.findElement(By.id("registration_lastname")).sendKeys("Viswa");
	driver.findElement(By.id("registration_email")).sendKeys("test123@mail.com");
	 UserName= driver.findElement(By.xpath("//input[@id='username']"));
     UserName.sendKeys(randomNameGenerator());
    un = driver.findElement(By.xpath("//input[@id='username']")).getText();
	driver.findElement(By.id("pass1")).sendKeys("test123chcek");
	driver.findElement(By.id("pass2")).sendKeys("test123chcek");
	driver.findElement(By.id("registration_submit")).click();
	Thread.sleep(10000);
	}
	
	else {
		System.out.println("Fail");
	}
	}
	@Then("User should be registered and must be able to login again")
	public void user_should_be_registered_and_must_be_able_to_login_again() throws InterruptedException {
	
		nametext = driver.findElement(By.xpath("//div[@class='row']/div/p[1]")).getText();
        System.out.println(nametext);
        
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        driver.findElement(By.xpath("//a[@id='logout_button']")).click();
        Thread.sleep(2000);
        
    
       
        
	}



public String randomNameGenerator() {
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 7; i++) {
        int index = (int) (AlphaNumericString.length() * Math.random());
        sb.append(AlphaNumericString.charAt(index));
    }
    String name=sb.toString();
    return name;
}
}
