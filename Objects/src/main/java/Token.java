public class Token {

    private int userID;
    private String role;
    private String signature;

    public Token(){}

    public Token(int userID, String role, String signature) {
        this.userID = userID;
        this.role = role;
        this.signature = signature;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String info() {
        return Integer.toString(userID) + ", " + role;
    }
}
