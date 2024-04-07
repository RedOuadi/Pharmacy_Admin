package controller;

import model.Produit;
import model.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProduitController", urlPatterns = {"/produits", "/produits/ajouter", "/produits/modifier", "/produits/supprimer"})
public class ProduitController extends HttpServlet {
    private ProduitService produitService;

    public void init() {
        produitService = new ProduitService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/produits/ajouter":
                showAjouterForm(request, response);
                break;
            case "/produits/modifier":
                showModifierForm(request, response);
                break;
            case "/produits/supprimer":
                supprimerProduit(request, response);
                break;
            default:
                listProduits(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/produits/ajouter":
                ajouterProduit(request, response);
                break;
            case "/produits/modifier":
                modifierProduit(request, response);
                break;
            default:
                listProduits(request, response);
                break;
        }
    }

    private void listProduits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> produits = produitService.getAllProduits();
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("/WEB-INF/views/Acceuil.jsp").forward(request, response);
    }

    private void showAjouterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/AjouterProduit.jsp").forward(request, response);
    }

    private void showModifierForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = produitService.getProduitById(id);
        request.setAttribute("produit", produit);
        request.getRequestDispatcher("/WEB-INF/views/ModifierProduit.jsp").forward(request, response);
    }

    private void ajouterProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        String description = request.getParameter("description");

        // Créer un nouvel objet Produit
        Produit newProduit = new Produit(id, nom, quantite, prix, description);

        // Ajouter le produit à la liste des produits
        produitService.ajouterProduit(newProduit);

        // Rediriger vers la page d'accueil des produits
        response.sendRedirect(request.getContextPath() + "/produits");
    }

    private void modifierProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        String description = request.getParameter("description");

        // Créer un objet Produit avec les données mises à jour
        Produit produitModifie = new Produit(id, nom, quantite, prix, description);

        // Modifier le produit dans la liste des produits
        produitService.modifierProduit(produitModifie);

        // Rediriger vers la page d'accueil des produits
        response.sendRedirect(request.getContextPath() + "/produits");
    }

    private void supprimerProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID du produit à supprimer
        int id = Integer.parseInt(request.getParameter("id"));

        // Supprimer le produit de la liste des produits
        produitService.supprimerProduit(id);

        // Rediriger vers la page d'accueil des produits
        response.sendRedirect(request.getContextPath() + "/produits");
    }
}


