package spdvi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.azure.core.util.Context;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.models.BlobRange;
import com.azure.storage.blob.models.DownloadRetryOptions;
import com.azure.storage.blob.specialized.BlockBlobClient;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import spdvi.dialogs.Login;
import spdvi.dialogs.Visualitzar;
import spdvi.pojos.Espai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import spdvi.dialogs.Profile;
import spdvi.helpers.ArgumentNullException;
import spdvi.helpers.DataAccess;
import spdvi.helpers.ImageHelper;
import spdvi.pojos.Imatge;
import spdvi.pojos.User;

/**
 *
 * @author angel
 */
public class MainForm extends javax.swing.JFrame implements Runnable{
    private JList<Espai> lstEspais;
    private ArrayList<JCheckBox> chkListModalitats;
    private ArrayList<JCheckBox> chkListModalitatsModify;
    private ArrayList<JCheckBox> chkListServeis;
    private ArrayList<JCheckBox> chkListServeisModify;
    private Thread downloadThread;
    private ArrayList<String> images = new ArrayList<>();
    private DefaultListModel imageListModel = new DefaultListModel();
    private ArrayList<String> oldImagesModify = new ArrayList<>();
    private ArrayList<String> imagesModify = new ArrayList<>();
    private DefaultListModel imageListModelModify = new DefaultListModel();
    private boolean inserted = false;
    private boolean modified = false;
    private User currentUser;
    private boolean threadFromInsert = false;
    private boolean threadFromRead = false;
    private boolean threadFromModify = false;
    private ArrayList<String> deletedImages = new ArrayList<>();
    private Espai espaiToModify;
           
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        lstEspais = new JList<Espai>();
        scrEspais.setViewportView(lstEspais);
        
        chkListModalitats = new ArrayList<>();
        chkListModalitats.add(chkEscultura);
        chkListModalitats.add(chkFotografia);
        chkListModalitats.add(chkPintura);
        chkListModalitats.add(chkVidre);
        chkListModalitats.add(chkVideo);
        
        chkListModalitatsModify = new ArrayList<>();
        chkListModalitatsModify.add(chkEsculturaModify);
        chkListModalitatsModify.add(chkFotografiaModify);
        chkListModalitatsModify.add(chkFotografiaModify);
        chkListModalitatsModify.add(chkPinturaModify);
        chkListModalitatsModify.add(chkVidreModify);
        chkListModalitatsModify.add(chkVideoModify);
        
        chkListServeis = new ArrayList<>();
        chkListServeis.add(chkAcces);
        chkListServeis.add(chkAparcament);
        chkListServeis.add(chkArxiu);
        chkListServeis.add(chkBiblioteca);
        chkListServeis.add(chkCafeteria);
        chkListServeis.add(chkConcerts);
        chkListServeis.add(chkConferencies);
        chkListServeis.add(chkTallers);
        chkListServeis.add(chkVisites);
        chkListServeis.add(chkJardins);
        chkListServeis.add(chkWifi);
        
        chkListServeisModify = new ArrayList<>();
        chkListServeisModify.add(chkAccesModify);
        chkListServeisModify.add(chkAparcamentModify);
        chkListServeisModify.add(chkArxiuModify);
        chkListServeisModify.add(chkBibliotecaModify);
        chkListServeisModify.add(chkCafeteriaModify);
        chkListServeisModify.add(chkConcertsModify);
        chkListServeisModify.add(chkConferenciesModify);
        chkListServeisModify.add(chkTallersModify);
        chkListServeisModify.add(chkVisitesModify);
        chkListServeisModify.add(chkJardinsModify);
        chkListServeisModify.add(chkWifiModify);
        
        lstEspais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEspaisMouseClicked(evt);
            }
        });
        lstEspais.addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            public void valueChanged(javax.swing.event.ListSelectionEvent evt){
                lstEspaisValueChanged(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        tabCRUD = new javax.swing.JTabbedPane();
        pnlRead = new javax.swing.JPanel();
        scrEspais = new javax.swing.JScrollPane();
        btnRead = new javax.swing.JButton();
        btnVisualitzar = new javax.swing.JButton();
        btnCercar = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        lblRegistre = new javax.swing.JLabel();
        lblComentaris = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        prgImatgeRead = new javax.swing.JProgressBar();
        btnModifyInsert = new javax.swing.JButton();
        btnReadHidden = new javax.swing.JButton();
        txtCercar = new javax.swing.JTextField();
        lblCercar = new javax.swing.JLabel();
        txtCercarMunicipi = new javax.swing.JTextField();
        lblCercar1 = new javax.swing.JLabel();
        btnCercarMunicipi = new javax.swing.JButton();
        pnlInsert = new javax.swing.JPanel();
        lblNomEspai = new javax.swing.JLabel();
        txtNomEspai = new javax.swing.JTextField();
        lblRegistreEspai = new javax.swing.JLabel();
        txtRegistreEspai = new javax.swing.JTextField();
        lblDescripcions = new javax.swing.JLabel();
        cmbDesc = new javax.swing.JComboBox<>();
        layeredDesc = new javax.swing.JLayeredPane();
        pnlCat = new javax.swing.JPanel();
        scrCat = new javax.swing.JScrollPane();
        txaCat = new javax.swing.JTextArea();
        pnlCast = new javax.swing.JPanel();
        scrCast = new javax.swing.JScrollPane();
        txaCast = new javax.swing.JTextArea();
        pnlEng = new javax.swing.JPanel();
        scrEng = new javax.swing.JScrollPane();
        txaEng = new javax.swing.JTextArea();
        lblMunicipi = new javax.swing.JLabel();
        txtMunicipi = new javax.swing.JTextField();
        lblAdreca = new javax.swing.JLabel();
        txtAdreca = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblWeb = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        lblTelefon = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        lblTipus = new javax.swing.JLabel();
        cmbTipus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        chkSelectAllMod = new javax.swing.JCheckBox();
        pnlModalitats = new javax.swing.JPanel();
        chkPintura = new javax.swing.JCheckBox();
        chkEscultura = new javax.swing.JCheckBox();
        chkFotografia = new javax.swing.JCheckBox();
        chkVidre = new javax.swing.JCheckBox();
        chkVideo = new javax.swing.JCheckBox();
        lblGestor = new javax.swing.JLabel();
        txtGestor = new javax.swing.JTextField();
        pnlServeis = new javax.swing.JPanel();
        chkAcces = new javax.swing.JCheckBox();
        chkCafeteria = new javax.swing.JCheckBox();
        chkBiblioteca = new javax.swing.JCheckBox();
        chkAparcament = new javax.swing.JCheckBox();
        chkTallers = new javax.swing.JCheckBox();
        chkVisites = new javax.swing.JCheckBox();
        chkArxiu = new javax.swing.JCheckBox();
        chkConcerts = new javax.swing.JCheckBox();
        chkConferencies = new javax.swing.JCheckBox();
        chkWifi = new javax.swing.JCheckBox();
        chkSelectAllServ = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        chkJardins = new javax.swing.JCheckBox();
        btnInsert = new javax.swing.JButton();
        lblImageIcon = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        lblimages = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        scrImages = new javax.swing.JScrollPane();
        lstImages = new javax.swing.JList<>();
        prgImage = new javax.swing.JProgressBar();
        btnBorrar = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        pnlModify = new javax.swing.JPanel();
        txtRegistreModify = new javax.swing.JTextField();
        lblRegistreModify = new javax.swing.JLabel();
        btnConfirmModify = new javax.swing.JButton();
        pnlModifyVisible = new javax.swing.JPanel();
        lblNomModify = new javax.swing.JLabel();
        txtNomModify = new javax.swing.JTextField();
        lblModalitatsModify = new javax.swing.JLabel();
        chkSelectAllModModify = new javax.swing.JCheckBox();
        pnlModalitatsModify = new javax.swing.JPanel();
        chkPinturaModify = new javax.swing.JCheckBox();
        chkEsculturaModify = new javax.swing.JCheckBox();
        chkFotografiaModify = new javax.swing.JCheckBox();
        chkVidreModify = new javax.swing.JCheckBox();
        chkVideoModify = new javax.swing.JCheckBox();
        btnModify = new javax.swing.JButton();
        lblImageIconModify = new javax.swing.JLabel();
        btnUploadModify = new javax.swing.JButton();
        lblimagesModify = new javax.swing.JLabel();
        txtImageModify = new javax.swing.JTextField();
        scrImagesModify = new javax.swing.JScrollPane();
        lstImagesModify = new javax.swing.JList<>();
        lblGestorModify = new javax.swing.JLabel();
        lblMunicipiModify = new javax.swing.JLabel();
        txtGestorModify = new javax.swing.JTextField();
        prgImageModify = new javax.swing.JProgressBar();
        txtMunicipiModify = new javax.swing.JTextField();
        pnlServeisModify = new javax.swing.JPanel();
        chkAccesModify = new javax.swing.JCheckBox();
        chkCafeteriaModify = new javax.swing.JCheckBox();
        chkBibliotecaModify = new javax.swing.JCheckBox();
        chkAparcamentModify = new javax.swing.JCheckBox();
        chkTallersModify = new javax.swing.JCheckBox();
        chkVisitesModify = new javax.swing.JCheckBox();
        chkArxiuModify = new javax.swing.JCheckBox();
        chkConcertsModify = new javax.swing.JCheckBox();
        chkConferenciesModify = new javax.swing.JCheckBox();
        chkWifiModify = new javax.swing.JCheckBox();
        chkSelectAllServModify = new javax.swing.JCheckBox();
        chkJardinsModify = new javax.swing.JCheckBox();
        sprModify = new javax.swing.JSeparator();
        btnBorrarModify = new javax.swing.JButton();
        lblAdrecaModify = new javax.swing.JLabel();
        txtAdrecaModify = new javax.swing.JTextField();
        lblEmailModify = new javax.swing.JLabel();
        txtEmailModify = new javax.swing.JTextField();
        lblWebModify = new javax.swing.JLabel();
        txtWebModify = new javax.swing.JTextField();
        lblTelefonModify = new javax.swing.JLabel();
        lblDescripcionsModify = new javax.swing.JLabel();
        txtTelefonModify = new javax.swing.JTextField();
        cmbDescModify = new javax.swing.JComboBox<>();
        lblTipusModify = new javax.swing.JLabel();
        layeredDescModify = new javax.swing.JLayeredPane();
        pnlCatModify = new javax.swing.JPanel();
        scrCatModify = new javax.swing.JScrollPane();
        txaCatModify = new javax.swing.JTextArea();
        pnlEspModify = new javax.swing.JPanel();
        scrEspModify = new javax.swing.JScrollPane();
        txaEspModify = new javax.swing.JTextArea();
        pnlEngModify = new javax.swing.JPanel();
        scrEngModify = new javax.swing.JScrollPane();
        txaEngModify = new javax.swing.JTextArea();
        cmbTipusModify = new javax.swing.JComboBox<>();
        chkVisible = new javax.swing.JCheckBox();
        btnCancelModify = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlRead.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRead.setText("Read");
        btnRead.setMaximumSize(new java.awt.Dimension(105, 23));
        btnRead.setMinimumSize(new java.awt.Dimension(105, 23));
        btnRead.setPreferredSize(new java.awt.Dimension(105, 23));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnVisualitzar.setText("Visualitzar");
        btnVisualitzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualitzarActionPerformed(evt);
            }
        });

        btnCercar.setText("Cercar");
        btnCercar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercarActionPerformed(evt);
            }
        });

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblRegistre.setText("Registre");

        lblComentaris.setText("Comentaris: ");

        lblNom.setText("Nom");

        prgImatgeRead.setStringPainted(true);

        btnModifyInsert.setText("Modify");
        btnModifyInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyInsertActionPerformed(evt);
            }
        });

        btnReadHidden.setText("Read Hidden");
        btnReadHidden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadHiddenActionPerformed(evt);
            }
        });

        lblCercar.setText("Introdueix el registre de l'espai");

        txtCercarMunicipi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCercarMunicipiActionPerformed(evt);
            }
        });

        lblCercar1.setText("Introdueix el municipi de l'espai");

        btnCercarMunicipi.setText("Cercar");
        btnCercarMunicipi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercarMunicipiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReadLayout = new javax.swing.GroupLayout(pnlRead);
        pnlRead.setLayout(pnlReadLayout);
        pnlReadLayout.setHorizontalGroup(
            pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrEspais, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReadLayout.createSequentialGroup()
                        .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReadLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNom)
                                    .addComponent(lblRegistre)))
                            .addGroup(pnlReadLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblComentaris))
                            .addGroup(pnlReadLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnReadHidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnModifyInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReadLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlReadLayout.createSequentialGroup()
                                        .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCercar, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCercar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCercar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlReadLayout.createSequentialGroup()
                                        .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCercarMunicipi, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCercar1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCercarMunicipi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlReadLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReadLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(prgImatgeRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(pnlReadLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnVisualitzar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlReadLayout.setVerticalGroup(
            pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReadLayout.createSequentialGroup()
                        .addComponent(scrEspais)
                        .addContainerGap())
                    .addGroup(pnlReadLayout.createSequentialGroup()
                        .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModifyInsert))
                        .addGap(14, 14, 14)
                        .addComponent(btnReadHidden)
                        .addGap(18, 18, 18)
                        .addComponent(lblCercar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCercar)
                            .addComponent(txtCercar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblCercar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCercarMunicipi)
                            .addComponent(txtCercarMunicipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(btnVisualitzar)
                        .addGap(5, 5, 5)
                        .addComponent(lblRegistre)
                        .addGap(10, 10, 10)
                        .addComponent(lblNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prgImatgeRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblComentaris)
                        .addGap(28, 28, 28))))
        );

        tabCRUD.addTab("Read", pnlRead);

        pnlInsert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNomEspai.setText("Nom");

        lblRegistreEspai.setText("Registre");

        lblDescripcions.setText("Descripcions");

        cmbDesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Català", "Español", "English" }));
        cmbDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDescItemStateChanged(evt);
            }
        });
        cmbDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDescActionPerformed(evt);
            }
        });
        cmbDesc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbDescPropertyChange(evt);
            }
        });

        pnlCat.setMaximumSize(new java.awt.Dimension(186, 118));

        scrCat.setMaximumSize(new java.awt.Dimension(166, 96));

        txaCat.setColumns(20);
        txaCat.setLineWrap(true);
        txaCat.setRows(5);
        txaCat.setWrapStyleWord(true);
        txaCat.setMaximumSize(new java.awt.Dimension(164, 94));
        scrCat.setViewportView(txaCat);

        pnlCast.setMaximumSize(new java.awt.Dimension(186, 118));

        scrCast.setMaximumSize(new java.awt.Dimension(166, 96));

        txaCast.setColumns(20);
        txaCast.setLineWrap(true);
        txaCast.setRows(5);
        txaCast.setWrapStyleWord(true);
        txaCast.setMaximumSize(new java.awt.Dimension(164, 94));
        scrCast.setViewportView(txaCast);

        pnlEng.setMaximumSize(new java.awt.Dimension(186, 118));
        pnlEng.setPreferredSize(new java.awt.Dimension(186, 118));

        scrEng.setMaximumSize(new java.awt.Dimension(166, 96));

        txaEng.setColumns(20);
        txaEng.setLineWrap(true);
        txaEng.setRows(5);
        txaEng.setWrapStyleWord(true);
        txaEng.setMaximumSize(new java.awt.Dimension(164, 94));
        scrEng.setViewportView(txaEng);

        javax.swing.GroupLayout pnlEngLayout = new javax.swing.GroupLayout(pnlEng);
        pnlEng.setLayout(pnlEngLayout);
        pnlEngLayout.setHorizontalGroup(
            pnlEngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
            .addGroup(pnlEngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEngLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrEng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlEngLayout.setVerticalGroup(
            pnlEngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
            .addGroup(pnlEngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEngLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrEng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlCastLayout = new javax.swing.GroupLayout(pnlCast);
        pnlCast.setLayout(pnlCastLayout);
        pnlCastLayout.setHorizontalGroup(
            pnlCastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCastLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlEng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlCastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCastLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrCast, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlCastLayout.setVerticalGroup(
            pnlCastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCastLayout.createSequentialGroup()
                .addComponent(pnlEng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCastLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrCast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlCatLayout = new javax.swing.GroupLayout(pnlCat);
        pnlCat.setLayout(pnlCatLayout);
        pnlCatLayout.setHorizontalGroup(
            pnlCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlCast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlCatLayout.setVerticalGroup(
            pnlCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCast, javax.swing.GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)
            .addGroup(pnlCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layeredDesc.setLayer(pnlCat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredDescLayout = new javax.swing.GroupLayout(layeredDesc);
        layeredDesc.setLayout(layeredDescLayout);
        layeredDescLayout.setHorizontalGroup(
            layeredDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layeredDescLayout.setVerticalGroup(
            layeredDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredDescLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblMunicipi.setText("Municipi");

        lblAdreca.setText("Adreça");

        txtAdreca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdrecaActionPerformed(evt);
            }
        });

        lblEmail.setText("Email");

        lblWeb.setText("Web");

        lblTelefon.setText("Telefon");

        txtTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonActionPerformed(evt);
            }
        });

        lblTipus.setText("Tipus");

        cmbTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Museu", "Galeria", "Centre Cultural" }));

        jLabel2.setText("Modalitats (selecciona al menys 1)");

        chkSelectAllMod.setText("Select all");
        chkSelectAllMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelectAllModActionPerformed(evt);
            }
        });

        pnlModalitats.setBorder(javax.swing.BorderFactory.createTitledBorder("Modalitats"));

        chkPintura.setText("Pintura");
        chkPintura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPinturaActionPerformed(evt);
            }
        });

        chkEscultura.setText("Escultura");
        chkEscultura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEsculturaActionPerformed(evt);
            }
        });

        chkFotografia.setText("Fotografia");
        chkFotografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFotografiaActionPerformed(evt);
            }
        });

        chkVidre.setText("Vidre");
        chkVidre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVidreActionPerformed(evt);
            }
        });

        chkVideo.setText("Video");
        chkVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVideoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlModalitatsLayout = new javax.swing.GroupLayout(pnlModalitats);
        pnlModalitats.setLayout(pnlModalitatsLayout);
        pnlModalitatsLayout.setHorizontalGroup(
            pnlModalitatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModalitatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModalitatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPintura)
                    .addComponent(chkEscultura)
                    .addComponent(chkFotografia)
                    .addComponent(chkVidre)
                    .addComponent(chkVideo))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlModalitatsLayout.setVerticalGroup(
            pnlModalitatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModalitatsLayout.createSequentialGroup()
                .addComponent(chkPintura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkEscultura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkFotografia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVidre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVideo)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        lblGestor.setText("Gestor");

        txtGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGestorActionPerformed(evt);
            }
        });

        pnlServeis.setBorder(javax.swing.BorderFactory.createTitledBorder("Serveis"));

        chkAcces.setText("Accés discapacitats");
        chkAcces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAccesActionPerformed(evt);
            }
        });

        chkCafeteria.setText("Cafeteria");
        chkCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCafeteriaActionPerformed(evt);
            }
        });

        chkBiblioteca.setText("Biblioteca");
        chkBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBibliotecaActionPerformed(evt);
            }
        });

        chkAparcament.setText("Aparcament");
        chkAparcament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAparcamentActionPerformed(evt);
            }
        });

        chkTallers.setText("Tallers");
        chkTallers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTallersActionPerformed(evt);
            }
        });

        chkVisites.setText("Visites concertades");
        chkVisites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVisitesActionPerformed(evt);
            }
        });

        chkArxiu.setText("Arxiu");
        chkArxiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkArxiuActionPerformed(evt);
            }
        });

        chkConcerts.setText("Concerts");

        chkConferencies.setText("Conferències");

        chkWifi.setText("Wifi");

        chkSelectAllServ.setText("Select all");
        chkSelectAllServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelectAllServActionPerformed(evt);
            }
        });

        jLabel5.setText("_____________________________________");

        chkJardins.setText("Jardins");

        javax.swing.GroupLayout pnlServeisLayout = new javax.swing.GroupLayout(pnlServeis);
        pnlServeis.setLayout(pnlServeisLayout);
        pnlServeisLayout.setHorizontalGroup(
            pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServeisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkVisites)
                    .addGroup(pnlServeisLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(chkSelectAllServ))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlServeisLayout.createSequentialGroup()
                        .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkAcces)
                            .addComponent(chkCafeteria)
                            .addComponent(chkBiblioteca)
                            .addComponent(chkAparcament)
                            .addComponent(chkTallers))
                        .addGap(18, 18, 18)
                        .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkJardins)
                            .addComponent(chkWifi)
                            .addComponent(chkConferencies)
                            .addComponent(chkArxiu)
                            .addComponent(chkConcerts))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlServeisLayout.setVerticalGroup(
            pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServeisLayout.createSequentialGroup()
                .addComponent(chkSelectAllServ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAcces)
                    .addComponent(chkArxiu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCafeteria)
                    .addComponent(chkConcerts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBiblioteca)
                    .addComponent(chkConferencies))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAparcament)
                    .addComponent(chkWifi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkTallers)
                    .addComponent(chkJardins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVisites))
        );

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        lblImageIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        lblimages.setText("Images");

        txtImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageActionPerformed(evt);
            }
        });

        lstImages.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstImagesValueChanged(evt);
            }
        });
        scrImages.setViewportView(lstImages);

        prgImage.setStringPainted(true);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInsertLayout = new javax.swing.GroupLayout(pnlInsert);
        pnlInsert.setLayout(pnlInsertLayout);
        pnlInsertLayout.setHorizontalGroup(
            pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlServeis, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addComponent(lblNomEspai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomEspai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addComponent(lblDescripcions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(layeredDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTipus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(chkSelectAllMod))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addComponent(pnlModalitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(prgImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(lblTelefon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefon))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(lblAdreca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAdreca))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(lblMunicipi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMunicipi))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(lblRegistreEspai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRegistreEspai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(lblEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEmail))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(lblWeb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addComponent(lblGestor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(220, 220, 220))
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(lblimages)
                                .addContainerGap())
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInsertLayout.createSequentialGroup()
                                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtImage)
                                            .addComponent(scrImages, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnUpload)
                                            .addComponent(btnBorrar))
                                        .addGap(43, 43, 43))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnClear)
                                            .addComponent(lblImageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(130, Short.MAX_VALUE))))))))
            .addGroup(pnlInsertLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnInsert)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlInsertLayout.setVerticalGroup(
            pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInsertLayout.createSequentialGroup()
                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRegistreEspai)
                            .addComponent(txtRegistreEspai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMunicipi)
                            .addComponent(txtMunicipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdreca)
                            .addComponent(txtAdreca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWeb)
                            .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefon)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGestor)
                            .addComponent(txtGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkSelectAllMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlModalitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInsertLayout.createSequentialGroup()
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(layeredDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 11, Short.MAX_VALUE))
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblNomEspai)
                                            .addComponent(txtNomEspai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblDescripcions)
                                            .addComponent(cmbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(143, 143, 143)))
                                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTipus)
                                    .addComponent(cmbTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlInsertLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblimages)
                                .addGap(16, 16, 16)
                                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpload))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrImages)
                                    .addGroup(pnlInsertLayout.createSequentialGroup()
                                        .addComponent(btnBorrar)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInsertLayout.createSequentialGroup()
                                .addComponent(lblImageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prgImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlServeis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(pnlInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnClear))
                .addGap(60, 60, 60))
        );

        tabCRUD.addTab("Insert", pnlInsert);

        pnlModify.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtRegistreModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistreModifyActionPerformed(evt);
            }
        });
        txtRegistreModify.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegistreModifyKeyTyped(evt);
            }
        });

        lblRegistreModify.setText("Registre");

        btnConfirmModify.setText("Confirm");
        btnConfirmModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmModifyActionPerformed(evt);
            }
        });

        lblNomModify.setText("Nom");

        lblModalitatsModify.setText("Modalitats (selecciona al menys 1)");

        chkSelectAllModModify.setText("Select all");
        chkSelectAllModModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelectAllModModifyActionPerformed(evt);
            }
        });

        pnlModalitatsModify.setBorder(javax.swing.BorderFactory.createTitledBorder("Modalitats"));

        chkPinturaModify.setText("Pintura");
        chkPinturaModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPinturaModifyActionPerformed(evt);
            }
        });

        chkEsculturaModify.setText("Escultura");
        chkEsculturaModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEsculturaModifyActionPerformed(evt);
            }
        });

        chkFotografiaModify.setText("Fotografia");
        chkFotografiaModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFotografiaModifyActionPerformed(evt);
            }
        });

        chkVidreModify.setText("Vidre");
        chkVidreModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVidreModifyActionPerformed(evt);
            }
        });

        chkVideoModify.setText("Video");
        chkVideoModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVideoModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlModalitatsModifyLayout = new javax.swing.GroupLayout(pnlModalitatsModify);
        pnlModalitatsModify.setLayout(pnlModalitatsModifyLayout);
        pnlModalitatsModifyLayout.setHorizontalGroup(
            pnlModalitatsModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModalitatsModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModalitatsModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPinturaModify)
                    .addComponent(chkEsculturaModify)
                    .addComponent(chkFotografiaModify)
                    .addComponent(chkVidreModify)
                    .addComponent(chkVideoModify))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlModalitatsModifyLayout.setVerticalGroup(
            pnlModalitatsModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModalitatsModifyLayout.createSequentialGroup()
                .addComponent(chkPinturaModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkEsculturaModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkFotografiaModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVidreModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVideoModify)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        lblImageIconModify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageIconModify.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImageIconModify.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnUploadModify.setText("Upload");
        btnUploadModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadModifyActionPerformed(evt);
            }
        });

        lblimagesModify.setText("Images");

        txtImageModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageModifyActionPerformed(evt);
            }
        });

        lstImagesModify.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstImagesModifyValueChanged(evt);
            }
        });
        scrImagesModify.setViewportView(lstImagesModify);

        lblGestorModify.setText("Gestor");

        lblMunicipiModify.setText("Municipi");

        txtGestorModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGestorModifyActionPerformed(evt);
            }
        });

        prgImageModify.setStringPainted(true);

        pnlServeisModify.setBorder(javax.swing.BorderFactory.createTitledBorder("Serveis"));

        chkAccesModify.setText("Accés discapacitats");
        chkAccesModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAccesModifyActionPerformed(evt);
            }
        });

        chkCafeteriaModify.setText("Cafeteria");
        chkCafeteriaModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCafeteriaModifyActionPerformed(evt);
            }
        });

        chkBibliotecaModify.setText("Biblioteca");
        chkBibliotecaModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBibliotecaModifyActionPerformed(evt);
            }
        });

        chkAparcamentModify.setText("Aparcament");
        chkAparcamentModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAparcamentModifyActionPerformed(evt);
            }
        });

        chkTallersModify.setText("Tallers");
        chkTallersModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTallersModifyActionPerformed(evt);
            }
        });

        chkVisitesModify.setText("Visites concertades");
        chkVisitesModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVisitesModifyActionPerformed(evt);
            }
        });

        chkArxiuModify.setText("Arxiu");
        chkArxiuModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkArxiuModifyActionPerformed(evt);
            }
        });

        chkConcertsModify.setText("Concerts");

        chkConferenciesModify.setText("Conferències");

        chkWifiModify.setText("Wifi");

        chkSelectAllServModify.setText("Select all");
        chkSelectAllServModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelectAllServModifyActionPerformed(evt);
            }
        });

        chkJardinsModify.setText("Jardins");

        javax.swing.GroupLayout pnlServeisModifyLayout = new javax.swing.GroupLayout(pnlServeisModify);
        pnlServeisModify.setLayout(pnlServeisModifyLayout);
        pnlServeisModifyLayout.setHorizontalGroup(
            pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServeisModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkVisitesModify)
                    .addGroup(pnlServeisModifyLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(chkSelectAllServModify))
                    .addGroup(pnlServeisModifyLayout.createSequentialGroup()
                        .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkAccesModify)
                            .addComponent(chkCafeteriaModify)
                            .addComponent(chkBibliotecaModify)
                            .addComponent(chkAparcamentModify)
                            .addComponent(chkTallersModify))
                        .addGap(18, 18, 18)
                        .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkJardinsModify)
                            .addComponent(chkWifiModify)
                            .addComponent(chkConferenciesModify)
                            .addComponent(chkArxiuModify)
                            .addComponent(chkConcertsModify))))
                .addContainerGap(10, Short.MAX_VALUE))
            .addComponent(sprModify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        pnlServeisModifyLayout.setVerticalGroup(
            pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServeisModifyLayout.createSequentialGroup()
                .addComponent(chkSelectAllServModify)
                .addGap(7, 7, 7)
                .addComponent(sprModify, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAccesModify)
                    .addComponent(chkArxiuModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCafeteriaModify)
                    .addComponent(chkConcertsModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBibliotecaModify)
                    .addComponent(chkConferenciesModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAparcamentModify)
                    .addComponent(chkWifiModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServeisModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkTallersModify)
                    .addComponent(chkJardinsModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVisitesModify))
        );

        btnBorrarModify.setText("Borrar");
        btnBorrarModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarModifyActionPerformed(evt);
            }
        });

        lblAdrecaModify.setText("Adreça");

        txtAdrecaModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdrecaModifyActionPerformed(evt);
            }
        });

        lblEmailModify.setText("Email");

        lblWebModify.setText("Web");

        lblTelefonModify.setText("Telefon");

        lblDescripcionsModify.setText("Descripcions");

        txtTelefonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonModifyActionPerformed(evt);
            }
        });

        cmbDescModify.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Català", "Español", "English" }));
        cmbDescModify.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDescModifyItemStateChanged(evt);
            }
        });
        cmbDescModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDescModifyActionPerformed(evt);
            }
        });
        cmbDescModify.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbDescModifyPropertyChange(evt);
            }
        });

        lblTipusModify.setText("Tipus");

        pnlCatModify.setMaximumSize(new java.awt.Dimension(186, 130));
        pnlCatModify.setMinimumSize(new java.awt.Dimension(186, 130));

        scrCatModify.setMaximumSize(new java.awt.Dimension(166, 96));
        scrCatModify.setMinimumSize(new java.awt.Dimension(166, 96));

        txaCatModify.setColumns(20);
        txaCatModify.setLineWrap(true);
        txaCatModify.setRows(5);
        txaCatModify.setWrapStyleWord(true);
        txaCatModify.setMaximumSize(new java.awt.Dimension(164, 94));
        txaCatModify.setMinimumSize(new java.awt.Dimension(164, 94));
        scrCatModify.setViewportView(txaCatModify);

        pnlEspModify.setMaximumSize(new java.awt.Dimension(186, 130));
        pnlEspModify.setMinimumSize(new java.awt.Dimension(186, 130));
        pnlEspModify.setPreferredSize(new java.awt.Dimension(186, 130));

        scrEspModify.setMaximumSize(new java.awt.Dimension(166, 96));
        scrEspModify.setMinimumSize(new java.awt.Dimension(166, 96));

        txaEspModify.setColumns(20);
        txaEspModify.setLineWrap(true);
        txaEspModify.setRows(5);
        txaEspModify.setWrapStyleWord(true);
        txaEspModify.setMaximumSize(new java.awt.Dimension(164, 94));
        txaEspModify.setMinimumSize(new java.awt.Dimension(164, 94));
        scrEspModify.setViewportView(txaEspModify);

        pnlEngModify.setMaximumSize(new java.awt.Dimension(186, 130));
        pnlEngModify.setMinimumSize(new java.awt.Dimension(186, 130));

        scrEngModify.setMaximumSize(new java.awt.Dimension(166, 96));
        scrEngModify.setMinimumSize(new java.awt.Dimension(166, 96));

        txaEngModify.setColumns(20);
        txaEngModify.setLineWrap(true);
        txaEngModify.setRows(5);
        txaEngModify.setWrapStyleWord(true);
        txaEngModify.setMaximumSize(new java.awt.Dimension(164, 94));
        txaEngModify.setMinimumSize(new java.awt.Dimension(164, 94));
        scrEngModify.setViewportView(txaEngModify);

        javax.swing.GroupLayout pnlEngModifyLayout = new javax.swing.GroupLayout(pnlEngModify);
        pnlEngModify.setLayout(pnlEngModifyLayout);
        pnlEngModifyLayout.setHorizontalGroup(
            pnlEngModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
            .addGroup(pnlEngModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEngModifyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrEngModify, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlEngModifyLayout.setVerticalGroup(
            pnlEngModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(pnlEngModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEngModifyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrEngModify, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlEspModifyLayout = new javax.swing.GroupLayout(pnlEspModify);
        pnlEspModify.setLayout(pnlEspModifyLayout);
        pnlEspModifyLayout.setHorizontalGroup(
            pnlEspModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEngModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlEspModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEspModifyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrEspModify, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlEspModifyLayout.setVerticalGroup(
            pnlEspModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEngModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEspModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEspModifyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrEspModify, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlCatModifyLayout = new javax.swing.GroupLayout(pnlCatModify);
        pnlCatModify.setLayout(pnlCatModifyLayout);
        pnlCatModifyLayout.setHorizontalGroup(
            pnlCatModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCatModifyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlEspModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlCatModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCatModifyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrCatModify, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlCatModifyLayout.setVerticalGroup(
            pnlCatModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEspModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCatModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCatModifyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrCatModify, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        layeredDescModify.setLayer(pnlCatModify, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredDescModifyLayout = new javax.swing.GroupLayout(layeredDescModify);
        layeredDescModify.setLayout(layeredDescModifyLayout);
        layeredDescModifyLayout.setHorizontalGroup(
            layeredDescModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCatModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layeredDescModifyLayout.setVerticalGroup(
            layeredDescModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredDescModifyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlCatModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        cmbTipusModify.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Museu", "Galeria", "Centre Cultural" }));
        cmbTipusModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipusModifyActionPerformed(evt);
            }
        });

        chkVisible.setText("Visible");

        btnCancelModify.setText("Cancel");
        btnCancelModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlModifyVisibleLayout = new javax.swing.GroupLayout(pnlModifyVisible);
        pnlModifyVisible.setLayout(pnlModifyVisibleLayout);
        pnlModifyVisibleLayout.setHorizontalGroup(
            pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                        .addComponent(lblNomModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomModify, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                        .addComponent(layeredDescModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                                .addComponent(lblTelefonModify)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefonModify))
                                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                                .addComponent(lblWebModify)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtWebModify, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                                .addComponent(lblMunicipiModify)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMunicipiModify, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                                .addComponent(lblAdrecaModify)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAdrecaModify, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                                .addComponent(lblEmailModify)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEmailModify, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModifyVisibleLayout.createSequentialGroup()
                                        .addComponent(lblGestorModify)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGestorModify, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrImagesModify, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addGap(90, 90, 90))
                            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                .addComponent(btnModify)
                                .addGap(53, 53, 53)
                                .addComponent(btnCancelModify)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkVisible)
                                .addGap(146, 146, 146))))))
            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlServeisModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                            .addComponent(lblDescripcionsModify)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbDescModify, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblTipusModify)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbTipusModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblModalitatsModify)
                                .addComponent(chkSelectAllModModify)
                                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                    .addComponent(pnlModalitatsModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79)
                                    .addComponent(prgImageModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(94, 94, 94))
                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                    .addGap(282, 282, 282)
                                    .addComponent(lblimagesModify)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                    .addGap(188, 188, 188)
                                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModifyVisibleLayout.createSequentialGroup()
                                            .addComponent(txtImageModify)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnUploadModify)
                                                .addComponent(btnBorrarModify)))
                                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                            .addComponent(lblImageIconModify, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(19, 19, 19)))))
        );
        pnlModifyVisibleLayout.setVerticalGroup(
            pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomModify)
                    .addComponent(txtNomModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMunicipiModify)
                    .addComponent(txtMunicipiModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdrecaModify)
                            .addComponent(txtAdrecaModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailModify)
                            .addComponent(txtEmailModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWebModify)
                            .addComponent(txtWebModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefonModify)
                            .addComponent(txtTelefonModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGestorModify)
                            .addComponent(txtGestorModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(scrImagesModify, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(layeredDescModify, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModifyVisibleLayout.createSequentialGroup()
                        .addComponent(chkVisible)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModifyVisibleLayout.createSequentialGroup()
                        .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModify)
                            .addComponent(btnCancelModify))
                        .addGap(22, 22, 22))))
            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                            .addGap(196, 196, Short.MAX_VALUE)
                            .addComponent(lblModalitatsModify)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(chkSelectAllModModify)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlModalitatsModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDescripcionsModify)
                                        .addComponent(cmbDescModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(143, 143, 143)
                                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTipusModify)
                                        .addComponent(cmbTipusModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlModifyVisibleLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(lblimagesModify)
                                    .addGap(16, 16, 16)
                                    .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtImageModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUploadModify))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBorrarModify)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(pnlModifyVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModifyVisibleLayout.createSequentialGroup()
                                    .addComponent(lblImageIconModify, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(prgImageModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34))
                                .addComponent(pnlServeisModify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(53, 53, 53)))
        );

        javax.swing.GroupLayout pnlModifyLayout = new javax.swing.GroupLayout(pnlModify);
        pnlModify.setLayout(pnlModifyLayout);
        pnlModifyLayout.setHorizontalGroup(
            pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifyLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(lblRegistreModify)
                .addGap(18, 18, 18)
                .addComponent(txtRegistreModify, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmModify)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlModifyVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlModifyLayout.setVerticalGroup(
            pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifyLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegistreModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegistreModify)
                    .addComponent(btnConfirmModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlModifyVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabCRUD.addTab("Modify", pnlModify);

        btnMyProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        btnMyProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tabCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabCRUD)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /*tabCRUD.setEnabledAt(1, false);
        tabCRUD.setEnabledAt(2, false);
        btnModifyInsert.setVisible(false);
        btnReadHidden.setVisible(false);
        */
        pnlCast.setVisible(false);
        pnlEng.setVisible(false);
        pnlEspModify.setVisible(false);
        pnlEngModify.setVisible(false);
        pnlModifyVisible.setVisible(false);
        /*Login l = new Login(this, true);
        l.setVisible(true);
        currentUser = l.getLoginUser();

        if(currentUser.isAdmin()){
            tabCRUD.setEnabledAt(1, true);
            tabCRUD.setEnabledAt(2, true);
            btnModifyInsert.setVisible(true);
            btnReadHidden.setVisible(true);
        }*/
        btnLogout.doClick();
    }//GEN-LAST:event_formWindowOpened

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        DataAccess da = new DataAccess();
        DefaultListModel<Espai> defaultListModel = new DefaultListModel<>();
        for(Espai e: da.getEspaisVisibleOrHidden(true)){
            defaultListModel.addElement(e);
        }
        lstEspais.setModel(defaultListModel);
    }//GEN-LAST:event_btnReadActionPerformed

    private void txtAdrecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdrecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdrecaActionPerformed

    private void txtTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonActionPerformed

    private void chkSelectAllModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelectAllModActionPerformed
        if(chkSelectAllMod.isSelected()){
            for(JCheckBox chkBox : chkListModalitats){
                chkBox.setSelected(true);
            }
        }else{
          for(JCheckBox chkBox : chkListModalitats){
                chkBox.setSelected(false);
          }  
        }
    }//GEN-LAST:event_chkSelectAllModActionPerformed

    private void chkPinturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPinturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkPinturaActionPerformed

    private void chkEsculturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEsculturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEsculturaActionPerformed

    private void chkFotografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFotografiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkFotografiaActionPerformed

    private void chkVidreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVidreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVidreActionPerformed

    private void chkVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVideoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVideoActionPerformed

    private void txtGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGestorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGestorActionPerformed

    private void chkSelectAllServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelectAllServActionPerformed
        if(chkSelectAllServ.isSelected()){
            for(JCheckBox chkBox : chkListServeis){
                chkBox.setSelected(true);
            }
        }else{
          for(JCheckBox chkBox : chkListServeis){
                chkBox.setSelected(false);
          }  
        }
    }//GEN-LAST:event_chkSelectAllServActionPerformed

    private void chkAccesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAccesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAccesActionPerformed

    private void chkCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCafeteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCafeteriaActionPerformed

    private void chkBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBibliotecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBibliotecaActionPerformed

    private void chkAparcamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAparcamentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAparcamentActionPerformed

    private void chkTallersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTallersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTallersActionPerformed

    private void chkVisitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVisitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVisitesActionPerformed

    private void chkArxiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkArxiuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkArxiuActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        DataAccess da = new DataAccess();
        boolean insert = true;
        LinkedHashMap<String, String> descripcions = new LinkedHashMap<>();
        descripcions.put("\"cat\"", "\"" + txaCat.getText() + "\"");
        descripcions.put("\"esp\"", "\"" + txaCast.getText() + "\"");
        descripcions.put("\"eng\"", "\"" + txaEng.getText() + "\"");
        
        Pattern emailRegEx = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        Pattern webRegEx = Pattern.compile("(www\\.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)|(www\\.)?(?!ww)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)");
        String modalitats = "";
        String error = "";
        try{
            if(txtRegistreEspai.getText() == null || txtRegistreEspai.getText().isBlank() || txtRegistreEspai.getText().isEmpty() ||
               txtAdreca.getText() == null || txtAdreca.getText().isBlank() || txtAdreca.getText().isEmpty() ||
               txtEmail.getText() == null || txtEmail.getText().isBlank() || txtEmail.getText().isEmpty() ||
               txtGestor.getText() == null || txtGestor.getText().isBlank() || txtGestor.getText().isEmpty() ||
               txtMunicipi.getText() == null || txtMunicipi.getText().isBlank() || txtMunicipi.getText().isEmpty() ||
               txtNomEspai.getText() == null || txtNomEspai.getText().isBlank() || txtNomEspai.getText().isEmpty() ||
               txtWeb.getText() == null || txtWeb.getText().isBlank() || txtWeb.getText().isEmpty() ||
               txtTelefon.getText() == null || txtTelefon.getText().isBlank() || txtTelefon.getText().isEmpty()) {
                error += "Els atributs no poden ser nulls o buits" + System.lineSeparator();
                //throw new ArgumentNullException(error);
            }
            
            if(txaCast.getText() == null || txaCast.getText().isBlank() || txaCast.getText().isEmpty() ||
               txaCat.getText() == null || txaCat.getText().isBlank() || txaCat.getText().isEmpty() ||
               txaEng.getText() == null || txaEng.getText().isBlank() || txaEng.getText().isEmpty()) {
                error += "S'han d'omplir les descripcions en els 3 idiomes" + System.lineSeparator();
                //throw new ArgumentNullException(error);
            }
            
            for(Espai espai : da.getEspais()){
                if(txtRegistreEspai.getText().equals(espai.getRegistre())){
                    error += "No es pot repetir un nombre de registre" + System.lineSeparator();
                    //throw new ArgumentNullException(error);
                }
            }
            
            if(images.isEmpty()){
                error += "Has d'introduïr 1 imatge com a mínim"  + System.lineSeparator();
                //throw new ArgumentNullException(error);
            }
            
            try{
                Integer.parseInt(txtTelefon.getText());
                if(txtTelefon.getText().length() != 9){
                    error += "El telèfon ha de ser un número vàlid" + System.lineSeparator();
                    //throw new ArgumentNullException(error);
                }
            }catch(Exception e){
                error += "El telèfon ha de ser un número vàlid" + System.lineSeparator();
            }
            
            for(JCheckBox checkBox : chkListModalitats){
                if(checkBox.isSelected()){
                    modalitats += checkBox.getText() + ", ";
                }
            }
            
            if(modalitats.isBlank() || modalitats.isBlank() || modalitats == null){
                error += "Al menys una modalitat ha de ser seleccionada"  + System.lineSeparator();
                //throw new ArgumentNullException(error);
            }
            modalitats = modalitats.substring(0, modalitats.length() - 1);
            
            if(!(emailRegEx.matcher(txtEmail.getText()).matches()) || !(emailRegEx.matcher(txtGestor.getText()).matches())){
                error += "Tant email com gestor han d'estar en un format d'email correcte" + System.lineSeparator();
            }
            
            if(!(webRegEx.matcher(txtWeb.getText()).matches())){
                error += "Web ha d'estar en el següent format: www.text.com" + System.lineSeparator();
            }
            
            if(!(error.isEmpty() || error.isBlank() || error == null)){
                throw new ArgumentNullException(error);
            }
        } catch (Exception e){
            insert = false;
            System.err.println(error);
            JOptionPane.showMessageDialog(null,
            error,
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        
        String serveis = "";
        for(JCheckBox checkBox : chkListServeis){
            if(checkBox.isSelected()){
                serveis += checkBox.getText() + ", ";
            }
        }
        if(!(serveis.isBlank() || serveis.isEmpty() || serveis == null)) {
            serveis = serveis.substring(0, serveis.length() - 1);
        }

        if(insert){
            Espai espai = new Espai(txtNomEspai.getText(),
                    txtRegistreEspai.getText(),
                    descripcions,
                    txtMunicipi.getText(),
                    txtAdreca.getText(),
                    txtEmail.getText(),
                    txtWeb.getText(),
                    Integer.parseInt(txtTelefon.getText()),
                    cmbTipus.getSelectedItem().toString(),
                    modalitats,
                    txtGestor.getText(),
                    serveis);
            int res = da.insertEspais(espai);
            String espaiImg = espai.getRegistre();
            int contador = 1;
            for(String imatge : images) {
                String id = espaiImg + "_" + contador;
                Imatge newImage = new Imatge(id, imatge, espaiImg);
                da.insertImage(newImage);
                contador++;
            };
            if (res != 0){
                inserted = true;
                JOptionPane.showMessageDialog(null,
                "S'ha introduït el espai correctament",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
                btnClear.doClick();
            }
        }
        inserted = false;
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnVisualitzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualitzarActionPerformed
        if(!(lstEspais.getSelectedValue() == null)){
            //DataAccess da = new DataAccess();
            Espai espai = lstEspais.getSelectedValue();
            //int coments = da.getNumComentaris(espai);
            Visualitzar visualitzar = new Visualitzar(this, true);
            visualitzar.setSelectedEspai(espai);
            visualitzar.getLblRegister().setText(espai.getRegistre());
            visualitzar.getLblTitol().setText(espai.getNom());
            visualitzar.getLblComentaris().setText("Comentaris: " + numComentaris(espai));
            visualitzar.getLblAdreca().setText(espai.getMunicipi() + ", " + espai.getAdreca());
            visualitzar.getLblWeb().setText(espai.getWeb());
            visualitzar.getLblEmail().setText(espai.getEmail());
            visualitzar.getLblGestor().setText(espai.getGestor());
            visualitzar.getLblTelefon().setText(Integer.toString(espai.getTelefon()));
            visualitzar.getTxaModalitats().setText(espai.getModalitat());
            visualitzar.getLblTipus().setText(espai.getTipus());
            String serveis = espai.getServeis();
            visualitzar.getTxaServeis().setText(serveis);
            if(serveis == null || serveis.isBlank() || serveis.isEmpty()){
                visualitzar.getTxaServeis().setText("Aquest espai no proporciona cap servei");
            }
            visualitzar.getTxaCat().setText(espai.getDescripcions().get("\"cat\""));
            visualitzar.getTxaEsp().setText(espai.getDescripcions().get("\"esp\""));
            visualitzar.getTxaEn().setText(espai.getDescripcions().get("\"eng\""));
            visualitzar.getLblUser().setText(currentUser.getUserName() + " :");
            visualitzar.setCurrentUser(currentUser);
            visualitzar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
            "No s'ha seleccionat cap espai per a visualitzar",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVisualitzarActionPerformed

    private void btnCercarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercarActionPerformed
        DataAccess da = new DataAccess();
        txtCercarMunicipi.setText("");
        DefaultListModel<Espai> defaultListModel = new DefaultListModel<>();
        for(Espai e: da.getEspaisSegonsRegistre(txtCercar.getText())){
            defaultListModel.addElement(e);
        }
        lstEspais.setModel(defaultListModel);
    }//GEN-LAST:event_btnCercarActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        Profile p = new Profile(this, true);
        p.setCurrentUser(currentUser);
        p.getLblEmail().setText(currentUser.getEmail());
        p.getLblUsername().setText(currentUser.getUserName());
        p.setVisible(true);
        if(p.isDeleted()){
            btnLogout.doClick();
        }
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        //DefaultListModel imageListModel = new DefaultListModel();
        uploadImage(txtImage, images, imageListModel, lstImages);
    }//GEN-LAST:event_btnUploadActionPerformed

    
    
    private void lstImagesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstImagesValueChanged
        if (!evt.getValueIsAdjusting()) {  //This line prevents double events when selecting by click
            if(!(lstImages.getSelectedValue() == null)){
                threadFromInsert = true;
                downloadThread = new Thread(this);
                downloadThread.start();
                lblImageIcon.setIcon(new ImageIcon(Visualitzar.class.getClassLoader().getResource("resizedloader.gif")));
            }
        }
    }//GEN-LAST:event_lstImagesValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        deleteImages();
        deleteImagesModify();
    }//GEN-LAST:event_formWindowClosing

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        String selectedImage = lstImages.getSelectedValue();
        if(!(lstImages.getSelectedValue() == null)){
            ImageHelper.getContainerClient().getBlobClient(selectedImage).delete();
            images.remove(selectedImage);
            imageListModel.remove(lstImages.getSelectedIndex());
            lstImages.setModel(imageListModel);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cmbDescPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbDescPropertyChange

    }//GEN-LAST:event_cmbDescPropertyChange

    private void cmbDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDescActionPerformed
        switch(cmbDesc.getSelectedItem().toString()){
            case "Català" -> {
                pnlCast.setVisible(false);
                pnlEng.setVisible(false);
            }
            case "Español" -> {
                pnlCast.setVisible(true);
                pnlEng.setVisible(false);
            }
            case "English" -> {
                pnlCast.setVisible(true);
                pnlEng.setVisible(true);
            }
        }
    }//GEN-LAST:event_cmbDescActionPerformed

    private void cmbDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDescItemStateChanged

    }//GEN-LAST:event_cmbDescItemStateChanged

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtRegistreEspai.setText("");
        txtNomEspai.setText("");
        txtAdreca.setText("");
        txtEmail.setText("");
        txtGestor.setText("");
        txtMunicipi.setText("");
        txtTelefon.setText("");
        txtWeb.setText("");
        txaCast.setText("");
        txaCat.setText("");
        txaEng.setText("");
        for(JCheckBox chkBox : chkListServeis){
                chkBox.setSelected(false);
        } 
        for(JCheckBox chkBox : chkListModalitats){
                chkBox.setSelected(false);
        }
        deleteImages();
        txtImage.setText("");
        images.clear();
        imageListModel.clear();
        lstImages.setModel(imageListModel);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageActionPerformed

    private void txtRegistreModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistreModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistreModifyActionPerformed

    private void btnModifyInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyInsertActionPerformed
        if(!(lstEspais.getSelectedValue() == null)){
            txtRegistreModify.setText(lstEspais.getSelectedValue().getRegistre());
            tabCRUD.setSelectedIndex(2);
        } else {
            JOptionPane.showMessageDialog(null,
            "No s'ha seleccionat cap espai per a visualitzar",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModifyInsertActionPerformed

    private void btnConfirmModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmModifyActionPerformed
        DataAccess da = new DataAccess();
        boolean exists = false;
        for(Espai espai : da.getEspais()){
            if(txtRegistreModify.getText().equals(espai.getRegistre())){
                exists = true;
                espaiToModify = espai;
                pnlModifyVisible.setVisible(true);
                txtRegistreModify.setEnabled(false);
                txtNomModify.setText(espai.getNom());
                txtMunicipiModify.setText(espai.getMunicipi());
                txtAdrecaModify.setText(espai.getAdreca());
                txtEmailModify.setText(espai.getEmail());
                txtWebModify.setText(espai.getWeb());
                txtTelefonModify.setText(Integer.toString(espai.getTelefon()));
                txtGestorModify.setText(espai.getGestor());
                if(espai.isVisible()){
                    chkVisible.setSelected(true);
                } else {
                    chkVisible.setSelected(false);
                }
                switch(espai.getTipus()){
                    case "Museu" -> cmbTipusModify.setSelectedItem("Museu");
                    case "Galeria" -> cmbTipusModify.setSelectedItem("Galeria");
                    case "Centre Cultural" -> cmbTipusModify.setSelectedItem("Centre Cultural");
                }
                String[] modalitats = espai.getModalitat().split(", ");
                for(String modalitat : modalitats){
                    switch(modalitat){
                        case "Pintura" -> chkPinturaModify.setSelected(true);
                        case "Escultura" -> chkEsculturaModify.setSelected(true);
                        case "Fotografia" -> chkFotografiaModify.setSelected(true);
                        case "Vidre" -> chkVidreModify.setSelected(true);
                        case "Video" -> chkVideoModify.setSelected(true);
                    }
                }
                if(!(espai.getServeis() == null || espai.getServeis().isEmpty() || espai.getServeis().isBlank())) {
                    String[] serveis = espai.getServeis().split(", ");
                    for(String servei : serveis){
                        switch(servei){
                            case "Accés discapacitats" -> chkAccesModify.setSelected(true);
                            case "Cafeteria" -> chkCafeteriaModify.setSelected(true);
                            case "Biblioteca" -> chkBibliotecaModify.setSelected(true);
                            case "Aparcament" -> chkAparcamentModify.setSelected(true);
                            case "Tallers" -> chkTallersModify.setSelected(true);
                            case "Visites Concertades" -> chkVisitesModify.setSelected(true);
                            case "Arxiu" -> chkArxiuModify.setSelected(true);
                            case "Concerts" -> chkConcertsModify.setSelected(true);
                            case "Conferències" -> chkConferenciesModify.setSelected(true);
                            case "Wifi" -> chkWifiModify.setSelected(true);
                            case "Jardins" -> chkJardinsModify.setSelected(true);
                        }
                    }
                }
                txaCatModify.setText(espai.getDescripcions().get("\"cat\""));
                txaEspModify.setText(espai.getDescripcions().get("\"esp\""));
                txaEngModify.setText(espai.getDescripcions().get("\"eng\""));
                
                for (Imatge image : da.getImatgesEspai(espai)){
                    oldImagesModify.add(image.getImatge());
                    imageListModelModify.addElement(image.getImatge());
                }
                lstImagesModify.setModel(imageListModelModify);
            }
        }
        if (!exists){
            JOptionPane.showMessageDialog(null,
            "No existeix cap espai amb aquest registre",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmModifyActionPerformed

    private void chkSelectAllModModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelectAllModModifyActionPerformed
        if(chkSelectAllModModify.isSelected()){
            for(JCheckBox chkBox : chkListModalitatsModify){
                chkBox.setSelected(true);
            }
        }else{
          for(JCheckBox chkBox : chkListModalitatsModify){
                chkBox.setSelected(false);
          }  
        }
    }//GEN-LAST:event_chkSelectAllModModifyActionPerformed

    private void chkPinturaModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPinturaModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkPinturaModifyActionPerformed

    private void chkEsculturaModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEsculturaModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEsculturaModifyActionPerformed

    private void chkFotografiaModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFotografiaModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkFotografiaModifyActionPerformed

    private void chkVidreModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVidreModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVidreModifyActionPerformed

    private void chkVideoModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVideoModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVideoModifyActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        DataAccess da = new DataAccess();
        boolean update = true;
        LinkedHashMap<String, String> descripcions = new LinkedHashMap<>();
        descripcions.put("\"cat\"", "\"" + txaCat.getText() + "\"");
        descripcions.put("\"esp\"", "\"" + txaCast.getText() + "\"");
        descripcions.put("\"eng\"", "\"" + txaEng.getText() + "\"");
        
        Pattern emailRegEx = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        Pattern webRegEx = Pattern.compile("(www\\.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)|(www\\.)?(?!ww)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)");
        String modalitats = "";
        String error = "";
        try{
            if(txtAdrecaModify.getText() == null || txtAdrecaModify.getText().isBlank() || txtAdrecaModify.getText().isEmpty() ||
               txtEmailModify.getText() == null || txtEmailModify.getText().isBlank() || txtEmailModify.getText().isEmpty() ||
               txtGestorModify.getText() == null || txtGestorModify.getText().isBlank() || txtGestorModify.getText().isEmpty() ||
               txtMunicipiModify.getText() == null || txtMunicipiModify.getText().isBlank() || txtMunicipiModify.getText().isEmpty() ||
               txtNomModify.getText() == null || txtNomModify.getText().isBlank() || txtNomModify.getText().isEmpty() ||
               txtWebModify.getText() == null || txtWebModify.getText().isBlank() || txtWebModify.getText().isEmpty() ||
               txtTelefonModify.getText() == null || txtTelefonModify.getText().isBlank() || txtTelefonModify.getText().isEmpty()) {
                error += "Els atributs no poden ser nulls o buits" + System.lineSeparator();
            }
            
            if(txaEspModify.getText() == null || txaEspModify.getText().isBlank() || txaEspModify.getText().isEmpty() ||
               txaCatModify.getText() == null || txaCatModify.getText().isBlank() || txaCatModify.getText().isEmpty() ||
               txaEngModify.getText() == null || txaEngModify.getText().isBlank() || txaEngModify.getText().isEmpty()) {
                error += "No es pot deixar buida la descripció en cap idioma" + System.lineSeparator();
            }
            
            if(imageListModelModify.isEmpty()){
                error += "L'espai ha de contenir al menys 1 imatge"  + System.lineSeparator();
            }
            
            try{
                Integer.parseInt(txtTelefonModify.getText());
                if(txtTelefonModify.getText().length() != 9){
                    error += "El telèfon ha de ser un número vàlid" + System.lineSeparator();
                }
            }catch(Exception e){
                error += "El telèfon ha de ser un número vàlid" + System.lineSeparator();
            }
            
            for(JCheckBox checkBox : chkListModalitatsModify){
                if(checkBox.isSelected()){
                    modalitats += checkBox.getText() + ", ";
                }
            }
            
            if(modalitats.isBlank() || modalitats.isBlank() || modalitats == null){
                error += "Al menys una modalitat ha de ser seleccionada"  + System.lineSeparator();
            }
            modalitats = modalitats.substring(0, modalitats.length() - 1);
            
            if(!(emailRegEx.matcher(txtEmailModify.getText()).matches()) || !(emailRegEx.matcher(txtGestorModify.getText()).matches())){
                error += "Tant email com gestor han d'estar en un format d'email correcte" + System.lineSeparator();
            }
            
            if(!(webRegEx.matcher(txtWebModify.getText()).matches())){
                error += "Web ha d'estar en el següent format: www.text.com" + System.lineSeparator();
            }
            
            if(!(error.isEmpty() || error.isBlank() || error == null)){
                throw new ArgumentNullException(error);
            }
        } catch (Exception e){
            update = false;
            System.err.println(error);
            JOptionPane.showMessageDialog(null,
            error,
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        
        String serveis = "";
        for(JCheckBox checkBox : chkListServeisModify){
            if(checkBox.isSelected()){
                serveis += checkBox.getText() + ", ";
            }
        }
        if(!(serveis.isBlank() || serveis.isEmpty() || serveis == null)) {
            serveis = serveis.substring(0, serveis.length() - 1);
        }

        if(update){
            espaiToModify.setNom(txtNomModify.getText());
            espaiToModify.setDescripcions(descripcions);
            espaiToModify.setMunicipi(txtMunicipiModify.getText());
            espaiToModify.setAdreca(txtAdrecaModify.getText());
            espaiToModify.setEmail(txtEmailModify.getText());
            espaiToModify.setWeb(txtWebModify.getText());
            espaiToModify.setTelefon(Integer.parseInt(txtTelefonModify.getText()));
            espaiToModify.setTipus(cmbTipusModify.getSelectedItem().toString());
            espaiToModify.setModalitat(modalitats);
            espaiToModify.setGestor(txtGestorModify.getText());
            espaiToModify.setServeis(serveis);
            espaiToModify.setVisible(chkVisible.isSelected());
            
            int res = da.updateEspai(espaiToModify);
            String espaiImg = espaiToModify.getRegistre();
            int contador = oldImagesModify.size() + 1;
            for(String imatge : imagesModify) {
                String id = espaiImg + "_" + contador;
                Imatge newImage = new Imatge(id, imatge, espaiImg);
                da.insertImage(newImage);
                contador++;
            };
            if (res != 0){
                for(String image : deletedImages){
                    ImageHelper.getContainerClient().getBlobClient(image).delete();
                    da.deleteImatge(image);
                }
                oldImagesModify.clear();
                imagesModify.clear();
                pnlModifyVisible.setVisible(false);
                txtRegistreModify.setText("");
                txtRegistreModify.setEnabled(true);
                JOptionPane.showMessageDialog(null,
                "S'ha modificat el espai correctament",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnUploadModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadModifyActionPerformed
        uploadImage(txtImageModify, imagesModify, imageListModelModify, lstImagesModify);
    }//GEN-LAST:event_btnUploadModifyActionPerformed

    private void txtImageModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageModifyActionPerformed

    private void lstImagesModifyValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstImagesModifyValueChanged
        if (!evt.getValueIsAdjusting()) {  //This line prevents double events when selecting by click
            if(!(lstImagesModify.getSelectedValue() == null)){
                threadFromModify = true;
                downloadThread = new Thread(this);
                downloadThread.start();
                lblImageIconModify.setIcon(new ImageIcon(Visualitzar.class.getClassLoader().getResource("resizedloader.gif")));
            }
        }
    }//GEN-LAST:event_lstImagesModifyValueChanged

    private void txtGestorModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGestorModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGestorModifyActionPerformed

    private void chkAccesModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAccesModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAccesModifyActionPerformed

    private void chkCafeteriaModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCafeteriaModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCafeteriaModifyActionPerformed

    private void chkBibliotecaModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBibliotecaModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBibliotecaModifyActionPerformed

    private void chkAparcamentModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAparcamentModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAparcamentModifyActionPerformed

    private void chkTallersModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTallersModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTallersModifyActionPerformed

    private void chkVisitesModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVisitesModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVisitesModifyActionPerformed

    private void chkArxiuModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkArxiuModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkArxiuModifyActionPerformed

    private void chkSelectAllServModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelectAllServModifyActionPerformed
        if(chkSelectAllServModify.isSelected()){
            for(JCheckBox chkBox : chkListServeisModify){
                chkBox.setSelected(true);
            }
        }else{
          for(JCheckBox chkBox : chkListServeisModify){
                chkBox.setSelected(false);
          }  
        }
    }//GEN-LAST:event_chkSelectAllServModifyActionPerformed

    private void btnBorrarModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarModifyActionPerformed
        String selectedImage = lstImagesModify.getSelectedValue();
        if(!(lstImagesModify.getSelectedValue() == null)){
            if(imagesModify.contains(selectedImage)){
                ImageHelper.getContainerClient().getBlobClient(selectedImage).delete();
                imagesModify.remove(selectedImage);
            }else{
                deletedImages.add(selectedImage);
            }
            imageListModelModify.remove(lstImagesModify.getSelectedIndex());
            lstImagesModify.setModel(imageListModelModify);
        }
    }//GEN-LAST:event_btnBorrarModifyActionPerformed

    private void txtAdrecaModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdrecaModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdrecaModifyActionPerformed

    private void txtTelefonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonModifyActionPerformed

    private void cmbDescModifyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDescModifyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDescModifyItemStateChanged

    private void cmbDescModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDescModifyActionPerformed
        switch(cmbDescModify.getSelectedItem().toString()){
            case "Català" -> {
                pnlEspModify.setVisible(false);
                pnlEngModify.setVisible(false);
            }
            case "Español" -> {
                pnlEspModify.setVisible(true);
                pnlEngModify.setVisible(false);
            }
            case "English" -> {
                pnlEspModify.setVisible(true);
                pnlEngModify.setVisible(true);
            }
        }
    }//GEN-LAST:event_cmbDescModifyActionPerformed

    private void cmbDescModifyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbDescModifyPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDescModifyPropertyChange

    private void cmbTipusModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipusModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipusModifyActionPerformed

    private void txtRegistreModifyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistreModifyKeyTyped
        pnlModifyVisible.setVisible(false);
    }//GEN-LAST:event_txtRegistreModifyKeyTyped

    private void btnCancelModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelModifyActionPerformed
        deleteImagesModify();
        oldImagesModify.clear();
        imagesModify.clear();
        deletedImages.clear();
        pnlModifyVisible.setVisible(false);
        txtRegistreModify.setText("");
        txtRegistreModify.setEnabled(true);
    }//GEN-LAST:event_btnCancelModifyActionPerformed

    private void btnReadHiddenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadHiddenActionPerformed
        DataAccess da = new DataAccess();
        DefaultListModel<Espai> defaultListModel = new DefaultListModel<>();
        for(Espai e: da.getEspaisVisibleOrHidden(false)){
            defaultListModel.addElement(e);
        }
        lstEspais.setModel(defaultListModel);
    }//GEN-LAST:event_btnReadHiddenActionPerformed

    private void btnCercarMunicipiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercarMunicipiActionPerformed
        DataAccess da = new DataAccess();
        txtCercar.setText("");
        DefaultListModel<Espai> defaultListModel = new DefaultListModel<>();
        for(Espai e: da.getEspaisSegonsMunicipi(txtCercarMunicipi.getText())){
            defaultListModel.addElement(e);
        }
        lstEspais.setModel(defaultListModel);
    }//GEN-LAST:event_btnCercarMunicipiActionPerformed

    private void txtCercarMunicipiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCercarMunicipiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCercarMunicipiActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        tabCRUD.setEnabledAt(1, false);
        tabCRUD.setEnabledAt(2, false);
        btnModifyInsert.setVisible(false);
        btnReadHidden.setVisible(false);

        Login l = new Login(this, true);
        l.setVisible(true);
        currentUser = l.getLoginUser();

        if(currentUser.isAdmin()){
            tabCRUD.setEnabledAt(1, true);
            tabCRUD.setEnabledAt(2, true);
            btnModifyInsert.setVisible(true);
            btnReadHidden.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void lstEspaisMouseClicked(java.awt.event.MouseEvent evt) {                                          
        if (evt.getClickCount() == 2) {
            btnVisualitzar.doClick();
        } 
    }   
    
    private void lstEspaisValueChanged(javax.swing.event.ListSelectionEvent evt){
        Espai selectedEspai = lstEspais.getSelectedValue();
        if(selectedEspai != null) {
            if (!evt.getValueIsAdjusting()) {  //This line prevents double events when selecting by click
                lblRegistre.setText(selectedEspai.getRegistre());
                lblNom.setText(selectedEspai.getNom());
                lblComentaris.setText("Comentaris: " + numComentaris(selectedEspai));
                threadFromRead = true;
                downloadThread = new Thread(this);
                downloadThread.start();
                lblImage.setIcon(new ImageIcon(Visualitzar.class.getClassLoader().getResource("resizedloader.gif")));
            }
        }
    }
    
    private int numComentaris(Espai espai){
        DataAccess da = new DataAccess(); 
        return da.getNumComentaris(espai);
    }
    
    private void deleteImages(){
        if(!inserted && !(images == null ||images.isEmpty())){
            BlobContainerClient container =  ImageHelper.getContainerClient();
            for(String image : images){
                container.getBlobClient(image).delete();
            }
        }
    }
    
    private void deleteImagesModify(){
        if(!(imagesModify == null || imagesModify.isEmpty())){
            BlobContainerClient container =  ImageHelper.getContainerClient();
            for(String image : imagesModify){
                container.getBlobClient(image).delete();
            }
        }
    }
    
    private void uploadImage(JTextField txtImg, ArrayList<String> imageList, DefaultListModel imageListModels, JList lstImage){
        JFileChooser fileChooser = new JFileChooser();
        Boolean status = true;
        BlobContainerClient blobContainerClient = ImageHelper.getContainerClient();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            try {
                status = ImageHelper.isJPEG(fileChooser.getSelectedFile().getAbsoluteFile());
            } catch (Exception ex) {
               ex.printStackTrace();
            }
            if(status){
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                if(!(blobContainerClient.getBlobClient(fileChooser.getSelectedFile().getName()).exists())) {
                    BlobClient blobClient = blobContainerClient.getBlobClient(fileChooser.getSelectedFile().getName());
                    txtImg.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    try {
                        BufferedImage bufferedImage = ImageIO.read(fileChooser.getSelectedFile().getAbsoluteFile());
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(bufferedImage, "jpg", baos);
                        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                        blobClient.upload(bais, baos.size());
                        BlobHttpHeaders headers = new BlobHttpHeaders();
                        headers.setContentType("image/jpeg");
                        blobClient.setHttpHeaders(headers);
                        baos.close();
                        bais.close();
                        imageList.add(fileChooser.getSelectedFile().getName());
                            
                        /*
                        for(String image : images){
                            imageListModel.addElement(image);
                        }
                        */
                        imageListModels.addElement(fileChooser.getSelectedFile().getName());
                        lstImage.setModel(imageListModels);
                    } catch (IOException ios) {
                        ios.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                    "La imatge que es vol introduïr ja existeix",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
                this.setCursor(Cursor.getDefaultCursor());
            } else {
                JOptionPane.showMessageDialog(null,
                "La imatge que es vol introduïr ha d'estar en format jpg",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if(threadFromInsert) {
            ImageHelper.downloadImage(lblImageIcon, prgImage, lstImages.getSelectedValue());
        }
        if(threadFromRead) {
            DataAccess da = new DataAccess();
            ImageHelper.downloadImage(lblImage, prgImatgeRead, da.firstImatge(lstEspais.getSelectedValue()).getImatge());
        }
        if(threadFromModify) {
            ImageHelper.downloadImage(lblImageIconModify, prgImageModify, lstImagesModify.getSelectedValue());
        }
        threadFromInsert = false;
        threadFromRead = false;
        threadFromModify = false;
        //downloadImage();
    }
    
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
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarModify;
    private javax.swing.JButton btnCancelModify;
    private javax.swing.JButton btnCercar;
    private javax.swing.JButton btnCercarMunicipi;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConfirmModify;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnModifyInsert;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnReadHidden;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnUploadModify;
    private javax.swing.JButton btnVisualitzar;
    private javax.swing.JCheckBox chkAcces;
    private javax.swing.JCheckBox chkAccesModify;
    private javax.swing.JCheckBox chkAparcament;
    private javax.swing.JCheckBox chkAparcamentModify;
    private javax.swing.JCheckBox chkArxiu;
    private javax.swing.JCheckBox chkArxiuModify;
    private javax.swing.JCheckBox chkBiblioteca;
    private javax.swing.JCheckBox chkBibliotecaModify;
    private javax.swing.JCheckBox chkCafeteria;
    private javax.swing.JCheckBox chkCafeteriaModify;
    private javax.swing.JCheckBox chkConcerts;
    private javax.swing.JCheckBox chkConcertsModify;
    private javax.swing.JCheckBox chkConferencies;
    private javax.swing.JCheckBox chkConferenciesModify;
    private javax.swing.JCheckBox chkEscultura;
    private javax.swing.JCheckBox chkEsculturaModify;
    private javax.swing.JCheckBox chkFotografia;
    private javax.swing.JCheckBox chkFotografiaModify;
    private javax.swing.JCheckBox chkJardins;
    private javax.swing.JCheckBox chkJardinsModify;
    private javax.swing.JCheckBox chkPintura;
    private javax.swing.JCheckBox chkPinturaModify;
    private javax.swing.JCheckBox chkSelectAllMod;
    private javax.swing.JCheckBox chkSelectAllModModify;
    private javax.swing.JCheckBox chkSelectAllServ;
    private javax.swing.JCheckBox chkSelectAllServModify;
    private javax.swing.JCheckBox chkTallers;
    private javax.swing.JCheckBox chkTallersModify;
    private javax.swing.JCheckBox chkVideo;
    private javax.swing.JCheckBox chkVideoModify;
    private javax.swing.JCheckBox chkVidre;
    private javax.swing.JCheckBox chkVidreModify;
    private javax.swing.JCheckBox chkVisible;
    private javax.swing.JCheckBox chkVisites;
    private javax.swing.JCheckBox chkVisitesModify;
    private javax.swing.JCheckBox chkWifi;
    private javax.swing.JCheckBox chkWifiModify;
    private javax.swing.JComboBox<String> cmbDesc;
    private javax.swing.JComboBox<String> cmbDescModify;
    private javax.swing.JComboBox<String> cmbTipus;
    private javax.swing.JComboBox<String> cmbTipusModify;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane layeredDesc;
    private javax.swing.JLayeredPane layeredDescModify;
    private javax.swing.JLabel lblAdreca;
    private javax.swing.JLabel lblAdrecaModify;
    private javax.swing.JLabel lblCercar;
    private javax.swing.JLabel lblCercar1;
    private javax.swing.JLabel lblComentaris;
    private javax.swing.JLabel lblDescripcions;
    private javax.swing.JLabel lblDescripcionsModify;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailModify;
    private javax.swing.JLabel lblGestor;
    private javax.swing.JLabel lblGestorModify;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageIcon;
    private javax.swing.JLabel lblImageIconModify;
    private javax.swing.JLabel lblModalitatsModify;
    private javax.swing.JLabel lblMunicipi;
    private javax.swing.JLabel lblMunicipiModify;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblNomEspai;
    private javax.swing.JLabel lblNomModify;
    private javax.swing.JLabel lblRegistre;
    private javax.swing.JLabel lblRegistreEspai;
    private javax.swing.JLabel lblRegistreModify;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblTelefonModify;
    private javax.swing.JLabel lblTipus;
    private javax.swing.JLabel lblTipusModify;
    private javax.swing.JLabel lblWeb;
    private javax.swing.JLabel lblWebModify;
    private javax.swing.JLabel lblimages;
    private javax.swing.JLabel lblimagesModify;
    private javax.swing.JList<String> lstImages;
    private javax.swing.JList<String> lstImagesModify;
    private javax.swing.JPanel pnlCast;
    private javax.swing.JPanel pnlCat;
    private javax.swing.JPanel pnlCatModify;
    private javax.swing.JPanel pnlEng;
    private javax.swing.JPanel pnlEngModify;
    private javax.swing.JPanel pnlEspModify;
    private javax.swing.JPanel pnlInsert;
    private javax.swing.JPanel pnlModalitats;
    private javax.swing.JPanel pnlModalitatsModify;
    private javax.swing.JPanel pnlModify;
    private javax.swing.JPanel pnlModifyVisible;
    private javax.swing.JPanel pnlRead;
    private javax.swing.JPanel pnlServeis;
    private javax.swing.JPanel pnlServeisModify;
    private javax.swing.JProgressBar prgImage;
    private javax.swing.JProgressBar prgImageModify;
    private javax.swing.JProgressBar prgImatgeRead;
    private javax.swing.JScrollPane scrCast;
    private javax.swing.JScrollPane scrCat;
    private javax.swing.JScrollPane scrCatModify;
    private javax.swing.JScrollPane scrEng;
    private javax.swing.JScrollPane scrEngModify;
    private javax.swing.JScrollPane scrEspModify;
    private javax.swing.JScrollPane scrEspais;
    private javax.swing.JScrollPane scrImages;
    private javax.swing.JScrollPane scrImagesModify;
    private javax.swing.JSeparator sprModify;
    private javax.swing.JTabbedPane tabCRUD;
    private javax.swing.JTextArea txaCast;
    private javax.swing.JTextArea txaCat;
    private javax.swing.JTextArea txaCatModify;
    private javax.swing.JTextArea txaEng;
    private javax.swing.JTextArea txaEngModify;
    private javax.swing.JTextArea txaEspModify;
    private javax.swing.JTextField txtAdreca;
    private javax.swing.JTextField txtAdrecaModify;
    private javax.swing.JTextField txtCercar;
    private javax.swing.JTextField txtCercarMunicipi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailModify;
    private javax.swing.JTextField txtGestor;
    private javax.swing.JTextField txtGestorModify;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtImageModify;
    private javax.swing.JTextField txtMunicipi;
    private javax.swing.JTextField txtMunicipiModify;
    private javax.swing.JTextField txtNomEspai;
    private javax.swing.JTextField txtNomModify;
    private javax.swing.JTextField txtRegistreEspai;
    private javax.swing.JTextField txtRegistreModify;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtTelefonModify;
    private javax.swing.JTextField txtWeb;
    private javax.swing.JTextField txtWebModify;
    // End of variables declaration//GEN-END:variables
}
