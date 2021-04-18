DROP TABLE IF EXISTS Creditools;

CREATE TABLE Creditools (
        id_dweller INT AUTO_INCREMENT  PRIMARY KEY,
        balance DOUBLE NOT NULL
);

INSERT INTO Creditools (id_dweller, balance) VALUES
(1, 10.0),
(2, 100.0),
(3, 4.32),
(4, 7.0),
(5, 1234.56),
(6, 78.90);
