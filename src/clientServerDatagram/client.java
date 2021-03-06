package clientServerDatagram;
import java.net.*;


public class client {
    public static void main(String[] args) throws Exception {
        String line = "Connected with the client";
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        sendData = line.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9000);
        clientSocket.send(sendPacket);
        while(true){
            System.out.println("Client Display terminal");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String msgReceived = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            System.out.println("Message typed in server side: "+ msgReceived);
        }


    }
}
