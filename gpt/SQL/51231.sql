CREATE TRIGGER trgAfterUpdate\nON YourTable\nAFTER UPDATE\nWITH EXECUTE AS 'dbo'\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    UPDATE YourTable\n    SET UPDATED = GETDATE()\n    WHERE ROWID IN (SELECT ROWID FROM INSERTED);\nEND;