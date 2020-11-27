package com.lemon.webauto.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Js {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
//		driver.get("https://www.baidu.com");
		driver.get("https://www.12306.cn/index/");
		//实现js的类型
		JavascriptExecutor executor=(JavascriptExecutor) driver;
	//	String js="var input=document.getElementById('kw'); return input;";
	//	WebElement element=(WebElement) executor.executeScript(js);	
//		WebElement element=(WebElement) executor.executeScript("return document.getElementById('kw');");		
//		element.sendKeys("柠檬班软件测试3！");
		driver.manage().window().maximize();
		executor.executeScript("document.getElementById('train_date').removeAttribute('readonly')");
		driver.findElement(By.id("train_date")).clear();
		driver.findElement(By.id("train_date")).sendKeys("2018-08-08");
		
		
	}
}
