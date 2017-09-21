package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by timothy on 2017-09-21, Server.
 */
public interface ChatClient extends Remote {
    void notifyNewMessage(String message) throws RemoteException;
    String getNickname() throws RemoteException;
}
