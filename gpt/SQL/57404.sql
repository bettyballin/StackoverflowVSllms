CREATE PROCEDURE Customer.InsertNewOrder\nWITH EXECUTE AS 'dbo'\nAS\nBEGIN\n    -- Your insert logic here\n    INSERT INTO dbo.Order (columns) VALUES (values);\nEND