package com.jest.socketUtil;

import com.jest.carte.Carte;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServeur {
    private static final int PORT = 8080;
    private int clientNo;
    private ServerSocket serverSocket;
    private ExecutorService service;
    private ArrayList<Socket> sockets;
    private ArrayList<JoueurEnLigne> joueurEnLignes;

    public SocketServeur()
    {
        joueurEnLignes = new ArrayList<>();
        sockets = new ArrayList<>();
        clientNo = 1;
        service = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public JoueurEnLigne attendreClient()
    {
        Socket socket;
        JoueurEnLigne joueurEnLigne = null;
        try {
            socket = serverSocket.accept();
            sockets.add(socket);
            joueurEnLigne = new JoueurEnLigne(0,"joueurEL"+clientNo,new ArrayList<Carte>(),socket,clientNo);
            clientNo++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return joueurEnLigne;
    }

    public int getClientNo() {
        return clientNo;
    }
}

