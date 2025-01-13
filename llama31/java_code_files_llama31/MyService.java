/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

interface MyService
extends Remote {
    public void myMethod() throws RemoteException;
}
