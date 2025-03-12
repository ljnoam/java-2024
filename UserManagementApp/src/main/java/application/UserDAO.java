package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void createUser(String name, String email) {
        String query = "INSERT INTO users (name, email, createdAt, updatedAt) VALUES (?, ?, NOW(), NOW())";
        try (Connection connection = Database.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Utilisateur ajouté avec succès : " + name + " - " + email);
            } else {
                System.out.println("Échec de l'ajout de l'utilisateur.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection connection = Database.getConnection(); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getTimestamp("createdAt"),
                        rs.getTimestamp("updatedAt")));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
        return users;
    }

    public void updateUser(int id, String name, String email) {
        String query = "UPDATE users SET name = ?, email = ?, updatedAt = NOW() WHERE id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
    
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Utilisateur mis à jour : " + name + " - " + email);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL (update) : " + e.getMessage());
        }
    }
    
    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
    
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Utilisateur supprimé (ID : " + id + ")");
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL (delete) : " + e.getMessage());
        }
    }
    
    public List<User> searchUsers(String keyword) {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE name LIKE ? OR email LIKE ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
    
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getTimestamp("createdAt"),
                        rs.getTimestamp("updatedAt")));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL (search) : " + e.getMessage());
        }
        return users;
    }
    
}
