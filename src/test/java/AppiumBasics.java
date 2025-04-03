import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {

    @Test
    public void AppiumTest() throws MalformedURLException {

        String os = System.getProperty("os.name").toLowerCase();

        // Set the path based on the OS
        String mainJSPath = os.contains("mac") ? "/usr/local/lib/node_modules/appium/build/lib/main.js" : "C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        String appPath = os.contains("mac") ? "/Users/davit/IdeaProjects/AppiumPlayground/src/test/resources/ApiDemos-debug.apk" : "C:\\Users\\Admin\\IdeaProjects\\AppiumTest\\src\\test\\resources\\ApiDemos-debug.apk";

        System.out.println(mainJSPath);
        System.out.println(appPath);

        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File(mainJSPath))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        //Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Medium Phone API 36");
        options.setApp(appPath);

        //Creating android driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        //Quit the driver
        driver.quit();

        //End server
        service.stop();


    }

}
