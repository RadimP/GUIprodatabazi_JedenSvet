/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import com.sun.rowset.CachedRowSetImpl;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

// Client class
public class Client {

    String tosend;

    DataInputStream dis;
    DataOutputStream dos;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    CachedRowSet crs;

    Client() {

    }

    public CachedRowSet getCachedRowset(String sql) {
        {
            try {
                Scanner scn = new Scanner(System.in);

                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = sql;
                    dos.writeUTF(tosend);

                    tosend = "cachedrowset";
                    dos.writeUTF(tosend);

                    crs = (CachedRowSet) ois.readObject();

                    // If client sends exit,close this connection 
                    // and then break from the while loop
                    // printing date or time as requested by client
                    //  String received = dis.readUTF();
                    //  System.out.println(received);
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                scn.close();
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return crs;
    }

    public void getDate() {
        try {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);

            // obtaining input and out streams
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true) {
                //  System.out.println(dis.readUTF());
                tosend = "Date";
                dos.writeUTF(tosend);

                // If client sends exit,close this connection 
                // and then break from the while loop
                // printing date or time as requested by client
                String received = dis.readUTF();
                System.out.println(received);
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);

            System.out.println("Closing this connection : " + s);
            s.close();
            System.out.println("Connection closed");

            // closing resources
            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String selectDataByValue(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, Object value) {
        DataSelectionByValue dtsbv = new DataSelectionByValue(namesofcolumnsDTBtable, nameofDTBtable, columnnameDTBtable, value);
        String querry = null;
        {
            try {
                Scanner scn = new Scanner(System.in);

                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = "DataSelectionByValue";
                    dos.writeUTF(tosend);

                    oos.writeObject(dtsbv);
                    oos.flush();
                    querry = dis.readUTF();
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                scn.close();
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return querry;
    }

    public String selectDataByValueThroughInnerJoin(String[] namesofcolumnsDTBtable_1, String nameofDTBtable_1, String nameofDTBtable_2, String columnnameDTBtable_1, String columnnameDTBtable_2, String conditioncolumnname, Object value) {
        DataSelectionByValueThroughInnerJoin dtsbvtij = new DataSelectionByValueThroughInnerJoin(namesofcolumnsDTBtable_1, nameofDTBtable_1, nameofDTBtable_2, columnnameDTBtable_1, columnnameDTBtable_2, conditioncolumnname, value);
        String querry = null;
        {
            try {
                Scanner scn = new Scanner(System.in);

                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = "DataSelectionByValueThroughInnerJoin";
                    dos.writeUTF(tosend);

                    oos.writeObject(dtsbvtij);
                    oos.flush();
                    querry = dis.readUTF();
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                scn.close();
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return querry;
    }

    public String selectDataByValueThroughInnerJoin3Columnns(Object value) {
        String querry = null;
        {
            try {
                Scanner scn = new Scanner(System.in);

                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = "DataSelectionByValue3Columns";
                    dos.writeUTF(tosend);

                    oos.writeObject(value);
                    oos.flush();
                    querry = dis.readUTF();
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                scn.close();
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return querry;
    }

    public String updateEditedValueInDTB(String nameofDTBtable, String nameofupdatedcolumn, Object newvalue, String nameofconditioncolumn, Object valueofcondition) {
        DataUpdate dup = new DataUpdate(nameofDTBtable, nameofupdatedcolumn, newvalue, nameofconditioncolumn, valueofcondition);
        String querry = null;
        {
            try {
                Scanner scn = new Scanner(System.in);

                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = "UpdateEditedvalue";
                    dos.writeUTF(tosend);

                    oos.writeObject(dup);
                    oos.flush();
                    querry = dis.readUTF();
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                scn.close();
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return querry;
    }

    public String insertNewRowIntoDTB_Predstaveni(String date, String idFilm) {
        String querry = null;
        {
            try {
                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = "InsertNewRowPredstaveni";
                    dos.writeUTF(tosend);
                    oos.writeObject(date);
                    oos.flush();
                    oos.writeObject(idFilm);
                    oos.flush();
                    querry = dis.readUTF();
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return querry;
    }
    
    public String searchBasedOnQuantitativeRelation(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, String relation, Object value) {
        DataSearchQuantitativeRelation datasearch = new DataSearchQuantitativeRelation(namesofcolumnsDTBtable, nameofDTBtable, columnnameDTBtable, relation, value);
        String querry = null;
        {
            try {
                Scanner scn = new Scanner(System.in);

                // getting localhost ip
                InetAddress ip = InetAddress.getByName("localhost");

                // establish the connection with server port 5056
                Socket s = new Socket(ip, 5056);

                // obtaining input and out streams
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                // the following loop performs the exchange of
                // information between client and client handler
                while (true) {
                    //  System.out.println(dis.readUTF());
                    tosend = "DataSearchQuantitative";
                    dos.writeUTF(tosend);

                    oos.writeObject(datasearch);
                    oos.flush();
                    querry = dis.readUTF();
                    tosend = "Exit";
                    break;
                }
                dos.writeUTF(tosend);

                System.out.println("Closing this connection : " + s);
                s.close();
                System.out.println("Connection closed");

                // closing resources
                scn.close();
                dis.close();
                dos.close();
                ois.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return querry;
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        /*  try
        {
            Scanner scn = new Scanner(System.in);
             
            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");
     
            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);
     
            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
     
            // the following loop performs the exchange of
            // information between client and client handler
            while (true) 
            {
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);
                 
                // If client sends exit,close this connection 
                // and then break from the while loop
                if(tosend.equals("Exit"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
                 
                // printing date or time as requested by client
                String received = dis.readUTF();
                System.out.println(received);
            }
             
            // closing resources
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
    }
}
