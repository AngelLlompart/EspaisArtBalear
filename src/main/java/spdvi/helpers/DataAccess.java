/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.helpers;

import spdvi.pojos.Espai;
import spdvi.pojos.User;
import java.awt.Frame;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import spdvi.pojos.Comentari;
import spdvi.pojos.Imatge;

/**
 *
 * @author angel
 */
public class DataAccess {

    private Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();

        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public int insertUser(User user) {
        try ( Connection connection = getConnection();) {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[User] (Username, Password, Email, Admin) "
                    + "VALUES (?,?,?,?)");

            insertStatement.setString(1, user.getUserName());
            insertStatement.setString(2, user.getPassword());
            insertStatement.setString(3, user.getEmail());
            insertStatement.setBoolean(4, user.isAdmin());
            insertStatement.executeUpdate();

            int result = insertStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "Select * FROM dbo.[User]"
            );
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("Username"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getBoolean("Admin")
                );
                //user.setId(resultSet.getInt("id"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public ArrayList<Espai> getEspais() {
        ArrayList<Espai> espais = new ArrayList<Espai>();
        try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "Select * FROM dbo.[Espai]"
            );
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String desc = resultSet.getString("Descripcions");
                String[] pairs = desc.split("\",");
                LinkedHashMap<String, String> mapDesc = new LinkedHashMap<>();
                for (String pair : pairs) {
                    String[] entry = pair.split(":");
                    mapDesc.put(entry[0].trim(), entry[1].trim());
                }
                Espai espai = new Espai(
                        resultSet.getString("Nom"),
                        resultSet.getString("Registre"),
                        mapDesc,
                        resultSet.getString("Municipi"),
                        resultSet.getString("Adreça"),
                        resultSet.getString("Email"),
                        resultSet.getString("Web"),
                        resultSet.getInt("Telefon"),
                        resultSet.getString("Tipus"),
                        resultSet.getString("Modalitats"),
                        resultSet.getString("Gestor"),
                        resultSet.getString("Serveis")
                );
                espais.add(espai);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return espais;
    }

    public int insertEspais(Espai es) {
        int result = 0;
        try ( Connection connection = getConnection();) {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[Espai] (Registre, Nom, Descripcions, Municipi, Adreça, Email, Web, Telefon, Tipus, Modalitats, Gestor, Serveis)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            insertStatement.setString(1, es.getRegistre());
            insertStatement.setString(2, es.getNom());
            insertStatement.setString(3, es.desc());
            insertStatement.setString(4, es.getMunicipi());
            insertStatement.setString(5, es.getAdreca());
            insertStatement.setString(6, es.getEmail());
            insertStatement.setString(7, es.getWeb());
            insertStatement.setInt(8, es.getTelefon());
            insertStatement.setString(9, es.getTipus());
            insertStatement.setString(10, es.getModalitat());
            insertStatement.setString(11, es.getGestor());
            insertStatement.setString(12, es.getServeis());

            result = insertStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int updatePassword(String password, String user ) throws SQLException {    
        try (Connection connection = getConnection();) {
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE dbo.[User] SET Password=? where Username=?"); 
            updateStatement.setString(1, password);
            updateStatement.setString(2, user);
            int i = updateStatement.executeUpdate();
            return i;
        }
    }
    
    public ArrayList<Imatge> getImatgesEspai(Espai espai){
        ArrayList<Imatge> imatges = new ArrayList<>();
         try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "Select * FROM dbo.[Imatge] where Espai=?"
            );
            selectStatement.setString(1, espai.getRegistre());
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Imatge imatge = new Imatge(
                      resultSet.getString("ImatgeId"),
                      resultSet.getString("Imatge"),
                      resultSet.getString("Espai")
                );
                imatges.add(imatge);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return imatges;
    }
    
    public int insertImage(Imatge imatge){
        int result = 0;
        try ( Connection connection = getConnection();) {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[Imatge] (ImatgeId, Imatge, Espai)"
                    + "VALUES (?,?,?)");
            
            insertStatement.setString(1, imatge.getId());
            insertStatement.setString(2, imatge.getImatge());
            insertStatement.setString(3, imatge.getEspai());
            result = insertStatement.executeUpdate();

        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return result;
    }
    
    public int getNumComentaris(Espai espai){
        int result = 0;
        try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "select count(dbo.Comentari.Espai) from dbo.Espai join dbo.Comentari on (dbo.Comentari.Espai = dbo.Espai.Registre) where Registre=?;"
            );
            selectStatement.setString(1, espai.getRegistre());
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<Comentari> getComentaris(Espai espai){
        ArrayList<Comentari> comentaris = new ArrayList<>();
        try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "Select * FROM dbo.[Comentari] where Espai=?"
            );
            selectStatement.setString(1, espai.getRegistre());
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Comentari comentari = new Comentari(
                        resultSet.getString("Usuari"), 
                        resultSet.getString("Espai"), 
                        resultSet.getString("Text"), 
                        LocalDate.parse(resultSet.getString("Data")), 
                        resultSet.getTime("Hora").toLocalTime());
                comentaris.add(comentari);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return comentaris;
    }
    
    public int insertComentari(Comentari comentari){
        int result = 0;
        try ( Connection connection = getConnection();) {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[Comentari] (Usuari, Espai, Text, Data, Hora)"
                    + "VALUES (?,?,?,?,?)");
            
            insertStatement.setString(1, comentari.getUsuari());
            insertStatement.setString(2, comentari.getEspai());
            insertStatement.setString(3, comentari.getText());
            insertStatement.setDate(4, Date.valueOf(comentari.getData()));
            insertStatement.setTime(5, Time.valueOf(comentari.getHora()));
            result = insertStatement.executeUpdate();

        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return result;
    }
    
    public Imatge firstImatge(Espai espai){
        Imatge imatge = null;
        try ( Connection connection = getConnection()) {
            
            PreparedStatement selectStatement = connection.prepareStatement(
                    "Select * FROM dbo.[Imatge] where Espai=?"
            );
            selectStatement.setString(1, espai.getRegistre());
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
                imatge = new Imatge(
                      resultSet.getString("ImatgeId"),
                      resultSet.getString("Imatge"),
                      resultSet.getString("Espai")
                );
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return imatge;
    }
}
