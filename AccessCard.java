public class AccessCard {
    private String owner;
    private String role;
    private String expiryDate;

    public AccessCard(String owner, String role, String expiryDate) {
        this.owner = owner;
        this.role = role;
        this.expiryDate = expiryDate;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "🪪 " + owner + " | Role: " + role + " | ExpiryDate: " + expiryDate;
    }
}