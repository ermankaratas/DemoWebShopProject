package Utility;

public class MyFunctions {
    private static String email = "xqw@email.com";
    private static String password = "123456";

    public static void wait(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEmail() {
        return email;
    }
    public static String getPassword() {
        return password;
    }
}
