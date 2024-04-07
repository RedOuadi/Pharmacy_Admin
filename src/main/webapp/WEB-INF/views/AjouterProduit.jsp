<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Produit</title>
</head>
<body>
    <h1>Ajouter Produit</h1>
    
    <form action="<%= request.getContextPath() %>/ajouterProduit" method="post">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom">
        
        <label for="quantite">Quantité:</label>
        <input type="text" id="quantite" name="quantite">
        
        <label for="prix">Prix:</label>
        <input type="text" id="prix" name="prix">
        
        <label for="description">Description:</label>
        <input type="text" id="description" name="description">
        
        <input type="submit" value="Ajouter Produit">
    </form>
</body>
</html>
