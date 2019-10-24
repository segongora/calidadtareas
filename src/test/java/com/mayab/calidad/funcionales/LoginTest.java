package com.mayab.calidad.funcionales;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.dbunit.Assertion.*;

public class LoginTest {
	
	private WebDriver driver;
	private String url;
	
	@Before
	public void beforeTest() {
		
		url = "https://anahuac.blackboard.com/webapps/login/";
		System.setProperty("webdriver.chrome.driver", "/Users/segongora/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@After
	public void afterTest() {
		driver.close();
	}

	@Test
	public void test() {
		driver.get(url);
		
		WebElement elementUser = driver.findElement(By.id("user_id"));
		elementUser.sendKeys("00317268");
		
		WebElement elementPass = driver.findElement(By.id("password"));
		elementPass.sendKeys("00317268");
		elementPass.submit();
		
		WebElement elementSuccess = driver.findElement(By.id("anonymous_element_5"));
		String success = elementSuccess.getText();
		assertEquals("Cursos en los que usted es: Alumno", success);
		System.out.print("¡Exito! Ha logrado iniciar sesión en Blackboard:\n" + success);
		
	}

}
