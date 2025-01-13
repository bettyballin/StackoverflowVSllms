/*
 * Decompiled with CFR 0.152.
 */
public class UserAction
extends ActionSupport {
    private String name;
    private int age;
    private String sex;
    private int cityId;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int n) {
        this.age = n;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String string) {
        this.sex = string;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int n) {
        this.cityId = n;
    }

    public static void main(String[] stringArray) {
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
