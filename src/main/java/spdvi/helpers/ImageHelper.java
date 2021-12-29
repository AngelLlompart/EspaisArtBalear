/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.helpers;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;

/**
 *
 * @author lawde
 */
public class ImageHelper {
    static Properties properties = new Properties();
    private static String connectionString;
    private static BlobServiceClient blobServiceClient;
    private static BlobContainerClient containerClient;
    //Create a unique name for the container
    private final static String containerName = "espaiarts";
 
    public static ImageIcon resizeImageIcon(BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;
        int newWidth = 0;
        float aspectRatio = (float) originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round(desiredWidth / aspectRatio);
        } else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        BufferedImage resultingImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resultingImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        graphics2D.dispose();
        ImageIcon imageIcon = new ImageIcon(resultingImage);

        return imageIcon;
    }
    
    public static BlobContainerClient getContainerClient() {
        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("application.properties"));
            connectionString = properties.getProperty("azureconnection");
            //Create a BlobServiceClient object which will be used to create a container client
            blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
            //Create the container and return a container client object
            containerClient = blobServiceClient.getBlobContainerClient(containerName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return containerClient;
    }
    
    public static Boolean isJPEG(File filename) throws Exception {
    DataInputStream ins = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
    try {
        if (ins.readInt() == 0xffd8ffe0) {
            return true;
        } else {
            return false;

        }
    } finally {
        ins.close();
    }
}
}
