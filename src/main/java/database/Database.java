package database;

import eu.hansolo.fx.countries.tools.Connection;

public class Database {
    private String serveur = "localhost";
    private String nomDeLaBase;
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

    public Connection getConnexion(){

    }
}
