package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashBordeFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    void btnDashboardOnAction(MouseEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBorde_form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }
    @FXML
    void btnAddStudentOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load((getClass().getResource("/view/add_student_form.fxml")));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_page_form.fxml"));
        Scene scene =new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void btnReservationOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Reservation_form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    @FXML
    void btnRoomsOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/view/room_form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/view/setting_form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
