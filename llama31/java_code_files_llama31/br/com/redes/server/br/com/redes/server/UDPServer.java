/*
 * Decompiled with CFR 0.152.
 */
package br.com.redes.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void exibirCabecalho() {
        System.out.println("-------------------------");
        System.out.println("UDP SERVER");
        System.out.println("-------------------------");
    }

    public static void main(String[] stringArray) throws IOException {
        UDPServer.exibirCabecalho();
        DatagramSocket datagramSocket = new DatagramSocket(12345);
        System.out.println("Iniciando servidor na porta: 12345");
        System.out.println("Aguardando cliente...");
        byte[] byArray = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
        datagramSocket.receive(datagramPacket);
        String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("Cliente conectado, processando requisi\u00e7\u00e3o...");
        byte[] byArray2 = UDPServer.processar(string);
        datagramPacket = new DatagramPacket(byArray2, byArray2.length, datagramPacket.getAddress(), datagramPacket.getPort());
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    private static byte[] processar(String string) {
        System.out.println("Procurando arquivo: " + string);
        File file = new File(string);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] byArray = new byte[(int)file.length()];
            fileInputStream.read(byArray);
            fileInputStream.close();
            return byArray;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return "arquivo n\u00e3o encontrado.".getBytes();
        }
        catch (IOException iOException) {
            return "erro ao ler arquivo.".getBytes();
        }
    }
}
