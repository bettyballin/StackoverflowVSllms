// Define a placeholder ActionSupport class
class ActionSupport {
    // Placeholder class to mimic Struts' ActionSupport for compilation purposes
}

public class UserAction extends ActionSupport {
    private String name;
    private int age;
    private String sex;
    private int cityId; // add this property

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public static void main(String[] args) {
        // Example usage
        UserAction userAction = new UserAction();
        userAction.setName("John Doe");
        userAction.setAge(30);
        userAction.setSex("Male");
        userAction.setCityId(12345);
        
        System.out.println("Name: " + userAction.getName());
        System.out.println("Age: " + userAction.getAge());
        System.out.println("Sex: " + userAction.getSex());
        System.out.println("City ID: " + userAction.getCityId());
    }
}