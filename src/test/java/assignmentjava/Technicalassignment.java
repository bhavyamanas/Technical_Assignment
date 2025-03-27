package assignmentjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Technicalassignment {

    public static void main(String[] args) {
        
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the login page
            driver.get("https://www.github.com/login");
            
            // Maximize the browser window
            driver.manage().window().maximize();
            
            // Find the username field and input the username
            WebElement usernameField = driver.findElement(By.id("login_field"));
            usernameField.sendKeys("bhavyamanasavannam@gmail.com");
            
            // Find the password field and input the password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Bhavani@5578");
            
            // Find and click the login button
            WebElement loginButton = driver.findElement(By.name("commit"));
            loginButton.click();
            
            // Add any wait (implicit, explicit, or fluent wait) to allow the page to load
            Thread.sleep(8000); // Just an example; you might want to use WebDriverWait instead
            
            // Optionally, you can check if login is successful by verifying an element after login
            WebElement dashboard = driver.findElement(By.xpath("//a[@class = 'AppHeader-context-item']"));
            if (dashboard.isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
