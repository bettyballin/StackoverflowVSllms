CREATE TABLE NoKillI (\n  id INT NOT NULL, FOREIGN KEY (id) REFERENCES Accounts(id) ON DELETE RESTRICT\n);\nINSERT INTO NoKillI (id) VALUES (0);\nINSERT INTO NoKillI (id) VALUES (1);\nINSERT INTO NoKillI (id) VALUES (2);