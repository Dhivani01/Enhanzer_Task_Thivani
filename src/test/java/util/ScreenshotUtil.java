package util;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.Base.BaseTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    

    // Capture screenshot and save as file, return absolute path
    public static String captureScreenshotAsFile(String testName) {
        try {
            File src = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path dest = Path.of("test-output", "screenshots", testName + "_" + timestamp + ".png");

            Files.createDirectories(dest.getParent()); // ensure folder exists
            Files.copy(src.toPath(), dest);

            return dest.toAbsolutePath().toString(); // absolute path for Extent
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Capture screenshot as Base64 string for direct embedding in Extent
    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);
    }
}


	
