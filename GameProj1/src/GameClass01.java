import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//file handling
//Importing the FileWriter class  
import java.io.FileWriter;   

//Importing the IOException class for handling errors  
import java.io.IOException;  

public class GameClass01 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://now.gg/apps/perfect-world/7724/perfect-world-mobile.html");
		driver.manage().window().maximize();
		
		WebElement play_button = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/section/div/div[2]/div/div[2]/div[4]/button"));
		
		play_button.click();

		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".flex:nth-child(2) .controller > .icon"))).click();
		
		System.out.println(" controls test"  );
	
		WebElement controls1 = driver.findElement(By.xpath("//*[@id=\"sidebar-wrap\"]/div[2]/div[2]/div[1]/ul[1]"));

		
		System.out.println("content " + controls1.getText());
		
		WebElement controls2 = driver.findElement(By.xpath("//*[@id=\"sidebar-wrap\"]/div[2]/div[2]/div[1]/ul[2]"));

		
		System.out.println("content " + controls2.getText());
		
		
		WebElement controls3 = driver.findElement(By.xpath("//*[@id=\"sidebar-wrap\"]/div[2]/div[2]/div[1]/ul[3]"));

		
		System.out.println("content " + controls3.getText());
		
		try {  
	        FileWriter fwrite = new FileWriter("src\\gamecontrols.txt");  
	          
	        fwrite.write(controls1.getText());   
	        fwrite.write(controls2.getText()); 
	        fwrite.write(controls3.getText()); 
	   
	        // Closing the stream  
	        fwrite.close();   
	        System.out.println("Content is successfully wrote to the file.");  
	    } catch (IOException e) {  
	        System.out.println("Unexpected error occurred");  
	        e.printStackTrace();  
	        }  
		
		driver.quit();
		

	}
	
}
