package monishss;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class CallieController {

    private Socket socket;
    private PrintWriter out;

    public CallieController() {

    }

    public void connect(String host,int port) throws IOException {
        socket = new Socket(host,port);
        out = new PrintWriter(socket.getOutputStream(),true);
        sendCommand("movej([0, -1.57, 0, -1.57, 0, 0], a=1.4, v=1.05)");
    }

    public void sendCommand(String command){
        out.println(command);
        System.out.println("Sent command:"+command);
    }


}
