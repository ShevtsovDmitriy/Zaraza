package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    // onClickStart - initialization Map

    public void drawing(GraphicsContext gc){

    }

    public void onClickStart(){
        Parser createMap=new Parser();
        String virusJson="";
        String countriesJson="";

        try{
            Scanner in = new Scanner(new File(createMap.wayToVirus));
            while(in.hasNext()){
                virusJson+=in.nextLine()+"\r\n";
            }
            in.close();

            Scanner inc=new Scanner(new File(createMap.wayToCountries));
            while(inc.hasNext()){
                countriesJson+=inc.nextLine()+"\r\n";
            }
            inc.close();
        } catch (Exception e){

        }

        createMap.toParseAllMap(countriesJson,virusJson);


    }
}
