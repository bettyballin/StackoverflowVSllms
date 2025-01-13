/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.Naming;

public class RemoteClient {
    public static void main(String[] stringArray) throws Exception {
        RemoteInterface remoteInterface = (RemoteInterface)((Object)Naming.lookup("rmi://server:port/service"));
        AsyncRemoteInterface asyncRemoteInterface = (AsyncRemoteInterface)((Object)remoteInterface);
        asyncRemoteInterface.doSomethingAsync();
    }
}
