CREATE TYPE InvoiceListTableType AS TABLE \n(\n    InvoiceId INT\n);\nGO\n\nCREATE PROCEDURE hd_invoice_selectFromTempTable\n(\n    @InvoiceList InvoiceListTableType READONLY\n)\nAS\nBEGIN\n    SELECT * FROM Invoice WHERE InvoiceID IN\n        (SELECT InvoiceId FROM @InvoiceList)\n\n    SELECT * FROM InvoiceItem WHERE InvoiceID IN \n        (SELECT InvoiceId FROM @InvoiceList)\n\n    SELECT * FROM InvoiceComments WHERE InvoiceID IN\n        (SELECT InvoiceId FROM @InvoiceList)\n\n    RETURN\nEND\nGO\n\nCREATE PROCEDURE hd_invoice_select(@id INT) AS\nBEGIN\n    DECLARE @InvoiceList AS InvoiceListTableType;\n\n    SELECT id AS ID \n        INTO @InvoiceList\n\n    EXEC hd_invoice_selectFromTempTable(@InvoiceList)\n    RETURN\nEND\nGO\n\nCREATE PROCEDURE hd_invoice_selectAllForCustomer(@customerID INT) AS\nBEGIN\n    DECLARE @InvoiceList AS InvoiceListTableType;\n\n    SELECT invoiceID as ID\n        INTO @InvoiceList\n        FROM Invoice WHERE CustomerID = @customerID\n\n    EXEC hd_invoice_selectFromTempTable(@InvoiceList)\n    RETURN\nEND\nGO\n\nCREATE PROCEDURE hd_invoice_selectAllActive AS\nBEGIN\n    DECLARE @InvoiceList AS InvoiceListTableType;\n\n    SELECT invoiceID as ID\n        INTO @InvoiceList\n        FROM Invoice WHERE Status = 10002\n\n    EXEC hd_invoice_selectFromTempTable(@InvoiceList)\n    RETURN\nEND\nGO