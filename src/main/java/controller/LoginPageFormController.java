package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageFormController implements Initializable {
    @FXML
    public AnchorPane root;
    public ImageView img1;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
//        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBorde_form.fxml"));
//        Stage stage = (Stage) root.getScene().getWindow();
//        Scene scene = new Scene(anchorPane);
//        stage.setScene(scene);
//        stage.centerOnScreen();
//        stage.setTitle("DashBord");
        Stage stage = (Stage) img1.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/DashBorde_form.fxml"))));
        stage.show();

    }

    @FXML
    void btnNewHereOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
