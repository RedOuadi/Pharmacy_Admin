package dao;
import model.Produit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProduitDAO {
    private static final String url = "jdbc:postgresql://localhost:5432/Pharmacie";
    private static final String user = "postgres";
    private static final String password = "ader12";

    // Méthode pour ajouter un nouveau produit à la base de données                     
    public void ajouterProduit(Produit produit) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Produits (nom, quantite, prix, description) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, produit.getNom());
            statement.setInt(2, produit.getQuantite());
            statement.setFloat(3, produit.getPrix());
            statement.setString(4, produit.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour modifier les informations d'un produit existant dans la base de données
    public void modifierProduit(Produit produit) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE Produits SET nom=?, quantite=?, prix=?, description=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, produit.getNom());
            statement.setInt(2, produit.getQuantite());
            statement.setFloat(3, produit.getPrix());
            statement.setString(4, produit.getDescription());
            statement.setInt(5, produit.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un produit de la base de données
    public void supprimerProduit(int idProduit) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM Produits WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idProduit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour obtenir la liste complète des produits disponibles dans la base de données
    public List<Produit> listerProduits() {
        List<Produit> produits = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Produits";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Produit produit = new Produit(
                    result.getInt("id"),
                    result.getString("nom"),
                    result.getInt("quantite"),
                    result.getFloat("prix"),
                    result.getString("description")
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }
}

