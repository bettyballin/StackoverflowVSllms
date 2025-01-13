/*
 * Decompiled with CFR 0.152.
 */
public class BusinessLogic {
    private MyDAO dao;

    public void initialize(Request request) {
        this.dao = DAOFactory.createDAO(request);
    }

    public void doSomething() {
        this.dao.doSomething();
    }

    public static void main(String[] stringArray) {
        BusinessLogic businessLogic = new BusinessLogic();
        Request request = new Request();
        businessLogic.initialize(request);
        businessLogic.doSomething();
    }
}
