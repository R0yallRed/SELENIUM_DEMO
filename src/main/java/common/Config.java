package common;

public class Config {
    /*
    Specify browser and platform for test:
    *  CHROME_WINDOWS
    *  MOZILLA_WINDOWS
    *  CHROME_MAC
    *  CHROME_MAC_ARM
    * */
    public static final  String BROWSER_AND_PLATFORM = "CHROME_WINDOWS";
    /*
    * Clean cookies after each test
    * */
    public static final  boolean CLEAR_COOKIES = true;
    /*
     * Keep browser open after all tests
     * */
    public static final  boolean HOLD_BROWSER_OPEN = false;
    /*
     * Delete old screenshots before new run
     * */
    public static final  boolean CLEAR_REPORTS_DIR = true;

}
