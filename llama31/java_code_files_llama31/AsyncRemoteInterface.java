/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

interface AsyncRemoteInterface
extends Remote {
    public void doSomethingAsync() throws RemoteException;
}
