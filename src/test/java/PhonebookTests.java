import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PhonebookTests {

    WebDriver wd;

    @BeforeMethod
    public void openSite(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Nadii/PhoneBook1-/chromedriver.exe");
      wd = new ChromeDriver();
      wd.manage().window().maximize();//bolshoy ekran
     // wd.get("url");//without history
      wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");

    }

    @Test
    public void phoneBookStart(){

        WebElement element =  wd.findElement(By.tagName("a"));
        element.click();
        element.clear();
        element.sendKeys("Hello");

        //List<WebElement> list =  wd.findElements(By.tagName("a"));
 WebElement elId = wd.findElement(By.id("root"));
 WebElement elClass = wd.findElement(By.className("container"));
 WebElement elLink = wd.findElement(By.linkText("HOME"));
 WebElement elLink1 = wd.findElement(By.partialLinkText("HOM"));
    }

    @Test
    public void fillFormLogin(){
        List <WebElement> list = wd.findElements(By.tagName("input"));
         WebElement inputEmail = list.get(0);
         WebElement inputPassword = list.get(1);
         WebElement buttonLogin = wd.findElement(By.tagName("Button"));

         inputEmail.click();
         inputEmail.clear();
         inputEmail.sendKeys("noa@gmail.com");

         inputPassword.click();
         inputPassword.clear();
         inputPassword.sendKeys("Nnoa12345$");

         buttonLogin.click();


    }

    @Test
    public void fillRegistrationTest(){
        //!!!!!!!!!!!!!!!!!!!!!!!
        List <WebElement> list = wd.findElements(By.tagName("input"));
        WebElement inputEmail = list.get(0);
        WebElement inputPassword = list.get(1);

        int index = (int)(System.currentTimeMillis()/1000)%3600;

        List <WebElement> listButton = wd.findElements(By.tagName("Button"));
        WebElement buttonRegistration = listButton.get(1);

        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("Lolita4" + index + "@gmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Lol12345$");

        buttonRegistration.click();

    }


    @AfterMethod
    public void close(){
      wd.quit();//all tabs
        //wd.close();//zakrivaet tolko deistvyushuy stranichky
    }
}
