CREATE FUNCTION fn_PreventDeletionOfMasterAccounts (@id INT)\nRETURNS BIT\nAS\nBEGIN\n    IF @id IN (0, 1, 2)\n        RETURN 0\n    ELSE\n        RETURN 1\nEND\nGO\n\nALTER TABLE YourTable\nADD CONSTRAINT chk_PreventDeletionOfMasterAccounts\nCHECK (dbo.fn_PreventDeletionOfMasterAccounts(id) = 1)