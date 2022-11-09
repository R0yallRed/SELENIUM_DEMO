package constants;

public class Constant {
    public static class timeoutVariables{
        public static final  int IMPLICIT_WAIT = 5; //неявное, работает весь прогон -> NoSuchElementException
        public static final  int EXPLICIT_WAIT = 10; // явное, работает в конкретном месте
    }
    public static class Urls{
        public static final String MAIN_PAGE_URL = "https://demo.seleniumeasy.com/";

    }
}
