import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Program extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        IP ip = new IP();
        Pane root = new Pane();
        Scene scene = new Scene(root,400,400);
        TextField tIP1 = new TextField();
        TextField tIP2 = new TextField();
        TextArea textArea = new TextArea();
        tIP1.setLayoutX(10);
        tIP1.setLayoutY(10);
        tIP2.setLayoutX(10);
        tIP2.setLayoutY(50);
        textArea.setLayoutX(10);
        textArea.setLayoutY(80);
        textArea.setPrefWidth(380);
        textArea.setPrefHeight(280);
        Button btnCheck = new Button("Sprawdź");
        btnCheck.setLayoutX(200);
        btnCheck.setLayoutY(25);
        btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ip.checkIP(tIP1.getText(),tIP2.getText())) {
                    textArea.setStyle("-fx-text-fill: blue;");
                    textArea.appendText("Są z tej samej sieci\n");
                    System.out.println("Są z tej samej sieci");
                } else
                {
                    textArea.setStyle("-fx-text-fill: red;");
                    textArea.appendText("Nie są z tej samej sieci\n");
                    System.out.println("Nie są z tej samej sieci");
                }
                textArea.appendText("Adres sieci: "+ip.networkAddress(tIP1.getText()));
                textArea.appendText("\nAdres rozgłoszeniowy: "+ip.broadcastAddress(tIP1.getText()));
                int liczba = 15;
                liczba = liczba >> 2;
                System.out.println(liczba);
            }
        });


        root.getChildren().addAll(tIP1,tIP2,btnCheck,textArea);

        primaryStage.setTitle("IPki");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
