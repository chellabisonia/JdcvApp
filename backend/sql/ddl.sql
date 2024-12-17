CREATE TABLE Sejour (
                        ID_Sejour SERIAL PRIMARY KEY,
                        Titre VARCHAR(255),
                        Description TEXT,
                        Ville VARCHAR(255),
                        TypeHebergement VARCHAR(255),
                        PrixParNuit DECIMAL(10, 2),
                        DateDebutDispo DATE,
                        DateFinDispo DATE
);

CREATE TABLE Avis (
                      ID_Avis SERIAL PRIMARY KEY,
                      Note INT,
                      Commentaire TEXT,
                      Date_Avis DATE,
                      ID_Utilisateur INT,
                      ID_Sejour INT,
                      FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur),
                      FOREIGN KEY (ID_Sejour) REFERENCES Sejour(ID_Sejour)
);

CREATE TABLE Paiement (
                          ID_Paiement SERIAL PRIMARY KEY,
                          Montant DECIMAL(10, 2),
                          Mode_Paiement VARCHAR(255),
                          Date_Paiement DATE,
                          NumTransaction VARCHAR(255),
                          Statut VARCHAR(50),
                          ID_Reservation INT,
                          FOREIGN KEY (ID_Reservation) REFERENCES Reservation(ID_Reservation)
);

CREATE TABLE Utilisateur (
                             ID_Utilisateur SERIAL PRIMARY KEY,
                             Nom VARCHAR(255),
                             Prenom VARCHAR(255),
                             Email VARCHAR(255),
                             Telephone VARCHAR(20),
                             Adresse TEXT,
                             DescriptionPersonnelle TEXT
);

CREATE TABLE Reservation (
                             ID_Reservation SERIAL PRIMARY KEY,
                             Date_Reservation DATE,
                             Nombre_Participants INT,
                             Statut VARCHAR(50),
                             DateDebutReservationSejour DATE,
                             DateFinReservationSejour DATE,
                             ID_Utilisateur INT,
                             ID_Sejour INT,
                             FOREIGN KEY (ID_Utilisateur) REFERENCES Utilisateur(ID_Utilisateur),
                             FOREIGN KEY (ID_Sejour) REFERENCES Sejour(ID_Sejour)
);

CREATE TABLE Photo (
                       ID_Photo SERIAL PRIMARY KEY,
                       url_photo VARCHAR(255),
                       DateAjoutPhoto DATE,
                       ID_Sejour INT,
                       FOREIGN KEY (ID_Sejour) REFERENCES Sejour(ID_Sejour)
);