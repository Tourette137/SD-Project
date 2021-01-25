package Servidor;

import Classes.MapasAplicacao;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    static final int dimensao = 10;

    public static void main(String[] args) throws IOException { //todo::::::: try catch aqui

        MapasAplicacao mapasAplicacao = new MapasAplicacao(dimensao);
        ServerSocket ss = new ServerSocket(12345);
        ServerSocket ss2 = new ServerSocket(54321);

        while (true) {
            Socket socket = ss.accept();
            Socket socket2 = ss2.accept();
            Thread worker = new Thread (new ServerWorker(socket, socket2, mapasAplicacao));
            worker.start();
        }

    }
}


