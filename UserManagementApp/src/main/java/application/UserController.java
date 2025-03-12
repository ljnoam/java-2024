package application;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField searchField;
    @FXML
    private Button addUserBtn;
    @FXML
    private Button updateUserBtn;
    @FXML
    private Button deleteUserBtn;
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Integer> colId;
    @FXML
    private TableColumn<User, String> colName;
    @FXML
    private TableColumn<User, String> colEmail;

    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        loadUsers();

        // Ajouter un événement pour sélectionner un utilisateur dans le tableau
        userTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nameField.setText(newSelection.getName());
                emailField.setText(newSelection.getEmail());
            }
        });
    }

    @FXML
    public void addUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            System.out.println("Les champs ne peuvent pas être vides !");
            return;
        }

        userDAO.createUser(name, email);
        loadUsers();

        // Vider les champs après l'ajout
        nameField.clear();
        emailField.clear();
    }

    @FXML
    public void updateUser() {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            System.out.println("Aucun utilisateur sélectionné.");
            return;
        }

        String newName = nameField.getText().trim();
        String newEmail = emailField.getText().trim();

        if (newName.isEmpty() || newEmail.isEmpty()) {
            System.out.println("Les champs ne peuvent pas être vides !");
            return;
        }

        userDAO.updateUser(selectedUser.getId(), newName, newEmail);
        loadUsers();
        userTable.refresh();
    }

    @FXML
    public void deleteUser() {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            System.out.println("Aucun utilisateur sélectionné.");
            return;
        }

        userDAO.deleteUser(selectedUser.getId());
        loadUsers();

        // Vider les champs après suppression
        nameField.clear();
        emailField.clear();
    }

    @FXML
    public void searchUser() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadUsers();
            return;
        }

        List<User> users = userDAO.searchUsers(keyword);
        userTable.getItems().setAll(users);
    }

    private void loadUsers() {
        List<User> users = userDAO.getAllUsers();
        userTable.getItems().setAll(users);
    }

    @FXML
    public void exportToCSV() {
        String filePath = "users.csv"; // Nom du fichier de sortie
        List<User> users = userDAO.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("Aucun utilisateur à exporter.");
            return;
        }

        CSVExporter.exportUsersToCSV(users, filePath);
        System.out.println("Fichier CSV exporté : " + filePath);
    }

    @FXML
    public void resetSearch() {
        searchField.clear();  // Efface la recherche
        userTable.getSelectionModel().clearSelection();  // Désélectionne tout
        loadUsers(); // Recharge tous les utilisateurs
    }


}
