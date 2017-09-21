package Server;

import Client.ChatClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by timothy on 2017-09-21, Server.
 */
public interface ChatCommands extends Remote {
    String getUsers() throws RemoteException;
    void getCommands() throws RemoteException;
    void connect(ChatClient client) throws RemoteException;
    void disconnect(ChatClient client) throws RemoteException;
}
