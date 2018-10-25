package register;

import connect.Connect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PassWordTest {
    WebDriver driver = Connect.getInstance();

    @BeforeMethod
    public void browserWeb() {
        driver.navigate().to("http://localhost:8080/register.jsp");
    }

    // kyTuDacBiet
    @Test
    public void inputSpecialCharacters() {
        try {
            driver.findElement(By.id("password")).sendKeys("&^&$$");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Mật khẩu dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //deTrong
    @Test
    public void inputSpace() {
        try {
            driver.findElement(By.id("password")).sendKeys("");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự!";
            String actual = driver.findElement(By.id("password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //co1KyTu
    @Test
    public void inputStringHasLength1() {
        try {
            driver.findElement(By.id("password")).sendKeys("a");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //co2KyTu
    @Test
    public void inputStringHasLength2() {
        try {
            driver.findElement(By.id("password")).sendKeys("aa");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //co51KyTu
    @Test()
    public void inputStringHasLength51() {
        try {
            driver.findElement(By.id("password")).sendKeys("Tuonglaicuabanphuthuocnhieudieunhungchuyeulavaobana");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Tên dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //saiMatKhau
    @Test
    public void inputIncorrectPass() {
        try {
            driver.findElement(By.id("password")).sendKeys("hanoi1");
            driver.findElement(By.id("re_password")).sendKeys("hanoi2");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Không trùng khớp mật khẩu";
            String actual = driver.findElement(By.id("re_password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //null
    @Test
    public void inputNull() {
        try {
            driver.findElement(By.id("password")).sendKeys(null);
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Mật khẩu dài hơn 3 và nhỏ hơn 50 ký tự";
            String actual = driver.findElement(By.id("password_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }
}


