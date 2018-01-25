package controller;
import controller.secure.AppSecurity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import start.AppManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtMail;
    @FXML
    private TextArea txtAboutYourself;
    @FXML
    private Button btnOk;
    @FXML
    private ComboBox<String> comboBox;

    private ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.addAll("newbie", "oop", "advanced");
        comboBox.setItems(list);
        btnOk.setOnAction(event -> printSelectedItem());
        btnOk.setOnAction(event -> printName());
        btnOk.setOnAction(event -> login());
    }

    private void printSelectedItem(){
        String selectedItem = comboBox.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);

        txtName.setText(txtName.getText());
        System.out.println(txtName.getText());
    }

    private void printName (){
        System.out.println(txtName.getText());
        new Thread(() -> {txtName.setText(Thread.currentThread().getName() + "name");
                nameToFile();
        }).start();
    }

    private void nameToFile(){
        String filePath = "src/main/resources/files/file.txt";
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(txtName.getText());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void login(){
        if (AppSecurity.check(txtName.getText())) {
            try {
                AppManager.getStage().setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Course.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            txtName.setText("wrong");
        }
    }
}
