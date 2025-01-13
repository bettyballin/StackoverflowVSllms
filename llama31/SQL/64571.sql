CREATE TABLE identities (\n    table_name VARCHAR(50) PRIMARY KEY,\n    recid INT\n);\n\nINSERT INTO identities (table_name, recid) VALUES ('subscriber', 1);\n\nBEGIN TRANSACTION\n    DECLARE @id int\n\n    SELECT @id = recid\n    FROM identities WITH (UPDLOCK, ROWLOCK)\n    WHERE table_name = 'subscriber'\n\n    -- Simulate some work being done\n    WAITFOR DELAY '00:00:06'\n\n    INSERT INTO subscriber (recid) VALUES (@id)\n\n    UPDATE identities SET recid = recid + 1\n    WHERE table_name = 'subscriber'\n\nCOMMIT TRANSACTION