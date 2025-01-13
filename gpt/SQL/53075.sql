SET SHOWPLAN_TEXT ON;\n   GO\n   SELECT \n       CustomerID, \n       SUM(InvoiceTotal) AS SumOfInvoiceTotal, \n       SUM(AmountPaid) AS SumOfAmountPaid \n   FROM tblInvoices \n   WHERE CustomerID = 2112 \n   GROUP BY customerID;\n   GO\n   SET SHOWPLAN_TEXT OFF;