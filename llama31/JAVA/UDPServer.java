package br.com.redes.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void exibirCabecalho(){
        System.out.println("-------------------------");
        System.out.println("UDP SERVER");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) throws IOException {
        UDPServer.exibirCabecalho();

        DatagramSocket socket = new DatagramSocket(12345); // replaced CommonKeys.PORTA_SERVIDOR with a hardcoded port number

        System.out.println("Iniciando servidor na porta: " + 12345);
        System.out.println("Aguardando cliente...");

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        String requisicao = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Cliente conectado, processando requisição...");

        byte[] resposta = processar(requisicao);
        packet = new DatagramPacket(resposta, resposta.length, packet.getAddress(), packet.getPort());
        socket.send(packet);

        socket.close();
    }

    private static byte[] processar(String requisicao) {
        final String ARQUIVO_NAO_ENCONTRADO = "arquivo não encontrado.";
        final String ARQUIVO_IO = "erro ao ler arquivo.";

        System.out.println("Procurando arquivo: " + requisicao);
        File f = new File(requisicao);
        try {
            FileInputStream input = new FileInputStream(f);
            byte[] buffer = new byte[(int) f.length()];
            input.read(buffer);
            input.close();
            return buffer;
        } catch (FileNotFoundException e) {
            return ARQUIVO_NAO_ENCONTRADO.getBytes();
        } catch (IOException e) {
            return ARQUIVO_IO.getBytes();
        }
    }
}