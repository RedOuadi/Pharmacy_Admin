package model;

import model.Produit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        // Initialisation de la liste des produits (peut être une base de données)
        produits = new ArrayList<>();
        // Exemple : Ajout de quelques produits pour la démonstration
        produits.add(new Produit(1, "Produit 1", 10, 5.99f, "Description du produit 1"));
        produits.add(new Produit(2, "Produit 2", 20, 9.99f, "Description du produit 2"));
    }

    public List<Produit> getAllProduits() {
        // Retourne tous les produits
        return produits;
    }

    public Produit getProduitById(int id) {
        // Retourne le produit avec l'ID spécifié s'il existe, sinon null
        return produits.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    public void ajouterProduit(Produit produit) {
        // Ajoute un nouveau produit à la liste
        // Pour une application réelle, vous voudrez peut-être vérifier les doublons, générer un ID unique, etc.
        produits.add(produit);
    }

    public void modifierProduit(Produit produitModifie) {
        // Met à jour les informations d'un produit existant
        // Ici, nous recherchons le produit par son ID, puis mettons à jour ses informations
        for (int i = 0; i < produits.size(); i++) {
            Produit produit = produits.get(i);
            if (produit.getId() == produitModifie.getId()) {
                produits.set(i, produitModifie);
                break;
            }
        }
    }

    public void supprimerProduit(int idProduit) {
        // Supprime le produit avec l'ID spécifié
        produits = produits.stream()
                            .filter(p -> p.getId() != idProduit)
                            .collect(Collectors.toList());
    }
}

