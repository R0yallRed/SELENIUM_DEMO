package tests.base;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class Listener implements TestWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - FAILED ", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() + randomNumeric(1, 6);
        LOGGER.info("Trying to trace screenshot...");
        TakesScreenshot takesScreenshot = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).webDriver;
        File sourse = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourse, new File("build/reports/tests/" + screenshotName + ".png"));
        } catch (IOException e) {
            LOGGER.info("Exception on saving screenshot!");
            e.printStackTrace();
        }
        attachScreenshotToAllure(takesScreenshot);
    }

    @Attachment
    public byte[] attachScreenshotToAllure(TakesScreenshot takesScreenshot) {
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
