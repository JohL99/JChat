package jsjf.wire;

import java.net.ServerSocket;

/**
 * This class is the server daemon. It is responsible for accepting new connections and creating new threads to handle them.
 */
public class MessageDaemon {
    private ServerSocket server;
    boolean running = false;
    /**
     * Constructor for the server daemon.
     * @param port The port to listen on.
     */
    public MessageDaemon(int port)
    {
        try {
            server = new ServerSocket(port);
            running = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is used to start the server.
     */
    public void run()
    {
        int i = 0;
        while(running)
        {
            i++;
            try {
                Thread t = new Thread(new MessageService(server.accept()));
                t.setName(("Thread no. " + i));
                System.out.println("New connection accepted on thread " + t.getName());
                t.start();
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
