CREATE TABLE myTable (\n    id INT PRIMARY KEY,\n    insertDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),\n    timestamp ROWVERSION NOT NULL\n);