package connect;

import org.openqa.selenium.chrome.ChromeDriver;

public class Connect extends ChromeDriver{

    private static Connect instance;

    private Connect() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\SOF304_Selenium_Test\\chromedriver.exe");
    }

    public static Connect getInstance() {
        if(instance == null) {
            instance = new Connect();
        }
        return instance;
    }
}
