CREATE TABLE Produits (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    quantite INTEGER NOT NULL,
    prix FLOAT NOT NULL,
    description VARCHAR(100)
);

-- Insertion de quelques données de test
INSERT INTO Produits (nom, quantite, prix, description) VALUES ('Paracétamol', 100, 5.99, 'Soulage la douleur et la fièvre');
INSERT INTO Produits (nom, quantite, prix, description) VALUES ('Ibuprofène', 50, 7.49, 'Anti-inflammatoire et antipyrétique');
INSERT INTO Produits (nom, quantite, prix, description) VALUES ('Aspirine', 80, 4.99, 'Réduit la douleur, l inflammation et la fièvre');
INSERT INTO Produits (nom, quantite, prix, description) VALUES ('Loratadine', 60, 9.99, 'Antihistaminique pour les allergies');
INSERT INTO Produits (nom, quantite, prix, description) VALUES ('Cétylpiridinium', 40, 8.99, 'Antiseptique pour la bouche et la gorge');