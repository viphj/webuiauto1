package com.lemon.webauto.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class M8 extends Base4{
	@Test
	 public void test2() throws InterruptedException{
		//操作一个窗口，首先实例化一个窗口对象,注意导入的包需要小心，org.openqa.selenium.WebDriver.Window
		//Window window=driver.manage().window();
		//将窗口最大化
		//window.maximize();
		long before = System.currentTimeMillis();
		driver.get("https://www.baidu.com");
		getElementWhileSetWebDriverWait(driver,By.cssSelector("span[class='soutu-btn']")).click();
		//往输入框中输入"第一个自动化测试程序"
		//Thread.sleep(5000);
		//注意这里图片搜索的时候，图片或文件的路径请一定使用\\进行转义，不要使用/，有的浏览器识别不了/作为图片或
		//文件路径（例如ie浏览器，firefox浏览器），因为windows系统下打开一个文件搜索窗口根据文件名搜索文件不		//认/,chrome浏览器做了
		//特殊处理所以可以识别   【【首先需要保证在所在的路径有这个图片文件等，不然那会执行不成功】】
		getElementWhileSetWebDriverWait(driver,By.cssSelector("input[class='upload-pic']")).sendKeys("C:\\Users\\viphj\\Desktop\\uipicture\\8a.jpg");
		long after=System.currentTimeMillis();
		//调试代码
		System.out.println("after-before:"+(after-before));
		Thread.sleep(2000);
	 }
	 
	//【封装的显示等待某个元素的方法】
	public WebElement getElementWhileSetWebDriverWait(WebDriver driver,By by){
		WebDriverWait wait=new WebDriverWait(driver, 8);  //WebDriverWait(driver, 20,500)默认轮询时间是500ms
		WebElement webElement=wait.until(ExpectedConditions.presenceOfElementLocated(by));
		//【老师在78个视频中讲解错了，如果用下面的方法执行百度图片搜索功能就会失败，定位不到元素，请用上面方法】
//		WebElement webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElement;
	}
}