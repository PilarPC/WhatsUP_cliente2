package com.example.whatsup;

import com.example.paquete.Paquete;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloController implements Runnable{

    @FXML
    private Button btAsc;

    @FXML
    private Button btPlano;

    @FXML
    private Button btPlano1;
    @FXML
    private VBox mensajes;

    @FXML
    private Button btsim;

    @FXML
    private PasswordField llabelb;

    @FXML
    private Button regreso;
    @FXML
    private TextField textoTF;
    @FXML
    private Label nombre;

    public Paquete paquete;//objeto de la clase paquete
    @FXML
    void ckAsc(ActionEvent event) {

    }




public void userChat(String n){
        nombre.setText(n);
}

    @FXML
    void ckregreso(ActionEvent event) throws IOException {
        servidor.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contactos.fxml"));
        root=fxmlLoader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ckPlano(ActionEvent event) {
        // mensajes.getChildren().add(new Label(textoTF.getText()));
            try{
                Socket misocket = new Socket("127.0.0.1",8000);//IPv4, puerto
                //DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());// convierte los datos a binario
                ObjectOutputStream flujo_salida = new ObjectOutputStream(misocket.getOutputStream());
                HBox Hbmandado = new HBox();
                Hbmandado.setAlignment(Pos.CENTER_RIGHT);
                TextFlow lbHb = new TextFlow(new Text(textoTF.getText()));
                Hbmandado.getChildren().add(lbHb);
                mensajes.getChildren().add(Hbmandado);
                paquete.setMensaje(textoTF.getText());
                flujo_salida.writeObject(paquete);
                //flujo_salida.writeUTF(textoTF.getText());//UTF para String's, especifacas el tipo de datos, writeFloat...
                flujo_salida.close();
            }

            catch(IOException e1){
                e1.printStackTrace();
            }

    }
    @FXML
    void cksim(ActionEvent event) {

    }

    public  void Establecer(Paquete p){
        this.paquete = p;
    }

    public void initialize(){
        Thread hilo1 = new Thread(this);
        hilo1.start();

    }
    //hios
    ServerSocket servidor;
    public void run(){

        try{

            servidor=new ServerSocket(9003);
            //ahora que acepte cualquier conexion que venga del exterior con el metodo accept

            while(true){
                Socket misocket=servidor.accept();//aceptara las conexiones que vengan del exterior
                ObjectInputStream flujo_entrada=new ObjectInputStream(misocket.getInputStream());
                Paquete data=(Paquete)flujo_entrada.readObject();
                if(paquete.getpPuertoR() == data.getPuertoE()){
                    //CONTENIDO CHAT
                    System.out.println(data.getMensaje());
                    Platform.runLater(()->{
                        //mensajes.setText(mensaje);
                        mensajes.getChildren().add(new Label(data.getMensaje()));
                    });
                }

                // misocket.close();
                misocket.close();
            }

        }
        catch(IOException|ClassNotFoundException e){

        }

    }
    private Stage stage;
    private Scene scene;
    private Parent root;
}
