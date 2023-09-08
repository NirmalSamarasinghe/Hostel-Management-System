package controller;

import bo.BOFactory;
import bo.custom.UserBO;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String password1 = txtPassword.getText();

        boolean isValid = userBO.checkUser(userName,password,password1);
        if (isValid){
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBorde_form.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(anchorPane));
            Stage stage1 = (Stage) root.getScene().getWindow();
            stage1.close();
            stage.setTitle("D24 Hostel Management System - Dashboard");
            stage.centerOnScreen();
            stage.show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Username and Password incorrect!...").show();
        }
    }

    @FXML
    void btnNewHereOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/registerration_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.setTitle("Sign up page");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
