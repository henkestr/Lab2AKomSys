package Client;

import Server.ClientHandler;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;

public class Client implements ChatClient{


    public static void main(String[] args){
        try {
            ClientHandler clientHandler = (ClientHandler) Naming.lookup("rmi://localhost/chat_server");
            Client client = new Client(clientHandler);
            clientHandler.connect(client);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    private String nickname;
    private ClientHandler clientHandler;

    public Client(ClientHandler clientHandler) {
        nickname = "User" + new Random().nextInt();
        this.clientHandler = clientHandler;
    }

    @Override
    public void notifyNewMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public String getNickname() throws RemoteException {
        return nickname;
    }

    private void runClient() {
        String message;
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                message = input.nextLine();
                if (message.equals("/quit"))
                    clientHandler.disconnect(this);
                if(message.equals("/who"))
                    System.out.println(clientHandler.getUsers());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }
}
