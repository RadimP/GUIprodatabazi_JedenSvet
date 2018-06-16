/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import com.sun.rowset.CachedRowSetImpl;
import java.io.*;
import java.net.*;
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
    private static final String ipadress = "localhost";
    private static final int port = 5056;

    Client() {

    }

    private Socket makeConnectionAndPrepareResources() {
        Socket s = null;
        try {
            InetAddress ip = InetAddress.getByName(ipadress);
            s = new Socket(ip, port);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private void closeConnectionAndResources(Socket s, DataInputStream dis, DataOutputStream dos, ObjectInputStream ois, ObjectOutputStream oos) {
        try{
            System.out.println("Closing this connection : " + s);
            s.close();
            System.out.println("Connection closed");
            dis.close();
            dos.close();
            ois.close();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public CachedRowSet getCachedRowset(String sql) {
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = sql;
                dos.writeUTF(tosend);
                tosend = "cachedrowset";
                dos.writeUTF(tosend);
                crs = (CachedRowSet) ois.readObject();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crs;
    }

    public String selectDataByValue(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, Object value) {
        DataSelectionByValue dtsbv = new DataSelectionByValue(namesofcolumnsDTBtable, nameofDTBtable, columnnameDTBtable, value);
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "DataSelectionByValue";
                dos.writeUTF(tosend);
                oos.writeObject(dtsbv);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }

    public String selectDataByValueThroughInnerJoin(String[] namesofcolumnsDTBtable_1, String nameofDTBtable_1, String nameofDTBtable_2, String columnnameDTBtable_1, String columnnameDTBtable_2, String conditioncolumnname, Object value) {
        DataSelectionByValueThroughInnerJoin dtsbvtij = new DataSelectionByValueThroughInnerJoin(namesofcolumnsDTBtable_1, nameofDTBtable_1, nameofDTBtable_2, columnnameDTBtable_1, columnnameDTBtable_2, conditioncolumnname, value);
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "DataSelectionByValueThroughInnerJoin";
                dos.writeUTF(tosend);
                oos.writeObject(dtsbvtij);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }

    public String selectDataByValueThroughInnerJoin3Columnns(Object value) {
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "DataSelectionByValue3Columns";
                dos.writeUTF(tosend);
                oos.writeObject(value);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }

    public String updateEditedValueInDTB(String nameofDTBtable, String nameofupdatedcolumn, Object newvalue, String nameofconditioncolumn, Object valueofcondition) {
        DataUpdate dup = new DataUpdate(nameofDTBtable, nameofupdatedcolumn, newvalue, nameofconditioncolumn, valueofcondition);
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "UpdateEditedvalue";
                dos.writeUTF(tosend);
                oos.writeObject(dup);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }

    public String insertNewRowIntoDTB_Predstaveni(String date, String idFilm) {
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
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
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }
    
     public String insertNewRowIntoDTB_Film(String JmenoF, String Reziser, String Rok, String Popis) {
        FilmInsertion filmin = new FilmInsertion(JmenoF, Reziser, Rok, Popis);
         String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "InsertNewRowFilm";
                dos.writeUTF(tosend);
                oos.writeObject(filmin);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }
     
     public String insertNewRowIntoDTB_Kino(String Nazev, String Ulice, String C_popisne, String C_orientacni, String Obec, String PSC) {
        KinoInsertion kinoin = new KinoInsertion(Nazev, Ulice, C_popisne, C_orientacni, Obec, PSC);
         String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "InsertNewRowKino";
                dos.writeUTF(tosend);
                oos.writeObject(kinoin);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }

    public String searchBasedOnQuantitativeRelation(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, String relation, Object value) {
        DataSearchQuantitativeRelation datasearch = new DataSearchQuantitativeRelation(namesofcolumnsDTBtable, nameofDTBtable, columnnameDTBtable, relation, value);
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "DataSearchQuantitative";
                dos.writeUTF(tosend);
                oos.writeObject(datasearch);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }
    
    public String searchTextData(String[] namesofcolumnsDTBtable, String nameofDTBtable, String columnnameDTBtable, Object value) {
        TextDataSearch textdatasearch = new TextDataSearch(namesofcolumnsDTBtable, nameofDTBtable, columnnameDTBtable, value);
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "TextDataSearch";
                dos.writeUTF(tosend);
                oos.writeObject(textdatasearch);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }
    
   public String deleteSelectedRows(String nameofDTBtable, String condition_columnnameDTBtable, Object condition_value) {
        DeletionOfSelectedRows rowsdeletion = new DeletionOfSelectedRows(nameofDTBtable, condition_columnnameDTBtable, condition_value);
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "RowsDeletion";
                dos.writeUTF(tosend);
                oos.writeObject(rowsdeletion);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    } 
   
   public String deleteidFilmFromPredstaveni(Object value) {
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "DeleteidFilm";
                dos.writeUTF(tosend);
                oos.writeObject(value);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }
   public boolean logIn(String name, String password) {
        boolean result = false;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "Login";
                dos.writeUTF(tosend);
                oos.writeObject(name);
                oos.flush();
                oos.writeObject(password);
                oos.flush();
                result = dis.readBoolean();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
   
   public String deleteidKinoFromPredstaveni(Object value) {
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "DeleteidKino";
                dos.writeUTF(tosend);
                oos.writeObject(value);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }
   public String selectMoviesSchedule(Object value) {
        String querry = null;
        try {
            Socket s = makeConnectionAndPrepareResources();
            while (true) {
                tosend = "MoviesSchedule";
                dos.writeUTF(tosend);
                oos.writeObject(value);
                oos.flush();
                querry = dis.readUTF();
                tosend = "Exit";
                break;
            }
            dos.writeUTF(tosend);
            closeConnectionAndResources(s, dis, dos, ois, oos);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return querry;
    }    
}
