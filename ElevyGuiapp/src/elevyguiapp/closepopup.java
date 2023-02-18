/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevyguiapp;
import javafx.scene.control.Button;
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage; 
/**
 *
 * @author akonr
 */
public class closepopup {
    
    static boolean answer;
   
    public static boolean exit (String title, String message) {
        Stage popwindow = new Stage();
        popwindow.setTitle("Exit");
        popwindow.initModality(Modality.APPLICATION_MODAL);
        popwindow.setMaxWidth(300);
        
        Label lblq = new Label();
                lblq.setText("Do you want to close the application?");
                lblq.setFont(Font.font("Arial", 14));
                lblq.setTextFill(Color.CADETBLUE);
        
       Button yes = new Button();
       yes.setText("Yes");
       yes.setFont(Font.font("Arial", 20));
       yes.setTextFill(Color.BLUE);
       yes.setOnAction(e-> {
           answer = false;
           popwindow.close();
       });
               
       
       Button no = new Button();
       no.setText("No");
       no.setFont(Font.font("Arial", 20));
       no.setTextFill(Color.RED);
       no.setOnAction(e-> {
           answer = true;
           popwindow.close();
               });
       
        HBox layout = new HBox(10);
        layout.getChildren().addAll(yes,no);
        layout.setAlignment(Pos.CENTER);
        
       VBox root = new VBox(10);
       root.setAlignment(Pos.CENTER);
       root.getChildren().addAll(lblq,layout);
       
        
        Scene scene = new Scene(root,300,200, Color.AZURE);
        popwindow.setScene(scene);
        popwindow.showAndWait();
        return answer;
        
    }
    
    
}
