package Server;

import Client.ChatClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by timothy on 2017-09-21, Server.
 */
public class ClientHandler extends UnicastRemoteObject implements ChatCommands {

    private ArrayList<ChatClient> chatClients;

    protected ClientHandler( ) throws RemoteException {
        super();
        chatClients = new ArrayList<>();
    }

    public String getUsers() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for(ChatClient c : chatClients)
            sb.append(c.getNickname());
        return sb.toString();
    }

    public void getCommands() throws RemoteException {

    }

    public void connect(ChatClient client) throws RemoteException {
        chatClients.add(client);
    }

    public void disconnect(ChatClient client) throws RemoteException {
        chatClients.remove(client);
    }
}
