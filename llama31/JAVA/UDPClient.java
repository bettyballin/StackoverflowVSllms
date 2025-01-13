package br.com.redes.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {
    public static void exibirCabecalho(){
        System.out.println("-------------------------");
        System.out.println("UDP CLIENT");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) throws IOException {
        UDPClient.exibirCabecalho();

        DatagramSocket socket = new DatagramSocket();

        String servidor = args[0];
        int porta = 12345; // replaced CommonKeys.PORTA_SERVIDOR with a constant

        InetAddress address = InetAddress.getByName(servidor);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, porta);

        System.out.println("Conectando ao servidor...");
        socket.send(packet);

        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String resposta = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Servidor: " + resposta);

        socket.close();
    }
}