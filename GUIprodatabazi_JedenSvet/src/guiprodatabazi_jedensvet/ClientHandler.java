/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

class ClientHandler extends Thread {
    
    DataFromDatabase dfdtb = new DataFromDatabase();
    final DataInputStream dis;
    final DataOutputStream dos;
    final ObjectOutputStream oos;
    final ObjectInputStream ois;
    final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, ObjectInputStream ois, ObjectOutputStream oos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.ois = ois;
        this.oos = oos;
    }
    
    @Override
    public void run() {
        String querry = "";
        try {
            String[] message;
            String received;
            String toreturn;
            
            while (true) {
                message = dis.readUTF().split(" ", 2);
                received = message[0].toUpperCase();
                System.out.println(received);
                
                if (received.equals("EXIT")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
                
                switch (received) {
                    
                    case "DATASELECTIONBYVALUE":
                        DataSelectionByValue dtsbv = (DataSelectionByValue) ois.readObject();
                        String querryselectbyvalue = PrepareStatement.executeSelectDatabySelectedValue(dtsbv.getNamesOfColumnsDTBtable(), dtsbv.getNameOfDTBtable(), dtsbv.getColumnnameDTBtable(), dtsbv.getValue());
                        System.out.println("Data selected by value");
                        dos.writeUTF(querryselectbyvalue);
                        break;
                    case "DATASELECTIONBYVALUETHROUGHINNERJOIN":
                        DataSelectionByValueThroughInnerJoin dtsbvtij = (DataSelectionByValueThroughInnerJoin) ois.readObject();
                        String querryselectthroughinnerjoin = PrepareStatement.executeSelectDatabySelectedValueUsingOneInnerJoin(dtsbvtij.getNamesOfColumnsDTBtable_1(), dtsbvtij.getNameOfDTBtable_1(), dtsbvtij.getNameOfDTBtable_2(), dtsbvtij.getColumnnameDTBtable_1(), dtsbvtij.getColumnnameDTBtable_2(), dtsbvtij.getConditionColumnName(), dtsbvtij.getValue());
                        System.out.println("Data selected trhough inner join.");
                        dos.writeUTF(querryselectthroughinnerjoin);
                        break;
                    case "DATASELECTIONBYVALUE3COLUMNS":
                        Object value = ois.readObject();
                        String querryvalue = PrepareStatement.executeSelectDatabySelectedValueUsingOneInnerJoinThreeColumns(value);
                        System.out.println("Data selected 3 columns.");
                        dos.writeUTF(querryvalue);
                        break;
                    case "UPDATEEDITEDVALUE":
                        DataUpdate dup = (DataUpdate) ois.readObject();
                        String querryupdate = PrepareStatement.executeUpdateEditedValueInDTB(dup.getNameOfDTBtable(), dup.getNameofupdatedcolumn(), dup.getNewValue(), dup.getNameofconditioncolumn(), dup.getValueOfCondition());
                        System.out.println("Data updated.");
                        dos.writeUTF(querryupdate);
                        break;
                    case "INSERTNEWROWPREDSTAVENI":
                        String dateforinsert = (String) ois.readObject();
                        String ifFilmforinsert = (String) ois.readObject();
                        String querryinsert = PrepareStatement.executeInsertNewItemIntoPredstaveniTable(dateforinsert, ifFilmforinsert);
                        System.out.println("Data inserted.");
                        dos.writeUTF(querryinsert);
                        break;
                    case "INSERTNEWROWFILM":
                        FilmInsertion filmin = (FilmInsertion) ois.readObject();
                        String querryinsertfilm = PrepareStatement.executeInsertNewItemIntoFilmTable(filmin.getJmenoF(), filmin.getReziser(), filmin.getRok(), filmin.getPopis());
                        System.out.println("Data inserted.");
                        dos.writeUTF(querryinsertfilm);
                        break;
                    case "INSERTNEWROWKINO":
                        KinoInsertion kinoin = (KinoInsertion) ois.readObject();
                        String querryinsertkino = PrepareStatement.executeInsertNewItemIntoKinoTable(kinoin.getNazev(), kinoin.getUlice(), kinoin.getC_popisne(), kinoin.getC_orientacni(), kinoin.getObec(), kinoin.getPSC());
                        System.out.println("Data inserted.");
                        dos.writeUTF(querryinsertkino);
                        break;
                    case "DATASEARCHQUANTITATIVE":
                        DataSearchQuantitativeRelation datasearch = (DataSearchQuantitativeRelation) ois.readObject();
                        if ("Datum".equals(datasearch.getColumnnameDTBtable())) {
                            datasearch.setValue((Object) HelperMethods.convertDateStringWithPointsToDatabaseFormat(datasearch.getValue().toString()));
                        }
                        String querrysearch = PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(datasearch.getNamesOfColumnsDTBtable(), datasearch.getNameOfDTBtable(), datasearch.getColumnnameDTBtable(), datasearch.getRelation(), datasearch.getValue());
                        System.out.println("Data searched.");
                        dos.writeUTF(querrysearch);
                        break;
                    case "TEXTDATASEARCH":
                        TextDataSearch textdatasearch = (TextDataSearch) ois.readObject();
                        String querrytextsearch = PrepareStatement.executeSearchTextData(textdatasearch.getNamesOfColumnsDTBtable(), textdatasearch.getNameOfDTBtable(), textdatasearch.getColumnnameDTBtable(), textdatasearch.getValue());
                        System.out.println("Text data searched.");
                        dos.writeUTF(querrytextsearch);
                        break;
                    case "ROWSDELETION":
                        DeletionOfSelectedRows rowsdeletion = (DeletionOfSelectedRows) ois.readObject();
                        String querrydeletion = PrepareStatement.executeDeleteSelectedRows(rowsdeletion.getNameofDTBtable(), rowsdeletion.getCondition_columnnameDTBtable(), rowsdeletion.getCondition_value());
                        System.out.println("Data deleted.");
                        dos.writeUTF(querrydeletion);
                        break;
                    case "DELETEIDFILM":
                        Object idvalue = ois.readObject();
                        String deletevalue = PrepareStatement.executeDeleteidFilmFromPredstaveni(idvalue);
                        System.out.println("idFilm deleted.");
                        dos.writeUTF(deletevalue);
                        break;
                    case "DELETEIDKINO":
                        Object idkinovalue = ois.readObject();
                        String deleteidkinovalue = PrepareStatement.executeDeleteidFilmFromPredstaveni(idkinovalue);
                        System.out.println("idKino deleted.");
                        dos.writeUTF(deleteidkinovalue);
                        break;
                    case "LOGIN":
                        String name = (String) ois.readObject();
                        String pasword = (String) ois.readObject();
                        boolean login = PrepareStatement.logIn(name, pasword);
                        System.out.println("Logged in.");
                        dos.writeBoolean(login);
                        break;                    
                    case "MOVIESSCHEDULE":
                        Object idkino = ois.readObject();
                        String querryschedule = PrepareStatement.executeSelectCinemaMoviesSchedule(idkino);
                        System.out.println("Data selected 3 columns.");
                        dos.writeUTF(querryschedule);
                        break;
                    case "SELECT":
                        querry = message[0] + " " + message[1];
                        break;
                    /*   case "UPDATE":
                        querry = message[0] + " " + message[1];
                        break;
                    case "DELETE":
                        querry = message[0] + " " + message[1];
                        break;
                    case "INSERT":
                        querry = message[0] + " " + message[1];
                        break;*/
                    case "CACHEDROWSET":
                        CachedRowSet crs = dfdtb.getCachedRowSet(querry);
                        oos.writeObject(dfdtb.getCachedRowSet(querry));
                        oos.flush();
                        break;
                    
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            }
            try {
                this.dis.close();
                this.dos.close();
                this.ois.close();
                this.oos.close();
            } catch (IOException e) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
            }            
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            try {                
                this.dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {                
                this.dos.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {                
                this.ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {                
                this.oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
