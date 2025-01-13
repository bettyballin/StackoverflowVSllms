/*
 * Decompiled with CFR 0.152.
 */
public class ServiceInvoker {
    private YourService service;

    public static void main(String[] stringArray) {
        YourServiceImplementation yourServiceImplementation = new YourServiceImplementation();
        ServiceInvoker serviceInvoker = new ServiceInvoker(yourServiceImplementation);
        serviceInvoker.invokeService();
    }

    public ServiceInvoker(YourService yourService) {
        this.service = yourService;
    }

    public void invokeService() {
        this.service.yourMethod("arg1", "arg2");
    }
}
