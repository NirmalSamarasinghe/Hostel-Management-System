import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_page_form.fxml"))));
        stage.setTitle("D24 Hostel Management System");
        stage.centerOnScreen();
        stage.show();
    }
}
