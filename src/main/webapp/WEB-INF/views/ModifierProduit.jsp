<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Produit</title>
</head>
<body>
    <h1>Modifier Produit</h1>
    
    <form action="<%= request.getContextPath() %>/modifierProduit" method="post">
        <input type="hidden" id="id" name="id" value="<%= request.getParameter("id") %>">
        
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" value="<%= request.getParameter("nom") %>">
        
        <label for="quantite">Quantité:</label>
        <input type="text" id="quantite" name="quantite" value="<%= request.getParameter("quantite") %>">
        
        <label for="prix">Prix:</label>
        <input type="text" id="prix" name="prix" value="<%= request.getParameter("prix") %>">
        
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="<%= request.getParameter("description") %>">
        
        <input type="submit" value="Modifier Produit">
    </form>
</body>
</html>
