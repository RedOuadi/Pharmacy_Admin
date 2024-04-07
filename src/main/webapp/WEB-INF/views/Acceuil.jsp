<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Produit" %>
<html>
<head>
    <title>Liste des Produits</title>
</head>
<body>
    <h1>Liste des Produits</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <% for (Produit produit : produits) { %>
            <tr>
                <td><%= produit.getId() %></td>
                <td><%= produit.getNom() %></td>
                <td><%= produit.getQuantite() %></td>
                <td><%= produit.getPrix() %></td>
                <td><%= produit.getDescription() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/modifierProduit?id=<%= produit.getId() %>">Modifier</a>
                    <a href="<%= request.getContextPath() %>/supprimerProduit?id=<%= produit.getId() %>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?')">Supprimer</a>
                </td>
            </tr>
        <% } %>
    </table>
    
    <form action="<%= request.getContextPath() %>/ajouterProduit" method="get">
        <input type="submit" value="Ajouter Produit">
    </form>
</body>
</html>
