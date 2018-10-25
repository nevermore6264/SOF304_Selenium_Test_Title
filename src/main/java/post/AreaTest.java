package post;

import connect.Connect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AreaTest {
    WebDriver driver = Connect.getInstance();

    @BeforeMethod
    public void browserWeb() {
        driver.navigate().to("http://localhost:8080/post_motel.jsp");
    }

    // kyTuDacBiet
    @Test
    public void inputSpecialCharacters() {
        try {
            driver.findElement(By.id("area")).sendKeys("&^&$$");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số";
            String actual = driver.findElement(By.id("area_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //deTrong
    @Test
    public void inputSpace() {
        try {
            driver.findElement(By.id("area")).sendKeys("");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường không được để trống";
            String actual = driver.findElement(By.id("area_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //chuCai
    @Test
    public void inputString() {
        try {
            driver.findElement(By.id("area")).sendKeys("abc");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số";
            String actual = driver.findElement(By.id("area_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //null
    @Test
    public void inputNull() {
        try {
            driver.findElement(By.id("area")).sendKeys(null);
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường không được để trống";
            String actual = driver.findElement(By.id("area_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //4m2
    @Test
    public void inputLess5() {
        try {
            driver.findElement(By.id("area")).sendKeys("1");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Diện tích lớn hơn hoặc bằng 5";
            String actual = driver.findElement(By.id("area_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

}
