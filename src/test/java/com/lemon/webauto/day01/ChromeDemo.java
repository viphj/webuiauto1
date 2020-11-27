package com.lemon.webauto.day01;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChromeDemo extends Base {
	@Parameters(value={"browserType"})
	@Test
	public void test1() {
		//有的时候找到firefox的驱动路径（不同浏览器找不到驱动添加的内容不同，可能不仅仅是驱动的错误）,根据错误提示判断
		//这里驱动是放置在resources目录下，所以值可以写相对路径，相对于这个maven项目而言
		//System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		//1.启动火狐浏览器
		//WebDriver driver=new FirefoxDriver();
		//2.访问百度
//		driver.get("https://www.baidu.com");
//		//3.往输入框中输入"第一个自动化测试程序"
//		driver.findElement(By.id("kw")).sendKeys("第一个firefox测试程序");
		driver.get("https://www.sina.com.cn/");
		driver.findElement(By.linkText("新浪简介")).click();
		
	}
}