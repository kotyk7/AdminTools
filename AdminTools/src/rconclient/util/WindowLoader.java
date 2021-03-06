/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rconclient.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rconclient.gui.RconWindowController;
import rconclient.gui.SettingsWindowController;

/**
 *
 * @author lukak
 */
public class WindowLoader {

    public static void loadRcon(AnchorPane rootPane) {
        loadWindow(rootPane, "/rconclient/gui/RconWindow.fxml");
    }

    public static void loadSettings(AnchorPane rootPane) {
        loadWindow(rootPane, "/rconclient/gui/SettingsWindow.fxml");
    }

    public static void loadStatus(AnchorPane rootPane) {
        loadWindow(rootPane, "/rconclient/gui/StatusWindow.fxml");
    }

    public static void loadLogin(AnchorPane rootPane) {
        loadWindow(rootPane, "/rconclient/gui/LoginWindow.fxml");
    }

    private static void loadWindow(AnchorPane rootPane, String url) {
        try {
            AnchorPane ap = FXMLLoader.load(SettingsWindowController.class.getResource(url));

            Scene scene2 = new Scene(ap);
            Stage windowStage = (Stage) rootPane.getScene().getWindow();
            //Get widht and height
            double width = windowStage.getWidth();
            double height = windowStage.getHeight();
            
            windowStage.setScene(scene2);

            //Refresh title
            Data d = Data.getInstance();
            String barebonesq = "";
            if (Data.arguments.length > 0) {
                if (Data.arguments[0].equals("barebones")) {
                    barebonesq = " [Barebones mode]";
                }
            }
            windowStage.setTitle("Admin Tools - " + d.getHost() + ":" + d.getPort() + barebonesq);

            //Set width after scene swithch
            windowStage.setWidth(width);
            windowStage.setHeight(height);
            
            windowStage.show();
        } catch (IOException ex) {
            Logger.getLogger(RconWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
