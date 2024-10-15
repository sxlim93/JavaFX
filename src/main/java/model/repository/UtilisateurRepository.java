package model.repository;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilisateurRepository {

    private String serveur = "localhost";
    private String nomDeLaBase = "JavaFX";
    private String utilisateur = "root";
    private String motDePasse = "";

    public boolean inscription(Utilisateur utilisateur) {
        String url = "jdbc:mysql://" + serveur + ":3306/" + nomDeLaBase + "?serverTimezone=UTC";

        String sql = "INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe,) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection maConnection = DriverManager.getConnection(url, this.utilisateur, this.motDePasse);
             PreparedStatement requetePrepareInsert = maConnection.prepareStatement(sql)) {


            requetePrepareInsert.setString(1, utilisateur.getNom());
            requetePrepareInsert.setString(2, utilisateur.getPrenom());
            requetePrepareInsert.setString(3, utilisateur.getEmail());
            requetePrepareInsert.setString(4, utilisateur.getMdp());

            int result = requetePrepareInsert.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
