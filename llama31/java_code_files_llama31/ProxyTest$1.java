/*
 * Decompiled with CFR 0.152.
 */
import java.net.Authenticator;
import java.net.PasswordAuthentication;

static class ProxyTest.1
extends Authenticator {
    ProxyTest.1() {
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("proxy_username", "proxy_password".toCharArray());
    }
}
