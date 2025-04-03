import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {

    @Test
    public void AppiumTest() throws MalformedURLException {

        //Start the server from code
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        //Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Medium Phone API 35");
        options.setApp("/Users/davit/IdeaProjects/AppiumPlayground/src/test/resources/ApiDemos-debug.apk");

        //Creating android driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

//        //androidUIAutomator (uses google engine) - Scrolling
//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollableView(new UiSelector())." +
//                "scrollIntoView(text(\"${anyTextYouWantToScrollTo}\"));"));


//        //Locators supported: Xpath, id, accessibilityId, classname, androidUIAutomator
//        WebElement testElement= driver.findElement(AppiumBy.accessibilityId(""));

        //How to check package/activity and direct directly to that screen
        //1. Open the desired screen on your app
        // On mac : adb shell dumpsys window | grep -E 'mCurrentFocus'
        // On windows: adb shell dumpsys window | find "mCurrentFocus"
//        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
//                "intent", "fullActivityName"
//        ));

        //Quit the driver
        driver.quit();

        //End server
        service.stop();

    }

}
