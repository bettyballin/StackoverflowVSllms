CREATE PROCEDURE Dummy\n    @ID INT\nAS\nBEGIN\n    IF @ID IS NULL\n    BEGIN\n        THROW 51000, '@ID cannot be NULL', 1\n    END\n\n    -- rest of the procedure code here\nEND