package jsjf.wire;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import jsjf.Message;

/**
 * This class is the server service. It is responsible for handling the client requests.
 */
public class MessageService implements Runnable {
    private Socket client;

    /**
     * Constructor for the server service.
     * @param socket The socket to use.
     */
    public MessageService(Socket socket) {
        client = socket;
    }
    
    private void populate_response(DataOutputStream out, Message message) throws IOException {
        out.writeBytes("Sending a message:\r\n");
        byte[] buffer = message.getMessageBody().getBytes();
        out.write(buffer, 0, buffer.length);
        out.writeBytes("\r\n");
        out.flush();
    }

    /**
     * This method is called when the thread is started.
     */
    @Override
    public void run() {
        BufferedReader in = null;
        DataOutputStream out = null;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            // bad code below
            out.writeBytes("Sending a message:\r\n");
            byte[] buffer = "Type a message, loser.\r".getBytes();
            out.write(buffer, 0, buffer.length);
            out.writeBytes("\r\n");
            out.flush();
            Message new_message = new Message(in.readLine(), "69", "69");
            System.out.println("Message received: " + new_message.getMessageBody());
            // bad code above
            populate_response(out, new_message);
        } catch (IOException e) {
            try {
                out.writeBytes("Something went wrong!\r\n");
                out.writeBytes("\r\n");
                out.flush();
            } catch (IOException f) {
                f.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}