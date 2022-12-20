package dev.kmt.seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Natmal {
	private WebDriver driver;
	private WebElement element;
	private List<WebElement> elements;
	private String url;

	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "C:\\Users\\yoo\\Desktop\\chromedriver\\chromedriver.exe";

	// 봇 세팅
	public Natmal() {
		// WebDriver 경로 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// 2. WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");

		driver = new ChromeDriver(options);

		// 낱말 유의어 사전
		url = "https://natmal.com/views/dictionary/syn";
		
	}

	// 봇 활성화
	public void activateBot() {
		try {
			driver.get(url);
			Thread.sleep(2000); // 3. 페이지 로딩 대기 시간
			
			// 4. 로그인 버튼 클릭
//			element = driver.findElement(By.className("ui fluid left icon input w-full"));
			element = driver.findElement(By.tagName("input"));
			element.click();
			
			// 검색어 입력
			element.sendKeys("기쁨");
			
			// Enter
			element.sendKeys(Keys.ENTER);
			
			
			Thread.sleep(2000);
			element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div/a[1]"));
			element.click(); 
			
			
			element = driver.findElement(By.id("btnViewTypeCloud"));
			element.click();
			
			Thread.sleep(2000);
			element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[5]/div/div/div[1]"));
			System.out.println(element.getAttribute("innerHTML").toString());
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
//			driver.close(); // 5. 브라우저 종료
		}
	}
}
