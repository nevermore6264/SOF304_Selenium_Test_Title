package register;

import connect.Connect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserNameTest {
    WebDriver driver = Connect.getInstance();

    @BeforeMethod
    public void browserWeb() {
        driver.navigate().to("http://localhost:8080/register.jsp");
    }

    // kyTuDacBiet
    @Test
    public void inputSpecialCharacters() {
        try {
            driver.findElement(By.id("name")).sendKeys("&^&$$");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên chỉ được nhập A đến Z và a đến z!";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //deTrong
    @Test
    public void inputSpace() {
        try {
            driver.findElement(By.id("name")).sendKeys("");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự!";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //co1KyTu
    @Test
    public void inputOneCharacter() {
        try {
            driver.findElement(By.id("name")).sendKeys("a");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //co2KyTu
    @Test
    public void inputTwoCharacters() {
        try {
            driver.findElement(By.id("name")).sendKeys("aa");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //co51KyTu
    @Test()
    public void input51Characters() {
        try {
            driver.findElement(By.id("name")).sendKeys("Tuonglaicuabanphuthuocnhieudieunhungchuyeulavaobana");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //so
    @Test
    public void inputNumber() {
        try {
            driver.findElement(By.id("name")).sendKeys("12345678");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên chỉ được nhập A đến Z và a đến z!";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //null
    @Test
    public void inputNull() {
        try {
            driver.findElement(By.id("name")).sendKeys(null);
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên chỉ được nhập A đến Z và a đến z!";
            String actual = driver.findElement(By.id("name_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }
}


