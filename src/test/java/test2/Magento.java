package test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Magento {
     @Test(priority=10)
	 public void register() {
	 WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://magento.com");
    driver.findElement(By.className("account-icon")).click();
    driver.findElement(By.id("register")).click();
    driver.findElement(By.id("firstname")).sendKeys("Pooja");
    driver.findElement(By.id("lastname")).sendKeys("Guleria");
    driver.findElement(By.id("email_address")).sendKeys("poojaguleria.guleria12@yahoo.com");
    driver.findElement(By.id("self_defined_company")).sendKeys("Yes M Systems");
    
    Select ct=new Select(driver.findElement(By.id("company_type")));
    ct.selectByVisibleText("Is a merchant who sells online");
    
    Select role=new Select(driver.findElement(By.id("individual_role")));
    role.selectByValue("technical/developer");
    
    Select country=new Select(driver.findElement(By.id("country")));
    country.selectByValue("US");
    
    driver.findElement(By.id("password")).sendKeys("password@123");
    driver.findElement(By.id("password-confirmation")).sendKeys("password@123");
    driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
    driver.findElement(By.className("recaptcha-checkbox-border")).click();
    driver.switchTo().defaultContent();
   
    if(driver.findElement(By.id("agree_terms")).isSelected())
   	 driver.findElement(By.id("agree_terms")).click();
      driver.quit();
}
    
    
    @Test(priority=5,dependsOnMethods= {"register"},enabled=false)
	 public void login() throws InterruptedException {
    	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("R.TAHKUR5555@YAHOO.COM");
		driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText());
	    driver.quit();
    }
}
