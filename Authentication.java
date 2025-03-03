public class Authentication {
    private final String ADMIN_PASSWORD = "123"; // กำหนดรหัสผ่าน Admin

    public boolean login(String role, String password) {
        if (role.equals("Admin") && password.equals(ADMIN_PASSWORD)) {
            return true;
        }
        return false;
    }
}