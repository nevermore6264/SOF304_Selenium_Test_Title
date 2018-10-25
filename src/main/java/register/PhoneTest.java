package register;

import connect.Connect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhoneTest {
    WebDriver driver = Connect.getInstance();

    @BeforeMethod
    public void browserWeb() {
        driver.navigate().to("http://localhost:8080/register.jsp");
    }

    // kyTuDacBiet
    @Test
    public void inputSpecialCharacters() {
        try {
            driver.findElement(By.id("phone")).sendKeys("&^&$$");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //deTrong
    @Test
    public void inputSpace() {
        try {
            driver.findElement(By.id("phone")).sendKeys("");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số 10-11 ký tự";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //co1KyTu
    @Test
    public void inputNumberHasLength1() {
        try {
            driver.findElement(By.id("phone")).sendKeys("1");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số 10-11 ký tự";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }


    //co12KyTu
    @Test
    public void inputNumberHasLength12() {
        try {
            driver.findElement(By.id("phone")).sendKeys("016633064899");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số 10-11 ký tự";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }

    }

    //double
    @Test()
    public void inputDouble() {
        try {
            driver.findElement(By.id("phone")).sendKeys("3.5");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //chuCai
    @Test
    public void inputString() {
        try {
            driver.findElement(By.id("phone")).sendKeys("abc");
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }

    //null
    @Test
    public void inputNull() {
        try {
            driver.findElement(By.id("phone")).sendKeys(null);
            driver.findElement(By.className("btn-click")).click();
            Thread.sleep(3000);
            String expect = "Trường bạn nhập vào phải là số";
            String actual = driver.findElement(By.id("phone_error")).getText();
            Assert.assertEquals(actual, expect);
        } catch (Exception e) {
        }
    }
}


