/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author RadimP
 */
public class JFrameJedenSvet extends javax.swing.JFrame {

    Client client = new Client();
    ZobrazeniDatTableModel tablemodel_predstaveni_dtb;
    ZobrazeniDatTableModel tablemodel_film_dtb;
    ZobrazeniDatTableModel tablemodel_kino_dtb;
    PridavaniDatTableModel tablemodel_predstaveni_pridavanidat;
    PridavaniDatTableModel tablemodel_film_pridavanidat;
    UpravaDatTableModel emptytable_predstaveni;
    UpravaDatTableModel emptytable_film;
    VyhledavaniDatTableModel emptyresulttable_predstaveni;
    VyhledavaniDatTableModel tablemodel_predstaveni_results;
    VyhledavaniDatTableModel emptyresulttable_film;
    VyhledavaniDatTableModel tablemodel_film_results;
    int switch_casenumber_predstaveni;
    int switch_casenumber_film;
    int predstaveni_popis_filmu_selectedrow_index;
    int predstaveni_popis_filmu_selectedcolumn_index;
    int film_popis_filmu_selectedrow_index;
    int film_popis_filmu_selectedcolumn_index;
    String[] namesofDTBtables = {"predstaveni", "film", "kino"};
    String[] namesofcolumns_predstavenitable = {"idPredstaveni", "Datum", "idFilm"};
    String[] namesofcolumns_filmtable = {"idFilm", "JmenoF", "Reziser", "Rok", "Popis"};
    String[] namesofcolumns_kinotable = {"idKino", "Nazev", "Ulice", "C.popisne", "C.orientacni", "Obec", "PSC", "idPredstaveni"};
    String performed_querry_predstaveni_film_by_date = null;
    String performed_querry_predstaveni_vyhledavani = null;
    String performed_querry_predstaveni_film_by_idFilm = null;
    String performed_querry_film__by_value = null;
    ArrayList<ArrayList<Integer>> edited_fields_predstaveni_tab = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> edited_fields_film_tab = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> edited_rows_predstaveni_tab = new ArrayList<Integer>();
    ArrayList<Integer> edited_rows_film_tab = new ArrayList<Integer>();
    DataFromDatabase fordefault = new DataFromDatabase();
    static String SQLDOTAZ_PREDSTAVENI = "SELECT idPredstaveni, Datum, idFilm FROM jeden_svet.predstaveni;";
    static final String SQLDOTAZ_FILM = "SELECT * FROM jeden_svet.film;";
    static final String SQLDOTAZ_KINO = "SELECT * FROM jeden_svet.kino;";

    /**
     * Creates new form JFrameJedenSvet and set PROPERTIES for connection to
     * Database
     */
    public JFrameJedenSvet() {
        //  PROPERTIES.setProperty("user", "root");
        //   PROPERTIES.setProperty("password", "1111");
        //   PROPERTIES.setProperty("useSSL", "false");
        //   PROPERTIES.setProperty("autoReconnect", "true");

        tablemodel_predstaveni_dtb = new ZobrazeniDatTableModel(SQLDOTAZ_PREDSTAVENI, 1);
        tablemodel_predstaveni_pridavanidat = new PridavaniDatTableModel(SQLDOTAZ_PREDSTAVENI);
        tablemodel_film_pridavanidat = new PridavaniDatTableModel(SQLDOTAZ_FILM);
        emptytable_predstaveni = new UpravaDatTableModel();
        emptytable_film = new UpravaDatTableModel();
        emptyresulttable_predstaveni = new VyhledavaniDatTableModel(SQLDOTAZ_PREDSTAVENI, "");
        tablemodel_predstaveni_results = new VyhledavaniDatTableModel(SQLDOTAZ_PREDSTAVENI, 1);
        emptyresulttable_film = new VyhledavaniDatTableModel(SQLDOTAZ_FILM, "");
        tablemodel_film_results = new VyhledavaniDatTableModel(SQLDOTAZ_FILM, 1);
        tablemodel_film_dtb = new ZobrazeniDatTableModel(SQLDOTAZ_FILM, 1);
        initComponents();

        //  HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTableFilmDataFromDTB);
        //   HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
        //   HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniPridaniDat);
        //  HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniVysledkyVyhledavani);
        JTableUtilities.setColumnWidths(jTablePredstaveniDatafromDTB, 95, 150, 50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneSpolecny = new javax.swing.JTabbedPane();
        jPanelPredstaveniHlavni = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePredstaveniDatafromDTB = new javax.swing.JTable();
        jTabbedPanePredstaveniVnoreny = new javax.swing.JTabbedPane();
        jPanelPredstaveniUpravaDat = new javax.swing.JPanel();
        jLabelPredstaveniPopisAktualizace = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePredstaveniZobrazenivybranychDat = new javax.swing.JTable();
        jButtonPredstaveniAktualizujVDTB = new javax.swing.JButton();
        jButtonPredstaveniUpravitPopis = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaPredstaveniUpravaPopisuFilmu = new javax.swing.JTextArea();
        jLabelPredstaveniUparavaPopisFilmu = new javax.swing.JLabel();
        jButtonPredstaveniUpravenyPopisAktualizovatVDTB = new javax.swing.JButton();
        jButtonPredstaveniPopisFilmuDoTabulky = new javax.swing.JButton();
        jPanelPredstaveniPridavaniDat = new javax.swing.JPanel();
        jLabelPredstaveniPridaniDat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePredstaveniPridaniDat = new javax.swing.JTable();
        jButtonPredstaveniPridatData = new javax.swing.JButton();
        jPanelPredstaveniVyhledavaniDat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePredstaveniVysledkyVyhledavani = new javax.swing.JTable();
        jLabelPredstaveniVyhledavaniPopisVolby = new javax.swing.JLabel();
        jLabelPredstaveniVyhledavaniVysledky = new javax.swing.JLabel();
        jButtonPredstaveniVyhledavaniidPredstaveniJeMensi = new javax.swing.JButton();
        jButtonPredstaveniVyhledavaniidPredstaveniJeRovno = new javax.swing.JButton();
        jLabelPredstaveniVyhledaniPodleidPredstaveni = new javax.swing.JLabel();
        jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi = new javax.swing.JButton();
        jSpinnerPredstaveniVyhledavaniidPredstaveni = new javax.swing.JSpinner();
        jLabelPredstaverniVyhledavaniDatum = new javax.swing.JLabel();
        jButtonPredstaveniVyhledavaniDatumJeVetsi = new javax.swing.JButton();
        jButtonPredstaveniVyhledavaniDatumJeRovno = new javax.swing.JButton();
        jButtonPredstaveniVyhledavaniDatumJeMensi = new javax.swing.JButton();
        jTextFieldPredstaveniVyhledavaniDatum = new javax.swing.JTextField();
        jLabelPredstaveniVyhledavaniidFilmu = new javax.swing.JLabel();
        jButtonPredstaveniVyhledavaniidFilmuJeVetsi = new javax.swing.JButton();
        jButtonPredstaveniVyhledavaniidFilmuJeRovno = new javax.swing.JButton();
        jButtonPredstaveniVyhledavaniidFilmJeMensi = new javax.swing.JButton();
        jSpinnerPredstaveniVyhledavaniidFilm = new javax.swing.JSpinner();
        jButtonPredstaveniVyhledavavniOdstranitVysledky = new javax.swing.JButton();
        jButtonPredstaveniVyhledavaniVymazatVybraneVysledky = new javax.swing.JButton();
        jLabelPredstaveniDatavDTB = new javax.swing.JLabel();
        jButtonPredstaveniVyberData = new javax.swing.JButton();
        jPanelFilmHlavni = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFilmDataFromDTB = new javax.swing.JTable();
        jTabbedPaneFilmVnoreny = new javax.swing.JTabbedPane();
        jPanelFilmUpravaDat = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableFilmZobrazeniVybranychDat = new javax.swing.JTable();
        jLabelFilmPopisAktualizace = new javax.swing.JLabel();
        jButtonFilmAktualizujVDTB = new javax.swing.JButton();
        jButtonFilmUpravitPopis = new javax.swing.JButton();
        jLabelFilmUpravaPopisu = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaFilmUpravaPopisu = new javax.swing.JTextArea();
        jButtonFilmAktualizovatPopisVDTB = new javax.swing.JButton();
        jButtonFilmPopisUlozitDoTabulky = new javax.swing.JButton();
        jPanelFilmPridavaniDat = new javax.swing.JPanel();
        jLabelFilmiPridaniDat = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableFilmPridaniDat = new javax.swing.JTable();
        jButtonFilmiPridatData = new javax.swing.JButton();
        jPanelFilmVyhledavaniDat = new javax.swing.JPanel();
        jLabelFilmVyhledavaniPopisVolby = new javax.swing.JLabel();
        jLabelFilmVyhledaniPodleidFilm = new javax.swing.JLabel();
        jButtonFilmVyhledavaniidFilmJeVetsi = new javax.swing.JButton();
        jButtonFilmVyhledavaniidFilmJeRovno = new javax.swing.JButton();
        jButtonFilmVyhledavaniidFilmJeMensi = new javax.swing.JButton();
        jSpinnerFilmVyhledavaniidFilm = new javax.swing.JSpinner();
        jLabelFilmVyhledaniPodleRok = new javax.swing.JLabel();
        jButtonFilmVyhledavaniRokJeVetsi = new javax.swing.JButton();
        jButtonFilmVyhledavaniRokJeRoven = new javax.swing.JButton();
        jButtonFilmVyhledavaniRokJeMensi = new javax.swing.JButton();
        jSpinnerFilmVyhledavaniRok = new javax.swing.JSpinner();
        jLabelFilmVyhledaniPodleJmenoF = new javax.swing.JLabel();
        jButtonFilmVyhledavaniJmenoFZacina = new javax.swing.JButton();
        jButtonFilmVyhledavaniJmenoFobsahuje = new javax.swing.JButton();
        jButtonFilmVyhledavaniJmenoFkoncina = new javax.swing.JButton();
        jButtonFilmVyhledavaniJmenoFje = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextAreaFilmVyhledavaniNazev = new javax.swing.JTextArea();
        jLabelFilmVyhledaniPodleReziser = new javax.swing.JLabel();
        jButtonFilmVyhledavaniReziserZacina = new javax.swing.JButton();
        jButtonFilmVyhledavaniReziserJe = new javax.swing.JButton();
        jButtonFilmVyhledavaniReziserObsahuje = new javax.swing.JButton();
        jButtonFilmVyhledavaniReziserKonciNa = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextAreaFilmVyhledavaniReziser = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextAreaFilmVyhledavaniPopis = new javax.swing.JTextArea();
        jButtonFilmVyhledavaniPopisZacina = new javax.swing.JButton();
        jButtonFilmVyhledavaniPopisJe = new javax.swing.JButton();
        jButtonFilmVyhledavaniPopisObsahuje = new javax.swing.JButton();
        jButtonFilmVyhledavaniPopisKonciNa = new javax.swing.JButton();
        jLabelFilmVyhledaniPodlePopis = new javax.swing.JLabel();
        jLabelFilmVyhledavaniVysledky = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableFilmVysledkyVyhledavani = new javax.swing.JTable();
        jButtonFilmVyhledavavniOdstranitVysledky = new javax.swing.JButton();
        jButtonFilmiVyhledavaniVymazatVybraneVysledky = new javax.swing.JButton();
        jLabelFilmDatavDTB = new javax.swing.JLabel();
        jButtonFilmVyberData = new javax.swing.JButton();
        jPanelKinoHlavni = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Databáze Jeden svět");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPaneSpolecny.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPaneSpolecny.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = Color.LIGHT_GRAY;
                lightHighlight = Color.LIGHT_GRAY;
                shadow = Color.LIGHT_GRAY;
                darkShadow = Color.LIGHT_GRAY;
                focus = Color.LIGHT_GRAY;
            }
        });
        jTabbedPaneSpolecny.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPaneSpolecny.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanelPredstaveniHlavni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTablePredstaveniDatafromDTB.setModel(tablemodel_predstaveni_dtb);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniDatafromDTB);
        jTablePredstaveniDatafromDTB.setCellSelectionEnabled(true);
        jTablePredstaveniDatafromDTB.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTablePredstaveniDatafromDTB);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniDatafromDTB);

        jTabbedPanePredstaveniVnoreny.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPanePredstaveniVnoreny.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = Color.LIGHT_GRAY;
                lightHighlight = Color.LIGHT_GRAY;
                shadow = Color.LIGHT_GRAY;
                darkShadow = Color.LIGHT_GRAY;
                focus = Color.LIGHT_GRAY;
            }
        });
        jTabbedPanePredstaveniVnoreny.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPanePredstaveniVnoreny.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPanePredstaveniVnoreny.setOpaque(true);

        jLabelPredstaveniPopisAktualizace.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniPopisAktualizace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPredstaveniPopisAktualizace.setText("Podrobnosti k vybrané položce");

        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
        jTablePredstaveniZobrazenivybranychDat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTablePredstaveniZobrazenivybranychDat.setModel(emptytable_predstaveni);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
        jTablePredstaveniZobrazenivybranychDat.setCellSelectionEnabled(true);
        jTablePredstaveniZobrazenivybranychDat.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
        jTablePredstaveniZobrazenivybranychDat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePredstaveniZobrazenivybranychDat.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTablePredstaveniZobrazenivybranychDat);

        jButtonPredstaveniAktualizujVDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniAktualizujVDTB.setText("Aktualizovat v DTB");
        jButtonPredstaveniAktualizujVDTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniAktualizujVDTBActionPerformed(evt);
            }
        });

        jButtonPredstaveniUpravitPopis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniUpravitPopis.setText("Upravit vybraný popis filmu v textovém poli");
        jButtonPredstaveniUpravitPopis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniUpravitPopisActionPerformed(evt);
            }
        });

        jTextAreaPredstaveniUpravaPopisuFilmu.setColumns(20);
        jTextAreaPredstaveniUpravaPopisuFilmu.setLineWrap(true);
        jTextAreaPredstaveniUpravaPopisuFilmu.setWrapStyleWord(true);
        jTextAreaPredstaveniUpravaPopisuFilmu.setRows(5);
        jScrollPane3.setViewportView(jTextAreaPredstaveniUpravaPopisuFilmu);

        jLabelPredstaveniUparavaPopisFilmu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniUparavaPopisFilmu.setText("Vybraný popis filmu");

        jButtonPredstaveniUpravenyPopisAktualizovatVDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniUpravenyPopisAktualizovatVDTB.setText("Aktualizovat popis v DTB");
        jButtonPredstaveniUpravenyPopisAktualizovatVDTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniUpravenyPopisAktualizovatVDTBActionPerformed(evt);
            }
        });

        jButtonPredstaveniPopisFilmuDoTabulky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniPopisFilmuDoTabulky.setText("Uložit popis do tabulky");
        jButtonPredstaveniPopisFilmuDoTabulky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniPopisFilmuDoTabulkyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPredstaveniUpravaDatLayout = new javax.swing.GroupLayout(jPanelPredstaveniUpravaDat);
        jPanelPredstaveniUpravaDat.setLayout(jPanelPredstaveniUpravaDatLayout);
        jPanelPredstaveniUpravaDatLayout.setHorizontalGroup(
            jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                .addGroup(jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabelPredstaveniPopisAktualizace, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                                        .addComponent(jButtonPredstaveniUpravenyPopisAktualizovatVDTB)
                                        .addGap(38, 38, 38)
                                        .addComponent(jButtonPredstaveniPopisFilmuDoTabulky))
                                    .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                                        .addComponent(jButtonPredstaveniAktualizujVDTB)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButtonPredstaveniUpravitPopis))))))
                    .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabelPredstaveniUparavaPopisFilmu))
                    .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanelPredstaveniUpravaDatLayout.setVerticalGroup(
            jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredstaveniUpravaDatLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelPredstaveniPopisAktualizace)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPredstaveniAktualizujVDTB)
                    .addComponent(jButtonPredstaveniUpravitPopis))
                .addGap(34, 34, 34)
                .addComponent(jLabelPredstaveniUparavaPopisFilmu)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPredstaveniUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPredstaveniUpravenyPopisAktualizovatVDTB)
                    .addComponent(jButtonPredstaveniPopisFilmuDoTabulky))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPanePredstaveniVnoreny.addTab("Úprava dat", jPanelPredstaveniUpravaDat);

        jPanelPredstaveniPridavaniDat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelPredstaveniPridaniDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniPridaniDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPredstaveniPridaniDat.setText("Tabulka pro přidání představení do databáze");

        jTablePredstaveniPridaniDat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTablePredstaveniPridaniDat.setModel(tablemodel_predstaveni_pridavanidat);
        jTablePredstaveniPridaniDat.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniPridaniDat);
        jTablePredstaveniPridaniDat.setColumnSelectionAllowed(true);
        jTablePredstaveniPridaniDat.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePredstaveniPridaniDat);
        jTablePredstaveniPridaniDat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonPredstaveniPridatData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniPridatData.setText("Přidat představení do databáze");
        jButtonPredstaveniPridatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniPridatDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPredstaveniPridavaniDatLayout = new javax.swing.GroupLayout(jPanelPredstaveniPridavaniDat);
        jPanelPredstaveniPridavaniDat.setLayout(jPanelPredstaveniPridavaniDatLayout);
        jPanelPredstaveniPridavaniDatLayout.setHorizontalGroup(
            jPanelPredstaveniPridavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredstaveniPridavaniDatLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanelPredstaveniPridavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelPredstaveniPridaniDat, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPredstaveniPridatData))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanelPredstaveniPridavaniDatLayout.setVerticalGroup(
            jPanelPredstaveniPridavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredstaveniPridavaniDatLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabelPredstaveniPridaniDat)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButtonPredstaveniPridatData)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPanePredstaveniVnoreny.addTab("Přidávání dat", jPanelPredstaveniPridavaniDat);

        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniVysledkyVyhledavani);
        jTablePredstaveniVysledkyVyhledavani.setModel(emptyresulttable_predstaveni);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniVysledkyVyhledavani);
        jTablePredstaveniVysledkyVyhledavani.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTablePredstaveniVysledkyVyhledavani.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTablePredstaveniVysledkyVyhledavani);

        jLabelPredstaveniVyhledavaniPopisVolby.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniVyhledavaniPopisVolby.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPredstaveniVyhledavaniPopisVolby.setText("Vyhledat představení podle:");

        jLabelPredstaveniVyhledavaniVysledky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniVyhledavaniVysledky.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPredstaveniVyhledavaniVysledky.setText("Výsledky vyhledávání:");

        jButtonPredstaveniVyhledavaniidPredstaveniJeMensi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniidPredstaveniJeMensi.setText("je menší");
        jButtonPredstaveniVyhledavaniidPredstaveniJeMensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniidPredstaveniJeMensiActionPerformed(evt);
            }
        });

        jButtonPredstaveniVyhledavaniidPredstaveniJeRovno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniidPredstaveniJeRovno.setText("je rovno");
        jButtonPredstaveniVyhledavaniidPredstaveniJeRovno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniidPredstaveniJeRovnoActionPerformed(evt);
            }
        });

        jLabelPredstaveniVyhledaniPodleidPredstaveni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniVyhledaniPodleidPredstaveni.setText("idPredstaveni");

        jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi.setText("je větší");
        jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniidPredstaveniJeVetsiActionPerformed(evt);
            }
        });

        jLabelPredstaverniVyhledavaniDatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaverniVyhledavaniDatum.setText("Datum");

        jButtonPredstaveniVyhledavaniDatumJeVetsi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniDatumJeVetsi.setText("je větší");
        jButtonPredstaveniVyhledavaniDatumJeVetsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniDatumJeVetsiActionPerformed(evt);
            }
        });

        jButtonPredstaveniVyhledavaniDatumJeRovno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniDatumJeRovno.setText("je rovno");
        jButtonPredstaveniVyhledavaniDatumJeRovno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniDatumJeRovnoActionPerformed(evt);
            }
        });

        jButtonPredstaveniVyhledavaniDatumJeMensi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniDatumJeMensi.setText("je menší");
        jButtonPredstaveniVyhledavaniDatumJeMensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniDatumJeMensiActionPerformed(evt);
            }
        });

        jTextFieldPredstaveniVyhledavaniDatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelPredstaveniVyhledavaniidFilmu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniVyhledavaniidFilmu.setText("idFilmu");

        jButtonPredstaveniVyhledavaniidFilmuJeVetsi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniidFilmuJeVetsi.setText("je větší");
        jButtonPredstaveniVyhledavaniidFilmuJeVetsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniidFilmuJeVetsiActionPerformed(evt);
            }
        });

        jButtonPredstaveniVyhledavaniidFilmuJeRovno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniidFilmuJeRovno.setText("je rovno");
        jButtonPredstaveniVyhledavaniidFilmuJeRovno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniidFilmuJeRovnoActionPerformed(evt);
            }
        });

        jButtonPredstaveniVyhledavaniidFilmJeMensi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniidFilmJeMensi.setText("je menší");
        jButtonPredstaveniVyhledavaniidFilmJeMensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniidFilmJeMensiActionPerformed(evt);
            }
        });

        jSpinnerPredstaveniVyhledavaniidFilm.setMinimumSize(new java.awt.Dimension(50, 20));

        jButtonPredstaveniVyhledavavniOdstranitVysledky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavavniOdstranitVysledky.setText("Vyprázdnit tabulku výsledků");
        jButtonPredstaveniVyhledavavniOdstranitVysledky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavavniOdstranitVysledkyActionPerformed(evt);
            }
        });

        jButtonPredstaveniVyhledavaniVymazatVybraneVysledky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyhledavaniVymazatVybraneVysledky.setText("Vymazat vybrané výsledky");
        jButtonPredstaveniVyhledavaniVymazatVybraneVysledky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyhledavaniVymazatVybraneVysledkyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPredstaveniVyhledavaniDatLayout = new javax.swing.GroupLayout(jPanelPredstaveniVyhledavaniDat);
        jPanelPredstaveniVyhledavaniDat.setLayout(jPanelPredstaveniVyhledavaniDatLayout);
        jPanelPredstaveniVyhledavaniDatLayout.setHorizontalGroup(
            jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(jSpinnerPredstaveniVyhledavaniidFilm, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addGap(147, 147, 147))
                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                        .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelPredstaveniVyhledavaniPopisVolby, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPredstaveniVyhledaniPodleidPredstaveni)
                                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelPredstaveniVyhledavaniidFilmu)
                                        .addComponent(jLabelPredstaverniVyhledavaniDatum)))))
                        .addGap(44, 44, 44)
                        .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPredstaveniVyhledavaniidFilmJeMensi)
                            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonPredstaveniVyhledavaniDatumJeRovno)
                                    .addComponent(jButtonPredstaveniVyhledavaniidPredstaveniJeRovno)
                                    .addComponent(jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPredstaveniVyhledavaniidPredstaveniJeMensi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPredstaveniVyhledavaniDatumJeVetsi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPredstaveniVyhledavaniDatumJeMensi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPredstaveniVyhledavaniidFilmuJeVetsi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPredstaveniVyhledavaniidFilmuJeRovno))
                                .addGap(49, 49, 49)
                                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                        .addComponent(jSpinnerPredstaveniVyhledavaniidPredstaveni)
                                        .addGap(69, 69, 69))
                                    .addComponent(jTextFieldPredstaveniVyhledavaniDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(86, 86, 86))
                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabelPredstaveniVyhledavaniVysledky, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                .addComponent(jButtonPredstaveniVyhledavavniOdstranitVysledky)
                                .addGap(54, 54, 54)
                                .addComponent(jButtonPredstaveniVyhledavaniVymazatVybraneVysledky)))))
                .addGap(84, 84, 84))
        );

        jPanelPredstaveniVyhledavaniDatLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonPredstaveniVyhledavaniDatumJeMensi, jButtonPredstaveniVyhledavaniDatumJeRovno, jButtonPredstaveniVyhledavaniDatumJeVetsi, jButtonPredstaveniVyhledavaniidFilmJeMensi, jButtonPredstaveniVyhledavaniidFilmuJeRovno, jButtonPredstaveniVyhledavaniidFilmuJeVetsi, jButtonPredstaveniVyhledavaniidPredstaveniJeMensi, jButtonPredstaveniVyhledavaniidPredstaveniJeRovno, jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi});

        jPanelPredstaveniVyhledavaniDatLayout.setVerticalGroup(
            jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                        .addComponent(jLabelPredstaveniVyhledavaniPopisVolby)
                        .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jSpinnerPredstaveniVyhledavaniidPredstaveni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPredstaveniVyhledaniPodleidPredstaveni))))
                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPredstaveniVyhledavaniidPredstaveniJeRovno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPredstaveniVyhledavaniidPredstaveniJeMensi)
                .addGap(23, 23, 23)
                .addComponent(jButtonPredstaveniVyhledavaniDatumJeVetsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPredstaveniVyhledavaniDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPredstaverniVyhledavaniDatum)
                    .addComponent(jButtonPredstaveniVyhledavaniDatumJeRovno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPredstaveniVyhledavaniDatumJeMensi)
                .addGap(26, 26, 26)
                .addComponent(jButtonPredstaveniVyhledavaniidFilmuJeVetsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPredstaveniVyhledavaniidFilmuJeRovno)
                        .addComponent(jSpinnerPredstaveniVyhledavaniidFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelPredstaveniVyhledavaniidFilmu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPredstaveniVyhledavaniidFilmJeMensi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabelPredstaveniVyhledavaniVysledky)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPredstaveniVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPredstaveniVyhledavavniOdstranitVysledky)
                    .addComponent(jButtonPredstaveniVyhledavaniVymazatVybraneVysledky))
                .addGap(17, 17, 17))
        );

        jTabbedPanePredstaveniVnoreny.addTab("Vyhledávání", jPanelPredstaveniVyhledavaniDat);

        jLabelPredstaveniDatavDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPredstaveniDatavDTB.setText("Tabulka Predstaveni - data v databázi");

        jButtonPredstaveniVyberData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPredstaveniVyberData.setText("Vyber označená data");
        jButtonPredstaveniVyberData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPredstaveniVyberDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPredstaveniHlavniLayout = new javax.swing.GroupLayout(jPanelPredstaveniHlavni);
        jPanelPredstaveniHlavni.setLayout(jPanelPredstaveniHlavniLayout);
        jPanelPredstaveniHlavniLayout.setHorizontalGroup(
            jPanelPredstaveniHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredstaveniHlavniLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addGroup(jPanelPredstaveniHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelPredstaveniDatavDTB)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPredstaveniVyberData)
                    .addComponent(jTabbedPanePredstaveniVnoreny, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanelPredstaveniHlavniLayout.setVerticalGroup(
            jPanelPredstaveniHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPredstaveniHlavniLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelPredstaveniDatavDTB)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPredstaveniVyberData)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPanePredstaveniVnoreny, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneSpolecny.addTab("Predstaveni", jPanelPredstaveniHlavni);

        jPanelFilmHlavni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableFilmDataFromDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableFilmDataFromDTB.setModel(tablemodel_film_dtb);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTableFilmDataFromDTB);
        jTableFilmDataFromDTB.setCellSelectionEnabled(true);
        jTableFilmDataFromDTB.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableFilmDataFromDTB.getTableHeader().setReorderingAllowed(false);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniDatafromDTB);
        jScrollPane4.setViewportView(jTableFilmDataFromDTB);

        jTabbedPaneFilmVnoreny.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = Color.LIGHT_GRAY;
                lightHighlight = Color.LIGHT_GRAY;
                shadow = Color.LIGHT_GRAY;
                darkShadow = Color.LIGHT_GRAY;
                focus = Color.LIGHT_GRAY;
            }
        });
        jTabbedPaneFilmVnoreny.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPaneFilmVnoreny.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPaneFilmVnoreny.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTableFilmZobrazeniVybranychDat);
        jTableFilmZobrazeniVybranychDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableFilmZobrazeniVybranychDat.setModel(emptytable_film);
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTableFilmDataFromDTB);
        jTableFilmZobrazeniVybranychDat.setCellSelectionEnabled(true);
        jTableFilmZobrazeniVybranychDat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(jTableFilmZobrazeniVybranychDat);

        jLabelFilmPopisAktualizace.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmPopisAktualizace.setText("Upravit údaje u vybraného filmu");

        jButtonFilmAktualizujVDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmAktualizujVDTB.setText("Aktualizovat v DTB");
        jButtonFilmAktualizujVDTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmAktualizujVDTBActionPerformed(evt);
            }
        });

        jButtonFilmUpravitPopis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmUpravitPopis.setText("Upravit vybraný údaj v textovém poli");
        jButtonFilmUpravitPopis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmUpravitPopisActionPerformed(evt);
            }
        });

        jLabelFilmUpravaPopisu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmUpravaPopisu.setText("Vybraný údaj");

        jTextAreaFilmUpravaPopisu.setColumns(20);
        jTextAreaFilmUpravaPopisu.setLineWrap(true);
        jTextAreaFilmUpravaPopisu.setRows(5);
        jTextAreaFilmUpravaPopisu.setWrapStyleWord(true);
        jScrollPane8.setViewportView(jTextAreaFilmUpravaPopisu);

        jButtonFilmAktualizovatPopisVDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmAktualizovatPopisVDTB.setText("Aktualizovat údaj v DTB");
        jButtonFilmAktualizovatPopisVDTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmAktualizovatPopisVDTBActionPerformed(evt);
            }
        });

        jButtonFilmPopisUlozitDoTabulky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmPopisUlozitDoTabulky.setText("Uložit údaj do tabulky");
        jButtonFilmPopisUlozitDoTabulky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmPopisUlozitDoTabulkyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilmUpravaDatLayout = new javax.swing.GroupLayout(jPanelFilmUpravaDat);
        jPanelFilmUpravaDat.setLayout(jPanelFilmUpravaDatLayout);
        jPanelFilmUpravaDatLayout.setHorizontalGroup(
            jPanelFilmUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmUpravaDatLayout.createSequentialGroup()
                .addGroup(jPanelFilmUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilmUpravaDatLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButtonFilmAktualizovatPopisVDTB)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonFilmPopisUlozitDoTabulky))
                    .addGroup(jPanelFilmUpravaDatLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanelFilmUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabelFilmPopisAktualizace)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFilmUpravaPopisu)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFilmUpravaDatLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButtonFilmAktualizujVDTB)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonFilmUpravitPopis)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanelFilmUpravaDatLayout.setVerticalGroup(
            jPanelFilmUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmUpravaDatLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelFilmPopisAktualizace)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFilmUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFilmAktualizujVDTB)
                    .addComponent(jButtonFilmUpravitPopis))
                .addGap(18, 18, 18)
                .addComponent(jLabelFilmUpravaPopisu)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFilmUpravaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFilmAktualizovatPopisVDTB)
                    .addComponent(jButtonFilmPopisUlozitDoTabulky))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPaneFilmVnoreny.addTab("Úprava dat", jPanelFilmUpravaDat);

        jLabelFilmiPridaniDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmiPridaniDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFilmiPridaniDat.setText("Tabulka pro přidání filmů do databáze");

        jTableFilmPridaniDat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableFilmPridaniDat.setModel(tablemodel_film_pridavanidat);
        jTableFilmPridaniDat.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTableFilmPridaniDat);
        jTableFilmPridaniDat.setCellSelectionEnabled(true);
        jTableFilmPridaniDat.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTableFilmPridaniDat);
        jTableFilmPridaniDat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonFilmiPridatData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmiPridatData.setText("Přidat film do databáze");
        jButtonFilmiPridatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmiPridatDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilmPridavaniDatLayout = new javax.swing.GroupLayout(jPanelFilmPridavaniDat);
        jPanelFilmPridavaniDat.setLayout(jPanelFilmPridavaniDatLayout);
        jPanelFilmPridavaniDatLayout.setHorizontalGroup(
            jPanelFilmPridavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmPridavaniDatLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanelFilmPridavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelFilmiPridaniDat, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFilmiPridatData))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanelFilmPridavaniDatLayout.setVerticalGroup(
            jPanelFilmPridavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmPridavaniDatLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabelFilmiPridaniDat)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButtonFilmiPridatData)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jTabbedPaneFilmVnoreny.addTab("Přidávání filmů", jPanelFilmPridavaniDat);

        jLabelFilmVyhledavaniPopisVolby.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledavaniPopisVolby.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFilmVyhledavaniPopisVolby.setText("Vyhledat film podle:");

        jLabelFilmVyhledaniPodleidFilm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledaniPodleidFilm.setText("idFilm");

        jButtonFilmVyhledavaniidFilmJeVetsi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniidFilmJeVetsi.setText("je větší");
        jButtonFilmVyhledavaniidFilmJeVetsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniidFilmJeVetsiActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniidFilmJeRovno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniidFilmJeRovno.setText("je rovno");
        jButtonFilmVyhledavaniidFilmJeRovno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniidFilmJeRovnoActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniidFilmJeMensi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniidFilmJeMensi.setText("je menší");
        jButtonFilmVyhledavaniidFilmJeMensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniidFilmJeMensiActionPerformed(evt);
            }
        });

        jLabelFilmVyhledaniPodleRok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledaniPodleRok.setText("Rok");

        jButtonFilmVyhledavaniRokJeVetsi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniRokJeVetsi.setText("je větší");
        jButtonFilmVyhledavaniRokJeVetsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniRokJeVetsiActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniRokJeRoven.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniRokJeRoven.setText("je roven");
        jButtonFilmVyhledavaniRokJeRoven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniRokJeRovenActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniRokJeMensi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniRokJeMensi.setText("je menší");
        jButtonFilmVyhledavaniRokJeMensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniRokJeMensiActionPerformed(evt);
            }
        });

        jSpinnerFilmVyhledavaniRok.setValue(new Integer(1895));
        jSpinnerFilmVyhledavaniRok.setEditor(new JSpinner.NumberEditor(jSpinnerFilmVyhledavaniRok,"#"));

        jLabelFilmVyhledaniPodleJmenoF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledaniPodleJmenoF.setText("Název");

        jButtonFilmVyhledavaniJmenoFZacina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniJmenoFZacina.setText("začíná na");
        jButtonFilmVyhledavaniJmenoFZacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniJmenoFZacinaActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniJmenoFobsahuje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniJmenoFobsahuje.setText("obsahuje");
        jButtonFilmVyhledavaniJmenoFobsahuje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniJmenoFobsahujeActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniJmenoFkoncina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniJmenoFkoncina.setText("končí na");
        jButtonFilmVyhledavaniJmenoFkoncina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniJmenoFkoncinaActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniJmenoFje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniJmenoFje.setText("zní");
        jButtonFilmVyhledavaniJmenoFje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniJmenoFjeActionPerformed(evt);
            }
        });

        jTextAreaFilmVyhledavaniNazev.setColumns(20);
        jTextAreaFilmVyhledavaniNazev.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaFilmVyhledavaniNazev.setLineWrap(true);
        jTextAreaFilmVyhledavaniNazev.setRows(5);
        jTextAreaFilmVyhledavaniNazev.setWrapStyleWord(true);
        jTextAreaFilmVyhledavaniNazev.setMinimumSize(new java.awt.Dimension(4, 15));
        jScrollPane10.setViewportView(jTextAreaFilmVyhledavaniNazev);

        jLabelFilmVyhledaniPodleReziser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledaniPodleReziser.setText("Režisér");

        jButtonFilmVyhledavaniReziserZacina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniReziserZacina.setText("příjmení  začíná na");
        jButtonFilmVyhledavaniReziserZacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniReziserZacinaActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniReziserJe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniReziserJe.setText("celé příjmení zní");
        jButtonFilmVyhledavaniReziserJe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniReziserJeActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniReziserObsahuje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniReziserObsahuje.setText("příjmení obsahuje");
        jButtonFilmVyhledavaniReziserObsahuje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniReziserObsahujeActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniReziserKonciNa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniReziserKonciNa.setText("příjmení končí na");
        jButtonFilmVyhledavaniReziserKonciNa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniReziserKonciNaActionPerformed(evt);
            }
        });

        jTextAreaFilmVyhledavaniReziser.setColumns(20);
        jTextAreaFilmVyhledavaniReziser.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaFilmVyhledavaniReziser.setLineWrap(true);
        jTextAreaFilmVyhledavaniReziser.setRows(5);
        jTextAreaFilmVyhledavaniReziser.setWrapStyleWord(true);
        jTextAreaFilmVyhledavaniReziser.setMinimumSize(new java.awt.Dimension(4, 15));
        jScrollPane11.setViewportView(jTextAreaFilmVyhledavaniReziser);

        jTextAreaFilmVyhledavaniPopis.setColumns(20);
        jTextAreaFilmVyhledavaniPopis.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaFilmVyhledavaniPopis.setLineWrap(true);
        jTextAreaFilmVyhledavaniPopis.setRows(5);
        jTextAreaFilmVyhledavaniPopis.setWrapStyleWord(true);
        jTextAreaFilmVyhledavaniPopis.setMinimumSize(new java.awt.Dimension(4, 15));
        jScrollPane12.setViewportView(jTextAreaFilmVyhledavaniPopis);

        jButtonFilmVyhledavaniPopisZacina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniPopisZacina.setText("popis  začíná slovem");
        jButtonFilmVyhledavaniPopisZacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniPopisZacinaActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniPopisJe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniPopisJe.setText("celý popis zní");
        jButtonFilmVyhledavaniPopisJe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniPopisJeActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniPopisObsahuje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniPopisObsahuje.setText("popis obsahuje");
        jButtonFilmVyhledavaniPopisObsahuje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniPopisObsahujeActionPerformed(evt);
            }
        });

        jButtonFilmVyhledavaniPopisKonciNa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavaniPopisKonciNa.setText("popis končí slovem");
        jButtonFilmVyhledavaniPopisKonciNa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavaniPopisKonciNaActionPerformed(evt);
            }
        });

        jLabelFilmVyhledaniPodlePopis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledaniPodlePopis.setText("Popis");

        jLabelFilmVyhledavaniVysledky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmVyhledavaniVysledky.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFilmVyhledavaniVysledky.setText("Výsledky vyhledávání:");

        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniVysledkyVyhledavani);
        jTableFilmVysledkyVyhledavani.setModel(emptyresulttable_film);
        jTableFilmVysledkyVyhledavani.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableFilmVysledkyVyhledavani.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(jTableFilmVysledkyVyhledavani);

        jButtonFilmVyhledavavniOdstranitVysledky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyhledavavniOdstranitVysledky.setText("Vyprázdnit tabulku výsledků");
        jButtonFilmVyhledavavniOdstranitVysledky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyhledavavniOdstranitVysledkyActionPerformed(evt);
            }
        });

        jButtonFilmiVyhledavaniVymazatVybraneVysledky.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmiVyhledavaniVymazatVybraneVysledky.setText("Vymazat vybrané výsledky");
        jButtonFilmiVyhledavaniVymazatVybraneVysledky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmiVyhledavaniVymazatVybraneVysledkyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilmVyhledavaniDatLayout = new javax.swing.GroupLayout(jPanelFilmVyhledavaniDat);
        jPanelFilmVyhledavaniDat.setLayout(jPanelFilmVyhledavaniDatLayout);
        jPanelFilmVyhledavaniDatLayout.setHorizontalGroup(
            jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelFilmVyhledavaniPopisVolby, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFilmVyhledaniPodleidFilm)
                            .addComponent(jLabelFilmVyhledaniPodleReziser))
                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonFilmVyhledavaniidFilmJeRovno)
                                    .addComponent(jButtonFilmVyhledavaniidFilmJeMensi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFilmVyhledavaniidFilmJeVetsi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerFilmVyhledavaniidFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFilmVyhledaniPodleRok)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonFilmVyhledavaniRokJeRoven)
                                    .addComponent(jButtonFilmVyhledavaniRokJeMensi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFilmVyhledavaniRokJeVetsi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerFilmVyhledavaniRok, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFilmVyhledaniPodleJmenoF)
                                .addGap(12, 12, 12)
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonFilmVyhledavaniJmenoFZacina, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFilmVyhledavaniJmenoFkoncina, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFilmVyhledavaniJmenoFje, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonFilmVyhledavaniJmenoFobsahuje, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButtonFilmVyhledavaniReziserObsahuje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonFilmVyhledavaniReziserJe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonFilmVyhledavaniReziserZacina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonFilmVyhledavaniReziserKonciNa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                                .addComponent(jLabelFilmVyhledaniPodlePopis)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jButtonFilmVyhledavaniPopisObsahuje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                    .addComponent(jButtonFilmVyhledavaniPopisJe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButtonFilmVyhledavaniPopisKonciNa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(jButtonFilmVyhledavaniPopisZacina)))
                                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                .addComponent(jLabelFilmVyhledavaniVysledky, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                                .addComponent(jButtonFilmVyhledavavniOdstranitVysledky)
                                                .addGap(54, 54, 54)
                                                .addComponent(jButtonFilmiVyhledavaniVymazatVybraneVysledky)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanelFilmVyhledavaniDatLayout.setVerticalGroup(
            jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelFilmVyhledavaniPopisVolby)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addComponent(jButtonFilmVyhledavaniidFilmJeVetsi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonFilmVyhledavaniidFilmJeRovno)
                                    .addComponent(jSpinnerFilmVyhledavaniidFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniidFilmJeMensi))
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addComponent(jButtonFilmVyhledavaniRokJeVetsi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonFilmVyhledavaniRokJeRoven)
                                    .addComponent(jSpinnerFilmVyhledavaniRok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniRokJeMensi))
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabelFilmVyhledaniPodleRok))))
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabelFilmVyhledaniPodleidFilm))
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabelFilmVyhledaniPodleJmenoF))
                            .addComponent(jButtonFilmVyhledavaniJmenoFZacina)
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jButtonFilmVyhledavaniJmenoFje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniJmenoFobsahuje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniJmenoFkoncina))
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabelFilmVyhledaniPodleReziser))
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addComponent(jButtonFilmVyhledavaniReziserZacina)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniReziserJe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniReziserObsahuje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniReziserKonciNa))
                            .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                        .addComponent(jButtonFilmVyhledavaniPopisZacina)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFilmVyhledavaniPopisJe)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFilmVyhledavaniPopisObsahuje))
                                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabelFilmVyhledaniPodlePopis)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFilmVyhledavaniPopisKonciNa))))
                    .addGroup(jPanelFilmVyhledavaniDatLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabelFilmVyhledavaniVysledky)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFilmVyhledavaniDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFilmVyhledavavniOdstranitVysledky)
                    .addComponent(jButtonFilmiVyhledavaniVymazatVybraneVysledky))
                .addContainerGap())
        );

        jTabbedPaneFilmVnoreny.addTab("Vyhledávání filmů", jPanelFilmVyhledavaniDat);

        jLabelFilmDatavDTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFilmDatavDTB.setText("Tabulka Film - data v databázi");

        jButtonFilmVyberData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFilmVyberData.setText("Vyber označená data");
        jButtonFilmVyberData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmVyberDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilmHlavniLayout = new javax.swing.GroupLayout(jPanelFilmHlavni);
        jPanelFilmHlavni.setLayout(jPanelFilmHlavniLayout);
        jPanelFilmHlavniLayout.setHorizontalGroup(
            jPanelFilmHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmHlavniLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFilmHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelFilmDatavDTB)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFilmVyberData))
                .addGap(313, 313, 313))
            .addGroup(jPanelFilmHlavniLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jTabbedPaneFilmVnoreny, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanelFilmHlavniLayout.setVerticalGroup(
            jPanelFilmHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmHlavniLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelFilmDatavDTB)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFilmVyberData)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPaneFilmVnoreny, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
        );

        jTabbedPaneSpolecny.addTab("Film", jPanelFilmHlavni);

        jPanelKinoHlavni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelKinoHlavniLayout = new javax.swing.GroupLayout(jPanelKinoHlavni);
        jPanelKinoHlavni.setLayout(jPanelKinoHlavniLayout);
        jPanelKinoHlavniLayout.setHorizontalGroup(
            jPanelKinoHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
        );
        jPanelKinoHlavniLayout.setVerticalGroup(
            jPanelKinoHlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );

        jTabbedPaneSpolecny.addTab("Kino", jPanelKinoHlavni);

        getContentPane().add(jTabbedPaneSpolecny);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonPredstaveniVyberDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyberDataActionPerformed
        int row = jTablePredstaveniDatafromDTB.getSelectedRow();
        int column = jTablePredstaveniDatafromDTB.getSelectedColumn();
        switch (column) {

            case 0:
                switch_casenumber_predstaveni = 0;
                String querry0 = null;
                querry0 = client.selectDataByValue(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], jTablePredstaveniDatafromDTB.getModel().getValueAt(row, column));
                //PrepareStatement.executeSelectDatabySelectedValue(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], jTablePredstaveniDatafromDTB.getModel().getValueAt(row, column));
                System.out.println(querry0);
                jTablePredstaveniZobrazenivybranychDat.setModel(new UpravaDatTableModel(querry0, 1) {

                    @Override //nastavení editovatelnosti data přepsaním typu na string
                    public Class getColumnClass(int column) {
                        for (int row = 0; row < getRowCount(); row++) {
                            Object o = getValueAt(row, column);
                            if (o != null && column != 1) {
                                return o.getClass();

                            } else {
                                if (o != null) {
                                    return String.class;
                                }
                            }
                        }

                        return Object.class;
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex == 1;
                    }
                });
                HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
                jLabelPredstaveniPopisAktualizace.setText("V této tabulce můžete upravit datum představení.");
                break;

            case 1:

                switch_casenumber_predstaveni = 1;
                String querry1 = null;
                querry1 = client.selectDataByValueThroughInnerJoin(namesofcolumns_filmtable, namesofDTBtables[1],
                        namesofDTBtables[0], namesofcolumns_filmtable[0], namesofcolumns_predstavenitable[2], namesofcolumns_predstavenitable[1],
                        jTablePredstaveniDatafromDTB.getModel().getValueAt(row, column));
                performed_querry_predstaveni_film_by_date = querry1;
                jTablePredstaveniZobrazenivybranychDat.setModel(new UpravaDatTableModel(querry1, 1));
                HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
                String datum = jTablePredstaveniDatafromDTB.getModel().getValueAt(row, column).toString();
                jLabelPredstaveniPopisAktualizace.setText(datum + " hrají tyto filmy:");
                break;

            case 2:

                switch_casenumber_predstaveni = 2;
                String querry2 = null;
                querry2 = client.selectDataByValueThroughInnerJoin3Columnns(jTablePredstaveniDatafromDTB.getModel().getValueAt(row, column));
                //PrepareStatement.executeSelectDatabySelectedValueUsingOneInnerJoinThreeColumns(jTablePredstaveniDatafromDTB.getModel().getValueAt(row, column));
                performed_querry_predstaveni_film_by_idFilm = querry2;
                jTablePredstaveniZobrazenivybranychDat.setModel(new UpravaDatTableModel(querry2, 1) {
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex == 2;
                    }
                });
                HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
                jLabelPredstaveniPopisAktualizace.setText("V této tabulce můžete u představení změnit idFilmu.");
            default:
                break;
        }
    }//GEN-LAST:event_jButtonPredstaveniVyberDataActionPerformed

    private void jButtonPredstaveniAktualizujVDTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniAktualizujVDTBActionPerformed
        edited_fields_predstaveni_tab = ((UpravaDatTableModel) jTablePredstaveniZobrazenivybranychDat.getModel()).getIndicesOfEditedFields();

        switch (switch_casenumber_predstaveni) {

            case 0:
                String querry0 = null;

                for (int i = 0; i < edited_fields_predstaveni_tab.size(); i++) {
                    querry0 = client.updateEditedValueInDTB(namesofDTBtables[0], namesofcolumns_predstavenitable[1],
                            jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0),
                                    edited_fields_predstaveni_tab.get(i).get(1)), namesofcolumns_predstavenitable[0],
                                    jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), 0));
                                    }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTablePredstaveniDatafromDTB, SQLDOTAZ_PREDSTAVENI);
                break;

            case 1:
                String querry1 = null;
                for (int i = 0; i < edited_fields_predstaveni_tab.size(); i++) {
                    String columnname = jTablePredstaveniZobrazenivybranychDat.getModel().getColumnName(edited_fields_predstaveni_tab.get(i).get(1));
                    querry1 = client.updateEditedValueInDTB(namesofDTBtables[1], columnname,
                            jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0),
                                    edited_fields_predstaveni_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                                    jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), 0));
                    
                    /*   PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], columnname,
                    jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0),
                    edited_fields_predstaveni_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                    jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), 0));*/

                }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTablePredstaveniDatafromDTB, SQLDOTAZ_PREDSTAVENI);
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
                break;

            case 2:
                String querry2 = null;
                for (int i = 0; i < edited_fields_predstaveni_tab.size(); i++) {
                    querry2 = client.updateEditedValueInDTB(namesofDTBtables[0], namesofcolumns_predstavenitable[2],
                            jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), edited_fields_predstaveni_tab.get(i).get(1)),
                            namesofcolumns_predstavenitable[0], jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), 0));
                    
                    /*  PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[0], namesofcolumns_predstavenitable[2],
                    jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), edited_fields_predstaveni_tab.get(i).get(1)),
                    namesofcolumns_predstavenitable[0], jTablePredstaveniZobrazenivybranychDat.getModel().getValueAt(edited_fields_predstaveni_tab.get(i).get(0), 0));*/

                }
                jTablePredstaveniZobrazenivybranychDat.setModel(new UpravaDatTableModel(performed_querry_predstaveni_film_by_idFilm, 1));
                HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniZobrazenivybranychDat);
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTablePredstaveniDatafromDTB, SQLDOTAZ_PREDSTAVENI);
                //  JTableUtilities.setColumnWidths(jTablePredstaveniDatafromDTB, 95, 150, 50);
                break;

            default:
                break;
        }

    }//GEN-LAST:event_jButtonPredstaveniAktualizujVDTBActionPerformed
    private ArrayList<Integer> getDistinctIndicesOfEditedRows(ArrayList<Integer> edited_rows, JTable table) {
        edited_rows = ((PridavaniDatTableModel) table.getModel()).getIndicesOfEditedRows();
        ArrayList<Integer> distinctIndices = new ArrayList<Integer>(new HashSet<>(edited_rows));
        return distinctIndices;
    }

    private void jButtonPredstaveniPridatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniPridatDataActionPerformed
        edited_rows_predstaveni_tab = getDistinctIndicesOfEditedRows(edited_rows_predstaveni_tab, jTablePredstaveniPridaniDat);
        for (int i = 0; i < edited_rows_predstaveni_tab.size(); i++) {
            String querry_insert = client.insertNewRowIntoDTB_Predstaveni(jTablePredstaveniPridaniDat.getModel().getValueAt(edited_rows_predstaveni_tab.get(i), 1).toString(), jTablePredstaveniPridaniDat.getModel().getValueAt(edited_rows_predstaveni_tab.get(i), 2).toString());
            
            //PrepareStatement.executeInsertNewItemIntoPredstaveniTable(jTablePredstaveniPridaniDat.getModel().getValueAt(edited_rows_predstaveni_tab.get(i), 1).toString(), jTablePredstaveniPridaniDat.getModel().getValueAt(edited_rows_predstaveni_tab.get(i), 2).toString());

            HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTablePredstaveniDatafromDTB, SQLDOTAZ_PREDSTAVENI);
            }
        jTablePredstaveniPridaniDat.setModel(new PridavaniDatTableModel(SQLDOTAZ_PREDSTAVENI));
        HelperMethods.setTableCellsAndHeaderCenterHorizontalAlignment(jTablePredstaveniPridaniDat);

    }//GEN-LAST:event_jButtonPredstaveniPridatDataActionPerformed


    private void jButtonPredstaveniVyhledavaniidPredstaveniJeRovnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniidPredstaveniJeRovnoActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], "=", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        
        //      PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], "=", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());

        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        //  jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqlidPredstaveni_equals, 1));
        //  JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniidPredstaveniJeRovnoActionPerformed

    private void jButtonPredstaveniVyhledavaniDatumJeRovnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniDatumJeRovnoActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], "=", jTextFieldPredstaveniVyhledavaniDatum.getText());
        
        //    PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], "=", jTextFieldPredstaveniVyhledavaniDatum.getText());
        //  String sqldate_equals = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], "=", jTextFieldPredstaveniVyhledavaniDatum.getText());

         System.out.println(querry);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        //  jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqldate_equals, 1));
        //  JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniDatumJeRovnoActionPerformed

    private void jButtonPredstaveniVyhledavaniDatumJeVetsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniDatumJeVetsiActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], ">", jTextFieldPredstaveniVyhledavaniDatum.getText());
        // PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], ">", jTextFieldPredstaveniVyhledavaniDatum.getText());
        //  String sqldate_more = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], ">", jTextFieldPredstaveniVyhledavaniDatum.getText());
        System.out.println(querry);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        //  jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqldate_more, 1));
        // JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniDatumJeVetsiActionPerformed

    private void jButtonPredstaveniVyhledavaniDatumJeMensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniDatumJeMensiActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], "<", jTextFieldPredstaveniVyhledavaniDatum.getText());
        
        //   PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], "<", jTextFieldPredstaveniVyhledavaniDatum.getText());
        //   String sqldate_less = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[1], "<", jTextFieldPredstaveniVyhledavaniDatum.getText());
         System.out.println(querry);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        //  jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqldate_less, 1));
        //  JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniDatumJeMensiActionPerformed

    private void jButtonPredstaveniVyhledavaniidPredstaveniJeVetsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniidPredstaveniJeVetsiActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], ">", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        
        //  PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], ">", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        // String sqlidPredstaveni_more = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], ">", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        // System.out.println(sqlidPredstaveni_more);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        // jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqlidPredstaveni_more, 1));
        // JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniidPredstaveniJeVetsiActionPerformed

    private void jButtonPredstaveniVyhledavaniidPredstaveniJeMensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniidPredstaveniJeMensiActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], "<", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        
        //  PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], "<", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        //  String sqlidPredstaveni_less = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[0], "<", jSpinnerPredstaveniVyhledavaniidPredstaveni.getValue());
        //  System.out.println(sqlidPredstaveni_less);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        //  jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqlidPredstaveni_less, 1));
        //  JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniidPredstaveniJeMensiActionPerformed

    private void jButtonPredstaveniVyhledavaniidFilmuJeVetsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniidFilmuJeVetsiActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], ">", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //    PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], ">", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //  String sqlidFilm_more = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], ">", jSpinnerPredstaveniVyhledavaniidFilm.getValue());

        // System.out.println(sqlidFilm_more);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        // jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqlidFilm_more, 1));
        // JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniidFilmuJeVetsiActionPerformed

    private void jButtonPredstaveniVyhledavaniidFilmuJeRovnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniidFilmuJeRovnoActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], "=", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //   PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], "=", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //  String sqlidFilm_equals = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], "=", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //  System.out.println(sqlidFilm_equals);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        // jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqlidFilm_equals, 1));
        //  JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniidFilmuJeRovnoActionPerformed

    private void jButtonPredstaveniVyhledavaniidFilmJeMensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniidFilmJeMensiActionPerformed
        performed_querry_predstaveni_vyhledavani = null;
        String querry = client.searchBasedOnQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], "<", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        
        //  PrepareStatement.executeSearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], "<", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //   String sqlidFilm_less = PrepareStatement.SearchDataFullfilingQuantitativeRelation(namesofcolumns_predstavenitable, namesofDTBtables[0], namesofcolumns_predstavenitable[2], "<", jSpinnerPredstaveniVyhledavaniidFilm.getValue());
        //  System.out.println(sqlidFilm_less);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, querry);
        // jTablePredstaveniVysledkyVyhledavani.setModel(new VyhledavaniDatTableModel(sqlidFilm_less, 1));
        // JTableUtilities.setCellsAlignment(jTablePredstaveniVysledkyVyhledavani, SwingConstants.CENTER);
        performed_querry_predstaveni_vyhledavani = querry;
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniidFilmJeMensiActionPerformed

    private void jButtonPredstaveniVyhledavavniOdstranitVysledkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavavniOdstranitVysledkyActionPerformed
        HelperMethods.clearTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, SQLDOTAZ_PREDSTAVENI);
    }//GEN-LAST:event_jButtonPredstaveniVyhledavavniOdstranitVysledkyActionPerformed


    private void jButtonPredstaveniVyhledavaniVymazatVybraneVysledkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniVyhledavaniVymazatVybraneVysledkyActionPerformed
        int[] row = jTablePredstaveniVysledkyVyhledavani.getSelectedRows();
        String querry = null;
        for (int i = 0; i < row.length; i++) {
            try {
                querry = PrepareStatement.executeDeleteSelectedRows(namesofDTBtables[0], namesofcolumns_predstavenitable[0], jTablePredstaveniVysledkyVyhledavani.getModel().getValueAt(i, 0));
                // String sqldotaz_delete = PrepareStatement.DeleteSelectedRows(namesofDTBtables[0], namesofcolumns_predstavenitable[0], jTablePredstaveniVysledkyVyhledavani.getModel().getValueAt(i, 0));
                //   String sqldotaz_delete = "DELETE FROM predstaveni WHERE idPredstaveni=" + jTablePredstaveniVysledkyVyhledavani.getModel().getValueAt(i, 0) + ";";
                // System.out.println(sqldotaz_delete);
                // executeStatement(sqldotaz_delete);
            } catch (SQLException ex) {
                Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniVysledkyVyhledavani, performed_querry_predstaveni_vyhledavani);
        HelperMethods.updateTableWithVyhledavaniDatTableModel(jTablePredstaveniDatafromDTB, SQLDOTAZ_PREDSTAVENI);
        //.setColumnWidths(jTablePredstaveniDatafromDTB, 95, 150, 50);
    }//GEN-LAST:event_jButtonPredstaveniVyhledavaniVymazatVybraneVysledkyActionPerformed

    private void jButtonPredstaveniUpravitPopisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniUpravitPopisActionPerformed
        if (jTablePredstaveniZobrazenivybranychDat.getSelectedColumn() == jTablePredstaveniZobrazenivybranychDat.getColumnCount() - 1) {
            predstaveni_popis_filmu_selectedrow_index = jTablePredstaveniZobrazenivybranychDat.getSelectedRow();
            predstaveni_popis_filmu_selectedcolumn_index = jTablePredstaveniZobrazenivybranychDat.getSelectedColumn();
            jTextAreaPredstaveniUpravaPopisuFilmu.setText(jTablePredstaveniZobrazenivybranychDat.getValueAt(jTablePredstaveniZobrazenivybranychDat.getSelectedRow(),
                    jTablePredstaveniZobrazenivybranychDat.getSelectedColumn()).toString());
        }
    }//GEN-LAST:event_jButtonPredstaveniUpravitPopisActionPerformed

    private void jButtonPredstaveniPopisFilmuDoTabulkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniPopisFilmuDoTabulkyActionPerformed
        jTablePredstaveniZobrazenivybranychDat.setValueAt(jTextAreaPredstaveniUpravaPopisuFilmu.getText(), predstaveni_popis_filmu_selectedrow_index,
                predstaveni_popis_filmu_selectedcolumn_index);
        jTablePredstaveniZobrazenivybranychDat.repaint(50);
        //System.out.println(jTextAreaPredstaveniUpravaPopisuFilmu.getText());
        //System.out.println(predstaveni_popis_filmu_selectedrow_index);
        // System.out.println(predstaveni_popis_filmu_selectedcolumn_index);
    }//GEN-LAST:event_jButtonPredstaveniPopisFilmuDoTabulkyActionPerformed

    private void jButtonPredstaveniUpravenyPopisAktualizovatVDTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPredstaveniUpravenyPopisAktualizovatVDTBActionPerformed
        String columnname = jTablePredstaveniZobrazenivybranychDat.getColumnName(predstaveni_popis_filmu_selectedcolumn_index);
        String querry = null;
        try {
            querry = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], columnname,
                    jTextAreaPredstaveniUpravaPopisuFilmu.getText(), namesofcolumns_filmtable[0],
                    jTablePredstaveniZobrazenivybranychDat.getValueAt(predstaveni_popis_filmu_selectedrow_index, 0));
            /*  String sql_dotaz_test = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], columnname,
            jTextAreaPredstaveniUpravaPopisuFilmu.getText(), namesofcolumns_filmtable[0],
            jTablePredstaveniZobrazenivybranychDat.getValueAt(predstaveni_popis_filmu_selectedrow_index, 0));*/
        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // executeStatement(sql_dotaz_test);
        jTablePredstaveniZobrazenivybranychDat.setModel(new UpravaDatTableModel(performed_querry_predstaveni_film_by_date, 1));
        JTableUtilities.setCellsAlignment(jTablePredstaveniZobrazenivybranychDat, SwingConstants.CENTER);
        HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTablePredstaveniDatafromDTB, SQLDOTAZ_PREDSTAVENI);
    }//GEN-LAST:event_jButtonPredstaveniUpravenyPopisAktualizovatVDTBActionPerformed

    private void jButtonFilmVyberDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyberDataActionPerformed
        int row = jTableFilmDataFromDTB.getSelectedRow();
        int column = jTableFilmDataFromDTB.getSelectedColumn();
        switch (column) {

            case 0:
                switch_casenumber_film = 0;
                String querry0 = null;
                try {
                    querry0 = PrepareStatement.executeSelectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[0], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                    performed_querry_film__by_value = querry0;
//  String sql0_dotaz = PrepareStatement.selectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[0], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                } catch (SQLException ex) {
                    Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                }

                jTableFilmZobrazeniVybranychDat.setModel(new UpravaDatTableModel(querry0, 1) {
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }
                }
                );
                JTableUtilities.setCellsAlignment(jTableFilmZobrazeniVybranychDat, SwingConstants.CENTER);
                jLabelFilmPopisAktualizace.setText("V této tabulce můžete upravit všechny údaje o filmu kromě jeho id.");
                break;

            case 1:
                switch_casenumber_film = 1;
                String querry1 = null;
                try {
                    querry1 = PrepareStatement.executeSelectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[1], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                    performed_querry_film__by_value = querry1;
//  String sql1_dotaz = PrepareStatement.selectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[1], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                } catch (SQLException ex) {
                    Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                }

                jTableFilmZobrazeniVybranychDat.setModel(new UpravaDatTableModel(querry1, 1) {
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }
                }
                );
                JTableUtilities.setCellsAlignment(jTableFilmZobrazeniVybranychDat, SwingConstants.CENTER);
                jLabelFilmPopisAktualizace.setText("V této tabulce můžete upravit všechny údaje o filmu kromě jeho id.");
                break;

            case 2:
                switch_casenumber_film = 2;
                String querry2 = null;
                try {
                    querry2 = PrepareStatement.executeSelectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[2], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                    performed_querry_film__by_value = querry2;
                } catch (SQLException ex) {
                    Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                }

                //  String sql2_dotaz = PrepareStatement.selectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[2], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                jTableFilmZobrazeniVybranychDat.setModel(new UpravaDatTableModel(querry2, 1) {
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }
                }
                );
                JTableUtilities.setCellsAlignment(jTableFilmZobrazeniVybranychDat, SwingConstants.CENTER);
                jLabelFilmPopisAktualizace.setText("V této tabulce můžete upravit všechny údaje o filmu kromě jeho id.");
                break;

            case 3:
                switch_casenumber_film = 3;
                String querry3 = null;

                try {
                    querry3 = PrepareStatement.executeSelectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[3], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                    performed_querry_film__by_value = querry3;
//   String sql3_dotaz = PrepareStatement.selectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[3], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                } catch (SQLException ex) {
                    Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                }

                jTableFilmZobrazeniVybranychDat.setModel(new UpravaDatTableModel(querry3, 1) {
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }
                }
                );
                JTableUtilities.setCellsAlignment(jTableFilmZobrazeniVybranychDat, SwingConstants.CENTER);
                jLabelFilmPopisAktualizace.setText("V této tabulce můžete upravit všechny údaje o filmu kromě jeho id.");
                break;

            case 4:
                switch_casenumber_film = 4;
                String querry4 = null;
                try {
                    querry4 = PrepareStatement.executeSelectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[4], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                    performed_querry_film__by_value = querry4;
                    //     String sql4_dotaz = PrepareStatement.selectDatabySelectedValue(namesofcolumns_filmtable, namesofDTBtables[1], namesofcolumns_filmtable[4], jTableFilmDataFromDTB.getModel().getValueAt(row, column));
                } catch (SQLException ex) {
                    Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                }

                jTableFilmZobrazeniVybranychDat.setModel(new UpravaDatTableModel(querry4, 1) {
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }
                }
                );
                JTableUtilities.setCellsAlignment(jTableFilmZobrazeniVybranychDat, SwingConstants.CENTER);
                jLabelFilmPopisAktualizace.setText("V této tabulce můžete upravit všechny údaje o filmu kromě jeho id.");
                break;

            default:
                break;

        }
    }//GEN-LAST:event_jButtonFilmVyberDataActionPerformed

    private void jButtonFilmAktualizujVDTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmAktualizujVDTBActionPerformed
        edited_fields_film_tab = ((UpravaDatTableModel) jTableFilmZobrazeniVybranychDat.getModel()).getIndicesOfEditedFields();

        switch (switch_casenumber_film) {

            case 0:
                String querry0 = null;
                for (int i = 0; i < edited_fields_film_tab.size(); i++) {
                    try {
                        querry0 = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[edited_fields_film_tab.get(i).get(1)],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                                        edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                        /*  String sql_dotaz = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[1],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                
                executeStatement(sql_dotaz);*/
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
                break;
            case 1:
                String querry1 = null;
                for (int i = 0; i < edited_fields_film_tab.size(); i++) {
                    try {
                        querry1 = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[edited_fields_film_tab.get(i).get(1)],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                                        edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                        /*  String sql_dotaz = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[1],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                
                executeStatement(sql_dotaz);*/
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
                break;
            case 2:
                String querry2 = null;
                for (int i = 0; i < edited_fields_film_tab.size(); i++) {
                    try {
                        querry2 = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[edited_fields_film_tab.get(i).get(1)],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                                        edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                        /*  String sql_dotaz = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[1],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                
                executeStatement(sql_dotaz);*/
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
                break;
            case 3:
                String querry3 = null;
                for (int i = 0; i < edited_fields_film_tab.size(); i++) {
                    try {
                        querry3 = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[edited_fields_film_tab.get(i).get(1)],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                                        edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                        /*  String sql_dotaz = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[1],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                
                executeStatement(sql_dotaz);*/
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
                break;
            case 4:
                String querry4 = null;
                for (int i = 0; i < edited_fields_film_tab.size(); i++) {
                    try {
                        querry4 = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[edited_fields_film_tab.get(i).get(1)],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                                        edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                        /*  String sql_dotaz = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], namesofcolumns_filmtable[1],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0),
                edited_fields_film_tab.get(i).get(1)), namesofcolumns_filmtable[0],
                jTableFilmZobrazeniVybranychDat.getModel().getValueAt(edited_fields_film_tab.get(i).get(0), 0));
                
                executeStatement(sql_dotaz);*/
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonFilmAktualizujVDTBActionPerformed

    private void jButtonFilmPopisUlozitDoTabulkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmPopisUlozitDoTabulkyActionPerformed
        jTableFilmZobrazeniVybranychDat.setValueAt(jTextAreaFilmUpravaPopisu.getText(), film_popis_filmu_selectedrow_index,
                film_popis_filmu_selectedcolumn_index);
        jTableFilmZobrazeniVybranychDat.repaint(50);
        jTextAreaFilmUpravaPopisu.setText(null);
    }//GEN-LAST:event_jButtonFilmPopisUlozitDoTabulkyActionPerformed

    private void jButtonFilmUpravitPopisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmUpravitPopisActionPerformed
        film_popis_filmu_selectedrow_index = jTableFilmZobrazeniVybranychDat.getSelectedRow();
        film_popis_filmu_selectedcolumn_index = jTableFilmZobrazeniVybranychDat.getSelectedColumn();
        jTextAreaFilmUpravaPopisu.setText(jTableFilmZobrazeniVybranychDat.getValueAt(jTableFilmZobrazeniVybranychDat.getSelectedRow(),
                jTableFilmZobrazeniVybranychDat.getSelectedColumn()).toString());
    }//GEN-LAST:event_jButtonFilmUpravitPopisActionPerformed

    private void jButtonFilmAktualizovatPopisVDTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmAktualizovatPopisVDTBActionPerformed
        String columnname = jTableFilmZobrazeniVybranychDat.getColumnName(film_popis_filmu_selectedcolumn_index);
        String querry = null;
        try {
            querry = PrepareStatement.executeUpdateEditedValueInDTB(namesofDTBtables[1], columnname,
                    jTextAreaFilmUpravaPopisu.getText(), namesofcolumns_filmtable[0],
                    jTableFilmZobrazeniVybranychDat.getValueAt(film_popis_filmu_selectedrow_index, 0));
            /*  String sql_dotaz_test = PrepareStatement.updateEditedValueInDTB(namesofDTBtables[1], columnname,
            jTextAreaPredstaveniUpravaPopisuFilmu.getText(), namesofcolumns_filmtable[0],
            jTablePredstaveniZobrazenivybranychDat.getValueAt(predstaveni_popis_filmu_selectedrow_index, 0));*/
        } catch (SQLException ex) {
            Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // executeStatement(sql_dotaz_test);
        jTableFilmZobrazeniVybranychDat.setModel(new UpravaDatTableModel(performed_querry_film__by_value, 1));
        //   JTableUtilities.setCellsAlignment(jTableFilmZobrazeniVybranychDat, SwingConstants.CENTER);
        HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
        jTextAreaFilmUpravaPopisu.setText(null);
    }//GEN-LAST:event_jButtonFilmAktualizovatPopisVDTBActionPerformed

    private void jButtonFilmiPridatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmiPridatDataActionPerformed
        edited_rows_film_tab = getDistinctIndicesOfEditedRows(edited_rows_film_tab, jTableFilmPridaniDat);

        for (int i = 0; i < edited_rows_film_tab.size(); i++) {
            try {
                String querry_insert = PrepareStatement.executeInsertNewItemIntoFilmTable(jTableFilmPridaniDat.getModel().getValueAt(edited_rows_film_tab.get(i), 1).toString(), jTableFilmPridaniDat.getModel().getValueAt(edited_rows_film_tab.get(i), 2).toString(),
                        jTableFilmPridaniDat.getModel().getValueAt(edited_rows_film_tab.get(i), 3).toString(), jTableFilmPridaniDat.getModel().getValueAt(edited_rows_film_tab.get(i), 4).toString());

            } catch (SQLException ex) {
                Logger.getLogger(JFrameJedenSvet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //  HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);         
        }
        HelperMethods.updateDisplayedDataInTableWithZobrazeniDatTableModel(jTableFilmDataFromDTB, SQLDOTAZ_FILM);
        jTableFilmPridaniDat.setModel(new PridavaniDatTableModel(SQLDOTAZ_FILM));
    }//GEN-LAST:event_jButtonFilmiPridatDataActionPerformed

    private void jButtonFilmVyhledavaniidFilmJeVetsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniidFilmJeVetsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniidFilmJeVetsiActionPerformed

    private void jButtonFilmVyhledavaniidFilmJeRovnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniidFilmJeRovnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniidFilmJeRovnoActionPerformed

    private void jButtonFilmVyhledavaniidFilmJeMensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniidFilmJeMensiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniidFilmJeMensiActionPerformed

    private void jButtonFilmVyhledavaniRokJeVetsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniRokJeVetsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniRokJeVetsiActionPerformed

    private void jButtonFilmVyhledavaniRokJeRovenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniRokJeRovenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniRokJeRovenActionPerformed

    private void jButtonFilmVyhledavaniRokJeMensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniRokJeMensiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniRokJeMensiActionPerformed

    private void jButtonFilmVyhledavaniJmenoFZacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniJmenoFZacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniJmenoFZacinaActionPerformed

    private void jButtonFilmVyhledavaniJmenoFobsahujeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniJmenoFobsahujeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniJmenoFobsahujeActionPerformed

    private void jButtonFilmVyhledavaniJmenoFkoncinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniJmenoFkoncinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniJmenoFkoncinaActionPerformed

    private void jButtonFilmVyhledavaniJmenoFjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniJmenoFjeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniJmenoFjeActionPerformed

    private void jButtonFilmVyhledavaniReziserZacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniReziserZacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniReziserZacinaActionPerformed

    private void jButtonFilmVyhledavaniReziserJeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniReziserJeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniReziserJeActionPerformed

    private void jButtonFilmVyhledavaniReziserObsahujeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniReziserObsahujeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniReziserObsahujeActionPerformed

    private void jButtonFilmVyhledavaniReziserKonciNaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniReziserKonciNaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniReziserKonciNaActionPerformed

    private void jButtonFilmVyhledavaniPopisZacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniPopisZacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniPopisZacinaActionPerformed

    private void jButtonFilmVyhledavaniPopisJeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniPopisJeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniPopisJeActionPerformed

    private void jButtonFilmVyhledavaniPopisObsahujeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniPopisObsahujeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniPopisObsahujeActionPerformed

    private void jButtonFilmVyhledavaniPopisKonciNaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavaniPopisKonciNaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavaniPopisKonciNaActionPerformed

    private void jButtonFilmVyhledavavniOdstranitVysledkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmVyhledavavniOdstranitVysledkyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmVyhledavavniOdstranitVysledkyActionPerformed

    private void jButtonFilmiVyhledavaniVymazatVybraneVysledkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmiVyhledavaniVymazatVybraneVysledkyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFilmiVyhledavaniVymazatVybraneVysledkyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameJedenSvet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameJedenSvet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameJedenSvet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameJedenSvet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrameJedenSvet jf = new JFrameJedenSvet();
                jf.pack();
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFilmAktualizovatPopisVDTB;
    private javax.swing.JButton jButtonFilmAktualizujVDTB;
    private javax.swing.JButton jButtonFilmPopisUlozitDoTabulky;
    private javax.swing.JButton jButtonFilmUpravitPopis;
    private javax.swing.JButton jButtonFilmVyberData;
    private javax.swing.JButton jButtonFilmVyhledavaniJmenoFZacina;
    private javax.swing.JButton jButtonFilmVyhledavaniJmenoFje;
    private javax.swing.JButton jButtonFilmVyhledavaniJmenoFkoncina;
    private javax.swing.JButton jButtonFilmVyhledavaniJmenoFobsahuje;
    private javax.swing.JButton jButtonFilmVyhledavaniPopisJe;
    private javax.swing.JButton jButtonFilmVyhledavaniPopisKonciNa;
    private javax.swing.JButton jButtonFilmVyhledavaniPopisObsahuje;
    private javax.swing.JButton jButtonFilmVyhledavaniPopisZacina;
    private javax.swing.JButton jButtonFilmVyhledavaniReziserJe;
    private javax.swing.JButton jButtonFilmVyhledavaniReziserKonciNa;
    private javax.swing.JButton jButtonFilmVyhledavaniReziserObsahuje;
    private javax.swing.JButton jButtonFilmVyhledavaniReziserZacina;
    private javax.swing.JButton jButtonFilmVyhledavaniRokJeMensi;
    private javax.swing.JButton jButtonFilmVyhledavaniRokJeRoven;
    private javax.swing.JButton jButtonFilmVyhledavaniRokJeVetsi;
    private javax.swing.JButton jButtonFilmVyhledavaniidFilmJeMensi;
    private javax.swing.JButton jButtonFilmVyhledavaniidFilmJeRovno;
    private javax.swing.JButton jButtonFilmVyhledavaniidFilmJeVetsi;
    private javax.swing.JButton jButtonFilmVyhledavavniOdstranitVysledky;
    private javax.swing.JButton jButtonFilmiPridatData;
    private javax.swing.JButton jButtonFilmiVyhledavaniVymazatVybraneVysledky;
    private javax.swing.JButton jButtonPredstaveniAktualizujVDTB;
    private javax.swing.JButton jButtonPredstaveniPopisFilmuDoTabulky;
    private javax.swing.JButton jButtonPredstaveniPridatData;
    private javax.swing.JButton jButtonPredstaveniUpravenyPopisAktualizovatVDTB;
    private javax.swing.JButton jButtonPredstaveniUpravitPopis;
    private javax.swing.JButton jButtonPredstaveniVyberData;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniDatumJeMensi;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniDatumJeRovno;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniDatumJeVetsi;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniVymazatVybraneVysledky;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniidFilmJeMensi;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniidFilmuJeRovno;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniidFilmuJeVetsi;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniidPredstaveniJeMensi;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniidPredstaveniJeRovno;
    private javax.swing.JButton jButtonPredstaveniVyhledavaniidPredstaveniJeVetsi;
    private javax.swing.JButton jButtonPredstaveniVyhledavavniOdstranitVysledky;
    private javax.swing.JLabel jLabelFilmDatavDTB;
    private javax.swing.JLabel jLabelFilmPopisAktualizace;
    private javax.swing.JLabel jLabelFilmUpravaPopisu;
    private javax.swing.JLabel jLabelFilmVyhledaniPodleJmenoF;
    private javax.swing.JLabel jLabelFilmVyhledaniPodlePopis;
    private javax.swing.JLabel jLabelFilmVyhledaniPodleReziser;
    private javax.swing.JLabel jLabelFilmVyhledaniPodleRok;
    private javax.swing.JLabel jLabelFilmVyhledaniPodleidFilm;
    private javax.swing.JLabel jLabelFilmVyhledavaniPopisVolby;
    private javax.swing.JLabel jLabelFilmVyhledavaniVysledky;
    private javax.swing.JLabel jLabelFilmiPridaniDat;
    private javax.swing.JLabel jLabelPredstaveniDatavDTB;
    private javax.swing.JLabel jLabelPredstaveniPopisAktualizace;
    private javax.swing.JLabel jLabelPredstaveniPridaniDat;
    private javax.swing.JLabel jLabelPredstaveniUparavaPopisFilmu;
    private javax.swing.JLabel jLabelPredstaveniVyhledaniPodleidPredstaveni;
    private javax.swing.JLabel jLabelPredstaveniVyhledavaniPopisVolby;
    private javax.swing.JLabel jLabelPredstaveniVyhledavaniVysledky;
    private javax.swing.JLabel jLabelPredstaveniVyhledavaniidFilmu;
    private javax.swing.JLabel jLabelPredstaverniVyhledavaniDatum;
    private javax.swing.JPanel jPanelFilmHlavni;
    private javax.swing.JPanel jPanelFilmPridavaniDat;
    private javax.swing.JPanel jPanelFilmUpravaDat;
    private javax.swing.JPanel jPanelFilmVyhledavaniDat;
    private javax.swing.JPanel jPanelKinoHlavni;
    private javax.swing.JPanel jPanelPredstaveniHlavni;
    private javax.swing.JPanel jPanelPredstaveniPridavaniDat;
    private javax.swing.JPanel jPanelPredstaveniUpravaDat;
    private javax.swing.JPanel jPanelPredstaveniVyhledavaniDat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinnerFilmVyhledavaniRok;
    private javax.swing.JSpinner jSpinnerFilmVyhledavaniidFilm;
    private javax.swing.JSpinner jSpinnerPredstaveniVyhledavaniidFilm;
    private javax.swing.JSpinner jSpinnerPredstaveniVyhledavaniidPredstaveni;
    private javax.swing.JTabbedPane jTabbedPaneFilmVnoreny;
    private javax.swing.JTabbedPane jTabbedPanePredstaveniVnoreny;
    private javax.swing.JTabbedPane jTabbedPaneSpolecny;
    private javax.swing.JTable jTableFilmDataFromDTB;
    private javax.swing.JTable jTableFilmPridaniDat;
    private javax.swing.JTable jTableFilmVysledkyVyhledavani;
    private javax.swing.JTable jTableFilmZobrazeniVybranychDat;
    private javax.swing.JTable jTablePredstaveniDatafromDTB;
    private javax.swing.JTable jTablePredstaveniPridaniDat;
    private javax.swing.JTable jTablePredstaveniVysledkyVyhledavani;
    private javax.swing.JTable jTablePredstaveniZobrazenivybranychDat;
    private javax.swing.JTextArea jTextAreaFilmUpravaPopisu;
    private javax.swing.JTextArea jTextAreaFilmVyhledavaniNazev;
    private javax.swing.JTextArea jTextAreaFilmVyhledavaniPopis;
    private javax.swing.JTextArea jTextAreaFilmVyhledavaniReziser;
    private javax.swing.JTextArea jTextAreaPredstaveniUpravaPopisuFilmu;
    private javax.swing.JTextField jTextFieldPredstaveniVyhledavaniDatum;
    // End of variables declaration//GEN-END:variables
}
