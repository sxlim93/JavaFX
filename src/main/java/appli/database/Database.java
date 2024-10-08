package appli.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String serveur = "localhost";
    private String nomDeLaBase = "JavaFX";
    private String utilisateur;
    private String mdp;

    public Database(String serveur, String nomDeLaBase, String utilisateur, String mdp) {
        this.serveur = serveur;
        this.nomDeLaBase = nomDeLaBase;
        this.utilisateur = utilisateur;
        this.mdp = mdp;
    }

    private String getUrl() {
        return "jdbc:mysql://"+serveur+"/"+nomDeLaBase;
    }

    public Connection getConnection() {
        try {
            Connection cnx = DriverManager.getConnection(this.getUrl(), this.serveur, this.mdp);
            System.out.print("État de la connexion : ");
            System.out.print(cnx.isClosed() ? "fermée" : "ouverte \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.print("Erreur lors de la tentative de connexion à la base de données");
            e.printStackTrace();
            return null;
        }
    }

}
