import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WireSharkTest {

    private WindowsDriver wireSharkSession = null;
    private WireSharkPOM wireShark = null;


    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("appium:deviceName", "WindowsPC");
        capabilities.setCapability("appium:app", "C:\\Work\\projects\\instalWizardAutoTest\\app\\Wireshark-4.4.5-x64.exe");
        try{
            wireSharkSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//            notepad = new NotepadPO(notepadSession);
            wireShark = new WireSharkPOM(wireSharkSession);
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Failed to create session. Ensure Appium server is running.");
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (wireSharkSession != null) {
            wireSharkSession.quit();
        }
    }

    @Test
    public void testWireShark() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(wireSharkSession.getPageSource());

        wireShark.nextButton().click();
        Assert.assertTrue(wireShark.notedButton().isDisplayed());
        wireShark.backButton().click();

    }
}