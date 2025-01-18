public class User {
    private boolean isAdmin;
    public boolean getIsAdmin() { 
        return this.isAdmin;
    }
    public void setIsAdmin(boolean isAdmin) { 
        this.isAdmin = isAdmin;
    }
    
    // Add a method that follows the Java Beans conventions
    public boolean isAdmin() {
        return this.isAdmin;
    }
}