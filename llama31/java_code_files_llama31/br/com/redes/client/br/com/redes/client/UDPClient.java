/*
 * Decompiled with CFR 0.152.
 */
package br.com.redes.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void exibirCabecalho() {
        System.out.println("-------------------------");
        System.out.println("UDP CLIENT");
        System.out.println("-------------------------");
    }

    public static void main(String[] stringArray) throws IOException {
        UDPClient.exibirCabecalho();
        DatagramSocket datagramSocket = new DatagramSocket();
        String string = stringArray[0];
        int n = 12345;
        InetAddress inetAddress = InetAddress.getByName(string);
        byte[] byArray = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, inetAddress, n);
        System.out.println("Conectando ao servidor...");
        datagramSocket.send(datagramPacket);
        datagramPacket = new DatagramPacket(byArray, byArray.length);
        datagramSocket.receive(datagramPacket);
        String string2 = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("Servidor: " + string2);
        datagramSocket.close();
    }
}
