package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVExporter {

    public static void exportUsersToCSV(List<User> users, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Écrire l'en-tête du fichier CSV
            writer.println("ID,Name,Email,CreatedAt,UpdatedAt");

            // Écrire les données des utilisateurs
            for (User user : users) {
                writer.println(user.getId() + "," +
                               user.getName() + "," +
                               user.getEmail() + "," +
                               user.getCreatedAt() + "," +
                               user.getUpdatedAt());
            }

            System.out.println("Export CSV réussi : " + filePath);

        } catch (IOException e) {
            System.out.println("Erreur lors de l'export CSV : " + e.getMessage());
        }
    }
}
