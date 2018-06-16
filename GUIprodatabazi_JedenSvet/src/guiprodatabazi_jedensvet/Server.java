/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Server class
public class Server {
final static int PORT = 5056;
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        while (true) {
            Socket s = null;
            try {
                 s = ss.accept(); 
                 DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                System.out.println("A new client is connected : " + s);
                System.out.println("Assigning new thread for this client");
                Thread t = new ClientHandler(s, dis, dos, ois, oos);
                t.start();
            } catch (IOException e) {
                s.close();
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
