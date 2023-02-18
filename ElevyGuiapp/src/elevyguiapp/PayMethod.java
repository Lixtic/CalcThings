

package elevyguiapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage; 
/**
 *
 * @author akonr
 */
public class PayMethod {
    public static void display (String title, String message) {
        Stage popwindow = new Stage();
        popwindow.setTitle("Exit");
        popwindow.initModality(Modality.APPLICATION_MODAL);
        popwindow.setMaxWidth(300);
        
       Button yes = new Button();
       yes.setText("Yes");
       yes.setFont(Font.font("Arial", 20));
       yes.setTextFill(Color.BLUE);
       yes.setOnAction(e-> popwindow.close());
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll();
        
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout,200,200, Color.AZURE);
        popwindow.setScene(scene);
        popwindow.showAndWait();
        
        
        
        
    }
    
}
