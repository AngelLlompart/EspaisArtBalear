/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author angel
 */
public class DataAccess {
    private Connection getConnection(){
        Connection connection = null;
        Properties properties = new Properties();
        
        try{
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        }catch(IOException ioe){
            ioe.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    } 
    
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
         try(Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "Select * FROM dbo.[User]"
            );
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                    resultSet.getString ("Username"),
                    resultSet.getString ("Email"),
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
}
