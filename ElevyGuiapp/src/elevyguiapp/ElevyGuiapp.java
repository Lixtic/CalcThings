
package elevyguiapp;


import java.text.DecimalFormat; 


import javafx.scene.control.Button;
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage; 

/**
 *
 * @author akonray
 */


public class ElevyGuiapp extends Application {
    
    Scene  scene,scene1,scene2,scene3, sAbout;
    Stage window;
    double networkCharge, bmi;
    
    
    @Override
    public void start(Stage window) {
        //close window popup
        window.setOnCloseRequest(e-> closeProgram());
        
                Label groupName = new Label();
                groupName.setText("E - Levy Calculator");
                groupName.setFont(Font.font("Algerian", 20));
      //to format any value   
    DecimalFormat df = new DecimalFormat("0.0#");
    
       TextField screen = new TextField();
            screen.setMaxWidth(250);
            screen.setPromptText("Type Your amount Here");
            
            // creating the file menu
            Menu fileMenu = new Menu("File");
                
                MenuItem home = new MenuItem("Home");
                    fileMenu.getItems().add(home);
                    home.setOnAction(e-> window.setScene(scene1));
                    
                fileMenu.getItems().add(new SeparatorMenuItem());
                
               MenuItem mexit = new MenuItem("Exit"); 
                fileMenu.getItems().add(mexit);
                mexit.setOnAction(e->closeProgram());
            Menu help = new Menu("Help");
                    MenuItem about = new MenuItem("About");
                   help.getItems().add(about);
                   about.setOnAction(e-> window.setScene(sAbout) );
              
                //creating the menubar
             MenuBar menuBar = new MenuBar();
                menuBar.getMenus().addAll(fileMenu,help);
             
             
       
       /*Label info = new Label();
            info.setText("Type Your amount Here");
            info.setTextFill(Color.DARKSLATEGREY);
            info.setFont(Font.font("Arial", 22));
            info.setId("bold-label");*/
       
        Label welcomeMessage = new Label();
            welcomeMessage.setText("");
            welcomeMessage.setTextFill(Color.BLUEVIOLET);
            welcomeMessage.setFont(Font.font("Arial", 20));
            
        
        Label pmethod = new Label();
            pmethod.setText("payment method");
            pmethod.setTextFill(Color.SLATEGRAY);
            pmethod.setFont(Font.font("Arial", 18));
            // this button takes us to the next scene
        Button paymentMethod = new Button();
            paymentMethod.setText("Select");
            
         // scene 2 holds the various network buttons
         Label lblhome = new Label();
            lblhome.setText("Choose an app");
           lblhome.setFont(Font.font("Algerian", 30));
           lblhome.setTextFill(Color.ALICEBLUE);
            
         Label lblchoose = new Label();
            lblchoose.setText(" Select payment method");
            lblchoose.setTextFill(Color.BLUEVIOLET);
            lblchoose.setFont(Font.font("Arial", 20));
            
        Button voda = new Button();
            voda.setText("Vodafon");
            voda.setTextFill(Color.RED);
            voda.setOnAction(e-> {
                paymentMethod.setText("Vodafon");
                pmethod.setText("Selected");
                networkCharge = 0;
                window.setScene(scene);
                    });
        
        Button tigo = new Button();
             tigo.setText("Airtel/Tigo");
             tigo.setTextFill(Color.BLUE);
             tigo.setOnAction(e-> {
                 paymentMethod.setText("Airtel/Tigo");
                 pmethod.setText("Selected");
                     networkCharge = 0.01;
                     window.setScene(scene);}
             );
        
        Button mtn = new Button();
             mtn.setText("MTN");
             mtn.setTextFill(Color.BLACK);
             mtn.setOnAction(e-> {
                 paymentMethod.setText("MTN");
                 pmethod.setText("Selected");
                     networkCharge = 0.0075;
                     window.setScene(scene);
                             }
             );
        
        
        HBox payHbox = new HBox();
            payHbox.setSpacing(15);
            payHbox.setAlignment(Pos.CENTER);
            payHbox.getChildren().addAll(paymentMethod,pmethod);
      
        
        paymentMethod.setOnAction(e ->
            window.setScene(scene2)
        );
         Button btnback = new Button("Home");
                 btnback.setOnAction(e-> window.setScene(scene1));
        
        Button btncalc = new Button();
            btncalc.setText("Calculate");
            btncalc.setTextFill(Color.BLUEVIOLET);
            
        Button exit = new Button();
            exit.setText("Exit");
            exit.setTextFill(Color.RED);
            exit.setOnAction(e-> closeProgram());
        
        HBox calxit = new HBox();
            calxit.getChildren().addAll(btncalc);
            calxit.setAlignment(Pos.CENTER);
            calxit.setSpacing(20);
            
        btncalc.setOnAction(e -> 
            welcomeMessage.setText("E - Levy = GH₵ "+ calC(screen) + "0")
        );
        
        
        VBox root = new VBox(); 
            root.setSpacing(10); 
            root.setAlignment(Pos.CENTER); 
            root.getChildren().addAll(payHbox,screen,calxit,welcomeMessage ); 
        
        VBox llout = new VBox();
            llout.getChildren().addAll(lblchoose,mtn,voda,tigo);
            llout.setSpacing(12);
            llout.setAlignment(Pos.CENTER);
            //the BMI calculator
        TextField txtBmi = new TextField();
          //  txtBmi.setPromptText("BMI");
          
            txtBmi.setMaxWidth(120);
          
         Label lblHeight = new Label();
            lblHeight.setText("BMI CALCULATOR");
            lblHeight.setTextFill(Color.DEEPSKYBLUE);
            lblHeight.setFont(Font.font("Algerian", 30));
            
          Label lblHeighttx = new Label();
            lblHeighttx.setText("Height");
            lblHeighttx.setTextFill(Color.WHITESMOKE);
            lblHeighttx.setFont(Font.font("Arial", 20));
         Label lblweight = new Label();
            lblweight.setText("Weight");
            lblweight.setTextFill(Color.WHITESMOKE);
            lblweight.setFont(Font.font("Arial", 20));
            HBox hnw = new HBox(50);
                hnw.getChildren().addAll(lblHeighttx, lblweight);
               hnw.setAlignment(Pos.CENTER);
         
            
         Label lblBmi = new Label();
            lblBmi.setText("");
            lblBmi.setTextFill(Color.ALICEBLUE);
            Label lblCm = new Label();
                lblCm.setText("Cm");
                lblCm.setTextFill(Color.ALICEBLUE);
                
            
         TextField txtheight = new TextField();
            txtheight.setPromptText("Height");
            txtheight.setMaxWidth(110);    
                 
         TextField txtmass = new TextField();
            txtmass.setPromptText("Weight ");
            txtmass.setMaxWidth(110);
               
             
           
         Button btnCalc = new Button("Calculate");
            btnCalc.setOnAction(e-> {
            double height = Double.parseDouble(txtheight.getText());
                    double height2 = height/100;
                    double height3 = height2*height2;
            double mass = Double.parseDouble(txtmass.getText());
                       bmi = mass/height3;
                       
            txtBmi.setText(" "+ df.format(bmi));
            
                if (bmi >=25.0 && bmi < 30) { 
                  lblBmi.setText("Your Body Mass Index is "+ df.format(bmi) + " .You are Overweight");        
                }
               
                else if(bmi >=18.5 && bmi < 25) {
                    lblBmi.setText("Your Body Mass Index is "+ df.format(bmi) + " .You are Healthy");
                    
                }
                else if (bmi < 18.5 ){
                 lblBmi.setText("Your Body Mass Index is "+ df.format(bmi) + " .You are Underweight");
                }
                else if (bmi >30.0){
                    lblBmi.setText("Your Body Mass Index is "+ df.format(bmi) + " .You are Obese");
                }
           
              System.out.printf("%,.1f", bmi);
             
            
            });
          Label lblKg = new Label();
            lblKg.setText("kg");
            lblKg.setTextFill(Color.ALICEBLUE);
            
         HBox lay2 = new HBox(20);
                lay2.getChildren().add(lblHeight);
                lay2.setAlignment(Pos.CENTER);
         HBox lay3 = new HBox(10);
                lay3.getChildren().addAll(txtheight,lblCm,txtmass,lblKg);
                lay3.setAlignment(Pos.CENTER);
         VBox lay4 = new VBox(20);
            lay4.getChildren().addAll(lay2,hnw,lay3, btnCalc, txtBmi,lblBmi);
            lay4.setAlignment(Pos.CENTER);
       
            TextArea txaAbout = new TextArea();
                txaAbout.setMaxWidth(200);
                txaAbout.setText("CalTins is an easy to use calculator. "
                        + "The app was officially designed by Group8 of the ITE200I class");
                
            GridPane lay6 = new GridPane();
            lay6.add(txaAbout, 0, 0);
            lay6.add(btnback, 1, 0);
            lay6.setVgap(20);
            lay6.setHgap(20);
           // BorderPane lay6 = new BorderPane();
                //lay6.setTop(menuBar);
              // lay6.setCenter(txaAbout);
              // lay6.setBottom(home);
            
        BorderPane lay = new BorderPane();
            
        BorderPane lay5 = new BorderPane();
        
        //BorderPane layout1 = new BorderPane();
          //  layout1.setTop(groupName);
            
             
              Button btnElevyCalc = new Button("Elevy Calc");
                btnElevyCalc.setOnAction(e-> {
                    lay.setTop(menuBar);
                    lay.setCenter(root);
                   // lay.setRight(btnback);
                    window.setScene(scene);});
                
              Button sce2 = new Button("BMI Calc");
                sce2.setOnAction(e->{ 
                    lay5.setTop(menuBar);
                     lay5.setCenter(lay4);
                     //lay5.setRight(btnback);
                    window.setScene(scene3);
                });
              VBox welcomeScreen = new VBox(20);
                    welcomeScreen.getChildren().addAll(lblhome,btnElevyCalc,sce2);
                    welcomeScreen.setAlignment(Pos.CENTER);
                
               /* HBox welcomeScreen = new HBox(20);
                    welcomeScreen.getChildren().addAll(sce1,sce2);
                    welcomeScreen.setAlignment(Pos.CENTER);*/
               
              
            
        sAbout = new Scene(lay6,350,400);
        scene1 = new Scene(welcomeScreen, 500, 400);
        scene2 = new Scene(llout, 500, 400);
        scene3= new Scene(lay5, 500, 400);
        scene = new Scene(lay, 500, 400, Color.ANTIQUEWHITE);
        
        scene.getStylesheets().add("manber.css");
        sAbout.getStylesheets().add("manber.css");
        scene1.getStylesheets().add("manber.css");
        scene3.getStylesheets().add("manber.css");
        
        window.setScene(scene1);
        window.setTitle("CalTins");
        window.show();
    }
    //creat a method to convert the textfield input to a douoble and to the calculations
    
private double calC(TextField input){
        
        double amount = Integer.parseInt(input.getText());
        double levy = 0.015 + networkCharge;
        double finalamount = amount*levy;
        return finalamount;
  
}

private void closeProgram(){
    
    Boolean answer = closepopup.exit("Title", "Are you sure you want to exit? ");
    if (answer) {
       window.close();
    }
        
}

    
    public static void main(String[] args) {
        launch(args);
         
        
        
    }
    
}
