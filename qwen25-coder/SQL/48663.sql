CREATE PROCEDURE hd_invoice_common(@mainQuery NVARCHAR(MAX), @itemSubquery NVARCHAR(MAX), @commentSubquery NVARCHAR(MAX)) AS\nBEGIN\n    EXEC sp_executesql @mainQuery;\n    EXEC sp_executesql @itemSubquery;\n    EXEC sp_executesql @commentSubquery;\nEND