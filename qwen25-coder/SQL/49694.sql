CREATE PROCEDURE GetDocumentForUser\n    @UserID INT,\n    @DocID INT\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Check if the user has access to the document\n    IF EXISTS (\n        SELECT 1 \n        FROM DocumentsAccess da\n        WHERE da.UserID = @UserID AND da.DocID = @DocID\n    )\n    BEGIN\n        -- Retrieve the document\n        SELECT *\n        FROM Documents d\n        WHERE d.DocID = @DocID;\n    END\n    ELSE\n    BEGIN\n        -- Handle access denied\n        RAISERROR ('Access Denied', 16, 1);\n    END\nEND