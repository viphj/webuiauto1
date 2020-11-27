package com.lemon.webauto.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Base3 {
//		public static WebDriver driver; //不是这个包中的类也可以访问这个方法通过WebDriver driver=Base.driver;
		public static WebDriver driver; //不是这个包中的类也可以访问这个方法通过WebDriver driver=Base.driver;	
		@Parameters(value={"browserType"})  //这里从testng.xml(不一定要这个名字)取得参数后传递给后面
		@BeforeTest
		public void init(String browserType) throws InterruptedException{
			//以下这个为调试代码
			//System.out.println("浏览器为:"+browserType);
			if("ie".equalsIgnoreCase(browserType)){
				System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
				//以下这行调试代码，可去掉
				//System.out.println("==="+driverPath+"===");
				//IE浏览器下忽略保护模式和忽略ZOOM缩放的问题
				DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
				desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
				//启动ie浏览器
				driver=new InternetExplorerDriver(desiredCapabilities);
			}else if("firefox".equalsIgnoreCase(browserType)){
				//有的时候找到firefox的驱动路径（不同浏览器找不到驱动添加的内容不同，可能不仅仅是驱动的错误）,根据错误提示判断
				//这里驱动是放置在resources目录下，所以值可以写相对路径，相对于这个maven项目而言
				System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
				//1.启动火狐浏览器
				driver=new FirefoxDriver();
			}else if("chrome".equalsIgnoreCase(browserType)){
				//在做自动化测试的时候chrome浏览器显示：Chrome正受到自动测试软件的控制，怎么取消(这种方法对74版本有效，83版本无效)
				//新版本在做自动化测试的时候有  受到自动测试软件控制就显示吧，网上的解答都不怎么行
				ChromeOptions option=new ChromeOptions();
				option.addArguments("disable-infobars");
				//有的时候Chrome的驱动找不到，所以将Chrome的驱动加入环境变量
				//这里驱动是放置在resources目录下，所以值可以写相对路径，相对于这个maven项目而言
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
				//1.启动火狐浏览器
				driver=new ChromeDriver(option);
			}else{
				System.out.println("暂不支持，请检查配置");
			}
		}
		@AfterTest
		public void tearDown() throws InterruptedException{
			driver.quit();
		}
}