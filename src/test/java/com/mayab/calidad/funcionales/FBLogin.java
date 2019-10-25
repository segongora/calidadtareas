package com.mayab.calidad.funcionales;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	private WebDriver driver;
	private String url;

	@Before
	public void beforeTest() {
		url = "https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver", "/Users/segongora/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@After
	public void afterTest() {
		driver.close();
	}

	//@Test
	public void testLogin() {
		driver.get(url);
		
		WebElement elementUser = driver.findElement(By.id("email"));
		elementUser.sendKeys("segongora9@gmail.com");
		
		WebElement elementPass = driver.findElement(By.id("pass"));
		elementPass.sendKeys("");
		elementPass.submit();
		
		WebElement elementSuccess = driver.findElement(By.className("linkWrap"));
		
		String success = elementSuccess.getText();
		assertEquals("Sergio Gongora", success);
		System.out.print("¡Exito! Ha logrado iniciar sesión en Facebook:\n" + success);
		
	}

	
	@Test
	public void testLoginDenied() {
		driver.get(url);
		
		WebElement elementUser = driver.findElement(By.id("email"));
		elementUser.sendKeys("segongora9@gmail.com");
		
		WebElement elementPass = driver.findElement(By.id("pass"));
		elementPass.sendKeys("Hola1234");
		elementPass.submit();
		
		WebElement elementDenied = driver.findElement(By.className("_2phz"));
		
		String denied = elementDenied.getText();
		assertEquals("Iniciar sesión como Sergio Gongora", denied);
		System.out.print("¡Incorrecto! La contraseña ingresada es incorrecta:\n" + denied);
		
	}

}
