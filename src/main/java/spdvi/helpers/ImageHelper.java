/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.helpers;

import spdvi.dataaccess.DataAccess;
import com.azure.core.util.Context;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobRange;
import com.azure.storage.blob.models.DownloadRetryOptions;
import com.azure.storage.blob.specialized.BlockBlobClient;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

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
    
    public static void downloadImage(JLabel lblImage, JProgressBar prgImage, String blobName) {
    // Downloading big images in chunks of 1kB might be very slow because of the request overhead to azure. Modify the algorithm to donwload eavery image in, for instance 20 chunks.

        ByteArrayOutputStream outputStream;
        BufferedImage originalImage;
        try {
            BlockBlobClient blobClient = ImageHelper.getContainerClient().getBlobClient(blobName).getBlockBlobClient();
            int dataSize = (int) blobClient.getProperties().getBlobSize();
            int numberOfBlocks = 20;
            int numberOfBPerBlock = dataSize / numberOfBlocks;  // Split every image in 20 blocks. That is, make 20 requests to Azure.
            System.out.println("Starting download of " + dataSize + " bytes in " + numberOfBlocks + " " + numberOfBPerBlock/1024 + "kB chunks");

            
            int i = 0;
            outputStream = new ByteArrayOutputStream(dataSize);

            while (i < numberOfBlocks) {
                BlobRange range = new BlobRange(i * numberOfBPerBlock, (long)numberOfBPerBlock);
                DownloadRetryOptions options = new DownloadRetryOptions().setMaxRetryRequests(5);

                System.out.println(i + ": Downloading bytes " + range.getOffset() + " to " + (range.getOffset() + range.getCount()) + " with status "
                        + blobClient.downloadStreamWithResponse(outputStream, range, options, null, false,
                                Duration.ofSeconds(30), Context.NONE));
                i++;
                prgImage.setValue(i * prgImage.getMaximum() / (numberOfBlocks + 1));
            }

            // Download the last bytes of the image
            BlobRange range = new BlobRange(i * numberOfBPerBlock);
            DownloadRetryOptions options = new DownloadRetryOptions().setMaxRetryRequests(5);
            System.out.println(i + ": Downloading bytes " + range.getOffset() + " to " + dataSize + " with status "
                    + blobClient.downloadStreamWithResponse(outputStream, range, options, null, false,
                            Duration.ofSeconds(30), Context.NONE));
            i++;
            prgImage.setValue(i * prgImage.getMaximum() / (numberOfBlocks + 1));
            
            originalImage = ImageIO.read(new ByteArrayInputStream(outputStream.toByteArray()));
            ImageIcon icon = ImageHelper.resizeImageIcon(originalImage, lblImage.getWidth(), lblImage.getHeight());
            lblImage.setIcon(icon);
            outputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
