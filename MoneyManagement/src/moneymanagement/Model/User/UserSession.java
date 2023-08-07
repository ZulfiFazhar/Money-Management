package moneymanagement.Model.User;

public class UserSession {
    private static String username, email;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserSession.username = username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserSession.email = email;
    }
    
    public static void clearSession() {
        username = null;
    }

    public static boolean isLogged() {
        return username != null;
    }
}
